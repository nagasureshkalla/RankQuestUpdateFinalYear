package com.example.admin.data.examEamcet.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.data.R;
import com.example.admin.data.examEamcet.model.Branches;

import java.util.List;

public class BranchAdapter extends RecyclerView.Adapter<BranchAdapter.ViewHolder>{

    List<Branches> lis;
    private int rowLayout;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView branch,sf,sa,per,code;

        public ViewHolder(View v) {
            super(v);
            branch=v.findViewById(R.id.branch);
            sa=v.findViewById(R.id.seatavail);
            code=v.findViewById(R.id.bcode);
            sf=v.findViewById(R.id.seatfill);
            per=v.findViewById(R.id.percent);
        }
    }

    public BranchAdapter(List<Branches> lis,int rowLayout, Context context) {
        this.lis=lis;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public BranchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent,false);
        return new BranchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BranchAdapter.ViewHolder holder, int position) {

        holder.branch.setText(lis.get(position).getName().toUpperCase());
        holder.sa.setText(":  "+lis.get(position).getSeats_avali());
        holder.sf.setText(":  "+lis.get(position).getSeats_fill());
        holder.per.setText(":  "+lis.get(position).getPercent());
        holder.code.setText(":  "+lis.get(position).getBranch());
    }

    @Override
    public int getItemCount() {
        return lis.size();
    }
}

