package com.example.admin.data.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.data.R;
import com.example.admin.data.examEamcet.model.Branches;
import com.example.admin.data.examEamcet.model.CollegeBranchDetails;

import java.util.List;


public class FragmentCollegeDetails extends Fragment {

    TextView t,i,j;
    TextView branch,mo1,mo2,mo3,mo4,mo5,mo6,mo7,mo8,mc1,mc2,mc3,mc4,mc5,mc6,mc7,mc8,fo1,fo2,fo3,fo4,fo5,fo6,fo7,fo8,fc1,fc2,fc3,fc4,fc5,fc6,fc7,fc8;
    static List<Branches> bran;

    private String mPage;
    public FragmentCollegeDetails(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public static FragmentCollegeDetails newInstance(CollegeBranchDetails branchDetails) {
        Bundle args = new Bundle();




        args.putString("branch_name",branchDetails.getBranch_name().toUpperCase());
        args.putString("oco",branchDetails.getOc_male_Best_Rank());
        args.putString("occ",branchDetails.getOc_male_Last_Rank());
        args.putString("ocof",branchDetails.getoC_Female_Best_Rank());
        args.putString("occf",branchDetails.getoC_Female_Last_Rank());

        args.putString("bcao",branchDetails.getBc_male_Best_Rank());
        args.putString("bcac",branchDetails.getBc_male_Last_Rank());
        args.putString("bcaof",branchDetails.getbC_A_Female_Best_Rank());
        args.putString("bcacf",branchDetails.getbC_A_Female_Last_Rank());

        args.putString("bcbo",branchDetails.getbC_B_Male_Best_Rank());
        args.putString("bcbc",branchDetails.getbC_B_Male_Last_Rank());
        args.putString("bcbof",branchDetails.getbC_B_Female_Best_Rank());
        args.putString("bcbcf",branchDetails.getbC_B_Female_Last_Rank());

        args.putString("bcco",branchDetails.getbC_C_Male_Best_Rank());
        args.putString("bccc",branchDetails.getbC_C_Male_Last_Rank());
        args.putString("bccof",branchDetails.getbC_C_Female_Best_Rank());
        args.putString("bcccf",branchDetails.getbC_C_Female_Last_Rank());

        args.putString("bcdo",branchDetails.getbC_D_Male_Best_Rank());
        args.putString("bcdc",branchDetails.getbC_D_Male_Last_Rank());
        args.putString("bcdof",branchDetails.getbC_D_Female_Best_Rank());
        args.putString("bcdcf",branchDetails.getbC_D_Female_Last_Rank());

        args.putString("bceo",branchDetails.getbC_E_Male_Best_Rank());
        args.putString("bcec",branchDetails.getbC_E_Male_Last_Rank());
        args.putString("bceof",branchDetails.getbC_E_Female_Best_Rank());
        args.putString("bcecf",branchDetails.getbC_E_Female_Last_Rank());


        args.putString("sco",branchDetails.getsC_Male_Best_Rank());
        args.putString("scc",branchDetails.getsC_Male_Last_Rank());
        args.putString("scof",branchDetails.getsC_Female_Best_Rank());
        args.putString("sccf",branchDetails.getsC_Female_Last_Rank());

        args.putString("sto",branchDetails.getsT_Male_Best_Rank());
        args.putString("stc",branchDetails.getsT_Male_Last_Rank());
        args.putString("stof",branchDetails.getsT_Female_Best_Rank());
        args.putString("stcf",branchDetails.getsT_Female_Last_Rank());

        FragmentCollegeDetails fragment = new FragmentCollegeDetails();
        fragment.setArguments(args);
        return fragment;
    }


    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycle_college_branch_details, container, false);
        return v;

    }
    @Override

    public void onViewCreated(View v, Bundle savedInstanceState) {

        super.onViewCreated(v, savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {


            branch=v.findViewById(R.id.branch_name);
            mo1=v.findViewById(R.id.oco);
            mo2=v.findViewById(R.id.occ);
            mo3=v.findViewById(R.id.ocof);
            mo4=v.findViewById(R.id.occf);

            mo5=v.findViewById(R.id.bcao);
            mo6=v.findViewById(R.id.bcac);
            mo7=v.findViewById(R.id.bcaof);
            mo8=v.findViewById(R.id.bcacf);

            mc1=v.findViewById(R.id.bcbo);
            mc2=v.findViewById(R.id.bcbc);
            mc3=v.findViewById(R.id.bcbof);
            mc4=v.findViewById(R.id.bcbcf);

            mc5=v.findViewById(R.id.bcco);
            mc6=v.findViewById(R.id.bccc);
            mc7=v.findViewById(R.id.bccof);
            mc8=v.findViewById(R.id.bcccf);

            fo1=v.findViewById(R.id.bcdo);
            fo2=v.findViewById(R.id.bcdc);
            fo3=v.findViewById(R.id.bcdof);
            fo4=v.findViewById(R.id.bcdcf);

            fo5=v.findViewById(R.id.bceo);
            fo6=v.findViewById(R.id.bcec);
            fo7=v.findViewById(R.id.bceof);
            fo8=v.findViewById(R.id.bcecf);

            fc1=v.findViewById(R.id.sco);
            fc2=v.findViewById(R.id.scc);
            fc3=v.findViewById(R.id.scof);
            fc4=v.findViewById(R.id.sccf);

            fc5=v.findViewById(R.id.sto);
            fc6=v.findViewById(R.id.stc);
            fc7=v.findViewById(R.id.stof);
            fc8=v.findViewById(R.id.stcf);



            branch.setText(args.getString("branch_name"));
            mo1.setText(args.getString("oco"));
            mo2.setText(args.getString("occ"));
            mo3.setText(args.getString("ocof"));
            mo4.setText(args.getString("occf"));

            mo5.setText(args.getString("bcao"));
            mo6.setText(args.getString("bcac"));
            mo7.setText(args.getString("bcaof"));
            mo8.setText(args.getString("bcacf"));

            mc1.setText(args.getString("bcbo"));
            mc2.setText(args.getString("bcbc"));
            mc3.setText(args.getString("bcbof"));
            mc4.setText(args.getString("bcbcf"));

            mc5.setText(args.getString("bcco"));
            mc6.setText(args.getString("bccc"));
            mc7.setText(args.getString("bccof"));
            mc8.setText(args.getString("bcccf"));

            fo1.setText(args.getString("bcdo"));
            fo2.setText(args.getString("bcdc"));
            fo3.setText(args.getString("bcdof"));
            fo4.setText(args.getString("bcdcf"));

            fo5.setText(args.getString("bceo"));
            fo6.setText(args.getString("bcec"));
            fo7.setText(args.getString("bceof"));
            fo8.setText(args.getString("bcecf"));

            fc1.setText(args.getString("sco"));
            fc2.setText(args.getString("scc"));
            fc3.setText(args.getString("scof"));
            fc4.setText(args.getString("sccf"));

            fc5.setText(args.getString("sto"));
            fc6.setText(args.getString("stc"));
            fc7.setText(args.getString("stof"));
            fc8.setText(args.getString("stcf"));
        }
    }


}
