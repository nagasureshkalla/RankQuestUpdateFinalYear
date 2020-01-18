package com.example.admin.data.examPolycet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import android.app.ActionBar;
import android.app.FragmentTransaction;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.example.admin.data.R;
import com.example.admin.data.examPolycet.adapters.CollegeDatailAdapter;
import com.example.admin.data.examPolycet.model.College;
import com.example.admin.data.examPolycet.model.CollegeBranchDetails;
import com.example.admin.data.examPolycet.rest.ApiClient;
import com.example.admin.data.examPolycet.rest.ApiInterface;
import com.example.admin.data.fragments.FragmentCollegeDetails_Polycet;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Polcet_Colleges_Details extends AppCompatActivity implements ActionBar.TabListener{
        private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";
        String q,b;
        TextView data,data2;
    ViewPager viewPager;
    List<CollegeBranchDetails> list;
    TabLayout tabLayout;
    ProgressBar p;
    TextView retry;
    LinearLayout ff,detailsback;
        public final static String MESSAGE_KEY ="code";
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Intent inten = getIntent();
            String message = inten.getStringExtra(MESSAGE_KEY);
            //Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            q="{code:'" + message + "'}";
            b="{colcode:'" + message + "'}";
            setContentView(R.layout.activity_polcet__colleges__details);
            start();
            SwipeRefreshLayout r;
            p=findViewById(R.id.progress);
            data=(TextView)findViewById(R.id.data);
            ff=findViewById(R.id.ff);
            p.setVisibility(View.VISIBLE);
            ff.setVisibility(View.INVISIBLE);
            detailsback=findViewById(R.id.detailsback);
            detailsback.setVisibility(View.INVISIBLE);
            retry=findViewById(R.id.retry);
            retry.setVisibility(View.INVISIBLE);



            viewPager = (ViewPager) findViewById(R.id.viewpager);


            tabLayout = (TabLayout) findViewById(R.id.tabs);
           tabLayout.setupWithViewPager(viewPager);
        }
        public void start() {
            try {

                if (API_KEY.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please obtain your API KEY", Toast.LENGTH_LONG).show();
                    return;
                }
                final RecyclerView recyclerVie = (RecyclerView) findViewById(R.id.recyclecollegedetails);

                recyclerVie.setLayoutManager(new LinearLayoutManager(this));


                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                final LayoutAnimationController controller =
                        AnimationUtils.loadLayoutAnimation(this, R.anim.layout_leftto_right);
                Call<List<College>> call = apiService.getColleg(q);


                call.enqueue(new Callback<List<College>>() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void onResponse(Call<List<College>> call, Response<List<College>> response) {
                        List<College> colg = response.body();

                        p.setVisibility(View.INVISIBLE);
                        detailsback.setVisibility(View.VISIBLE);
                        retry.setVisibility(View.INVISIBLE);
                        ff.setVisibility(View.VISIBLE);
                        recyclerVie.setVisibility(View.VISIBLE);

                        CollegeDatailAdapter adapter = new CollegeDatailAdapter(colg, R.layout.recycle_college_details, getApplicationContext());
                        recyclerVie.setAdapter(adapter);

                        recyclerVie.setLayoutAnimation(controller);
                        adapter.notifyDataSetChanged();
                        recyclerVie.scheduleLayoutAnimation();
                        //setupViewPager(viewPager);
                        //tabLayout.setupWithViewPager(viewPager);

                    }

                    @Override
                    public void onFailure(Call<List<College>> call, Throwable t) {

                        retry.setVisibility(View.VISIBLE);
                        p.setVisibility(View.INVISIBLE);
                        detailsback.setVisibility(View.INVISIBLE);
                        recyclerVie.setVisibility(View.INVISIBLE);
                        Snackbar snackbar = Snackbar
                                .make(findViewById(R.id.ll), "No Network", Snackbar.LENGTH_INDEFINITE).setAction("Retry", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        p.setVisibility(View.VISIBLE);
                                        ff.setVisibility(View.INVISIBLE);
                                        retry.setVisibility(View.INVISIBLE);
                                       // Toast.makeText(getApplicationContext(),"hii",Toast.LENGTH_SHORT).show();
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
            }
            catch (Exception e){
                start();

            }
       // }
    //private void setupViewPager(final ViewPager viewPager) {
            try {
                final ViewPagerAdapter adapter1 = new ViewPagerAdapter(getSupportFragmentManager());
                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                Call<List<CollegeBranchDetails>> call = apiService.getData2(b);
                call.enqueue(new Callback<List<CollegeBranchDetails>>() {
                    @Override
                    public void onResponse(Call<List<CollegeBranchDetails>> call, Response<List<CollegeBranchDetails>> response) {
                        list = response.body();

                        data.setVisibility(View.VISIBLE);
                        for (int i = 0; i < list.size(); i++) {
                            adapter1.addFragment(new FragmentCollegeDetails_Polycet(), list, i);
                        }
                        viewPager.setAdapter(adapter1);
                        if (list.isEmpty()) {
                            //Toast.makeText(getApplicationContext(), "No data Available for branches", Toast.LENGTH_SHORT).show();


                            final ViewPagerAdapter adapter1 = new ViewPagerAdapter(getSupportFragmentManager());
                            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                            Call<List<CollegeBranchDetails>> call2 = apiService.getData6(b);

                            call2.enqueue(new Callback<List<CollegeBranchDetails>>() {
                                @Override
                                public void onResponse(Call<List<CollegeBranchDetails>> call, Response<List<CollegeBranchDetails>> response) {
                                    list = response.body();

                                    for (int i = 0; i < list.size(); i++) {
                                        adapter1.addFragment(new FragmentCollegeDetails_Polycet(), list, i);
                                    }
                                    if(list.isEmpty()){
                                        data.setText("No data Available for branches");
                                    }
                                    viewPager.setAdapter(adapter1);
                                }

                                @Override
                                public void onFailure(Call<List<CollegeBranchDetails>> call, Throwable t) {
                                   // data.setText("No data Available for branches");
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
                                       // Toast.makeText(getApplicationContext(),"in view pager",Toast.LENGTH_SHORT).show();
                                        start();
                                       // setupViewPager(viewPager);
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
            }
            catch (Exception e){
                //setupViewPager(viewPager);
            }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

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
            return FragmentCollegeDetails_Polycet.newInstance(list.get(position));

        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(FragmentCollegeDetails_Polycet fragment, List<CollegeBranchDetails> title,int position) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title.get(position).getBranch());
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
