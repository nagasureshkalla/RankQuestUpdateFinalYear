package com.example.admin.data.Homepage.DynamicFragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.data.FastScroll.FastScrollRecyclerViewItemDecoration;
import com.example.admin.data.Homepage.rest.ApiClientExams;
import com.example.admin.data.Homepage.rest.ApiInterfacePut;
import com.example.admin.data.R;
import com.example.admin.data.examEcet.adapter.SelectCollegeAdapter;
import com.example.admin.data.examEcet.model.CollegeDetails;
import com.example.admin.data.examEcet.rest.ApiClient;
import com.example.admin.data.examEcet.rest.ApiInterface;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectColleges extends AppCompatActivity {
    private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";

    SelectCollegeAdapter adapter=null;
    List<CollegeDetails> colg=null;
    List<String> selectedColleges=null;
    Button ok;
    String[] outputStrAr=null,select;
    EditText t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_colleges);
        t=(EditText)findViewById(R.id.editSelectColleges) ;
        t.setVisibility(View.INVISIBLE);
        ok=(Button)findViewById(R.id.ok);
        start();
        SwipeRefreshLayout r;
        r=(SwipeRefreshLayout)findViewById(R.id.refreshselectcolleges);
        r.setColorScheme(android.R.color.holo_red_dark);
        r.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        start();
                        r.setRefreshing(false);
                    }
                },10000);
            }
        });
        try {

            SharedPreferences details = getSharedPreferences("exam", MODE_PRIVATE);
            getSupportActionBar().setTitle(details.getString("exam_name","").toUpperCase());
            getSupportActionBar().setDisplayShowTitleEnabled(true);

        }
        catch (Exception e){

        }
    }
    void start(){

        try {
            AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
            AlertDialog alert = alertDialog.create();
            alert.show();

            alert.setCancelable(false);
            alert.setContentView(R.layout.loadingdialog);
            selectedColleges = new ArrayList<>();
            final RecyclerView recyclerVie = (RecyclerView) findViewById(R.id.recycleSelectColleges);

            LinearLayoutManager lm = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
            recyclerVie.setLayoutManager(lm);

            ApiInterfacePut apiService = ApiClientExams.getClient().create(ApiInterfacePut.class);
            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(this, R.anim.layout_leftto_right);

            SharedPreferences details = getSharedPreferences("exam", MODE_PRIVATE);

            Call<List<CollegeDetails>> call = apiService.getCollege(details.getString("dbname",""),details.getString("collegeinfo",""),API_KEY);
            call.enqueue(new Callback<List<CollegeDetails>>() {
                @Override
                public void onResponse(Call<List<CollegeDetails>> call, Response<List<CollegeDetails>> response) {
                    colg = response.body();
                    t.setVisibility(View.VISIBLE);
                    alert.dismiss();

                    Collections.sort(colg);
                    //HashMap<String, Integer> mapIndex = calculateIndexesForName(colg);
                    for (int i=0;i<colg.size();i++){
                        colg.get(i).setPosition(i);
                    }
                    HashMap<String, Integer> map = calculateIndexesForName(colg);
                    adapter = new SelectCollegeAdapter(colg,map,R.layout.recycle_select_colleges, new SelectCollegeAdapter.OnItemClickListener() {
                        @Override
                        public void onItem(CollegeDetails item) {
                            Toast.makeText(getApplicationContext(), "Selected College Code: " + item.getCode(), Toast.LENGTH_SHORT).show();
                            selectedColleges.add(item.getCode());

                        }
                    }, getApplicationContext());
                    recyclerVie.setAdapter(adapter);

                    recyclerVie.setLayoutAnimation(controller);
                    adapter.notifyDataSetChanged();
                    recyclerVie.scheduleLayoutAnimation();

                    FastScrollRecyclerViewItemDecoration decoration = new FastScrollRecyclerViewItemDecoration(getApplicationContext());
                    recyclerVie.addItemDecoration(decoration);
                    recyclerVie.setItemAnimator(new DefaultItemAnimator());

                }

                @Override
                public void onFailure(Call<List<CollegeDetails>> call, Throwable t) {
                    alert.dismiss();
                    Snackbar snackbar = Snackbar
                            .make(findViewById(R.id.ll), "No Network", Snackbar.LENGTH_INDEFINITE).setAction("Retry", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    start();
                                }
                            });
                    View snackbarView = snackbar.getView();
                    snackbarView.setMinimumHeight(25);
                    snackbarView.setBackgroundResource(R.color.orange);
                    TextView textView = snackbarView.findViewById(R.id.snackbar_action);
                    textView.setTextColor(Color.WHITE);
                    TextView textView1=snackbarView.findViewById(R.id.snackbar_text);
                    textView1.setTextSize(25);
                    textView.setTextSize(15);
                    snackbar.show();

                }
            });
            setupsearch();
        }
        catch (Exception e){
            start();
        }
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    List<String> position=SelectCollegeAdapter.getPosition();
                    if (position.size()>7){
                        Toast.makeText(getApplicationContext(), R.string.selectColleges, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        for (int i = 0; i < position.size(); i++) {
                            Log.i("Postion: ", position.get(i).toString());
                        }

                        outputStrAr = new String[position.size()];
                        for (int i = 0; i < position.size(); i++) {
                            outputStrAr[i] = position.get(i);
                        }

                        LinkedHashSet<String> lhSetColors =
                                new LinkedHashSet<String>(Arrays.asList(outputStrAr));
                        String[] newArray = lhSetColors.toArray(new String[lhSetColors.size()]);


                        Intent intent = new Intent();
                        Bundle b = new Bundle();
                        b.putStringArray("selectedColleges", newArray);
                        intent.putExtras(b);
                        setResult(2, intent);
                        finish();
                    }
                }
                catch (Exception e){

                }
            }
        });
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
        List<CollegeDetails> filterdNames =new ArrayList<CollegeDetails>();

        //looping through existing elements
        for (CollegeDetails s : colg) {
            //if the existing elements contains the search input
            if (s.getName().contains(text.toUpperCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }
        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(filterdNames);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.select_show, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.show:
                try {
                    List<String> position = SelectCollegeAdapter.getBranches();
                    for (int i = 0; i < position.size(); i++) {
                        Log.i("Postion: ", position.get(i).toString());
                    }

                    outputStrAr = new String[position.size()];
                    for (int i = 0; i < position.size(); i++) {
                        outputStrAr[i] = position.get(i);
                    }

                    LinkedHashSet<String> lhSetColors =
                            new LinkedHashSet<String>(Arrays.asList(outputStrAr));
                    String[] newArray = lhSetColors.toArray(new String[lhSetColors.size()]);

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Selected Colleges are...").setItems(newArray, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                catch (Exception e){

                }
                break;
        }
        return true;
    }
    private HashMap<String, Integer> calculateIndexesForName(List<CollegeDetails> c){

        HashMap<String, Integer> mapIndex = new LinkedHashMap<>();
        for (int i = 0; i<c.size(); i++){
            String name = c.get(i).getName();
            System.out.println(name+"\n");
            String index = name.substring(0,1);
            System.out.println(index+"hello");
            index = index.toUpperCase();
            System.out.println("what in upper"+index);

            if (!mapIndex.containsKey(index)) {
                mapIndex.put(index, i);
            }
        }
        System.out.println(mapIndex+"in map index");
        return mapIndex;
    }
}
