package com.example.admin.data.examPgecet.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.data.R;
import com.example.admin.data.examPgecet.model.College;
import com.example.admin.data.examPgecet.model.CollegeDetails;

import java.util.List;

public class CollegeDatailAdapter extends RecyclerView.Adapter<CollegeDatailAdapter.ViewHolder> {
    List<CollegeDetails> lis;
    List<College> lis2;
    private int rowLayout;
    private Context context;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;

        TextView collegenam,colcod,fee,dist,place,region,type,afflicted,coed;
        public ViewHolder(View v) {
            super(v);

            collegenam=v.findViewById(R.id.collegename);
            colcod=v.findViewById(R.id.code);
            fee=v.findViewById(R.id.fee1);
            dist=v.findViewById(R.id.distname);
            place=v.findViewById(R.id.place);
            region=v.findViewById(R.id.regions);
            type=v.findViewById(R.id.collegetype);
            coed=v.findViewById(R.id.coeduction);
            afflicted=v.findViewById(R.id.affiliate);
        }
    }
    public CollegeDatailAdapter(List<CollegeDetails> lis, int rowLayout, Context context) {
        this.lis=lis;
        this.rowLayout = rowLayout;
        this.context = context;
        this.lis2=lis2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent,false);
        return new CollegeDatailAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollegeDatailAdapter.ViewHolder holder, int position) {
        holder.collegenam.setText(lis.get(position).getNamenew());
        holder.colcod.setText(": "+lis.get(position).getCodenew());
        holder.fee.setText(": "+lis.get(position).getFee());
        holder.place.setText(": "+lis.get(position).getPlace());
        holder.dist.setText(": "+lis.get(position).getDist());
        holder.coed.setText(": "+lis.get(position).getCoed());
        holder.region.setText(": "+lis.get(position).getRegion());
        holder.afflicted.setText(": "+lis.get(position).getAffil());
        holder.type.setText(": "+lis.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
