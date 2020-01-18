package com.example.admin.data.Homepage.DynamicFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.admin.data.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class Fragment_Checklist_Ecet extends Fragment {
    TabLayout tabLayout;
    TabItem tabcheck,tabreport;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    private String tabIcons[] = {"CheckList","Reporting Centers"};
RecyclerView r;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment__checklist__ecet, container, false);


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

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabIcons[position];
        }
        public PageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:

                    return new Fraagment_Checklist_Ecet_Main();
                case 1:

                    return new Fragment_Reportingcenters_Ecet();
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
