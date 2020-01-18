package com.example.admin.data.FragmentsExams.POLYCET;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.data.FastScroll.FastScrollRecyclerViewItemDecoration;
import com.example.admin.data.R;
import com.example.admin.data.examEamcet.model.BranchStatatics;
import com.example.admin.data.examEamcet.model.CasteStatatics;
import com.example.admin.data.examPgecet.model.Exam;
import com.example.admin.data.examPolycet.Polycet_Statastics_Graphs;
import com.example.admin.data.examPolycet.adapters.StatasticsAdapter_Polycet;
import com.example.admin.data.examPolycet.model.Branch;
import com.example.admin.data.examPolycet.model.College;
import com.example.admin.data.examPolycet.rest.ApiClient;
import com.example.admin.data.examPolycet.rest.ApiInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Fragment_Statatics_Polycet extends Fragment  implements AdapterView.OnItemSelectedListener{
    private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";
    Call<List<College>> call;
    List<College> branch;
    EditText t;
    StatasticsAdapter_Polycet adapter;

    List<College> bran;
    List<Exam> examm,examf;
    Call<List<Exam>> call3,call4;
    Call<List<Branch>> call2;
    List<Branch> branches;
    Spinner s;
    int male,female;
    String[] d;
    String branchselected;
    List<String> coucillist;
    Call<List<BranchStatatics>> call6;
    List<CasteStatatics> castelist;
    List<BranchStatatics> branchlist;
    Call<List<CasteStatatics>> call5;
    ProgressBar p;
    TextView retry;
    SwipeRefreshLayout r;
    CardView c;
    RecyclerView recyclerVie;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragment__statatics__polycet, container, false);
        try {
            t = view.findViewById(R.id.statsearch);
            s = view.findViewById(R.id.statSpinner);
            s.setVisibility(View.INVISIBLE);
            t.setVisibility(View.INVISIBLE);

            c = view.findViewById(R.id.statcard);
            p = view.findViewById(R.id.progress);
            retry = view.findViewById(R.id.retry);
            r = (SwipeRefreshLayout) view.findViewById(R.id.refreshcollege);

            c.setVisibility(View.INVISIBLE);
            retry.setVisibility(View.INVISIBLE);

            r.setColorSchemeResources(R.color.cutdown);
            r.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            start();
                            r.setRefreshing(false);
                        }
                    }, 2000);
                }
            });
            recyclerVie = (RecyclerView) view.findViewById(R.id.recyclestatastics);
            recyclerVie.setLayoutManager(new LinearLayoutManager(getContext()));
            start();// getBranchesIntoSpinner();

        }
        catch (Exception e){

        }
        return view;
    }
    public void getBranchesIntoSpinner()
    {
        try {

            p.setVisibility(View.VISIBLE);
            retry.setVisibility(View.INVISIBLE);
            recyclerVie.setVisibility(View.INVISIBLE);

            ApiInterface apiInterface1 = ApiClient.getClient().create(ApiInterface.class);


            call2 = apiInterface1.getData(API_KEY);

            call2.enqueue(new Callback<List<Branch>>() {
                @Override
                public void onResponse(Call<List<Branch>> call, Response<List<Branch>> response) {
                    branches = response.body();


                    if (branches.size() > 0) {
                        d = new String[branches.size()];
                        for (int i = 0; i < branches.size(); i++) {
                            d[i] = branches.get(i).getBranch()+"--"+branches.get(i).getName().toUpperCase();
                        }
                        if (d.length > 0) {
                            coucillist = Arrays.asList(d);
                            branchselected = coucillist.get(0).substring(0,3);
                            //Toast.makeText(this, "Branchselected  :"+branchselected, Toast.LENGTH_SHORT).show();
                            ArrayAdapter<String> counada = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, coucillist);
                            counada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s.setAdapter(counada);

                            s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    branchselected=parent.getItemAtPosition(position).toString().substring(0,3);

                                    // Toast.makeText(getApplicationContext(), branchselected, Toast.LENGTH_SHORT).show();
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {

                                            start();
                                        }
                                    },2000);
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            s.setVisibility(View.VISIBLE);
                            t.setVisibility(View.VISIBLE);
                            // start(branchselected);
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<Branch>> call, Throwable t) {
                    retry.setVisibility(View.VISIBLE);
                    recyclerVie.setVisibility(View.INVISIBLE);
                    p.setVisibility(View.INVISIBLE);
                }
            });
        }
        catch (Exception e){
            getBranchesIntoSpinner();
        }
    }
    void start(){

        try {
            p.setVisibility(View.VISIBLE);
            retry.setVisibility(View.INVISIBLE);
            recyclerVie.setVisibility(View.INVISIBLE);
            c.setVisibility(View.INVISIBLE);
            if (API_KEY.isEmpty()) {
                Toast.makeText(getContext(), "Please obtain your API KEY", Toast.LENGTH_LONG).show();
                return;
            } else {

                AlertDialog.Builder alertDialog=new AlertDialog.Builder(getContext());
                AlertDialog alert = alertDialog.create();


                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                final LayoutAnimationController controller =
                        AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_leftto_right);
                call = apiService.getColleges1(API_KEY);
                call.enqueue(new Callback<List<College>>() {
                    @Override
                    public void onResponse(Call<List<College>> call, Response<List<College>> response) {

                        try {
                            bran = response.body();
                            Collections.sort(bran);
                            p.setVisibility(View.INVISIBLE);
                            recyclerVie.setVisibility(View.VISIBLE);
                            t.setVisibility(View.VISIBLE);
                            retry.setVisibility(View.INVISIBLE);
                            c.setVisibility(View.VISIBLE);
                            HashMap<String, Integer> map = calculateIndexesForName(bran);
                            recyclerVie.setHasFixedSize(true);
                            try {
                                adapter = new StatasticsAdapter_Polycet(bran, map, new StatasticsAdapter_Polycet.OnItemClick() {
                                    @Override
                                    public void onItem(College item) {
                                        //  Toast.makeText(getApplicationContext(), "Selected College Code: "+item.getCode(), Toast.LENGTH_SHORT).show();
                                        ApiInterface apiInterface3 = ApiClient.getClient().create(ApiInterface.class);

                                        alert.setMessage("Loading...");
                                        alert.show();
                                        alert.setCancelable(false);
                                        alert.setContentView(R.layout.loadingdialog);

                                        try {
                                            String caste = "{code:'" + item.getCode() + "'}";
                                            call5 = apiInterface3.getCasteStatics(caste);
                                            call5.enqueue(new Callback<List<CasteStatatics>>() {
                                                @Override
                                                public void onResponse(Call<List<CasteStatatics>> call, Response<List<CasteStatatics>> response) {
                                                    castelist = response.body();


                                                    call6 = apiInterface3.getBranchStatics(caste);
                                                    call6.enqueue(new Callback<List<BranchStatatics>>() {
                                                        @Override
                                                        public void onResponse(Call<List<BranchStatatics>> call, Response<List<BranchStatatics>> response) {
                                                            branchlist = response.body();

                                                            Log.i("Branch list", branchlist.toString());
                                                            alert.dismiss();
                                                            Intent i = new Intent(getContext(), Polycet_Statastics_Graphs.class);
                                                            i.putExtra("male", male);
                                                            i.putExtra("female", female);
                                                            i.putExtra("name", item.getName());

                                                            i.putExtra("exam", "polycet");
                                                            i.putExtra("code", item.getCode());
                                                            i.putExtra("oc", castelist.get(0).getOC());
                                                            i.putExtra("bca", castelist.get(0).getBC_A());
                                                            i.putExtra("bcb", castelist.get(0).getBC_B());
                                                            i.putExtra("bcc", castelist.get(0).getBC_C());
                                                            i.putExtra("bcd", castelist.get(0).getBC_D());
                                                            i.putExtra("bce", castelist.get(0).getBC_E());
                                                            i.putExtra("sc", castelist.get(0).getSC());
                                                            i.putExtra("st", castelist.get(0).getST());

                                                            startActivity(i);
                                                        }

                                                        @Override
                                                        public void onFailure(Call<List<BranchStatatics>> call, Throwable t) {
                                                            Log.i("Failure ", "At branch Retrival");

                                                            alert.setMessage("No Network !");
                                                            alert.setCancelable(true);
                                                        }
                                                    });


                                                }

                                                @Override
                                                public void onFailure(Call<List<CasteStatatics>> call, Throwable t) {

                                                    Log.i("Failure ", "At Caste Retrival");
                                                    alert.setMessage("No Network !");
                                                    alert.setCancelable(true);

                                                    //Toast.makeText(getContext(), "No Network", Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                        } catch (Exception e) {

                                        }
                                    }
                                }, getContext());
                                recyclerVie.setAdapter(adapter);

                                recyclerVie.setLayoutAnimation(controller);
                                adapter.notifyDataSetChanged();
                                recyclerVie.scheduleLayoutAnimation();

                                FastScrollRecyclerViewItemDecoration decoration = new FastScrollRecyclerViewItemDecoration(getContext());
                                recyclerVie.addItemDecoration(decoration);
                                recyclerVie.setItemAnimator(new DefaultItemAnimator());

                                setupsearch();
                            }
                            catch (Exception e){

                            }
                        }
                        catch (Exception e){

                        }
                    }

                    @Override
                    public void onFailure(Call<List<College>> call, Throwable t) {
                        retry.setVisibility(View.VISIBLE);
                        recyclerVie.setVisibility(View.INVISIBLE);
                        p.setVisibility(View.INVISIBLE);
                    }
                });


            }
        }catch (Exception e){
            start();
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
        //new array list that will hold the filtered data
        List<College> filterdNames =new ArrayList<College>();

        //looping through existing elements
        for (College s : bran) {
            //if the existing elements contains the search input
            if (s.getName().contains(text.toUpperCase())||s.getCode().contains(text.toUpperCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }
        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(filterdNames);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        branchselected=parent.getItemAtPosition(position).toString().substring(0,3);

        // Toast.makeText(getApplicationContext(), branchselected, Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                start();
            }
        },5000);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private HashMap<String, Integer> calculateIndexesForName(List<College> items){

        HashMap<String, Integer> mapIndex = new LinkedHashMap<>();
        for (int i = 0; i<items.size(); i++){
            String name = items.get(i).getName();
            System.out.println(name+"\n");
            String index = name.substring(0,1);
            Log.i(index,"hello");
            index = index.toUpperCase();
            Log.i("what in upper",index);

            if (!mapIndex.containsKey(index)) {
                mapIndex.put(index, i);
            }
        }
        System.out.println(mapIndex+"in map index");
        return mapIndex;
    }
}
