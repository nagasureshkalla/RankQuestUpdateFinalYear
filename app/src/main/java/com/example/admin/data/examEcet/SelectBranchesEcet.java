package com.example.admin.data.examEcet;

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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.data.FastScroll.FastScrollRecyclerViewItemDecoration;
import com.example.admin.data.R;
import com.example.admin.data.examEcet.adapter.SelectBranchAdapter;
import com.example.admin.data.examEcet.rest.ApiClient;
import com.example.admin.data.examEcet.rest.ApiInterface;
import com.example.admin.data.examEcet.model.Branch;

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

public class SelectBranchesEcet extends AppCompatActivity {
    private final static String API_KEY = "VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI";
    List<Branch> list;
    Call<List<Branch>> call;
    List<String> selectedColleges=null;
    String[] outputStrAr=null,select;
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_branches_ecet);

        ok=(Button)findViewById(R.id.ok);
        getData();

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> position=SelectBranchAdapter.getPosition();
                if (position.size()>6){
                    Toast.makeText(getApplicationContext(), R.string.selectBranches, Toast.LENGTH_SHORT).show();
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
                    b.putStringArray("selectedItems", newArray);
                    intent.putExtras(b);
                    setResult(1, intent);
                    finish();
                }
            }
        });
    }
    void getData(){

        try {
            AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
            AlertDialog alert = alertDialog.create();
            alert.show();
            alert.setCancelable(false);
            alert.setContentView(R.layout.loadingdialog);

            selectedColleges = new ArrayList<>();
            final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleselectbranches);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(this, R.anim.layout_leftto_right);
            call = apiService.getData(API_KEY);
            call.enqueue(new Callback<List<Branch>>() {
                @Override
                public void onResponse(Call<List<Branch>> call, Response<List<Branch>> response) {

                    List<Branch> list = response.body();
                    alert.dismiss();

                    Collections.sort(list);
                    //HashMap<String, Integer> mapIndex = calculateIndexesForName(colg);
                    for (int i=0;i<list.size();i++){
                        list.get(i).setPosition(i);
                    }
                    HashMap<String, Integer> map = calculateIndexesForName(list);
                    SelectBranchAdapter adapter = new SelectBranchAdapter(list,map, R.layout.recyclereportingcenters, new SelectBranchAdapter.OnItemClick() {
                        @Override
                        public void onItem(Branch item) {
                            Toast.makeText(getApplicationContext(), "Branch Selected  :" + item.getBranch(), Toast.LENGTH_SHORT).show();
                            selectedColleges.add(item.getBranch());

                        }
                    }, getApplicationContext());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutAnimation(controller);
                    adapter.notifyDataSetChanged();
                    recyclerView.scheduleLayoutAnimation();
                    // Toast.makeText(MainActivity.this, "Succesfully Loaded", Toast.LENGTH_SHORT).show();
                    FastScrollRecyclerViewItemDecoration decoration = new FastScrollRecyclerViewItemDecoration(getApplicationContext());
                    recyclerView.addItemDecoration(decoration);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                }

                @Override
                public void onFailure(Call<List<Branch>> call, Throwable t) {
                    alert.dismiss();
                    Snackbar snackbar = Snackbar
                            .make(findViewById(R.id.ll), "No Network", Snackbar.LENGTH_INDEFINITE).setAction("Retry", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    getData();
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
        }
        catch (Exception e){
            getData();
        }
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
                    List<String> position = SelectBranchAdapter.getBranches();
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
                    builder.setTitle("Selected Branches are...").setItems(newArray, new DialogInterface.OnClickListener() {
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
    private HashMap<String, Integer> calculateIndexesForName(List<Branch> c){

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

//    @Override
//    public boolean onSupportNavigateUp() {
//        //super.onBackPressed();
//        try {
//            List<String> position = SelectBranchAdapter.getPosition();
//            if (position.size()>6){
//                Toast.makeText(getApplicationContext(), "Select Lessthan 7 Branches", Toast.LENGTH_SHORT).show();
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
//                Intent intent = new Intent();
//                Bundle b = new Bundle();
//                b.putStringArray("selectedItems", newArray);
//                intent.putExtras(b);
//                setResult(1, intent);
//                finish();
//            }
//        }
//        catch (Exception e){
//
//        }
//        return  true;
//    }
}
