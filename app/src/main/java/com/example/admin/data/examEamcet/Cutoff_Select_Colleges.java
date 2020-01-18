package com.example.admin.data.examEamcet;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.example.admin.data.R;
import com.example.admin.data.examEamcet.adapter.SelectCollegeAdapter;
import com.example.admin.data.examEamcet.model.College;
import com.example.admin.data.examEamcet.rest.ApiClient;
import com.example.admin.data.examEamcet.rest.ApiInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cutoff_Select_Colleges extends AppCompatActivity {

    private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";

    SelectCollegeAdapter adapter=null;
    List<College> colg=null;
    List<String> selectedColleges=null;
    Button ok;
    String[] outputStrAr=null;
    EditText t;
    String[] newArray=null;
    int j=0;
    SwipeRefreshLayout r;

   // @Override
  //  public boolean onSupportNavigateUp() {

//        try {
//
//            List<String> position=SelectCollegeAdapter.getPosition();
//            if (position.size()>7){
//                Toast.makeText(getApplicationContext(), "Select Lessthan 8 Colleges", Toast.LENGTH_SHORT).show();
//            }
//            else {
//                for (int i = 0; i < position.size(); i++) {
//                    Log.i("Postion: ", position.get(i).toString());
//                }
//
//                outputStrAr = new String[position.size()];
//                for (int i = 0; i < position.size(); i++) {
//                    outputStrAr[i] = position.get(i);
//                }
//
//                LinkedHashSet<String> lhSetColors =
//                        new LinkedHashSet<String>(Arrays.asList(outputStrAr));
//                String[] newArray = lhSetColors.toArray(new String[lhSetColors.size()]);
//
//
//                Log.i("new Array", String.valueOf(newArray));
//                Intent intent = new Intent();
//                Bundle b = new Bundle();
//                b.putStringArray("selectedColleges", newArray);
//                intent.putExtras(b);
//                setResult(2, intent);
//                finish();
//            }
//
//        }catch (Exception e){
//
//        }
 //       finish();
 //       return true;
 //   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutoff__select__colleges);
        t = findViewById(R.id.editSelectColleges);
        t.setVisibility(View.INVISIBLE);
        ok = (Button) findViewById(R.id.ok);

        start();


        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        r=(SwipeRefreshLayout)findViewById(R.id.refreshselectcolleges);
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
                },2000);
            }
        });

    }

    public void start() {
        try {
            androidx.appcompat.app.AlertDialog.Builder alertDialog=new androidx.appcompat.app.AlertDialog.Builder(this);
            androidx.appcompat.app.AlertDialog alert = alertDialog.create();
            alert.show();
            alert.setCancelable(false);
            alert.setContentView(R.layout.loadingdialog);


            selectedColleges = new ArrayList<>();
            final RecyclerView recyclerVie = (RecyclerView) findViewById(R.id.recycleSelectColleges);

            LinearLayoutManager lm = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
            recyclerVie.setLayoutManager(lm);

            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(this, R.anim.layout_leftto_right);
            Call<List<College>> call = apiService.getCollege(API_KEY);

            call.enqueue(new Callback<List<College>>() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onResponse(Call<List<College>> call, Response<List<College>> response) {
                    colg = response.body();
                    alert.dismiss();
                    t.setVisibility(View.VISIBLE);
                    Collections.sort(colg);
                    //HashMap<String, Integer> mapIndex = calculateIndexesForName(colg);
                    for (int i=0;i<colg.size();i++){
                        colg.get(i).setPosition(i);
                        colg.get(i).setChecked(false);
                    }



                    HashMap<String, Integer> mapIndex = calculateIndexesForName(colg);
                   // Log.i("Indexes: ",mapIndex.toString());
                   adapter = new SelectCollegeAdapter(colg,mapIndex, R.layout.recycle_select_colleges, new SelectCollegeAdapter.OnItemClickListener() {

                        @Override
                        public void onItem(College item) {
                            // Toast.makeText(Cutoff_Select_Colleges.this, "Selected College Code: " + item.getCode(), Toast.LENGTH_SHORT).show();
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
                public void onFailure(Call<List<College>> call, Throwable t) {
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

                    TextView textView1 = snackbarView.findViewById(R.id.snackbar_text);
                    textView1.setTextSize(25);

                    textView.setTextSize(25);
                    snackbar.show();
                    //Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
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
                        newArray = lhSetColors.toArray(new String[lhSetColors.size()]);


                        Log.i("new Array", String.valueOf(newArray));
                        Intent intent = new Intent();
                        Bundle b = new Bundle();
                        b.putStringArray("selectedColleges", newArray);
                        intent.putExtras(b);
                        setResult(2, intent);
                        finish();
                    }

                }catch (Exception e){

                }
            }
        });

    }

    public void setupsearch() {

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
        List<College> filterdNames = new ArrayList<College>();

        //looping through existing elements
        for (College s : colg) {
            //if the existing elements contains the search input
            if (s.getCollegename().contains(text.toUpperCase())) {
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
        try {
            getMenuInflater().inflate(R.menu.select_show, menu);
        }catch (Exception e){

        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            switch (item.getItemId()) {
                case R.id.show:

                    try {

                        List<String> position = SelectCollegeAdapter.getBranches();
                        for (int i = 0; i < position.size(); i++) {
                            Log.i("Postion: ", position.get(i).toString());
                        }


                        //int[] select=SelectCollegeAdapter.getSelect();
                        // Toast.makeText(getApplicationContext(), "length" + select.length, Toast.LENGTH_SHORT).show();
                        outputStrAr = new String[position.size()];
                        for (int i = 0; i < position.size(); i++) {
                            outputStrAr[i] = position.get(i);
                        }
                        Log.i("Length : ", String.valueOf(outputStrAr.length));
                        LinkedHashSet<String> lhSetColors =
                                new LinkedHashSet<String>(Arrays.asList(outputStrAr));
                        newArray = lhSetColors.toArray(new String[lhSetColors.size()]);
                        // Toast.makeText(getApplicationContext(), "new length" + newArray.length, Toast.LENGTH_SHORT).show();

                        Log.i("new Array", String.valueOf(newArray));
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("Selected Colleges are...").setItems(newArray, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();

                    } catch (Exception e) {

                    }
                    break;
            }
        }catch (Exception e){

        }
        return true;
    }

    private HashMap<String, Integer> calculateIndexesForName(List<College> c){

        HashMap<String, Integer> mapIndex = new LinkedHashMap<>();
        for (int i = 0; i<c.size(); i++){
            String name = c.get(i).getCollegename();
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
