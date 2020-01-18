package com.example.admin.data.FragmentsExams.EAMCET;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.admin.data.R;
import com.example.admin.data.examEamcet.Cutoff_Select_Colleges;
import com.example.admin.data.examEamcet.Eamcet_Cutoff_Result;
import com.example.admin.data.examEamcet.Select;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;


public class Fragment_Cutoff extends Fragment implements AdapterView.OnItemSelectedListener{
    MaterialButton show, branches, colleges;
    TextInputEditText rank;
    RadioGroup gg,g;
    Spinner cast, councling;
    RadioButton male,female;
    static  String t1,gender="M",sortby="yes";
    int t2;
    static StringBuilder stringBuilder;
    static String item,item2,q;
    static int requestCode1=1,requestCode2=2;
    String[] d1={},d2={};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragment__cutoff, container, false);


        rank =  view.findViewById(R.id.rank);
        show =  view.findViewById(R.id.show);
        gg = (RadioGroup) view.findViewById(R.id.gg);
        cast = (Spinner) view.findViewById(R.id.cast);
        councling = (Spinner) view.findViewById(R.id.counselling);
        branches =  view.findViewById(R.id.branches);
        colleges =  view.findViewById(R.id.colleges);
        g=view.findViewById(R.id.g);


       /*rank.setInputType(InputType.TYPE_NULL);
        rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rank.setInputType(InputType.TYPE_CLASS_NUMBER);
                rank.requestFocus();

                InputMethodManager mgr = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.showSoftInput(rank, InputMethodManager.SHOW_IMPLICIT);
            }
        });*/

        g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.college){
                    sortby="yes";
                }
                else{
                    sortby="no";
                }
            }
        });
        gg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.male){
                    gender="M";
                }
                else{
                    gender="F";
                }
            }
        });

        cast.setOnItemSelectedListener(this);
        councling.setOnItemSelectedListener(this);
        List<String> castl = new ArrayList<String>();
        castl.add("OC");
        castl.add("BC_A");
        castl.add("BC_B");
        castl.add("BC_C");
        castl.add("BC_D");
        castl.add("BC_E");
        castl.add("SC");
        castl.add("ST");
        ArrayAdapter<String> castlist = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, castl);
        castlist.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cast.setAdapter(castlist);


        List<String> coucillist = new ArrayList<String>();
        coucillist.add("counselling 1");
        coucillist.add("counselling 2");
        coucillist.add("counselling 3");
        ArrayAdapter<String> counada = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, coucillist);
        counada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        councling.setAdapter(counada);

        branches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), Select.class);
                startActivityForResult(i,requestCode1);
            }
        });

        colleges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(getContext(), Cutoff_Select_Colleges.class);
                startActivityForResult(j,requestCode2);
            }
        });


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1=rank.getText().toString();
                if (t1.isEmpty()) {
                    Toast.makeText(getContext(), "Please provide rank", Toast.LENGTH_SHORT).show();
                }
                else if(Integer.parseInt(t1)==0){
                    Toast.makeText(getContext(), "Please provide valid rank", Toast.LENGTH_SHORT).show();

                }
                else if(d1.length<=0){
                    Toast.makeText(getContext(), "Please select branches", Toast.LENGTH_SHORT).show();
                }
//
                else {
                    Intent i = new Intent(getContext(), Eamcet_Cutoff_Result.class);
                    i.putExtra("gender",gender);
                    i.putExtra("caste",item);
                    i.putExtra("council",item2);
                    i.putExtra("rank",t1);
                    i.putExtra("sortby",sortby);
                    Bundle b = new Bundle();
                    b.putStringArray("selectedItems",d1);
                    i.putExtras(b);
                    Bundle t=new Bundle();
                    t.putStringArray("selectedColleges",d2);
                    i.putExtras(t);
                    startActivity(i);
                }
            }
        });

        return view;
    }
    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            d1 =data.getStringArrayExtra("selectedItems");

            for (int i=0;i<d1.length;i++){
                System.out.println(d1[i]);
            }
        }
        if(resultCode == 2){
            d2=data.getStringArrayExtra("selectedColleges");

            for (int i=0;i<d2.length;i++){
                System.out.println(d2[i]);
            }
        }

    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()){
            case R.id.cast:
                item=adapterView.getItemAtPosition(i).toString();    //caste
                // Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
            case R.id.counselling:
                item2=adapterView.getItemAtPosition(i).toString();  //counselling
                //Toast.makeText(this, item2, Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        item="OC";
        item2="counselling 1";
    }
}
