package com.example.admin.data.Homepage;

import com.example.admin.data.FragmentsExams.EAMCET.Adapter.BottomPagerAdapter;
import com.example.admin.data.FragmentsExams.EAMCET.Fragment_Branches;
import com.example.admin.data.FragmentsExams.EAMCET.Fragment_Checklist;
import com.example.admin.data.FragmentsExams.EAMCET.Fragment_Colleges;
import com.example.admin.data.FragmentsExams.EAMCET.Fragment_Cutoff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.MenuItem;

import com.example.admin.data.FragmentsExams.EAMCET.Fragment_Statatics;
import com.example.admin.data.FragmentsExams.PGECET.Fragment_Cutoff_pgcet;
import com.example.admin.data.R;
import com.google.android.gms.ads.AdView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class Eamcet extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    CardView c1,c2,c3,c4,c5,c6;
    AdView ad;
    ViewPager pager;
    BottomNavigationView navigation;
    BottomPagerAdapter pagerAdapter;
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eamcet);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try {

             navigation = findViewById(R.id.navigation);
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
    private  void setUpPager(ViewPager pager){

        try {
            pagerAdapter = new BottomPagerAdapter(getSupportFragmentManager());
            pagerAdapter.addFrag(new Fragment_Cutoff());
            pagerAdapter.addFrag(new Fragment_Colleges());
            pagerAdapter.addFrag(new Fragment_Branches());
            pagerAdapter.addFrag(new Fragment_Checklist());
            pagerAdapter.addFrag(new Fragment_Statatics());
            pager.setAdapter(pagerAdapter);
        }
        catch (Exception e){

        }

    }
    private class MyPagerAdapter extends FragmentPagerAdapter {



        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment_Cutoff();
                case 1:
                    return new Fragment_Colleges();
                case 2:
                    return new Fragment_Branches();
                case 3:
                    return new Fragment_Checklist();
                case 4:
                    return new Fragment_Statatics();
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
