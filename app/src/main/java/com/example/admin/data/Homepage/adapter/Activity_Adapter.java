package com.example.admin.data.Homepage.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.data.Homepage.Model.Exam_Name_MainPage;
import com.example.admin.data.R;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import yanzhikai.textpath.SyncTextPathView;

public class Activity_Adapter extends RecyclerView.Adapter<Activity_Adapter.MyViewHolder> {

    Context context;
    private Set<String> modelList;
    private List<Exam_Name_MainPage> imageList1=new ArrayList<>();
    private final Nested_Activity_Adapter.OnItemClick click;
    private RecyclerView.RecycledViewPool viewPool;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public SyncTextPathView activity_name;

        public RecyclerView nested_recycleview;
        public MyViewHolder(View view) {
            super(view);
            activity_name =  view.findViewById(R.id.activity_title);
            nested_recycleview=view.findViewById(R.id.nested_activity_recycleview);

        }

        public void bind(final Exam_Name_MainPage l,final OnItemClick vv){
            activity_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    vv.onItem(l);

                }
            });
        }
    }


    public Activity_Adapter(Set<String> moviesList, List<Exam_Name_MainPage> list1, Nested_Activity_Adapter.OnItemClick click) {
        this.click=click;
        this.modelList = moviesList;
        this.imageList1=list1;
        viewPool=new RecyclerView.RecycledViewPool();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_nested_recycleview, parent, false);


        return new MyViewHolder(itemView);
    }
    public  interface OnItemClick{
        void onItem(Exam_Name_MainPage item);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        List<String> stringsList = new ArrayList<>(modelList);
        List<Exam_Name_MainPage> imageList2=new ArrayList<>();

        holder.activity_name.setText(stringsList.get(position));


        Log.d("Event ",stringsList.get(position));


        for (Exam_Name_MainPage customer : imageList1) {
            if (customer.getState().equals(stringsList.get(position))) {
                imageList2.add(customer);
            }
        }


        for(Exam_Name_MainPage list:imageList2){
            Log.d("Exam in Recycle ",list.getExam_name());
        }

        holder.nested_recycleview.setLayoutManager(new GridLayoutManager(context,2));
        //holder.nested_recycleview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true));

        Nested_Activity_Adapter nested_activity_adapter=new Nested_Activity_Adapter(imageList2, click);
        holder.nested_recycleview.setAdapter(nested_activity_adapter);
        holder.nested_recycleview.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
