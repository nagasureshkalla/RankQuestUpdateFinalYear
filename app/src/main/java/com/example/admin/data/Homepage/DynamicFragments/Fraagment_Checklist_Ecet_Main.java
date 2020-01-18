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

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.admin.data.Homepage.Model.ChecklistModel;
import com.example.admin.data.Homepage.adapter.Checklist_Adapter;
import com.example.admin.data.Homepage.rest.ApiClientExams;
import com.example.admin.data.Homepage.rest.ApiInterfacePut;
import com.example.admin.data.R;
import com.example.admin.data.examEamcet.adapter.ReportingCentersAdapter;
import com.example.admin.data.examEamcet.model.ReportingCenters;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class Fraagment_Checklist_Ecet_Main extends Fragment {

    RecyclerView r;
    private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";
    Checklist_Adapter adapter;
    ProgressBar p;
    TextView retry;
    SwipeRefreshLayout swipeRefreshLayout;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_fraagment__checklist__ecet__main, container, false);


        p=view.findViewById(R.id.progress);
        retry=view.findViewById(R.id.retry);
        swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.refreshcollege);
        r = (RecyclerView) view.findViewById(R.id.recyclereports);
        r.setLayoutManager(new LinearLayoutManager(getContext()));
        retry.setVisibility(View.INVISIBLE);


        swipeRefreshLayout.setColorSchemeResources(R.color.cutdown);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        start(view);
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },2000);
            }
        });

        start(view);

        return view;
    }
    public void start(View view){
        try {

            SharedPreferences details = view.getContext().getSharedPreferences("exam", MODE_PRIVATE);

            p.setVisibility(View.VISIBLE);
            retry.setVisibility(View.INVISIBLE);
            r.setVisibility(View.INVISIBLE);
            ApiInterfacePut apiService = ApiClientExams.getClient().create(ApiInterfacePut.class);
            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_leftto_right);
            Call<List<ChecklistModel>> call = apiService.getChecklist(details.getString("dbname",""),details.getString("checklist",""),API_KEY);
            call.enqueue(new Callback<List<ChecklistModel>>() {
                @Override
                public void onResponse(Call<List<ChecklistModel>> call, Response<List<ChecklistModel>> response) {
                    List<ChecklistModel> colg = response.body();
                    p.setVisibility(View.INVISIBLE);
                    r.setVisibility(View.VISIBLE);
                    adapter = new Checklist_Adapter(colg, getContext());
                    r.setAdapter(adapter);

                    r.setLayoutAnimation(controller);
                    adapter.notifyDataSetChanged();
                    r.scheduleLayoutAnimation();

                }

                @Override
                public void onFailure(Call<List<ChecklistModel>> call, Throwable t) {
                    retry.setVisibility(View.VISIBLE);
                    r.setVisibility(View.INVISIBLE);
                    p.setVisibility(View.INVISIBLE);
                }
            });
        }catch (Exception e){
            start(view);
        }
    }
}
