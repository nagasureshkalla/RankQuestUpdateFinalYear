package com.example.admin.data.Homepage.DynamicFragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.admin.data.Homepage.rest.ApiClient;
import com.example.admin.data.Homepage.rest.ApiClientExams;
import com.example.admin.data.Homepage.rest.ApiInterfacePut;
import com.example.admin.data.R;
import com.example.admin.data.examEcet.adapter.BranchAdapter;
import com.example.admin.data.examEcet.model.Branch;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class Fragment_Branches_Ecet extends Fragment {
    RecyclerView recyclerView;
    private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";
    ProgressBar p;
    TextView retry;
    SwipeRefreshLayout r;
    List<Branch> list;
    Call<List<Branch>> call;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_fragment__branches__ecet, container, false);
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
                        start(view);
                        r.setRefreshing(false);
                    }
                },2000);
            }
        });

        start(view);


        return view;
    }
    public void start(View view){

        try {

            SharedPreferences sharedPreferences=view.getContext().getSharedPreferences("exam",MODE_PRIVATE);


            p.setVisibility(View.VISIBLE);
            retry.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);


            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_leftto_right);
            ApiInterfacePut apiService = ApiClientExams.getClient().create(ApiInterfacePut.class);

            call = apiService.getExam(sharedPreferences.getString("dbname",""),sharedPreferences.getString("branches",""),API_KEY);
            call.enqueue(new Callback<List<Branch>>() {
                @Override
                public void onResponse(Call<List<Branch>> call, Response<List<Branch>> response) {

                    list = response.body();
                    p.setVisibility(View.INVISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);
                    BranchAdapter adapter = new BranchAdapter(list, R.layout.recycle_branches, getContext());
                    recyclerView.setAdapter(adapter);

                    recyclerView.setLayoutAnimation(controller);
                    adapter.notifyDataSetChanged();
                    recyclerView.scheduleLayoutAnimation();
                    //Toast.makeText(getApplicationContext(), "Succesfully Loaded", Toast.LENGTH_SHORT).show();
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
            start(view);
        }
    }
}
