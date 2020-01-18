package com.example.admin.data.FragmentsExams.PGECET;

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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.data.R;
import com.example.admin.data.examPgecet.adapter.BranchAdapter;
import com.example.admin.data.examPgecet.model.Branches;
import com.example.admin.data.examPgecet.rest.ApiClient;
import com.example.admin.data.examPgecet.rest.ApiInterface;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Branches_Pgcet extends Fragment {
    private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";
    Call<List<Branches>> call;
    List<Branches> bran;
    BranchAdapter adapter;
    EditText t;
    ProgressBar p;
    TextView retry;
    SwipeRefreshLayout r;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment__branches__pgcet, container, false);
        recyclerView = view.findViewById(R.id.recyclebranch);
        t=view.findViewById(R.id.branch);
        p=view.findViewById(R.id.progress);
        retry=view.findViewById(R.id.retry);
        r=(SwipeRefreshLayout)view.findViewById(R.id.refreshcollege);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        retry.setVisibility(View.INVISIBLE);
        t.setVisibility(View.INVISIBLE);

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
            t.setVisibility(View.INVISIBLE);

            if (API_KEY.isEmpty()) {
                Toast.makeText(getContext(), "Please obtain your API KEY", Toast.LENGTH_LONG).show();
                return;
            }

            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_leftto_right);

            call = apiService.getBran(API_KEY);
            call.enqueue(new Callback<List<Branches>>() {
                @Override
                public void onResponse(Call<List<Branches>> call, Response<List<Branches>> response) {
                    bran = response.body();

                    t.setVisibility(View.VISIBLE);
                    p.setVisibility(View.INVISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);
                    t.setVisibility(View.VISIBLE);
                    adapter = new BranchAdapter(bran, R.layout.recycle_branches, getContext());
                    recyclerView.setAdapter(adapter);

                    recyclerView.setLayoutAnimation(controller);
                    adapter.notifyDataSetChanged();
                    recyclerView.scheduleLayoutAnimation();
                    //Toast.makeText(Eamcet_Branches.this, "Succesfully Loaded", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<List<Branches>> call, Throwable th) {
                    retry.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.INVISIBLE);
                    p.setVisibility(View.INVISIBLE);
                    t.setVisibility(View.INVISIBLE);
                   //Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                }
            });
            setupsearch();
        }
        catch (Exception e){

        }
    }
    public void setupsearch(){

        t.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString());
            }
        });
    }
    private void filter(String text) {
        //new array list that will hold the filtered data
        List<Branches> filterdNames =new ArrayList<>();

        //looping through existing elements
        for (Branches s : bran) {
            //if the existing elements contains the search input
            if (s.getName().contains(text.toUpperCase())||s.getBranch().contains(text.toUpperCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }
        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(filterdNames);

    }

}
