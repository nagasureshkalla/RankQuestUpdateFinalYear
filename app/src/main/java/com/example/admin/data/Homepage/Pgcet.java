package com.example.admin.data.Homepage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.MenuItem;

import com.example.admin.data.FragmentsExams.EAMCET.Adapter.BottomPagerAdapter;
import com.example.admin.data.FragmentsExams.PGECET.Fragment_Branches_Pgcet;
import com.example.admin.data.FragmentsExams.PGECET.Fragment_Checklist_Pgcet;
import com.example.admin.data.FragmentsExams.PGECET.Fragment_Colleges_Pgcet;
import com.example.admin.data.FragmentsExams.PGECET.Fragment_Cutoff_pgcet;
import com.example.admin.data.FragmentsExams.PGECET.Fragment_Statatics_Pgcet;
import com.example.admin.data.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Pgcet extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9;
    ViewPager pager;
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgcet);

        /*MobileAds.initialize(this,"ca-app-pub-1002768150287472~3177562999");

        AdView adview=findViewById(R.id.adViewEamcet);

        AdRequest adRequest=new AdRequest.Builder().build();
        adview.loadAd(adRequest);*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
            BottomPagerAdapter pagerAdapter = new BottomPagerAdapter(getSupportFragmentManager());
            pagerAdapter.addFrag(new Fragment_Cutoff_pgcet());
            pagerAdapter.addFrag(new Fragment_Colleges_Pgcet());
            pagerAdapter.addFrag(new Fragment_Branches_Pgcet());
            pagerAdapter.addFrag(new Fragment_Checklist_Pgcet());
            pagerAdapter.addFrag(new Fragment_Statatics_Pgcet());
            pager.setAdapter(pagerAdapter);
        }catch (Exception e){

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
                    return new Fragment_Cutoff_pgcet();
                case 1:
                    return new Fragment_Colleges_Pgcet();
                case 2:
                    return new Fragment_Branches_Pgcet();
                case 3:
                    return new Fragment_Checklist_Pgcet();
                case 4:
                    return new Fragment_Statatics_Pgcet();
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
