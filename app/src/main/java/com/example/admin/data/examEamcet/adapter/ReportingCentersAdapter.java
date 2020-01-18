package com.example.admin.data.examEamcet.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.data.R;
import com.example.admin.data.examEamcet.model.ReportingCenters;

import java.util.List;

public class ReportingCentersAdapter extends RecyclerView.Adapter<ReportingCentersAdapter.ViewHolder>{

    List<ReportingCenters> lis;
    private int rowLayout;
    Context context;

    public ReportingCentersAdapter(List<ReportingCenters> lis,Context context) {
        this.lis=lis;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclecolleges, parent,false);
        return new ReportingCentersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.collegenam.setText(lis.get(position).getCenter());
        holder.colcod.setText(lis.get(position).getPlace());
    }

    @Override
    public int getItemCount() {
        return lis.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView collegenam,colcod;

        public ViewHolder(View v) {
            super(v);
            collegenam=v.findViewById(R.id.colname);
            colcod=v.findViewById(R.id.colcode);
        }

    }
}
