package com.example.admin.data.examEamcet.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.data.R;
import com.example.admin.data.examEamcet.model.CollegeBranchDetails;

import java.util.List;

public class CutoffAdapter extends RecyclerView.Adapter<CutoffAdapter.ViewHolder>{
    List<CollegeBranchDetails> list1;
    private int rowLayout;
    private Context context1;

    private final OnItemClick click;

    public  interface OnItemClick{
        void onItem(CollegeBranchDetails item);
    }
    public CutoffAdapter(List<CollegeBranchDetails> list1, int rowLayout,OnItemClick click, Context context1) {
        this.list1=list1;
        this.rowLayout=rowLayout;
        this.click=click;
        this.context1=context1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public  TextView college,openr,closer;
        public CardView cardView;


        public ViewHolder(View v) {
            super(v);
            college=(TextView)v.findViewById(R.id.col);
            openr=(TextView)v.findViewById(R.id.openrank);
            closer=(TextView)v.findViewById(R.id.closerank);
            cardView=(CardView)v.findViewById(R.id.cutoffcard);
        }
        public void bind(final CollegeBranchDetails l, final OnItemClick vv){
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    vv.onItem(l);
                }
            });
        }
    }


    @NonNull
    @Override
    public CutoffAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent,false);
        return new CutoffAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.college.setText(list1.get(position).getName());
        holder.openr.setText("Branch: "+list1.get(position).getBranch());
        holder.closer.setText("College Code: "+list1.get(position).getCode());
        holder.bind(list1.get(position),click);

    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public void filterList(List<CollegeBranchDetails> filterlist) {
        this.list1 = filterlist;
        notifyDataSetChanged();
    }

}
