package com.example.admin.data.Homepage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.admin.data.Homepage.rest.ApiClient;
import com.example.admin.data.Homepage.rest.ApiInterfacePut;
import com.example.admin.data.Homepage.rest.Otp_Client;
import com.example.admin.data.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String profw,q;
    String mlabusr,mlabpwd,pro;
    String user,pass,pr;
    String number;
    EditText username,password,phone;
    Spinner profession;
    Button save,forget,send;
    Toolbar toolbar;
    List<String> castl;
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         username=(EditText)findViewById(R.id.username);
         password=(EditText)findViewById(R.id.password);
         profession=(Spinner)findViewById(R.id.profession);
        save=(Button)findViewById(R.id.save);
        forget=(Button)findViewById(R.id.forget);
        phone=(EditText)findViewById(R.id.number);
        send=(Button)findViewById(R.id.send);

        profession.setOnItemSelectedListener(this);
        castl = new ArrayList<String>();
        castl.add("Student");
        castl.add("Teacher");
        castl.add("Parent");

        ArrayAdapter<String> castlist = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, castl);
        castlist.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       profession.setAdapter(castlist);

       forget.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               phone.setVisibility(View.VISIBLE);
               send.setVisibility(View.VISIBLE);
           }
       });
       send.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               number=phone.getText().toString();
               if(number.length()==10){
                   String s="{username:'"+number+"',profession:'Teacher'}";
                   ApiInterfacePut apiService = ApiClient.getClient().create(ApiInterfacePut.class);

                   Call<List<LoginData>> call = apiService.getUser(s);
                   call.enqueue(new Callback<List<LoginData>>() {
                       @Override
                       public void onResponse(Call<List<LoginData>> call, Response<List<LoginData>> response) {
                           List<LoginData> colg=response.body();

                           if(colg.size() <= 0){
                               Toast.makeText(Login.this, "Only Teacher can request OTP\n\nNumber is not Registered as Teacher", Toast.LENGTH_SHORT).show();
                           }
                           else {
                               user = colg.get(0).getUsername();
                               pass = colg.get(0).getPassword();
                               pr = colg.get(0).getProfession();
                               Log.i("1.Details", user + pass + pr);
                               sendOTP();
                           }
                       }

                       @Override
                       public void onFailure(Call<List<LoginData>> call, Throwable t) {
                           Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                       }
                   });

               }
               else{
                   Toast.makeText(Login.this, "Please Enter 10 digit number", Toast.LENGTH_SHORT).show();
               }

           }
       });


       save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String user = username.getText().toString();
               String pass = password.getText().toString();
               q = "{username:'" + user + "',password:'" + pass + "',profession:'" + profw + "'}";
               Log.i("\n\n\nquery\n",q);

               if (user.length() > 0 && pass.length() > 0) {
                   ApiInterfacePut apiCall = ApiClient.getClient().create(ApiInterfacePut.class);
                   final Call<List<LoginData>> data = apiCall.Login(q);
                   data.enqueue(new Callback<List<LoginData>>() {
                       @Override
                       public void onResponse(@NonNull Call<List<LoginData>> call, @NonNull Response<List<LoginData>> response) {
                            List<LoginData> data1=response.body();
                           if (data1.size() > 0) {
                               mlabusr = data1.get(0).getUsername();
                               mlabpwd =data1.get(0).getPassword();
                               pro=data1.get(0).getProfession();
                              // Log.i("user",mlabusr);
                              // Log.i("password",mlabpwd);
                           }

                           if (user.equals(mlabusr) && pass.equals(mlabpwd)) {
                               //shared preference
                               SharedPreferences details = getSharedPreferences("login", MODE_PRIVATE);
                               SharedPreferences.Editor editor = details.edit();
                               editor.putString("username", mlabusr);
                               editor.putString("password", mlabpwd);
                               editor.putString("profession",pro);
                               Log.i("\n\nshared:: ",mlabpwd+mlabusr+pro);
                               editor.commit();
                               Intent intent=new Intent();
                               setResult(1,intent);
                               finish();
                           } else {
                               Toast.makeText(Login.this, "Invalid Username or Password ", Toast.LENGTH_SHORT).show();
                           }
                       }

                       @Override
                       public void onFailure(Call<List<LoginData>> call, Throwable t) {
                           Toast.makeText(getApplicationContext(), "Please Check Your Connection", Toast.LENGTH_SHORT).show();
                       }
                   });


               }
               else{
                   Toast.makeText(Login.this, "Invalid Username or Password ", Toast.LENGTH_SHORT).show();
               }
           }
       });
       }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getId()==R.id.profession){
                profw=adapterView.getItemAtPosition(i).toString();   //profession

        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        profw="Student";

    }
    public  void sendOTP(){
        //Log.i("2.Details",user+pass+pr);
        ApiInterfacePut apiCall= Otp_Client.getOtp().create(ApiInterfacePut.class);

        String msg="\t\t\tRank Quest\n\nUsername :: "+user+"\n"+"Password :: "+pass+"\nProfession : "+pr;

        Call<String> retro  = apiCall.getOTP_Login("sasicollege","SITE2002","INSITE",number,msg,"1");
        retro.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(getApplicationContext(), "Details Send Successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Check your Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
