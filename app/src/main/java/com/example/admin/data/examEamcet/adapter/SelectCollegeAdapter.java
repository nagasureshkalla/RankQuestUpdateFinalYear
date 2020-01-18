package com.example.admin.data.examEamcet.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
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
import com.example.admin.data.examEamcet.model.College;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectCollegeAdapter extends RecyclerView.Adapter<SelectCollegeAdapter.ViewHolder> implements FastScrollRecyclerViewInterface {


    List<College> lis=null;
    private int rowLayout;
    Thread splas;
    private Context context;
    public  static List<College> selected;
    public static int[] select=null,unselect,dd;
    int count=0;
    private static List<String> position=null ;
    HashMap<String, Integer> map;




    private final OnItemClickListener click;


    private static List<String> branches=null;
    public static List<String> getBranches(){
        return branches;
    }


    private static SparseBooleanArray itemStateArray= new SparseBooleanArray();

    public static  List<String> getPosition(){
        return position;
    }

    public static int[] getSelect(){

        select = new int[itemStateArray.size()];
        for (int i = 0; i < itemStateArray.size(); i++) {

            if (itemStateArray.size()>0) {
                if (itemStateArray.valueAt(i)) {
                    select[i] = itemStateArray.keyAt(i);

                    Log.i("position : ", String.valueOf(itemStateArray.keyAt(i)) + itemStateArray.valueAt(i));
                }

            }

        }
        return select;
    }

    @Override
    public HashMap<String, Integer> getMapIndex() {
        return map;
    }


    public  interface OnItemClickListener{
        void onItem(College item);
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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
            v.setOnClickListener((View.OnClickListener) this);


        }

        @SuppressLint("ResourceAsColor")
        public void bind(final College l, final OnItemClickListener click,int position){
            //c.setText(String.valueOf(lis.get(position).getPosition()));
            if (!itemStateArray.get(position, false)) {
                //c.setChecked(false);
                c.setImageResource(R.drawable.uncheck);
            }
            else {

                c.setImageResource(R.drawable.check);
                //c.setChecked(true);
            }
        }


        @SuppressLint("ResourceAsColor")
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
                    //c.setChecked(false);

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

    public SelectCollegeAdapter(List<College> lis,HashMap<String ,Integer> map,int rowLayout, OnItemClickListener click, Context context) {
        this.lis=lis;
        this.rowLayout = rowLayout;

        count=0;
        this.map=map;
        position=new ArrayList<>();
        branches=new ArrayList<>();
        itemStateArray.clear();
        this.context = context;
        notifyDataSetChanged();
        this.click = click;
    }

    @Override
    public SelectCollegeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent,false);
        return new SelectCollegeAdapter.ViewHolder(view);
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull SelectCollegeAdapter.ViewHolder holder, int position) {

        holder.collegenam.setText(lis.get(position).getCollegename());
        holder.colcod.setText("College Code :: " + lis.get(position).getCode());
        holder.bind(lis.get(position),click,position);

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
