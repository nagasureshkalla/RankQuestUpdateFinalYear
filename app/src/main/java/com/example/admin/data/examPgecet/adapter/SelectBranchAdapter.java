package com.example.admin.data.examPgecet.adapter;

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
import com.example.admin.data.examPgecet.model.Branches;
import com.example.admin.data.examPgecet.model.CollegeDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectBranchAdapter extends RecyclerView.Adapter<SelectBranchAdapter.ViewHolder> implements FastScrollRecyclerViewInterface{
    static List<Branches> lis;
    List<CollegeDetails> filterlist;
    private int rowLayout;
    private static Context context;
    static int count1=0;
    private static SparseBooleanArray itemStateArray= new SparseBooleanArray();
    private final SelectBranchAdapter.OnItemClick click;

    HashMap<String,Integer> map;
    @Override
    public HashMap<String, Integer> getMapIndex() {
        return map;
    }

    public  interface OnItemClick{
        void onItem(Branches item);
    }
    private static List<String> position=null;
    public static  List<String> getPosition(){
        return position;
    }
    private static List<String> branches=null;
    public static List<String> getBranches(){
        return branches;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout moviesLayout;
        TextView collegenam,colcod;
        CardView cc;
        LinearLayout ll;
        ImageView c;
        public ViewHolder(View v) {
            super(v);
            collegenam=v.findViewById(R.id.college);
            colcod=v.findViewById(R.id.colcode);
            cc=v.findViewById(R.id.cc);
            c=v.findViewById(R.id.checked);
            this.setIsRecyclable(false);
            v.setOnClickListener(this);
        }
        @SuppressLint("ResourceAsColor")
        public void bind(final Branches l, final OnItemClick click, int position){
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
                    itemStateArray.put(adapterPosition, true);
                    count1+=1;
                    position.add(lis.get(adapterPosition).getBranch());
                    branches.add(lis.get(adapterPosition).getName());
                } else {
                    c.setImageResource(R.drawable.uncheck);
                    itemStateArray.put(adapterPosition, false);
                    count1-=1;
                    position.remove(lis.get(adapterPosition).getBranch());
                    branches.remove(lis.get(adapterPosition).getName());
                }
            }
            else {
                Toast.makeText(context, R.string.selectBranches, Toast.LENGTH_SHORT).show();
                if (itemStateArray.get(adapterPosition, false)) {
                    c.setImageResource(R.drawable.uncheck);
                    itemStateArray.put(adapterPosition, false);
                    count1 -= 1;
                    position.remove(lis.get(adapterPosition).getBranch());
                    branches.remove(lis.get(adapterPosition).getName());
                }
            }
        }
    }
    public SelectBranchAdapter(List<Branches> list,HashMap<String,Integer> map,int rowLayout, OnItemClick click, Context context) {
        this.lis=list;
        this.click=click;
        this.map=map;
        count1=0;
        position=new ArrayList<>();
        branches=new ArrayList<>();
        itemStateArray.clear();
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
        holder.collegenam.setText(lis.get(position).getName());
        holder.colcod.setText("Branch Code : "+lis.get(position).getBranch());
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
