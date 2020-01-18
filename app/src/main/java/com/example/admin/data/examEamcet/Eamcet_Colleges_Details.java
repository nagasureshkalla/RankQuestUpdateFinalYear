package com.example.admin.data.examEamcet;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.data.R;
import com.example.admin.data.examEamcet.adapter.CollegeDatailAdapter;
import com.example.admin.data.examEamcet.model.Branches;
import com.example.admin.data.examEamcet.model.CollegeBranchDetails;
import com.example.admin.data.examEamcet.model.CollegeDetails;
import com.example.admin.data.examEamcet.rest.ApiClient;
import com.example.admin.data.examEamcet.rest.ApiInterface;
import com.example.admin.data.fragments.FragmentCollegeDetails;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Eamcet_Colleges_Details extends AppCompatActivity {
    private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";
    String q,b;
    TextView data,data2,nam;
    public final static String MESSAGE_KEY ="college_code";
    Call<List<CollegeBranchDetails>> call;
    List<CollegeBranchDetails> list;
    List<CollegeDetails> colg;
    ViewPager viewPager;
    TabLayout tabLayout;
    int i;

    LinearLayout ff,detailsback;
    ProgressBar p;
    TextView retry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent inten = getIntent();
        String message = inten.getStringExtra(MESSAGE_KEY);
       // Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
        q="{\"collegeCode\":\"" + message + "\"}";
        b="{\"code\":\"" + message + "\"}";

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_eamcet__colleges__details);
        start();



        data=(TextView)findViewById(R.id.data);
        detailsback=findViewById(R.id.detailsback);
        detailsback.setVisibility(View.INVISIBLE);
        p=findViewById(R.id.progress);
        ff=findViewById(R.id.ff);
        p.setVisibility(View.VISIBLE);
        ff.setVisibility(View.INVISIBLE);
        retry=findViewById(R.id.retry);
        retry.setVisibility(View.INVISIBLE);




        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    public void start() {

        try {

            if (API_KEY.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please obtain your API KEY", Toast.LENGTH_LONG).show();
                return;
            }

            final RecyclerView recyclerVie = (RecyclerView) findViewById(R.id.recyclecollegedetails);
            recyclerVie.setLayoutManager(new LinearLayoutManager(this));

            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(this, R.anim.layout_leftto_right);
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

            Call<List<CollegeDetails>> call = apiService.getCollegeDetail(b);


            call.enqueue(new Callback<List<CollegeDetails>>() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onResponse(Call<List<CollegeDetails>> call, Response<List<CollegeDetails>> response) {
                    colg = response.body();

                    p.setVisibility(View.INVISIBLE);
                    retry.setVisibility(View.INVISIBLE);

                    detailsback.setVisibility(View.VISIBLE);
                    ff.setVisibility(View.VISIBLE);
                    recyclerVie.setVisibility(View.VISIBLE);
                    CollegeDatailAdapter adapter = new CollegeDatailAdapter(colg, R.layout.recycle_college_details, getApplicationContext());
                    recyclerVie.setAdapter(adapter);
                    recyclerVie.setLayoutAnimation(controller);
                    adapter.notifyDataSetChanged();
                    recyclerVie.scheduleLayoutAnimation();

                }

                @Override
                public void onFailure(Call<List<CollegeDetails>> call, Throwable t) {
                    // Toast.makeText(Eamcet_Colleges_Details.this, "No Internet Connection", Toast.LENGTH_LONG).show();

                    retry.setVisibility(View.VISIBLE);
                    detailsback.setVisibility(View.INVISIBLE);
                    p.setVisibility(View.INVISIBLE);
                    recyclerVie.setVisibility(View.INVISIBLE);
                    Snackbar snackbar = Snackbar
                            .make(findViewById(R.id.ll), "No Network", Snackbar.LENGTH_INDEFINITE).setAction("Retry", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    p.setVisibility(View.VISIBLE);
                                    ff.setVisibility(View.INVISIBLE);
                                    retry.setVisibility(View.INVISIBLE);
                                    start();
                                }
                            });
                    View snackbarView = snackbar.getView();
                    snackbarView.setMinimumHeight(25);
                    snackbarView.setBackgroundResource(R.color.orange);
                    TextView textView = snackbarView.findViewById(R.id.snackbar_action);
                    textView.setTextColor(Color.BLACK);
                    TextView textView1=snackbarView.findViewById(R.id.snackbar_text);
                    textView1.setTextSize(25);
                    textView.setTextSize(15);
                    snackbar.show();
                }
            });

        }
        catch (Exception e){
            start();

        }


    //}

    //private void setupViewPager(final ViewPager viewPager) {

        try {

            final ViewPagerAdapter adapter1 = new ViewPagerAdapter(getSupportFragmentManager());
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<List<CollegeBranchDetails>> call = apiService.getData3(b);
            call.enqueue(new Callback<List<CollegeBranchDetails>>() {
                @Override
                public void onResponse(Call<List<CollegeBranchDetails>> call, Response<List<CollegeBranchDetails>> response) {
                    list = response.body();
        try {
    Log.d("Branch ", list.toString());
}catch (Exception e){
         Log.d("Branch",e.getMessage());
        }
                    for (i = 0; i < list.size(); i++) {
                        adapter1.addFragment(new FragmentCollegeDetails(), list, i);

                    }
                    data.setVisibility(View.VISIBLE);
                    viewPager.setAdapter(adapter1);
                    if (list.isEmpty()) {
                        // Toast.makeText(Eamcet_Colleges_Details.this, "No data Available for branches", Toast.LENGTH_SHORT).show();

                        final ViewPagerAdapter adapter1 = new ViewPagerAdapter(getSupportFragmentManager());
                        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                        Call<List<CollegeBranchDetails>> call2 = apiService.getData6(b);

                        call2.enqueue(new Callback<List<CollegeBranchDetails>>() {
                            @Override
                            public void onResponse(Call<List<CollegeBranchDetails>> call, Response<List<CollegeBranchDetails>> response) {
                                list=response.body();

                                for (i = 0; i < list.size(); i++){
                                    adapter1.addFragment(new FragmentCollegeDetails(), list, i);
                                }
                                if(list.isEmpty()){
                                    data.setText("No data Available for branches");
                                }
                                viewPager.setAdapter(adapter1);
                            }

                            @Override
                            public void onFailure(Call<List<CollegeBranchDetails>> call, Throwable t) {
                                //data.setText("No data Available for branches");
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<List<CollegeBranchDetails>> call, Throwable t) {

                    //Toast.makeText(Eamcet_Colleges_Details.this, "No Internet Connection", Toast.LENGTH_LONG).show();
                    Snackbar snackbar = Snackbar
                            .make(findViewById(R.id.ll), "No Network", Snackbar.LENGTH_INDEFINITE).setAction("Retry", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    p.setVisibility(View.VISIBLE);
                                    detailsback.setVisibility(View.INVISIBLE);
                                    ff.setVisibility(View.INVISIBLE);
                                    retry.setVisibility(View.INVISIBLE);
                                   start();
                                }
                            });
                    View snackbarView = snackbar.getView();
                    snackbarView.setMinimumHeight(25);
                    snackbarView.setBackgroundResource(R.color.orange);
                    TextView textView = snackbarView.findViewById(R.id.snackbar_action);
                    textView.setTextColor(Color.BLACK);
                    TextView textView1=snackbarView.findViewById(R.id.snackbar_text);
                    textView1.setTextSize(25);
                    textView.setTextSize(15);
                    snackbar.show();
                }
            });
        }
        catch (Exception e){
            start();
        }

    }



    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        private final List<String> mFragmentBranchName=new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            return FragmentCollegeDetails.newInstance(list.get(position));

        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(FragmentCollegeDetails fragment, List<CollegeBranchDetails> title,int position) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title.get(position).getBranch());

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }
    public int getName(int position){
        return position;
    }
}
