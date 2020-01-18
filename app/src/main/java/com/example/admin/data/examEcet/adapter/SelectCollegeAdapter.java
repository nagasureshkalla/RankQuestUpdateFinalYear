package com.example.admin.data.examEcet.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.data.FastScroll.FastScrollRecyclerViewInterface;
import com.example.admin.data.R;
import com.example.admin.data.examEcet.model.CollegeDetails;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectCollegeAdapter extends RecyclerView.Adapter<SelectCollegeAdapter.ViewHolder> implements FastScrollRecyclerViewInterface{
    static List<CollegeDetails> lis=null;
    private int rowLayout;
    static int count=0;
    private static Context context;
    List<CollegeDetails> selected=null;
    HashMap<String, Integer> map;

    private static SparseBooleanArray itemStateArray=new SparseBooleanArray();

    private final OnItemClickListener click;

    @Override
    public HashMap<String, Integer> getMapIndex() {
        return map;
    }

    public  interface OnItemClickListener{
        void onItem(CollegeDetails item);
    }
    private static List<String> position=null;
    public static  List<String> getPosition(){
        return position;
    }

    private static List<String> branches=null;
    public static List<String> getBranches(){
        return branches;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        LinearLayout moviesLayout;
        TextView collegenam,colcod;
        CardView cc;
        LinearLayout ll;
        public View v;
        ImageView c;
        public ViewHolder(View v) {
            super(v);
            collegenam=v.findViewById(R.id.college);
            colcod=v.findViewById(R.id.colcode);
            cc=v.findViewById(R.id.cc);
            c=v.findViewById(R.id.checked);

            v.setOnClickListener(this);
        }
        @SuppressLint("ResourceAsColor")
        public void bind(final CollegeDetails l, final OnItemClickListener click,int position){
            //c.setText(String.valueOf(lis.get(position).getPosition()));
            if (!itemStateArray.get(position, false)) {
                c.setImageResource(R.drawable.uncheck);
            }
            else {
                c.setImageResource(R.drawable.check);
            }
        }


        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            if (count<7) {
                if (!itemStateArray.get(adapterPosition, false)) {
                    c.setImageResource(R.drawable.check);
                    itemStateArray.put(adapterPosition, true);
                    count+=1;
                    position.add(lis.get(adapterPosition).getCode());
                    branches.add(lis.get(adapterPosition).getName());
                } else {
                    c.setImageResource(R.drawable.uncheck);
                    itemStateArray.put(adapterPosition, false);
                    count-=1;
                    position.remove(lis.get(adapterPosition).getCode());
                    branches.remove(lis.get(adapterPosition).getName());
                }
            }
            else{
                Toast.makeText(context, R.string.selectColleges, Toast.LENGTH_SHORT).show();
                if (itemStateArray.get(adapterPosition, false)) {
                    c.setImageResource(R.drawable.uncheck);
                    itemStateArray.put(adapterPosition, false);
                    count -= 1;
                    position.remove(lis.get(adapterPosition).getCode());
                    branches.remove(lis.get(adapterPosition).getName());
                }
            }
        }

    }
    public SelectCollegeAdapter(List<CollegeDetails> lis,HashMap<String, Integer> map, int rowLayout, OnItemClickListener click, Context context) {
        this.lis=lis;
        this.map=map;
        this.rowLayout = rowLayout;
        position=new ArrayList<>();
        branches=new ArrayList<>();
        count=0;
        itemStateArray.clear();
        this.context = context;
        this.selected=new ArrayList<>();
        this.click = click;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent,false);
        return new SelectCollegeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CollegeDetails item = lis.get(position);
        holder.collegenam.setText(item.getName());
        holder.colcod.setText("College Code :: " + item.getCode());
        holder.bind(lis.get(position),click,position);
                holder.c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.bind(lis.get(position),click,position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return lis.size();
    }


    public void filterList(List<CollegeDetails> filterlist) {
        this.lis = filterlist;
        notifyDataSetChanged();
    }
}
