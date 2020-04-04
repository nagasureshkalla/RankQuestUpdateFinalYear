package com.example.admin.data.Homepage;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.admin.data.Homepage.rest.ApiInterfacePut;
import com.example.admin.data.Homepage.rest.Register_Client;
import com.example.admin.data.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Feedback extends AppCompatActivity {
    public String b,r,e;
    public float t;
    ProgressBar progressBar;
    SimpleDateFormat formatter;
    Date date;
     RatingBar ratingbar;
    Button button;
    TextInputEditText suggestions;
    public  void showProgress()
    {
        button.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }
    public  void hideProgress()
    {
        button.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
         suggestions =  findViewById(R.id.suggestions);
        progressBar=findViewById(R.id.progressBar);


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
        AdView adview=findViewById(R.id.adViewfeedback);
        AdRequest adRequest=new AdRequest.Builder().build();
        adview.loadAd(adRequest);


        ratingbar = findViewById(R.id.ratingBar);
        button =findViewById(R.id.button);

         formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        date = new Date();
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        catch (Exception e){

        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

b=null;
try {
    b = suggestions.getText().toString();
}catch (Exception e){

}
                t=ratingbar.getRating();
                if(b.equals("")){
                    Toast.makeText(getApplicationContext(), "Please write suggestion", Toast.LENGTH_SHORT).show();
                }
                else {
showProgress();
JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("suggestion", b);
                        jsonObject.put("rating", t);
                        jsonObject.put("date", formatter.format(date));
                        ApiInterfacePut apiPut = Register_Client.getService().create(ApiInterfacePut.class);
                        Call<ResponseBody> body1 = apiPut.feedback(jsonObject.toString());
                        body1.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                Toast.makeText(getApplicationContext(), "Feedback posted successfull", Toast.LENGTH_SHORT).show();
                                hideProgress();
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "please check your network", Toast.LENGTH_SHORT).show();
                                hideProgress();
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                        hideProgress();
                    }
                }
            }
        });
    }
}
