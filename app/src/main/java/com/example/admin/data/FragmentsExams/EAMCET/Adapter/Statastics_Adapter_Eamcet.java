package com.example.admin.data.FragmentsExams.EAMCET.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.data.FastScroll.FastScrollRecyclerViewInterface;
import com.example.admin.data.R;
import com.example.admin.data.examEamcet.model.College;


import org.eazegraph.lib.charts.StackedBarChart;

import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Statastics_Adapter_Eamcet extends RecyclerView.Adapter<Statastics_Adapter_Eamcet.ViewHolder> implements FastScrollRecyclerViewInterface {

    List<College> lis;
    HashMap<String,Integer> map;
    Context context;
    String male,female;
    public Statastics_Adapter_Eamcet(List<College> lis, HashMap<String,Integer> map, Context context) {
        this.lis=lis;
        this.map=map;
        this.context = context;
    }


    @NonNull
    @Override
    public Statastics_Adapter_Eamcet.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.statastics, parent,false);
        return new Statastics_Adapter_Eamcet.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Statastics_Adapter_Eamcet.ViewHolder holder, int position) {

        holder.name.setText(lis.get(position).getCollegename().toUpperCase());

    }

    @Override
    public int getItemCount() {
        return lis.size();
    }

    @Override
    public HashMap<String, Integer> getMapIndex() {
        return map;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        StackedBarChart mStackedBarChart;
        public ViewHolder(@NonNull View view) {
            super(view);
            mStackedBarChart = (StackedBarChart) view.findViewById(R.id.stackedbarchart);
            name=view.findViewById(R.id.name);
        }
    }

    public void filterList(List<College> filterlist) {
        this.lis = filterlist;
        notifyDataSetChanged();
    }
}
