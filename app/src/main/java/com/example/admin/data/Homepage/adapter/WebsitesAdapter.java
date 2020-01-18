package com.example.admin.data.Homepage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.admin.data.Homepage.Model.WebsitesModel;
import com.example.admin.data.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class WebsitesAdapter extends RecyclerView.Adapter<WebsitesAdapter.ViewHolder> {
    List<WebsitesModel> lis;
    private int rowLayout;
    private Context context;

    private final OnItemClick click;



    public  interface OnItemClick{
        void onItem(WebsitesModel item);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView branch;

        public ViewHolder(View v) {
            super(v);
            branch = v.findViewById(R.id.websitename);

        }
        public void bind(final WebsitesModel l,final OnItemClick vv){
            branch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    vv.onItem(l);
                }
            });
        }
    }

    public WebsitesAdapter(List<WebsitesModel> lis, int rowLayout, Context context,OnItemClick click) {
        this.lis = lis;
        this.rowLayout = rowLayout;
        this.context = context;
        this.click=click;
    }

    @Override
    public WebsitesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new WebsitesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WebsitesAdapter.ViewHolder holder, int position) {
        holder.branch.setText(lis.get(position).getExamname().toUpperCase());
        holder.bind(lis.get(position),click);

    }

    @Override
    public int getItemCount() {
        return lis.size();
    }
}
