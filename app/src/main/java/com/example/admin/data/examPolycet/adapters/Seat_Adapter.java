package com.example.admin.data.examPolycet.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.data.R;
import com.example.admin.data.examPolycet.model.SeatsBranches;


import java.util.List;

public class Seat_Adapter extends RecyclerView.Adapter<Seat_Adapter.ViewHolder> {
    List<SeatsBranches> list;
    private int rowLayout;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView id,title;
        TextView collegenam,code,place,fees,bran,dist,sf,sa,br,lr,c;

        public ViewHolder(View v) {
            super(v);
            c=v.findViewById(R.id.colname);
            sf=v.findViewById(R.id.colcode);
        }
    }
    public Seat_Adapter(List<SeatsBranches> list, int rowLayout, Context context) {
        this.list=list;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.br.setText("Branch: "+list.get(position).getBranch());
        holder.sa.setText("Conveyer Seats:  " +list.get(position).getConveyseats());

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
