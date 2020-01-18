package com.example.admin.data.Homepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.admin.data.Homepage.Model.DevelopersModel;
import com.example.admin.data.Homepage.adapter.DeveloperAdapter;
import com.example.admin.data.Homepage.rest.ApiClientExams;
import com.example.admin.data.Homepage.rest.ApiInterfacePut;
import com.example.admin.data.R;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Developers extends AppCompatActivity {

    private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";




    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        try{

            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        }
        catch (Exception e){

        }
        start();
        mentor_start();
    }
//    @Override
//    public boolean onSupportNavigateUp(){
//        finish();
//        return true;
//    }
    public void start(){
        try {



            final RecyclerView r=findViewById(R.id.developersrecycle);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            r.setLayoutManager(linearLayoutManager);
            ApiInterfacePut apiService = ApiClientExams.getClient().create(ApiInterfacePut.class);
            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(getApplicationContext(), R.anim.layout_leftto_right);
            Call<List<DevelopersModel>> call = apiService.getDevelopers("rankquest_mainpage_exams","developers",API_KEY);
            call.enqueue(new Callback<List<DevelopersModel>>() {
                @Override
                public void onResponse(Call<List<DevelopersModel>> call, Response<List<DevelopersModel>> response) {
                    try {
                        List<DevelopersModel> colg = response.body();

                        Log.d("Developer ",colg.get(0).getDevelopername());

                        DeveloperAdapter adapter = new DeveloperAdapter(colg,R.layout.recycle_developers,getApplicationContext());
                        r.setAdapter(adapter);


                    }
                    catch (Exception e){

                    }

                }

                @Override
                public void onFailure(Call<List<DevelopersModel>> call, Throwable t) {



                }
            });
        }catch (Exception e){

            start();
        }
    }

    public void mentor_start(){
        try {



            final RecyclerView r=findViewById(R.id.developersrecyclementors);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            r.setLayoutManager(linearLayoutManager);
            ApiInterfacePut apiService = ApiClientExams.getClient().create(ApiInterfacePut.class);
            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(getApplicationContext(), R.anim.layout_leftto_right);
            Call<List<DevelopersModel>> call = apiService.getDevelopers("rankquest_mainpage_exams","mentors",API_KEY);
            call.enqueue(new Callback<List<DevelopersModel>>() {
                @Override
                public void onResponse(Call<List<DevelopersModel>> call, Response<List<DevelopersModel>> response) {
                    try {
                        List<DevelopersModel> colg = response.body();

                        Log.d("Developer ",colg.get(0).getDevelopername());

                        DeveloperAdapter adapter = new DeveloperAdapter(colg,R.layout.recycle_developers,getApplicationContext());
                        r.setAdapter(adapter);


                    }
                    catch (Exception e){

                    }

                }

                @Override
                public void onFailure(Call<List<DevelopersModel>> call, Throwable t) {



                }
            });
        }catch (Exception e){

            mentor_start();
        }
    }
}
