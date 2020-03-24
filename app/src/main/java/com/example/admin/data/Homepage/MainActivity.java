package com.example.admin.data.Homepage;


import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.data.Homepage.Model.Exam_Name_MainPage;
import com.example.admin.data.Homepage.adapter.Activity_Adapter;
import com.example.admin.data.Homepage.adapter.Nested_Activity_Adapter;
import com.example.admin.data.Homepage.rest.ApiClient;
import com.example.admin.data.Homepage.rest.ApiClientExams;
import com.example.admin.data.Homepage.rest.ApiInterfacePut;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.mxn.soul.flowingdrawer_core.*;
import com.example.admin.data.R;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Serializable {
    CardView  c6, c7, c8, c9;

    Set<String> hash_Set = new HashSet<String>();
    List<Exam_Name_MainPage> exam_name_mainPageList=new ArrayList<>();
    String apiKey="VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Admob Account redants@sasi.ac.in


//        // Need to remove at the time deployment in playstore
//        List<String> testDeviceIds = Arrays.asList("863376046429999");
//        RequestConfiguration configuration =
//                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
//        MobileAds.setRequestConfiguration(configuration);
//        //upto here



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        AdView adview=findViewById(R.id.adViewEamcet);

        AdRequest adRequest=new AdRequest.Builder().build();

        adview.loadAd(adRequest);

        display_exams();

       try {

           c6 = (CardView) findViewById(R.id.card6);
           c7 = (CardView) findViewById(R.id.card7);
           c8 = (CardView) findViewById(R.id.card8);
           c9 = (CardView) findViewById(R.id.card9);



           c6.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent y = new Intent(MainActivity.this, Developers.class);
                   startActivity(y);
               }
           });
           c7.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent i = new Intent();
                   i.setAction(Intent.ACTION_SEND);
                   i.setType("text/plain");

                   i.putExtra(Intent.EXTRA_TEXT, "http://play.google.com/store/apps/details?id=com.redants.rankquest");
                   startActivity(i);
               }
           });
           c8.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent u = new Intent(MainActivity.this, Websites.class);
                   startActivity(u);
               }
           });
           c9.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent o = new Intent(MainActivity.this, Feedback.class);
                   startActivity(o);
               }
           });
       }
       catch (Exception e){

       }
    }

    private void display_exams(){

        ApiInterfacePut apiService = ApiClientExams.getClient().create(ApiInterfacePut.class);
        Call<List<Exam_Name_MainPage>> call = apiService.getExams("rankquest_mainpage_exams","exams",apiKey);

        call.enqueue(new Callback<List<Exam_Name_MainPage>>() {
            @Override
            public void onResponse(Call<List<Exam_Name_MainPage>> call, Response<List<Exam_Name_MainPage>> response) {
                exam_name_mainPageList=response.body();

                try {
                    for (Exam_Name_MainPage obj : exam_name_mainPageList) {
                        Log.d("Exam ", obj.getExam_name());

                    }

                    for (int n = 0; n < exam_name_mainPageList.size(); n++) {

                        hash_Set.add(exam_name_mainPageList.get(n).getState());

                    }

                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_recycle);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    //GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
                   // recyclerView.setLayoutManager(gridLayoutManager);

                    Activity_Adapter adapter = new Activity_Adapter(hash_Set,exam_name_mainPageList,new Nested_Activity_Adapter.OnItemClick(){
                        @Override
                        public void onItem(Exam_Name_MainPage item) {
                            // Toast.makeText(Eamcet_Colleges.this, "Clicked "+item.getCode(), Toast.LENGTH_SHORT).show();
                            Intent r = new Intent(getApplicationContext(),Dynamic_Class_For_Bottom_Navigation.class);

                            r.putExtra("obj",item);


                            startActivity(r);
                        }
                    });

                    recyclerView.setAdapter(adapter);
                }
                catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<List<Exam_Name_MainPage>> call, Throwable t) {

            }
        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//
//        switch (item.getItemId()) {
//            case R.id.login:
//                SharedPreferences d=getSharedPreferences("login",MODE_PRIVATE);
//                String r=d.getString("username","");
//                if(r!=""){
//                    Toast.makeText(getApplicationContext(), r+" Logged In", Toast.LENGTH_LONG).show();
//                }
//                else{
//                    Intent i=new Intent(getApplicationContext(),Login.class);
//                    startActivityForResult(i,1);
//                }
//                return true;
//            case R.id.register:
//                Intent j=new Intent(getApplicationContext(),Register.class);
//                startActivity(j);
//                return true;
//            case R.id.survey:
//                SharedPreferences detail=getSharedPreferences("login",MODE_PRIVATE);
//                String p=detail.getString("profession","");
//                String name=detail.getString("username","");
//                if(p.equals("Teacher")){
//                    Intent s=new Intent(getApplicationContext(),Survey.class);
//                    startActivity(s);
//                }
//                else if(name==""){
//                    //Toast.makeText(getApplicationContext(), "Login First", Toast.LENGTH_LONG).show();
//                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
//                    AlertDialog alert = alertDialog.create();
//                    alert.setMessage("Login First");
//                    alert.show();
//                }
//                else{
//                    //Toast.makeText(getApplicationContext(), "Your not a Teacher To Survey", Toast.LENGTH_SHORT).show();
//                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
//                    AlertDialog alert = alertDialog.create();
//                    alert.setMessage("Your not a Teacher To Survey");
//                    alert.show();
//                }
//
//                return true;
//            case R.id.logout:
//                SharedPreferences details = getSharedPreferences("login", MODE_PRIVATE);
//                if(details.getString("username","")==""){
//                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
//                    AlertDialog alert = alertDialog.create();
//                    alert.setMessage("Login First");
//                    alert.show();//Toast.makeText(getApplicationContext(), "Login First", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    SharedPreferences.Editor editor = details.edit();
//                    editor.putString("username", "");
//                    editor.putString("password", "");
//                    editor.putString("profession", "");
//                    editor.putString("logined", "false");
//                    editor.commit();
//                    Toast.makeText(getApplicationContext(), "Logout Done", Toast.LENGTH_SHORT).show();
//                }
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==1)
        {
            SharedPreferences details = getSharedPreferences("login", MODE_PRIVATE);
            String pe=details.getString("profession","");
            String ty=details.getString("username","");
            if(ty!="") {
                Toast.makeText(getApplicationContext(), ty + " --- " + pe, Toast.LENGTH_SHORT).show();
            }
        }
    }
}

