package com.example.admin.data.Homepage.DynamicFragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.admin.data.R;
import com.example.admin.data.examEcet.Cutoff_Select_Colleges_Ecet;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;


public class Fragment_Cutoff_Ecet extends Fragment implements AdapterView.OnItemSelectedListener{
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
    Set<String> counsel;
    SharedPreferences sharedPreferences;

    String exam;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment__cutoff__ecet, container, false);


        rank =  view.findViewById(R.id.rank);
        show =  view.findViewById(R.id.show);
        gg = (RadioGroup) view.findViewById(R.id.gg);
        cast = (Spinner) view.findViewById(R.id.cast);
        councling = (Spinner) view.findViewById(R.id.counselling);
        branches =  view.findViewById(R.id.branches);
        colleges =  view.findViewById(R.id.colleges);
        g=view.findViewById(R.id.g);

        try {

            sharedPreferences = view.getContext().getSharedPreferences("exam", MODE_PRIVATE);
            String dbname = sharedPreferences.getString("dbname", "");
            exam=sharedPreferences.getString("exam_name", "");




            Log.d("dbname ",dbname);

            counsel = sharedPreferences.getStringSet("counsellings",null);
            for (String s : counsel) {
                Log.d("Councel ", s.toString());
            }
        }
        catch (Exception e){

        }





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


        try {
            counsel = sharedPreferences.getStringSet("counsellings",null);
            List<String> coucillist = new ArrayList<String>(counsel);
            for (String i:coucillist){
                Log.d("Councel ",i);
            }
            ArrayAdapter<String> counada = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, coucillist);
            counada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            councling.setAdapter(counada);


        }
        catch (Exception e){

        }

        


        branches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), SelectBranches.class);
                startActivityForResult(i,requestCode1);
            }
        });

        colleges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(getContext(), SelectColleges.class);
                startActivityForResult(j,requestCode2);
            }
        });

        try{

            cast.setOnItemSelectedListener(this);
            councling.setOnItemSelectedListener(this);
        }
        catch (Exception e){

        }


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    t1 = rank.getText().toString();
                }
                catch (Exception e){

                }
                if (t1.isEmpty()) {
                    Toast.makeText(getContext(), "Please provide rank", Toast.LENGTH_SHORT).show();
                }
                else if(Integer.parseInt(t1)==0){
                    Toast.makeText(getContext(), "Please provide valid rank", Toast.LENGTH_SHORT).show();

                }
                else if(d1.length<=0){
                    Toast.makeText(getContext(), "Please select branches", Toast.LENGTH_SHORT).show();
                }

                else {
                    try {
                        Intent i = new Intent(getContext(), Dynamic_Cutoff_Result.class);
                        i.putExtra("gender", gender);
                        i.putExtra("caste", item);
                        i.putExtra("council", item2);
                        i.putExtra("rank", t1);
                        i.putExtra("sortby", sortby);
                        Bundle b = new Bundle();
                        b.putStringArray("selectedItems", d1);
                        i.putExtras(b);
                        Bundle t = new Bundle();
                        t.putStringArray("selectedColleges", d2);
                        i.putExtras(t);
                        startActivity(i);
                    }
                    catch (Exception e){

                    }
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
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
        switch (adapterView.getId()){
            case R.id.cast:
                item=adapterView.getItemAtPosition(i).toString();    //caste
                // Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
            case R.id.counselling:
                try {
                    item2 = adapterView.getItemAtPosition(i).toString();  //counselling
                }
                catch (Exception e){

                }
                //Toast.makeText(this, item2, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        item="OC";
        item2=parent.getItemAtPosition(0).toString();
    }
}
