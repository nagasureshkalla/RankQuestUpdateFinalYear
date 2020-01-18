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
import com.example.admin.data.examEamcet.model.CollegeDetails;

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
            lr=v.findViewById(R.id.lastrank);
        }
    }

    public Seat_Adapter(List<CollegeDetails> list, int rowLayout, Context context) {
        this.list=list;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public Seat_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.br.setText("Best Rank:  "+list.get(position).getBest_Rank_is());
        holder.sa.setText("Seat Available:   " +list.get(position).getNo_of_seats_Avaliable());
        holder.sf.setText("Seat Filled:   "+list.get(position).getNo_of_seats_filled());
        holder.lr.setText("Last Rank:  "+list.get(position).getLast_Rank_is());
        holder.c.setText(council[position]);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
