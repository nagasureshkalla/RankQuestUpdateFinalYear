package com.example.admin.data.examEamcet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;

import com.github.mikephil.charting.utils.EntryXComparator;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.cardview.widget.CardView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.data.R;
import com.example.admin.data.examEamcet.adapter.CutoffAdapter;
import com.example.admin.data.examEamcet.model.CollegeBranchDetails;
import com.example.admin.data.examEamcet.rest.ApiClient;
import com.example.admin.data.examEamcet.rest.ApiInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Eamcet_Cutoff_Result extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    MaterialButton showmore;
    int showmoreClick=1;
    String q,q2,q3,q4,q5,q6,q7;
    FrameLayout showlayout;
    ProgressBar showmoreProgress;
    //List<String> queries=new ArrayList<>();



    private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";
    List<CollegeBranchDetails> list,more;
    List<com.example.admin.data.examPolycet.model.College> list1;
    String gender,caste,rank,council,sortby;

     String cas;
     Spinner branch;
    public final static String MESSAGE_KEY ="college_code";
    EditText t;
    CutoffAdapter cutoffAdapter;
    String branchselected;
    List<String> coucillist;
    String[] c,d,all;
    SwipeRefreshLayout refreshLayout;
    ProgressBar p;
    LinearLayout ll;
    CardView ft;
    TextView retry;

    public void refresh(){


        refreshLayout.setColorSchemeResources(R.color.cutdown);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        start(branchselected);
                            refreshLayout.setRefreshing(false);


                    }
                },2000);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eamcet__cutoff__result);
        Intent i=getIntent();
        gender=i.getStringExtra("gender");
        caste=i.getStringExtra("caste");
        rank=i.getStringExtra("rank");
        council=i.getStringExtra("council");
        sortby=i.getStringExtra("sortby");
        d =i.getStringArrayExtra("selectedItems");
        c=i.getStringArrayExtra("selectedColleges");


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        t=(EditText)findViewById(R.id.search) ;
        t.setVisibility(View.INVISIBLE);

        showlayout=findViewById(R.id.showlayout);
        showmoreProgress=findViewById(R.id.showmoreProgress);
        showmoreProgress.setVisibility(View.INVISIBLE);
        showlayout.setVisibility(View.GONE);
        showmore=findViewById(R.id.showmore);

        p=findViewById(R.id.progress);
        ft=findViewById(R.id.ft);
        retry=findViewById(R.id.retry);
        refreshLayout=(SwipeRefreshLayout)findViewById(R.id.refreshcutoff);

        refreshLayout.setVisibility(View.INVISIBLE);

        try {
            ll = findViewById(R.id.ll);
            ll.setVisibility(View.INVISIBLE);
            retry.setVisibility(View.INVISIBLE);
            branch = (Spinner) findViewById(R.id.branchesdata);
            branch.setVisibility(View.INVISIBLE);


            ft.setVisibility(View.INVISIBLE);

            all = new String[d.length + 1];
            all[0] = "ALL";


            for (int j = 0; j < d.length; j++) {
                //System.out.print(d[j]);
                all[j + 1] = d[j];

                System.out.println(all[j]);
            }

            coucillist = Arrays.asList(all);
            branchselected = coucillist.get(0).substring(0, 3);
            //Toast.makeText(this, "Branchselected  :"+branchselected, Toast.LENGTH_SHORT).show();
            ArrayAdapter<String> counada = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, coucillist);
            counada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            branch.setAdapter(counada);







            switch (caste) {
                case "OC":
                    if (gender.equals("M")) {
                        cas = "oc_male_Last_Rank";
                    } else {
                        cas = "oC_Female_Last_Rank";
                    }
                    break;
                case "BC_A":
                    if (gender.equals("M")) {
                        cas = "bc_male_Last_Rank";

                    } else {
                        cas = "bC_A_Female_Last_Rank";
                    }
                    break;
                case "BC_B":
                    if (gender.equals("M")) {
                        cas = "bC_B_Male_Last_Rank";

                    } else {
                        cas = "bC_B_Female_Last_Rank";

                    }
                    break;
                case "BC_C":
                    if (gender.equals("M")) {
                        cas = "bC_C_Male_Last_Rank";

                    } else {
                        cas = "bC_C_Female_Last_Rank";

                    }
                    break;
                case "BC_D":
                    if (gender.equals("M")) {
                        cas = "bC_D_Male_Last_Rank";

                    } else {
                        cas = "bC_D_Female_Last_Rank";

                    }
                    break;
                case "BC_E":
                    if (gender.equals("M")) {
                        cas = "bC_E_Male_Last_Rank";

                    } else {
                        cas = "bC_E_Female_Last_Rank";

                    }
                    break;
                case "SC":
                    if (gender.equals("M")) {
                        cas = "sC_Male_Last_Rank";

                    } else {
                        cas = "sC_Female_Last_Rank";

                    }
                    break;
                case "ST":
                    if (gender.equals("M")) {
                        cas = "sT_Male_Last_Rank";

                    } else {
                        cas = "sC_Female_Last_Rank";

                    }
                    break;
            }

            branch.setOnItemSelectedListener(this);


                refresh();

        }
        catch (Exception e){
            e.printStackTrace();
        }
       // start(branchselected);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        branchselected=adapterView.getItemAtPosition(i).toString().substring(0,3);

        //Toast.makeText(Eamcet_Cutoff_Result.this, "Swipe Down to Refresh", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                start(branchselected);
            }
        },2000);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
          //  branchselected=adapterView.getItemAtPosition(0).toString().substring(0,3);
    }



    public void start(String branchselected){



        int k=0;
        try {

                p.setVisibility(View.VISIBLE);

                refreshLayout.setVisibility(View.INVISIBLE);
                retry.setVisibility(View.INVISIBLE);


            //Toast.makeText(this, gender+caste+council+rank, Toast.LENGTH_SHORT).show();
            if (c.length == 0) {


                if(branchselected.equals("ALL")){

                    q = "{$or:[";
                    for (int i = 0; i < d.length; i++) {

                        if (i != d.length - 1) {
                            q = q + "{" + cas + ":{$gte:" + rank + "},branch:'" + d[i].substring(0,3) + "'},{" + cas + ":'NA',branch:'" + d[i].substring(0,3) + "'},";
                        } else {
                            q = q + "{" + cas + ":{$gte:" + rank + "},branch:'" + d[i].substring(0,3) + "'},{" + cas + ":'NA',branch:'" + d[i].substring(0,3) + "'}]}";
                        }
                    }
                }

            }
            else {

                if(branchselected.equals("ALL")){

                    q = "{$or:[";
                    for (int i = 0; i < c.length; i++) {

                        for (int j = 0; j < d.length; j++) {
                                k = k + 1;
                                Log.d("Checking", "If" + String.valueOf(i));
                                q = q + "{" + cas + ":{$gte:" + rank + "},branch:'" + d[j].substring(0, 3) + "',code:'" + c[i] + "'},{" + cas + ":'NA',branch:'" + d[j].substring(0, 3) + "',code:'" + c[i] + "'},";

                        }


                    }
                    q= q.substring(0,q.length()-1);
                    q=q+"]}";
                }

            }
            // Toast.makeText(this, gender+rank+council+caste+q, Toast.LENGTH_LONG).show();

            Log.i("\n\nK value is :", String.valueOf(k));
            Log.i("\n\nshowClick is: ",String.valueOf(showmoreClick));


            final RecyclerView recycle = (RecyclerView) findViewById(R.id.recyclecutoff);

            recycle.setLayoutManager(new LinearLayoutManager(this));

            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            //final LayoutAnimationController controller =
              //      AnimationUtils.loadLayoutAnimation(this, R.anim.layout_leftto_right);

            Call<List<CollegeBranchDetails>> call;
            if (council.contains("counselling 1")) {
                call = apiService.getData1(q);
                //Toast.makeText(this, "council 1", Toast.LENGTH_SHORT).show();
            } else if (council.contains("counselling 2")) {
                call = apiService.getData2(q);
                //Toast.makeText(this, "council 2", Toast.LENGTH_SHORT).show();
            } else {
                call = apiService.getData3(q);
                // Toast.makeText(this, "council 3", Toast.LENGTH_SHORT).show();
            }


            call.enqueue(new Callback<List<CollegeBranchDetails>>() {
                @Override
                public void onResponse(Call<List<CollegeBranchDetails>> call, Response<List<CollegeBranchDetails>> response) {
                    try {
                        list = response.body();

                        t.setVisibility(View.VISIBLE);
                        branch.setVisibility(View.VISIBLE);

                        ll.setVisibility(View.VISIBLE);

                        p.setVisibility(View.INVISIBLE);
                        refreshLayout.setVisibility(View.VISIBLE);


                        if (sortby.equals("yes")) {
                            Collections.sort(list);
                        }

                        cutoffAdapter = new CutoffAdapter(list, R.layout.recycle_cutoff, new CutoffAdapter.OnItemClick() {
                            @Override
                            public void onItem(CollegeBranchDetails item) {
                                //Toast.makeText(getApplicationContext(), "Clicked "+item.getCode(), Toast.LENGTH_SHORT).show();
                                Intent r = new Intent(Eamcet_Cutoff_Result.this, Eamcet_Colleges_Details.class);
                                r.putExtra(MESSAGE_KEY, item.getCode());
                                startActivity(r);
                            }
                        }, getApplicationContext());
                        recycle.setAdapter(cutoffAdapter);



                        cutoffAdapter.notifyDataSetChanged();

                        Log.i("Count ", String.valueOf(list.size()));
                        if (list.isEmpty()) {
                            Toast.makeText(Eamcet_Cutoff_Result.this, "Please Select Another Branch", Toast.LENGTH_LONG).show();
                            retry.setText("No Colleges Found For Your Rank\nPlease Select Another Branch");
                            retry.setVisibility(View.VISIBLE);
                            recycle.setVisibility(View.INVISIBLE);
                        }

                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<List<CollegeBranchDetails>> call, Throwable t) {
                    p.setVisibility(View.INVISIBLE);
                    retry.setVisibility(View.VISIBLE);
                    ll.setVisibility(View.INVISIBLE);
                    refreshLayout.setVisibility(View.VISIBLE);
                    //Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_SHORT).show();
                }
            });
            setupsearch();
        }
        catch (Exception e){
            start(branchselected);
        }
    }


    public void setupsearch(){

        t.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString());
            }
        });
    }
    private void filter(String text) {
        //new array list that will hold the filtered data90
        List<CollegeBranchDetails> filterdNames =new ArrayList<CollegeBranchDetails>();

        //looping through existing elements
        for (CollegeBranchDetails s : list) {
            //if the existing elements contains the search input
            if (s.getName().contains(text.toUpperCase())||s.getCode().contains(text.toUpperCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }
        //calling a method of the adapter class and passing the filtered list
        cutoffAdapter.filterList(filterdNames);
    }


}
