package com.example.admin.data.Homepage;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.admin.data.Homepage.Model.DevelopersModel;
import com.example.admin.data.Homepage.Model.WebsitesModel;
import com.example.admin.data.Homepage.adapter.DeveloperAdapter;
import com.example.admin.data.Homepage.adapter.WebsitesAdapter;
import com.example.admin.data.Homepage.rest.ApiClientExams;
import com.example.admin.data.Homepage.rest.ApiInterfacePut;
import com.example.admin.data.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Websites extends AppCompatActivity {
CardView c1,c2,c3,c4,c5,c6,c7;
    private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);


        // Need to remove at the time deployment in playstore
        List<String> testDeviceIds = Arrays.asList("863376046429999");
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);
        //upto here


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        AdView adview=findViewById(R.id.adViewWebsites);

        AdRequest adRequest=new AdRequest.Builder().build();

        adview.loadAd(adRequest);



        start();


        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        catch (Exception e){

        }





    }
    public  void start(){
        try {



            RecyclerView r=findViewById(R.id.websitesrecycleview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            r.setLayoutManager(linearLayoutManager);
            ApiInterfacePut apiService = ApiClientExams.getClient().create(ApiInterfacePut.class);
            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(getApplicationContext(), R.anim.layout_leftto_right);
            Call<List<WebsitesModel>> call = apiService.getWebsites("rankquest_mainpage_exams","websites",API_KEY);
            call.enqueue(new Callback<List<WebsitesModel>>() {
                @Override
                public void onResponse(Call<List<WebsitesModel>> call, Response<List<WebsitesModel>> response) {
                    try {
                        List<WebsitesModel> colg = response.body();



                        WebsitesAdapter adapter = new WebsitesAdapter(colg, R.layout.recycle_websites, getApplicationContext(), new WebsitesAdapter.OnItemClick() {
                            @Override
                            public void onItem(WebsitesModel item) {
                                Intent t=new Intent(Intent.ACTION_VIEW, Uri.parse(item.getLink()));
                                startActivity(t);
                            }
                        });
                        r.setAdapter(adapter);


                    }
                    catch (Exception e){

                    }

                }

                @Override
                public void onFailure(Call<List<WebsitesModel>> call, Throwable t) {



                }
            });
        }catch (Exception e){

            start();
        }
    }
}