package com.example.admin.data.Homepage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.admin.data.Homepage.Model.DevelopersModel;
import com.example.admin.data.R;
import com.squareup.picasso.Picasso;


import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.ViewHolder> {
    List<DevelopersModel> lis;
    private int rowLayout;
    private Context context;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView branch, sa;

        CircleImageView circleImageView;
        public ViewHolder(View v) {
            super(v);
            branch = v.findViewById(R.id.developername);
            sa = v.findViewById(R.id.developermail);
            circleImageView=v.findViewById(R.id.developersimage);
        }
    }

    public DeveloperAdapter(List<DevelopersModel> lis, int rowLayout, Context context) {
        this.lis = lis;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public DeveloperAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new DeveloperAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.branch.setText(lis.get(position).getDevelopername());
        holder.sa.setText(lis.get(position).getMail());



            Picasso.get().load(lis.get(position).getImage())
                    .placeholder(R.drawable.ic_people_outline_black_24dp).into(holder.circleImageView);


    }

    @Override
    public int getItemCount() {
        return lis.size();
    }
}