package com.example.admin.data.Homepage;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.admin.data.Homepage.rest.ApiClient;
import com.example.admin.data.Homepage.rest.ApiInterfacePut;
import com.example.admin.data.Homepage.rest.Register_Client;
import com.example.admin.data.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText pass,phone,user;
    Button register;
    List<LoginData> colg;
    String username,password;
   String string,number;
    Spinner profession;
    List<String> castl;
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        pass=(EditText)findViewById(R.id.pass);
        user=(EditText)findViewById(R.id.user);
        phone=(EditText)findViewById(R.id.phone);
        register=(Button)findViewById(R.id.register);
        profession=(Spinner)findViewById(R.id.prof);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        profession.setOnItemSelectedListener(this);
        castl = new ArrayList<String>();
        castl.add("Student");
        castl.add("Teacher");
        castl.add("Parent");

        ArrayAdapter<String> castlist = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, castl);
        castlist.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        profession.setAdapter(castlist);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = user.getText().toString();
                password = pass.getText().toString();
                 number = phone.getText().toString();
                 if(username.isEmpty()){
                     Toast.makeText(Register.this, "Please enter username", Toast.LENGTH_SHORT).show();
                 }
                 if (password.isEmpty()){
                     Toast.makeText(Register.this, "Please enter password", Toast.LENGTH_SHORT).show();
                 }
                 if (number.length() == 10 && username!="" && password!="") {
                     check(number);
                 }
                 else{
                     Toast.makeText(getApplicationContext(), "Please enter 10 digit number", Toast.LENGTH_SHORT).show();
                 }
            }
        });
}
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId()==R.id.prof){
                string=adapterView.getItemAtPosition(i).toString();   //profession
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        string="Student";

    }
    public void check(String number){
        String num="{phone:'"+number+"'}";
        ApiInterfacePut apiService = ApiClient.getClient().create(ApiInterfacePut.class);

        Call<List<LoginData>> call = apiService.check(num);
        call.enqueue(new Callback<List<LoginData>>() {
            @Override
            public void onResponse(Call<List<LoginData>> call, Response<List<LoginData>> response) {
                List<LoginData> colg=response.body();

                if(colg.size()>0){
                    Toast.makeText(getApplicationContext(), number+" is already Registered \n\t\t\t\t\tPlease try to login", Toast.LENGTH_SHORT).show();
                }
                else {

                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("username", number);
                        jsonObject.put("password", password);
                        jsonObject.put("Name", username);
                        jsonObject.put("profession", string);
                        ApiInterfacePut apiPut = Register_Client.getService().create(ApiInterfacePut.class);
                        Call<ResponseBody> body1 = apiPut.Registration(jsonObject.toString());
                        body1.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                Toast.makeText(getApplicationContext(), "Succesfully Registered", Toast.LENGTH_SHORT).show();
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
            public void onFailure(Call<List<LoginData>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
            }
        });
    }
}
