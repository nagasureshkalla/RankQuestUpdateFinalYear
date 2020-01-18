package com.example.admin.data.examEcet.adapter;



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
import com.example.admin.data.examEcet.model.CollegeDetails;

import java.util.HashMap;
import java.util.List;

public class CollegeAdapter extends RecyclerView.Adapter<CollegeAdapter.ViewHolder> implements FastScrollRecyclerViewInterface{

    List<CollegeDetails> lis;
    List<CollegeDetails> filterlist;
    private int rowLayout;
    int row_index;
    private Context context;
    private final OnItemClick click;
    HashMap<String, Integer> map;

    @Override
    public HashMap<String, Integer> getMapIndex() {
        return map;
    }

    public  interface OnItemClick{
        void onItem(CollegeDetails item);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView collegenam,colcod,fee,dist,place,region,type,afflicted,coed;
        CardView cc;
        LinearLayout ll;

        public ViewHolder(View v) {
            super(v);
            cc=v.findViewById(R.id.cc);
            collegenam=v.findViewById(R.id.colname);
            colcod=v.findViewById(R.id.colcode);

        }
        public void bind(final CollegeDetails l,final OnItemClick vv){
            cc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    vv.onItem(l);
                }
            });
        }
    }

    public CollegeAdapter(List<CollegeDetails> lis,HashMap<String, Integer> map,int rowLayout,OnItemClick click, Context context) {
        this.lis=lis;
        this.click=click;
        this.map=map;
        this.rowLayout=rowLayout;
        this.context = context;
    }

    @Override
    public CollegeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent,false);
        return new CollegeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollegeAdapter.ViewHolder holder, int position) {
        holder.collegenam.setText(lis.get(position).getName());
        holder.colcod.setText("College Code :: "+lis.get(position).getCode());
        holder.bind(lis.get(position),click);

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
