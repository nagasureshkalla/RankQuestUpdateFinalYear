package com.example.admin.data.Homepage.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.data.Homepage.Survey;
import com.example.admin.data.Homepage.SurveyData;
import com.example.admin.data.R;

import java.util.ArrayList;
import java.util.List;

public class SurveyAdapter extends RecyclerView.Adapter<SurveyAdapter.ViewHolder>{

    List<SurveyData> lis;
    List<SurveyData> filterlist;
    private int rowLayout;
    private Context context;

    static List<Integer> deletedItems=new ArrayList<>();

    public static List<Integer> getDeletedItems(){
        return deletedItems;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {

        TextView college,name,mail,phone,inter,ma10,address,exam;

        CardView cardView;


        public ViewHolder(View v) {
            super(v);
            cardView=v.findViewById(R.id.surveyCard);
            college=v.findViewById(R.id.college);
            name=v.findViewById(R.id.name);
            mail=v.findViewById(R.id.mail);
            phone=v.findViewById(R.id.phone);
            inter=v.findViewById(R.id.intermarks);
            ma10=v.findViewById(R.id.marks10);
            address=v.findViewById(R.id.address);
            exam=v.findViewById(R.id.exam);

        }

    }

    public SurveyAdapter(List<SurveyData> lis, int rowLayout,Context context) {
        this.lis=lis;
        this.rowLayout = rowLayout;

        this.context = context;
    }

    @Override
    public SurveyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent,false);
        return new SurveyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SurveyAdapter.ViewHolder holder, int position) {

        holder.college.setText(lis.get(position).getCollege());
        holder.phone.setText(lis.get(position).getPhone());
        holder.name.setText(lis.get(position).getName());
        holder.mail.setText(lis.get(position).getMail());
        holder.inter.setText(lis.get(position).getIntermarks());
        holder.ma10.setText(lis.get(position).getTenthmarks());
        holder.address.setText(lis.get(position).getAddress());
        holder.exam.setText(lis.get(position).getExam());

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                deletedItems.add(lis.get(position).getPosition());
                Toast.makeText(context, lis.get(position).getName()+" Record Deleted", Toast.LENGTH_SHORT).show();
                lis.remove(lis.get(position));
                notifyDataSetChanged();

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return lis.size();
    }


    public void filterList(List<SurveyData> filterlist) {
        this.lis = filterlist;
        notifyDataSetChanged();
    }

}
