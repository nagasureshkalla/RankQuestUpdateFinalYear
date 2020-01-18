package com.example.admin.data.examPolycet.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.data.FastScroll.FastScrollRecyclerViewInterface;
import com.example.admin.data.R;
import com.example.admin.data.examPolycet.model.College;

import java.util.HashMap;
import java.util.List;

public class StatasticsAdapter_Polycet extends RecyclerView.Adapter<StatasticsAdapter_Polycet.ViewHolder> implements FastScrollRecyclerViewInterface{

    List<College> lis;
    List<College> filterlist;
    private int rowLayout;
    private Context context;
    private final OnItemClick click;

    HashMap<String, Integer> map;
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
        public void bind(final College l,final OnItemClick vv){
            cc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    vv.onItem(l);
                }
            });
        }
    }

    public StatasticsAdapter_Polycet(List<College> lis,HashMap<String, Integer> map,OnItemClick click, Context context) {
        this.lis=lis;
        this.click=click;
        this.map=map;
        this.context = context;
    }

    @Override
    public StatasticsAdapter_Polycet.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclecolleges, parent,false);
        return new StatasticsAdapter_Polycet.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.colname.setText(lis.get(position).getName());
        holder.colcode.setText("College code :"+lis.get(position).getCode());
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
