package com.example.admin.data.examEcet.adapter;


import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
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
import com.example.admin.data.examEcet.model.Branch;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectBranchAdapter extends RecyclerView.Adapter<SelectBranchAdapter.ViewHolder> implements FastScrollRecyclerViewInterface {
   static  List<Branch> lis=null;
   static int count1=0;
    List<Branch> filterlist;
    private int rowLayout;
    private static Context context;
    HashMap<String, Integer> map;
    private static SparseBooleanArray itemStateArray= new SparseBooleanArray();

    private final OnItemClick click;

    private static List<String> position=null;
    private static List<String> branches=null;
    public static  List<String> getPosition(){
        return position;
    }
    public static List<String> getBranches(){
        return branches;
    }

    @Override
    public HashMap<String, Integer> getMapIndex() {
        return map;
    }


    public  interface OnItemClick{
        void onItem(Branch item);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        LinearLayout moviesLayout;
        TextView collegenam,colcod;
        CardView cc;
        LinearLayout ll;
        ImageView c;
        ImageView check;
        public ViewHolder(View v) {
            super(v);
            colcod=v.findViewById(R.id.reportcollege);
            cc=v.findViewById(R.id.cc);
            c=v.findViewById(R.id.c);
            this.setIsRecyclable(false);
            v.setOnClickListener(this);
        }
        @SuppressLint("ResourceAsColor")
        public void bind(final Branch l,OnItemClick click, int position){
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
            if (count1<6) {
                if (!itemStateArray.get(adapterPosition, false)) {
                    c.setImageResource(R.drawable.check);
                    // check.setVisibility(View.VISIBLE);
                    count1+=1;
                    itemStateArray.put(adapterPosition, true);
                    position.add(lis.get(adapterPosition).getBranch());
                    branches.add(lis.get(adapterPosition).getName());
                } else {
                    c.setImageResource(R.drawable.uncheck);
                    //check.setVisibility(View.INVISIBLE);
                    itemStateArray.put(adapterPosition, false);
                    count1-=1;
                    position.remove(lis.get(adapterPosition).getBranch());
                    branches.remove(lis.get(adapterPosition).getName());
                }
            }
            else{
                Toast.makeText(context, R.string.selectBranches, Toast.LENGTH_SHORT).show();
                if (itemStateArray.get(adapterPosition, false)) {
                    c.setImageResource(R.drawable.uncheck);
                    itemStateArray.put(adapterPosition, false);
                    count1-= 1;
                    position.remove(lis.get(adapterPosition).getBranch());
                    branches.remove(lis.get(adapterPosition).getName());
                }
            }
        }

    }
    public SelectBranchAdapter(List<Branch> list,HashMap<String, Integer> map, int rowLayout, OnItemClick click, Context context) {
        this.lis=list;
        this.map=map;
        position=new ArrayList<>();
        count1=0;
        branches=new ArrayList<>();
        itemStateArray.clear();
        this.click=click;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public SelectBranchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent,false);
        return new SelectBranchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectBranchAdapter.ViewHolder holder, int position) {
        holder.colcod.setText(lis.get(position).getName());
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
}
