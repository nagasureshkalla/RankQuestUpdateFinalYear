package com.example.admin.data.fragments;


        import android.annotation.SuppressLint;
        import android.os.Bundle;
        import androidx.fragment.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import com.example.admin.data.R;
        import com.example.admin.data.examPolycet.model.CollegeBranchDetails;


public class FragmentCollegeDetails_Polycet  extends Fragment {

    TextView t,i,j;
    TextView branch,mo1,mo2,mo3,mo4,mo5,mo6,mo7,mo8,mc1,mc2,mc3,mc4,mc5,mc6,mc7,mc8,fo1,fo2,fo3,fo4,fo5,fo6,fo7,fo8,fc1,fc2,fc3,fc4,fc5,fc6,fc7,fc8;


    private String mPage;
    public FragmentCollegeDetails_Polycet (){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public static FragmentCollegeDetails_Polycet  newInstance(CollegeBranchDetails branchDetails) {
        Bundle args = new Bundle();
        args.putString("branch_name",branchDetails.getBranch_name().toUpperCase());
        args.putString("oco",branchDetails.getOc_m_min());
        args.putString("occ",branchDetails.getOc_m_max());
        args.putString("ocof",branchDetails.getOc_f_min());
        args.putString("occf",branchDetails.getOc_f_max());

        args.putString("bcao",branchDetails.getBc_a_m_min());
        args.putString("bcac",branchDetails.getBc_a_m_max());
        args.putString("bcaof",branchDetails.getBc_a_f_min());
        args.putString("bcacf",branchDetails.getBc_a_f_max());

        args.putString("bcbo",branchDetails.getBc_b_m_min());
        args.putString("bcbc",branchDetails.getBc_b_m_max());
        args.putString("bcbof",branchDetails.getBc_b_f_min());
        args.putString("bcbcf",branchDetails.getBc_b_f_max());

        args.putString("bcco",branchDetails.getBc_c_m_min());
        args.putString("bccc",branchDetails.getBc_c_m_max());
        args.putString("bccof",branchDetails.getBc_c_f_min());
        args.putString("bcccf",branchDetails.getBc_c_f_max());

        args.putString("bcdo",branchDetails.getBc_d_m_min());
        args.putString("bcdc",branchDetails.getBc_d_m_max());
        args.putString("bcdof",branchDetails.getBc_d_f_min());
        args.putString("bcdcf",branchDetails.getBc_d_f_max());

        args.putString("bceo",branchDetails.getBc_e_m_min());
        args.putString("bcec",branchDetails.getBc_e_m_max());
        args.putString("bceof",branchDetails.getBc_e_f_min());
        args.putString("bcecf",branchDetails.getBc_e_f_max());


        args.putString("sco",branchDetails.getSc_m_min());
        args.putString("scc",branchDetails.getSc_m_max());
        args.putString("scof",branchDetails.getSc_f_min());
        args.putString("sccf",branchDetails.getSc_f_max());

        args.putString("sto",branchDetails.getSt_m_min());
        args.putString("stc",branchDetails.getSt_m_max());
        args.putString("stof",branchDetails.getSt_f_min());
        args.putString("stcf",branchDetails.getSt_f_max());

        FragmentCollegeDetails_Polycet  fragment = new FragmentCollegeDetails_Polycet ();
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
