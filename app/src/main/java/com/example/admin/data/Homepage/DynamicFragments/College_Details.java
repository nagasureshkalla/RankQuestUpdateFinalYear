package com.example.admin.data.Homepage.DynamicFragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.admin.data.Homepage.rest.ApiClientExams;
import com.example.admin.data.Homepage.rest.ApiInterfacePut;
import com.example.admin.data.R;




import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
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
import com.example.admin.data.examEcet.adapter.CollegeDatailAdapter;
import com.example.admin.data.examEcet.model.CollegeDetails;
import com.example.admin.data.examEcet.rest.ApiClient;
import com.example.admin.data.examEcet.rest.ApiInterface;
import com.example.admin.data.examPgecet.model.CollegeBranchDetails;
import com.example.admin.data.fragments.FragmentCollegeDetails_Ecet;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class College_Details extends AppCompatActivity implements ActionBar.TabListener{
    private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";
    String q,b;
    TextView data,data2;
    public final static String MESSAGE_KEY ="colcode";
    Call<List<CollegeBranchDetails>> call;
    List<CollegeBranchDetails> list;
    List<CollegeDetails> colg;
    ViewPager viewPager;
    TabLayout tabLayout;

    LinearLayout ff,detailsback;
    ProgressBar p;
    TextView retry;
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecet__colleges__details);

        Intent inten = getIntent();
        String message = inten.getStringExtra(MESSAGE_KEY);
        // Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
        q="{\"institute_code\":\"" + message + "\"}";
        b="{\"colcode\":\"" + message + "\"}";
        setContentView(R.layout.activity_college__details);
        start();
        data=(TextView)findViewById(R.id.data);
        detailsback=findViewById(R.id.detailsback);
        detailsback.setVisibility(View.INVISIBLE);
        p=findViewById(R.id.progress);
        retry=findViewById(R.id.retry);
        retry.setVisibility(View.INVISIBLE);
        ff=findViewById(R.id.ff);
        p.setVisibility(View.VISIBLE);
        ff.setVisibility(View.INVISIBLE);


        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        catch (Exception e){

        }
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



        try {
            SharedPreferences details = getSharedPreferences("exam", MODE_PRIVATE);

            getSupportActionBar().setTitle(details.getString("exam_name","").toUpperCase());
            getSupportActionBar().setDisplayShowTitleEnabled(true);

        }
        catch (Exception e){

        }
    }
    public void start() {

        try {



            if (API_KEY.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please obtain your API KEY", Toast.LENGTH_LONG).show();
                return;
            }
            final RecyclerView recyclerVie = (RecyclerView) findViewById(R.id.recyclecollegedetails);
            recyclerVie.setLayoutManager(new LinearLayoutManager(this));

            SharedPreferences details =getSharedPreferences("exam", MODE_PRIVATE);

            ApiInterfacePut apiService = ApiClientExams.getClient().create(ApiInterfacePut.class);
            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(this, R.anim.layout_leftto_right);
            Call<List<CollegeDetails>> call = apiService.getCollegeDetails(details.getString("dbname",""),details.getString("collegeinfo",""),API_KEY,q);


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
                    retry.setVisibility(View.VISIBLE);
                    detailsback.setVisibility(View.INVISIBLE);
                    p.setVisibility(View.INVISIBLE);
                    recyclerVie.setVisibility(View.INVISIBLE);
                    // Toast.makeText(Eamcet_Colleges_Details.this, "No Internet Connection", Toast.LENGTH_LONG).show();
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
            //setupViewPager(viewPager);
        }
        // }
        //private void setupViewPager(final ViewPager viewPager) {
        try {
            SharedPreferences details =getSharedPreferences("exam", MODE_PRIVATE);

            final ViewPagerAdapter adapter1 = new ViewPagerAdapter(getSupportFragmentManager());
            ApiInterfacePut apiService = ApiClientExams.getClient().create(ApiInterfacePut.class);

            Log.d("counselBydefault ",details.getString("counselBydefault",""));

            Call<List<CollegeBranchDetails>> call = apiService.getBranch(details.getString("dbname",""),details.getString("counselBydefault",""),API_KEY,b);
            call.enqueue(new Callback<List<CollegeBranchDetails>>() {
                @Override
                public void onResponse(Call<List<CollegeBranchDetails>> call, Response<List<CollegeBranchDetails>> response) {
                    list = response.body();

                    for (int i = 0; i < list.size(); i++) {
                        adapter1.addFragment(new FragmentCollegeDetails_Ecet(), list, i);
                    }
                    viewPager.setAdapter(adapter1);
                    data.setVisibility(View.VISIBLE);
                    if (list.isEmpty()) {


                        final ViewPagerAdapter adapter1 = new ViewPagerAdapter(getSupportFragmentManager());
                        ApiInterfacePut apiService = ApiClientExams.getClient().create(ApiInterfacePut.class);
                        Call<List<CollegeBranchDetails>> call2 = apiService.getBranch(details.getString("dbname",""),details.getString("counselBydefault",""),API_KEY,b);

                        call2.enqueue(new Callback<List<CollegeBranchDetails>>() {
                            @Override
                            public void onResponse(Call<List<CollegeBranchDetails>> call, Response<List<CollegeBranchDetails>> response) {
                                list = response.body();

                                for (int i = 0; i < list.size(); i++) {

                                    adapter1.addFragment(new FragmentCollegeDetails_Ecet(), list, i);
                                }
                                if(list.isEmpty()){
                                    data.setText("No data Available for branches");
                                }

                                viewPager.setAdapter(adapter1);
                            }

                            @Override
                            public void onFailure(Call<List<CollegeBranchDetails>> call, Throwable t) {
                                //
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<List<CollegeBranchDetails>> call, Throwable t) {

                    Snackbar snackbar = Snackbar
                            .make(findViewById(R.id.ll), "No Network", Snackbar.LENGTH_INDEFINITE).setAction("Retry", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    p.setVisibility(View.VISIBLE);
                                    ff.setVisibility(View.INVISIBLE);
                                    detailsback.setVisibility(View.INVISIBLE);
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
                    snackbar.show();//Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                }
            });
        }catch (Exception e){

            start();
        }
    }
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        //  tab.setText(bran.get(0).getBranch());

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            return FragmentCollegeDetails_Ecet.newInstance(list.get(position));

        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(FragmentCollegeDetails_Ecet fragment, List<CollegeBranchDetails> title,int position) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title.get(position).getBranch());
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
