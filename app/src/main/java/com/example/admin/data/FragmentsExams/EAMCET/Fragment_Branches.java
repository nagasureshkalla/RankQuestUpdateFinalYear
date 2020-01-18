package com.example.admin.data.FragmentsExams.EAMCET;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
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
import android.widget.Toast;

import com.example.admin.data.R;
import com.example.admin.data.examEamcet.adapter.BranchAdapter;
import com.example.admin.data.examEamcet.model.Branches;
import com.example.admin.data.examEamcet.rest.ApiClient;
import com.example.admin.data.examEamcet.rest.ApiInterface;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Collections;
import java.util.List;


public class Fragment_Branches extends Fragment {
    private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";
    Call<List<Branches>> call;
    List<Branches> bran;
    RecyclerView recyclerView;
    ProgressBar p;
    TextView retry;
    SwipeRefreshLayout r;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_fragment__branches, container, false);
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
    public void start(){
        try {
            p.setVisibility(View.VISIBLE);
            retry.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);

            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_leftto_right);
            call = apiService.getBran(API_KEY);
            call.enqueue(new Callback<List<Branches>>() {
                @Override
                public void onResponse(Call<List<Branches>> call, Response<List<Branches>> response) {
                    bran = response.body();

                    p.setVisibility(View.INVISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);

                    Collections.sort(bran);
                    BranchAdapter adapter = new BranchAdapter(bran, R.layout.recycle_branches, getContext());
                    recyclerView.setAdapter(adapter);


                    recyclerView.setLayoutAnimation(controller);
                    adapter.notifyDataSetChanged();
                    recyclerView.scheduleLayoutAnimation();
                    //Toast.makeText(Eamcet_Branches.this, "Succesfully Loaded", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<List<Branches>> call, Throwable t) {
                    retry.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.INVISIBLE);
                    p.setVisibility(View.INVISIBLE);

                    // Toast.makeText(Eamcet_Branches.this, "No Internet Connection", Toast.LENGTH_LONG).show();

                }
            });
        }catch (Exception e){
            start();
        }
    }
}
