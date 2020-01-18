package com.example.admin.data.Homepage;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;

import com.example.admin.data.R;

public class Icet extends AppCompatActivity {
    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icet);

        c1=(CardView)findViewById(R.id.ic1);
        c2=(CardView)findViewById(R.id.ic2);
        c3=(CardView)findViewById(R.id.ic3);
        c4=(CardView)findViewById(R.id.ic4);
        c5=(CardView)findViewById(R.id.ic5);
        c6=(CardView)findViewById(R.id.ic6);

/*

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q=new Intent(Icet.this,Icet_Cutoff.class);
                startActivity(q);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent w=new Intent(Icet.this,Icet_Colleges.class);
                startActivity(w);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e=new Intent(Icet.this,Icet_Checklist.class);
                startActivity(e);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(Icet.this,Icet_Reports.class);
                startActivity(r);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=new Intent(Icet.this,Icet_Branches.class);
                startActivity(t);
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y = new Intent(Icet.this, Icet_Statatics.class);
                startActivity(y);
            }
        });*/
    }
}