package com.example.admin.data.Homepage.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.data.Homepage.Model.Exam_Name_MainPage;
import com.example.admin.data.R;

import com.facebook.shimmer.ShimmerFrameLayout;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Nested_Activity_Adapter extends RecyclerView.Adapter<Nested_Activity_Adapter.MyViewHolder> {
    Date d =new Date();
    Context context;
    private List<Exam_Name_MainPage> modelList;
    private final OnItemClick click;
    public  interface OnItemClick{
        void onItem(Exam_Name_MainPage item);
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView activity_name;
        TextView name;

        ShimmerFrameLayout shimmerFrameLayout;
        public RecyclerView nested_recycleview;
        public MyViewHolder(View view) {
            super(view);
            name=view.findViewById(R.id.exan_name);
            shimmerFrameLayout=view.findViewById(R.id.nested_recycle_shimmer);
        }
        public void bind(final Exam_Name_MainPage l,final OnItemClick vv){
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    vv.onItem(l);
                }
            });
        }
    }


    public Nested_Activity_Adapter(List<Exam_Name_MainPage> moviesList,OnItemClick click) {
        this.modelList = moviesList;
        this.context=context;
        this.click=click;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exam_activity_recycleview, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {



            holder.name.setText(modelList.get(position).getExam_name());

        holder.bind(modelList.get(position),click);


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
