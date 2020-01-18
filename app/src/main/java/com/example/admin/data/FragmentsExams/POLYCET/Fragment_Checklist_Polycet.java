package com.example.admin.data.FragmentsExams.POLYCET;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import com.example.admin.data.R;
import com.example.admin.data.examEamcet.adapter.ReportingCentersAdapter;
import com.example.admin.data.examEamcet.model.ReportingCenters;
import com.example.admin.data.examPolycet.rest.ApiClient;
import com.example.admin.data.examPolycet.rest.ApiInterface;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.List;


public class Fragment_Checklist_Polycet extends Fragment {

    TabLayout tabLayout;
    TabItem tabcheck,tabreport;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    private String tabIcons[] = {"CheckList","Reporting Centers"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment__checklist__polycet, container, false);

        tabcheck = view.findViewById(R.id.checklistFrag);
        tabreport = view.findViewById(R.id.reportingFrag);

        viewPager = view.findViewById(R.id.chechlistViewpager);
        pageAdapter = new PageAdapter(getFragmentManager());
        tabLayout = view.findViewById(R.id.checklistTabs);

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(pageAdapter);
        return view;
    }
    public class PageAdapter extends FragmentPagerAdapter {


        public PageAdapter(FragmentManager fm) {
            super(fm);
        }
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabIcons[position];
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:

                    return new Fragment_Checklist_Polycet_Main();
                case 1:

                    return new Fragment_Reportingcenters_Polycet();
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}
