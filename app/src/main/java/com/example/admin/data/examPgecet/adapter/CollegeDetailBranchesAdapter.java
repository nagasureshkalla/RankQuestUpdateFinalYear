package com.example.admin.data.examPgecet.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.data.examPgecet.model.CollegeBranchDetails;

import java.util.List;

public class CollegeDetailBranchesAdapter extends RecyclerView.Adapter<CollegeDetailBranchesAdapter.ViewHolder>  {
    List<CollegeBranchDetails> lis;
    private int rowLayout;
    private Context context;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView branch,mo1,mo2,mo3,mo4,mo5,mo6,mo7,mo8,mc1,mc2,mc3,mc4,mc5,mc6,mc7,mc8,fo1,fo2,fo3,fo4,fo5,fo6,fo7,fo8,fc1,fc2,fc3,fc4,fc5,fc6,fc7,fc8;
        public ViewHolder(View v) {
            super(v);

          /*  branch=v.findViewById(R.id.branchname);
            mo1=v.findViewById(R.id.mo1);
            mo2=v.findViewById(R.id.mo2);
            mo3=v.findViewById(R.id.mo3);
            mo4=v.findViewById(R.id.mo4);
            mo5=v.findViewById(R.id.mo5);
            mo6=v.findViewById(R.id.mo6);
            mo7=v.findViewById(R.id.mo7);
            mo8=v.findViewById(R.id.mo8);
            mc1=v.findViewById(R.id.mc1);
            mc2=v.findViewById(R.id.mc2);
            mc3=v.findViewById(R.id.mc3);
            mc4=v.findViewById(R.id.mc4);
            mc5=v.findViewById(R.id.mc5);
            mc6=v.findViewById(R.id.mc6);
            mc7=v.findViewById(R.id.mc7);
            mc8=v.findViewById(R.id.mc8);
            fo1=v.findViewById(R.id.fo1);
            fo2=v.findViewById(R.id.fo2);
            fo3=v.findViewById(R.id.fo3);
            fo4=v.findViewById(R.id.fo4);
            fo5=v.findViewById(R.id.fo5);
            fo6=v.findViewById(R.id.fo6);
            fo7=v.findViewById(R.id.fo7);
            fo8=v.findViewById(R.id.fo8);
            fc1=v.findViewById(R.id.fc1);
            fc2=v.findViewById(R.id.fc2);
            fc3=v.findViewById(R.id.fc3);
            fc4=v.findViewById(R.id.fc4);
            fc5=v.findViewById(R.id.fc5);
            fc6=v.findViewById(R.id.fc6);
            fc7=v.findViewById(R.id.fc7);
            fc8=v.findViewById(R.id.fc8);*/

        }
    }
    public CollegeDetailBranchesAdapter(List<CollegeBranchDetails> list2, int recycle_college_branch_details, Context applicationContext) {
        this.lis=list2;
        this.rowLayout = recycle_college_branch_details;
        this.context = applicationContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent,false);
        return new CollegeDetailBranchesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      /*  holder.branch.setText("Branch Code:"+lis.get(position).getBranch());
        holder.mo1.setText(lis.get(position).getOc_m_min());
        holder.mo2.setText(lis.get(position).getBc_a_m_min());
        holder.mo3.setText(lis.get(position).getBc_b_m_min());
        holder.mo4.setText(lis.get(position).getBc_c_m_min());
        holder.mo5.setText(lis.get(position).getBc_d_m_min());
        holder.mo6.setText(lis.get(position).getBc_e_m_min());
        holder.mo7.setText(lis.get(position).getSc_m_min());
        holder.mo8.setText(lis.get(position).getSt_m_min());

        holder.mc1.setText(lis.get(position).getOc_m_max());
        holder.mc2.setText(lis.get(position).getBc_a_m_max());
        holder.mc3.setText(lis.get(position).getBc_b_m_max());
        holder.mc4.setText(lis.get(position).getBc_c_m_max());
        holder.mc5.setText(lis.get(position).getBc_d_m_max());
        holder.mc6.setText(lis.get(position).getBc_e_m_max());
        holder.mc7.setText(lis.get(position).getSc_m_max());
        holder.mc8.setText(lis.get(position).getSt_m_max());

        holder.fo1.setText(lis.get(position).getOc_f_min());
        holder.fo2.setText(lis.get(position).getBc_a_f_min());
        holder.fo3.setText(lis.get(position).getBc_b_f_min());
        holder.fo4.setText(lis.get(position).getBc_c_f_min());
        holder.fo5.setText(lis.get(position).getBc_d_f_min());
        holder.fo6.setText(lis.get(position).getBc_e_f_min());
        holder.fo7.setText(lis.get(position).getSc_f_min());
        holder.fo8.setText(lis.get(position).getSt_f_min());

        holder.fc1.setText(lis.get(position).getOc_f_max());
        holder.fc2.setText(lis.get(position).getBc_a_f_max());
        holder.fc3.setText(lis.get(position).getBc_b_f_max());
        holder.fc4.setText(lis.get(position).getBc_c_f_max());
        holder.fc5.setText(lis.get(position).getBc_d_f_max());
        holder.fc6.setText(lis.get(position).getBc_e_f_max());
        holder.fc7.setText(lis.get(position).getSc_f_max());
        holder.fc8.setText(lis.get(position).getSt_f_max());*/
    }


    @Override
    public int getItemCount() {
        return lis.size();
    }
}
