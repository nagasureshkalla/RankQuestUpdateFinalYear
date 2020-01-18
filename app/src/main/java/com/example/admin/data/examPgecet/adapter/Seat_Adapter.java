package com.example.admin.data.examPgecet.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.data.R;
import com.example.admin.data.examPgecet.model.CollegeDetails;

import java.util.List;

public class Seat_Adapter extends RecyclerView.Adapter<Seat_Adapter.ViewHolder> {
    List<CollegeDetails> list;
    private int rowLayout;
    private Context context;
    String[] council={"counselling 1","counselling 2","counselling 3"};

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView id,title;
        TextView collegenam,code,place,fees,bran,dist,sf,sa,br,lr,c;

        public ViewHolder(View v) {
            super(v);
            c=v.findViewById(R.id.c);
            sf=v.findViewById(R.id.seat_f);
            sa=v.findViewById(R.id.seat_a);
            br=v.findViewById(R.id.bestrank);
        }
    }

    public Seat_Adapter(List<CollegeDetails> lis, int rowLayout, Context context) {
        this.list=lis;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent,false);
        return new Seat_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sa.setText("Total Seats: "+list.get(position).getTotal_seats());
        holder.br.setText("Branch: "+list.get(position).getBranch_name());
        holder.sf.setText("Branch Code:"+list.get(position).getBranch_code());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
