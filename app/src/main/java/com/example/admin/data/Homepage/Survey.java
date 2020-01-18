package com.example.admin.data.Homepage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.admin.data.Homepage.adapter.SurveyAdapter;
import com.example.admin.data.Homepage.rest.ApiClient;
import com.example.admin.data.Homepage.rest.ApiInterfacePut;
import com.example.admin.data.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Survey extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {

    EditText sname, sphone, smail, scollege, sinter, s10, addr;

    Button post, viewpost;
    EditText surveysearch;
    Spinner exam1, exam2;
    List<String> coucillist;
    String username;
    String branchselected, branchViewd;
    SurveyAdapter adapter;
    List<SurveyData> colg;
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        Resources r = getResources();
        String[] t = r.getStringArray(R.array.exams);

        SharedPreferences details = getSharedPreferences("login", MODE_PRIVATE);  //Activity1.class
        username = details.getString("username", "");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sname = (EditText) findViewById(R.id.sname);
        sphone = (EditText) findViewById(R.id.sphone);
        smail = (EditText) findViewById(R.id.smail);
        scollege = (EditText) findViewById(R.id.scollege);
        sinter = (EditText) findViewById(R.id.sinter);
        s10 = (EditText) findViewById(R.id.s10);
        addr = (EditText) findViewById(R.id.addresses);
        post = (Button) findViewById(R.id.post);
        viewpost = (Button) findViewById(R.id.viewpost);
        exam1 = (Spinner) findViewById(R.id.examput);

        coucillist = Arrays.asList(t);
        branchselected = coucillist.get(0);

        //Toast.makeText(this, "Branchselected  :"+branchselected, Toast.LENGTH_SHORT).show();
        ArrayAdapter<String> counada = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, coucillist);
        counada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exam1.setAdapter(counada);


        viewpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Survey.this,SurveyViewDetails.class);
                 startActivity(i);
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postDetails(branchselected);
            }
        });
        exam1.setOnItemSelectedListener(this);
    }


    public void postDetails(String branchselected){
        String s1=sname.getText().toString();
        String s2=sphone.getText().toString();
        String s3=smail.getText().toString();
        String s4=scollege.getText().toString();
        String s5=sinter.getText().toString();
        String s6=s10.getText().toString();
        String s7=addr.getText().toString();
        JSONObject jsonObject = new JSONObject();
        if(s1.isEmpty()){

            Toast.makeText(Survey.this, "Please enter name", Toast.LENGTH_SHORT).show();
        }
        else if (s2.length()!=10){
            Toast.makeText(Survey.this, "Please enter valid number", Toast.LENGTH_SHORT).show();
        }
        else if (s4.isEmpty()){
            Toast.makeText(Survey.this, "Please enter college name", Toast.LENGTH_SHORT).show();
        }
        else if (s5.isEmpty()){
            Toast.makeText(Survey.this, "Please enter inter marks", Toast.LENGTH_SHORT).show();
        }
        else {
            try {
                jsonObject.put("name", s1);
                jsonObject.put("phone", s2);
                jsonObject.put("mail", s3);
                jsonObject.put("college", s4);
                jsonObject.put("intermarks", s5);
                jsonObject.put("10marks", s6);
                jsonObject.put("address", s7);
                jsonObject.put("username", username);
                jsonObject.put("exam",branchselected);
                ApiInterfacePut apiPut = ApiClient.getSurvey().create(ApiInterfacePut.class);
                Call<ResponseBody> body1 = apiPut.Survey(jsonObject.toString());
                body1.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(getApplicationContext(), "Successfully Posted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "please check your network", Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        branchselected=parent.getItemAtPosition(position).toString();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                postDetails(branchselected);
            }
        },2000);
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
