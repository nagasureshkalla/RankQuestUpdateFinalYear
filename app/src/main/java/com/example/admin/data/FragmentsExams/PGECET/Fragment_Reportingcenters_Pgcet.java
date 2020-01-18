package com.example.admin.data.FragmentsExams.PGECET;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.admin.data.R;
import com.example.admin.data.examEamcet.adapter.ReportingCentersAdapter;
import com.example.admin.data.examEamcet.model.ReportingCenters;
import com.example.admin.data.examPgecet.rest.ApiClient;
import com.example.admin.data.examPgecet.rest.ApiInterface;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Reportingcenters_Pgcet extends Fragment {

    private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";
    ReportingCentersAdapter adapter;
    RecyclerView r;
    ProgressBar p;
    TextView retry;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_fragment__reportingcenters__pgcet, container, false);

        p=view.findViewById(R.id.progress);
        retry=view.findViewById(R.id.retry);
        swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.refreshcollege);
        swipeRefreshLayout.setColorSchemeResources(R.color.cutdown);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        start();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },2000);
            }
        });
        r = (RecyclerView) view.findViewById(R.id.recyclereports);
        r.setLayoutManager(new LinearLayoutManager(getContext()));
        retry.setVisibility(View.INVISIBLE);

        start();
        return view;
    }

    public void start(){

        try {
            p.setVisibility(View.VISIBLE);
            retry.setVisibility(View.INVISIBLE);
            r.setVisibility(View.INVISIBLE);

            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_leftto_right);

            Call<List<ReportingCenters>> call = apiService.getCentre(API_KEY);
            call.enqueue(new Callback<List<ReportingCenters>>() {
                @Override
                public void onResponse(Call<List<ReportingCenters>> call, Response<List<ReportingCenters>> response) {
                    List<ReportingCenters> colg = response.body();
                    p.setVisibility(View.INVISIBLE);
                    r.setVisibility(View.VISIBLE);
                    adapter = new ReportingCentersAdapter(colg, getContext());
                    r.setAdapter(adapter);

                    r.setLayoutAnimation(controller);
                    adapter.notifyDataSetChanged();
                    r.scheduleLayoutAnimation();
                }

                @Override
                public void onFailure(Call<List<ReportingCenters>> call, Throwable t) {
                    retry.setVisibility(View.VISIBLE);
                    r.setVisibility(View.INVISIBLE);
                    p.setVisibility(View.INVISIBLE);// Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                }
            });
        }
        catch (Exception e){

        }

    }
}
