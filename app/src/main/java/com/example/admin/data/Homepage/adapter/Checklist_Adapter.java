package com.example.admin.data.Homepage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.data.Homepage.Model.ChecklistModel;
import com.example.admin.data.R;
import com.example.admin.data.examEamcet.adapter.ReportingCentersAdapter;

import java.util.List;

public class Checklist_Adapter extends RecyclerView.Adapter<Checklist_Adapter.ViewHolder>{

    List<ChecklistModel> lis;
    private int rowLayout;
    Context context;

    public Checklist_Adapter(List<ChecklistModel> lis,Context context) {
        this.lis=lis;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_checklist, parent,false);
        return new Checklist_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.collegenam.setText(lis.get(position).getTitle());
        holder.colcod.setText(lis.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return lis.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView collegenam,colcod;

        public ViewHolder(View v) {
            super(v);
            collegenam=v.findViewById(R.id.title);
            colcod=v.findViewById(R.id.body);
        }

    }
}
