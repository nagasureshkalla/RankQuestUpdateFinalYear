package com.example.admin.data.FragmentsExams.POLYCET;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.admin.data.R;
import com.example.admin.data.examPolycet.adapters.BranchAdapter;
import com.example.admin.data.examPolycet.model.Branch;
import com.example.admin.data.examPolycet.rest.ApiClient;
import com.example.admin.data.examPolycet.rest.ApiInterface;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;


public class Fragment_Branches_Polycet extends Fragment {
    private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";
    List<Branch> list;
    Call<List<Branch>> call;
    RecyclerView recyclerView;
    ProgressBar p;
    TextView retry;
    SwipeRefreshLayout r;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment__branches__polycet, container, false);
        recyclerView = view.findViewById(R.id.recyclebranch);

        p=view.findViewById(R.id.progress);
        retry=view.findViewById(R.id.retry);
        r=(SwipeRefreshLayout)view.findViewById(R.id.refreshcollege);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        retry.setVisibility(View.INVISIBLE);

        r.setColorSchemeResources(R.color.cutdown);
        r.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        start();
                        r.setRefreshing(false);
                    }
                },2000);
            }
        });

        start();
        return view;
    }
    private void start(){

        try {
            p.setVisibility(View.VISIBLE);
            retry.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_leftto_right);

            call = apiService.getData(API_KEY);
            call.enqueue(new Callback<List<Branch>>() {
                @Override
                public void onResponse(Call<List<Branch>> call, Response<List<Branch>> response) {

                    List<Branch> list = response.body();
                    p.setVisibility(View.INVISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);

                    BranchAdapter adapter = new BranchAdapter(list, R.layout.recycle_branches, getContext());
                    recyclerView.setAdapter(adapter);

                    recyclerView.setLayoutAnimation(controller);
                    adapter.notifyDataSetChanged();
                    recyclerView.scheduleLayoutAnimation();
                    // Toast.makeText(MainActivity.this, "Succesfully Loaded", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<List<Branch>> call, Throwable t) {
                    retry.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.INVISIBLE);
                    p.setVisibility(View.INVISIBLE);
                   }
            });
        }
        catch (Exception e){
            start();
        }
    }

}
