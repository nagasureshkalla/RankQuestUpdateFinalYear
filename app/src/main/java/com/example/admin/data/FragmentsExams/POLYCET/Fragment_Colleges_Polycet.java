package com.example.admin.data.FragmentsExams.POLYCET;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.data.FastScroll.FastScrollRecyclerViewItemDecoration;
import com.example.admin.data.R;
import com.example.admin.data.examPolycet.Polcet_Colleges_Details;
import com.example.admin.data.examPolycet.adapters.Collegeadapters;
import com.example.admin.data.examPolycet.model.College;
import com.example.admin.data.examPolycet.rest.ApiClient;
import com.example.admin.data.examPolycet.rest.ApiInterface;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


public class Fragment_Colleges_Polycet extends Fragment {
    private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";
    public final static String MESSAGE_KEY ="code";
    EditText t;
    ProgressBar p;
    List<College> colg;
    Call<List<College>> call;
    Collegeadapters adapter;
    TextView retry;
    SwipeRefreshLayout r;
    RecyclerView recyclerVie;
    MaterialCardView c;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment__colleges__polycet, container, false);

        t=(EditText)view.findViewById(R.id.searchview) ;
        t.setVisibility(View.INVISIBLE);
        p=view.findViewById(R.id.progress);
        retry=view.findViewById(R.id.retry);
        r=(SwipeRefreshLayout)view.findViewById(R.id.refreshcollege);
        c=view.findViewById(R.id.c);
        recyclerVie = (RecyclerView) view.findViewById(R.id.fastscroller);


        recyclerVie.setLayoutManager(new LinearLayoutManager(getContext()));
        retry.setVisibility(View.INVISIBLE);
        c.setVisibility(View.INVISIBLE);


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
    void start() {

        try {

            p.setVisibility(View.VISIBLE);
            t.setVisibility(View.INVISIBLE);
            retry.setVisibility(View.INVISIBLE);
            c.setVisibility(View.INVISIBLE);
            recyclerVie.setVisibility(View.INVISIBLE);


            if (API_KEY.isEmpty()) {
                Toast.makeText(getContext(), "Please obtain your API KEY", Toast.LENGTH_LONG).show();
                return;
            }


            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_leftto_right);

            Call<List<College>> call = apiService.getCollege(API_KEY);
            call.enqueue(new Callback<List<College>>() {
                @Override
                public void onResponse(Call<List<College>> call, Response<List<College>> response) {
                    colg = response.body();
                    t.setVisibility(View.VISIBLE);
                    t.setVisibility(View.VISIBLE);
                    t.setVisibility(View.VISIBLE);
                    p.setVisibility(View.INVISIBLE);
                    c.setVisibility(View.VISIBLE);
                    recyclerVie.setVisibility(View.VISIBLE);
                    Collections.sort(colg);

                    HashMap<String,Integer> map=calculateIndexesForName(colg);
                    recyclerVie.setHasFixedSize(true);
                    adapter = new Collegeadapters(colg,map,R.layout.recyclecolleges, new Collegeadapters.OnItemClick() {
                        @Override
                        public void onItem(College item) {
                            //Toast.makeText(getApplicationContext(), "Clicked "+item.getCode(), Toast.LENGTH_SHORT).show();
                            Intent r = new Intent(getContext(), Polcet_Colleges_Details.class);
                            r.putExtra(MESSAGE_KEY, item.getCode());
                            startActivity(r);
                        }
                    }, getContext());
                    recyclerVie.setAdapter(adapter);

                    recyclerVie.setLayoutAnimation(controller);
                    adapter.notifyDataSetChanged();
                    recyclerVie.scheduleLayoutAnimation();

                    FastScrollRecyclerViewItemDecoration decoration = new FastScrollRecyclerViewItemDecoration(getContext());
                    recyclerVie.addItemDecoration(decoration);
                    recyclerVie.setItemAnimator(new DefaultItemAnimator());
                }

                @Override
                public void onFailure(Call<List<College>> call, Throwable t) {
                    retry.setVisibility(View.VISIBLE);
                    recyclerVie.setVisibility(View.INVISIBLE);
                    p.setVisibility(View.INVISIBLE);
                    c.setVisibility(View.INVISIBLE);
                    }
            });
            setupsearch();
        }
        catch (Exception e){
            start();
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
        List<College> filterdNames =new ArrayList<College>();

        //looping through existing elements
        for (College s : colg) {
            //if the existing elements contains the search input
            if (s.getName().contains(text.toUpperCase())||s.getCode().contains(text.toUpperCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }
        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(filterdNames);

    }
    private HashMap<String, Integer> calculateIndexesForName(List<College> items){

        HashMap<String, Integer> mapIndex = new LinkedHashMap<>();
        for (int i = 0; i<items.size(); i++){
            String name = items.get(i).getName();
            System.out.println(name+"\n");
            String index = name.substring(0,1);
            Log.i(index,"hello");
            index = index.toUpperCase();
            Log.i("what in upper",index);

            if (!mapIndex.containsKey(index)) {
                mapIndex.put(index, i);
            }
        }
        System.out.println(mapIndex+"in map index");
        return mapIndex;
    }

}
