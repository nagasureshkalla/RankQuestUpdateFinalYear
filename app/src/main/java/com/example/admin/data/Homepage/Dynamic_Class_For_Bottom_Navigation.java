package com.example.admin.data.Homepage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.admin.data.FragmentsExams.EAMCET.Adapter.BottomPagerAdapter;

import com.example.admin.data.Homepage.DynamicFragments.Fragment_Branches_Ecet;
import com.example.admin.data.Homepage.DynamicFragments.Fragment_Checklist_Ecet;
import com.example.admin.data.Homepage.DynamicFragments.Fragment_Colleges_Ecet;
import com.example.admin.data.Homepage.DynamicFragments.Fragment_Cutoff_Ecet;
import com.example.admin.data.Homepage.DynamicFragments.Fragment_Statatics_Ecet;
import com.example.admin.data.Homepage.Model.Exam_Name_MainPage;
import com.example.admin.data.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Dynamic_Class_For_Bottom_Navigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    ViewPager pager;
    Set<String> counsellings=new HashSet<>();
    String[] counsel;
    Exam_Name_MainPage exam_name_mainPage=null;
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic__class__for__bottom__navigation);

        try {
            exam_name_mainPage = (Exam_Name_MainPage) getIntent().getSerializableExtra("obj");

        }
        catch (Exception e){

        }
        try{

            int l=exam_name_mainPage.getCounsellings().length;
            Log.d("Length ", String.valueOf(l));
            String[] cou=exam_name_mainPage.getCounsellings();

            counsellings.addAll(Arrays.asList(cou).subList(0, l));



            SharedPreferences details = getSharedPreferences("exam", MODE_PRIVATE);
            SharedPreferences.Editor editor = details.edit();
            editor.putString("exam_name",exam_name_mainPage.getExam_name().toUpperCase());
            editor.putString("dbname", exam_name_mainPage.getDbname());
            editor.putString("branches",exam_name_mainPage.getBranches());
            editor.putString("collegeinfo",exam_name_mainPage.getCollegedetails());
            editor.putString("reportingcenters",exam_name_mainPage.getReportingcenters());
            editor.putString("counselBydefault",exam_name_mainPage.getCounsellings()[0]);
            editor.putString("branchstatistics",exam_name_mainPage.getBranchstatistics());
            editor.putString("castestatistics",exam_name_mainPage.getCastestatistics());
            editor.putStringSet("counsellings",counsellings);
            editor.putString("checklist",exam_name_mainPage.getChecklist());
            editor.apply();

            try {


                getSupportActionBar().setTitle(exam_name_mainPage.getExam_name().toUpperCase());
                getSupportActionBar().setDisplayShowTitleEnabled(true);

            }
            catch (Exception e){

            }

            try {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
            catch (Exception e){

            }
        }
        catch (Exception e){

        }
        try {
            Log.d("Name ", exam_name_mainPage.getExam_name());
        }
        catch (Exception e){

        }





        try {

            BottomNavigationView navigation = findViewById(R.id.navigation);
            navigation.setSelectedItemId(R.id.cutoff);
            navigation.setOnNavigationItemSelectedListener(this);

            pager = (ViewPager) findViewById(R.id.container);
            pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
            pager.setOffscreenPageLimit(5);
            setUpPager(pager);
        }
        catch (Exception e)
        {}

    }
    private  void setUpPager(ViewPager pager){

        try {
            BottomPagerAdapter pagerAdapter = new BottomPagerAdapter(getSupportFragmentManager());
            pagerAdapter.addFrag(new Fragment_Cutoff_Ecet());
            pagerAdapter.addFrag(new Fragment_Colleges_Ecet());
            pagerAdapter.addFrag(new Fragment_Branches_Ecet());
            pagerAdapter.addFrag(new Fragment_Checklist_Ecet());
            pagerAdapter.addFrag(new Fragment_Statatics_Ecet());
            pager.setAdapter(pagerAdapter);
        }
        catch (Exception e){

        }

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.colleges:
                // fragment=new Fragment_Colleges();
                pager.setCurrentItem(1);
                break;
            case R.id.branches:
                pager.setCurrentItem(2);
                break;
            case R.id.cutoff:
                pager.setCurrentItem(0);
                break;
            case R.id.checklist:
                pager.setCurrentItem(3);
                break;
            case R.id.statastics:
                pager.setCurrentItem(4);
                break;
        }
        return true;
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment_Cutoff_Ecet();
                case 1:
                    return new Fragment_Colleges_Ecet();
                case 2:
                    return new Fragment_Branches_Ecet();
                case 3:
                    return new Fragment_Checklist_Ecet();
                case 4:
                    return new Fragment_Statatics_Ecet();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
