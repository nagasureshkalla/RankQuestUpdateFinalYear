package com.example.admin.data.examPgecet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.data.FastScroll.FastScrollRecyclerViewInterface;
import com.example.admin.data.R;
import com.example.admin.data.examPgecet.model.College;
import com.example.admin.data.examPgecet.model.CollegeDetails;

import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class StatasticsAdapter extends RecyclerView.Adapter<StatasticsAdapter.ViewHolder> implements FastScrollRecyclerViewInterface{

    List<College> lis;
    List<College> filterlist;
    private int rowLayout;
    private Context context;
    private final OnItemClick click;

    HashMap<String,Integer> map;
    @Override
    public HashMap<String, Integer> getMapIndex() {
        return map;
    }

    public  interface OnItemClick{
        void onItem(College item);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView colname,colcode;
        CardView cc;
        LinearLayout ll;

        public ViewHolder(View v) {
            super(v);
            cc=v.findViewById(R.id.cc);
            colname=v.findViewById(R.id.colname);
            colcode=v.findViewById(R.id.colcode);
        }
        public void bind(final College l, final OnItemClick vv){
            cc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    vv.onItem(l);
                }
            });
        }
    }

    public StatasticsAdapter(List<College> lis, HashMap<String,Integer> map, OnItemClick click, Context context) {
        this.lis=lis;
        this.click=click;
        this.map=map;
        this.context = context;
    }

    @Override
    public StatasticsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclecolleges, parent,false);
        return new StatasticsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatasticsAdapter.ViewHolder holder, int position) {
        holder.colname.setText(lis.get(position).getCollegename());
        holder.colcode.setText("College Code : "+lis.get(position).getCode());
        holder.bind(lis.get(position),click);

    }

    @Override
    public int getItemCount() {
        return lis.size();
    }


    public void filterList(List<College> filterlist) {
        this.lis = filterlist;
        notifyDataSetChanged();
    }

}
