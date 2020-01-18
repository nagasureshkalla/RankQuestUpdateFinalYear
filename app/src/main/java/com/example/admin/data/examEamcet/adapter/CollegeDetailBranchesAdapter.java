package com.example.admin.data.examEamcet.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.data.R;
import com.example.admin.data.examEamcet.model.CollegeBranchDetails;

import java.util.List;

public class CollegeDetailBranchesAdapter extends RecyclerView.Adapter<CollegeDetailBranchesAdapter.ViewHolder>{
    List<CollegeBranchDetails> lis;
    private int rowLayout;
    private Context context;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView branch,mo1,mo2,mo3,mo4,mo5,mo6,mo7,mo8,mc1,mc2,mc3,mc4,mc5,mc6,mc7,mc8,fo1,fo2,fo3,fo4,fo5,fo6,fo7,fo8,fc1,fc2,fc3,fc4,fc5,fc6,fc7,fc8;
        public ViewHolder(View v) {
            super(v);

            branch=v.findViewById(R.id.branchname);
          /*      mo1=v.findViewById(R.id.mo1);
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
            fc8=v.findViewById(R.id.fc8);
*/
        }
    }

    public CollegeDetailBranchesAdapter(List<CollegeBranchDetails> lis, int rowLayout, Context context) {
        this.lis=lis;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent,false);
        return new CollegeDetailBranchesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollegeDetailBranchesAdapter.ViewHolder holder, int position) {

        holder.branch.setText(lis.get(position).getdIST());

     /*   holder.mo1.setText(lis.get(position).getOc_male_Best_Rank());
        holder.mo2.setText(lis.get(position).getBc_male_Best_Rank());
        holder.mo3.setText(lis.get(position).getbC_B_Male_Best_Rank());
        holder.mo4.setText(lis.get(position).getbC_C_Male_Best_Rank());
        holder.mo5.setText(lis.get(position).getbC_D_Male_Best_Rank());
        holder.mo6.setText(lis.get(position).getbC_E_Male_Best_Rank());
        holder.mo7.setText(lis.get(position).getsC_Male_Best_Rank());
        holder.mo8.setText(lis.get(position).getsT_Male_Best_Rank());

        holder.mc1.setText(lis.get(position).getOc_male_Last_Rank());
        holder.mc2.setText(lis.get(position).getBc_male_Last_Rank());
        holder.mc3.setText(lis.get(position).getbC_B_Male_Last_Rank());
        holder.mc4.setText(lis.get(position).getbC_C_Male_Last_Rank());
        holder.mc5.setText(lis.get(position).getbC_D_Male_Last_Rank());
        holder.mc6.setText(lis.get(position).getbC_E_Male_Last_Rank());
        holder.mc7.setText(lis.get(position).getsC_Male_Last_Rank());
        holder.mc8.setText(lis.get(position).getsT_Male_Last_Rank());

        holder.fo1.setText(lis.get(position).getoC_Female_Best_Rank());
        holder.fo2.setText(lis.get(position).getbC_A_Female_Best_Rank());
        holder.fo3.setText(lis.get(position).getbC_B_Female_Best_Rank());
        holder.fo4.setText(lis.get(position).getbC_C_Female_Best_Rank());
        holder.fo5.setText(lis.get(position).getbC_D_Female_Best_Rank());
        holder.fo6.setText(lis.get(position).getbC_E_Female_Best_Rank());
        holder.fo7.setText(lis.get(position).getsC_Female_Best_Rank());
        holder.fo8.setText(lis.get(position).getsT_Female_Best_Rank());

        holder.fc1.setText(lis.get(position).getoC_Female_Last_Rank());
        holder.fc2.setText(lis.get(position).getbC_A_Female_Last_Rank());
        holder.fc3.setText(lis.get(position).getbC_B_Female_Last_Rank());
        holder.fc4.setText(lis.get(position).getbC_C_Female_Last_Rank());
        holder.fc5.setText(lis.get(position).getbC_D_Female_Last_Rank());
        holder.fc6.setText(lis.get(position).getbC_E_Female_Last_Rank());
        holder.fc7.setText(lis.get(position).getsC_Female_Last_Rank());
        holder.fc8.setText(lis.get(position).getsT_Female_Last_Rank());*/
    }

    @Override
    public int getItemCount() {
        return lis.size();
    }

}


