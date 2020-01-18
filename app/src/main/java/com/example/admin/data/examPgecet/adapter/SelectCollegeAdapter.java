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
import com.example.admin.data.examPgecet.model.College;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectCollegeAdapter extends RecyclerView.Adapter<SelectCollegeAdapter.ViewHolder> implements FastScrollRecyclerViewInterface{
    static List<College> lis;
    private int rowLayout;
    private static Context context;
    static int count=0;
    List<College> selected;

    HashMap<String,Integer> map;
    private static SparseBooleanArray itemStateArray= new SparseBooleanArray();

    private final OnItemClickListener click;

    @Override
    public HashMap<String, Integer> getMapIndex() {
        return map;
    }

    public  interface OnItemClickListener{
        void onItem(College item);
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
        public View v;
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
        public void bind(final College l, final OnItemClickListener click,int position){
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
                    count += 1;
                    position.add(lis.get(adapterPosition).getCode());
                    branches.add(lis.get(adapterPosition).getCollegename());
                } else {
                    c.setImageResource(R.drawable.uncheck);
                    itemStateArray.put(adapterPosition, false);
                    count -= 1;
                    position.remove(lis.get(adapterPosition).getCode());
                    branches.remove(lis.get(adapterPosition).getCollegename());
                }
            }
            else{
                Toast.makeText(context, R.string.selectColleges, Toast.LENGTH_SHORT).show();
                if (itemStateArray.get(adapterPosition, false)) {
                    c.setImageResource(R.drawable.uncheck);
                    itemStateArray.put(adapterPosition, false);
                    count -= 1;
                    position.remove(lis.get(adapterPosition).getCode());
                    branches.remove(lis.get(adapterPosition).getCollegename());
                }
            }
        }

    }
    public SelectCollegeAdapter(List<College> lis,HashMap<String,Integer> map,int rowLayout, OnItemClickListener click, Context context) {
        this.lis=lis;
        this.rowLayout = rowLayout;
        count=0;
        this.map=map;
        this.context = context;
        position=new ArrayList<>();
        branches=new ArrayList<>();
        itemStateArray.clear();
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

        holder.collegenam.setText(lis.get(position).getCollegename());
        holder.colcod.setText("College Code :: " + lis.get(position).getCode());
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


    public void filterList(List<College> filterlist) {
        this.lis = filterlist;
        notifyDataSetChanged();
    }
}
