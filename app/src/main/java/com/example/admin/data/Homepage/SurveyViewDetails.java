package com.example.admin.data.Homepage;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;

import com.example.admin.data.Homepage.rest.ApiClient;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.data.Homepage.adapter.SurveyAdapter;
import com.example.admin.data.Homepage.rest.ApiInterfacePut;
import com.example.admin.data.Homepage.rest.ClientGetSurvey;
import com.example.admin.data.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurveyViewDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    AlertDialog.Builder builder;
    EditText t;
    Spinner s;
    String branchselected;
    Call<List<SurveyData>> call;
    SurveyAdapter adapter;
    List<SurveyData> list,copylist;
     String[] c;
    List<String> coucillist;

    String username;
    @Override
    public boolean onSupportNavigateUp(){
      //  getDeleted();

        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_view_details);

        t=(EditText)findViewById(R.id.searchviewdetails) ;
        s=(Spinner)findViewById(R.id.spinnerviewdetails);
        t.setVisibility(View.INVISIBLE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        coucillist = new ArrayList<String>();
        coucillist.add("EAMCET");
        coucillist.add("POLYCET");
        coucillist.add("ECET");
        //coucillist.add("ICET");
        coucillist.add("PGCET");
        branchselected=coucillist.get(0);
        //Toast.makeText(this, "Branchselected  :"+branchselected, Toast.LENGTH_SHORT).show();
        ArrayAdapter<String> counada = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, coucillist);
        counada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(counada);
        s.setOnItemSelectedListener(this);

        SharedPreferences details = getSharedPreferences("login", MODE_PRIVATE);  //Activity1.class
        username = details.getString("username", "");
    }

    void start(String branchselected){

        try {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Loading...");
            AlertDialog alert = alertDialog.create();
            alert.show();
            alert.setCancelable(true);
            String q = "{exam:'" + branchselected + "'}";
            final RecyclerView recycle = (RecyclerView) findViewById(R.id.recycleviewdetails);
            recycle.setLayoutManager(new LinearLayoutManager(this));

            ApiInterfacePut apiService = ClientGetSurvey.getClient().create(ApiInterfacePut.class);
            call = apiService.getSurveyDetails(q);
            call.enqueue(new Callback<List<SurveyData>>() {
                @Override
                public void onResponse(Call<List<SurveyData>> call, Response<List<SurveyData>> response) {
                    list = response.body();

                    alert.dismiss();
                    t.setVisibility(View.VISIBLE);

                    for (int i=0;i<list.size();i++){
                        list.get(i).setPosition(i);
                    }
                    copylist=list;
                    adapter = new SurveyAdapter(list, R.layout.survey_recycle, getApplicationContext());
                    recycle.setAdapter(adapter);


                }

                @Override
                public void onFailure(Call<List<SurveyData>> call, Throwable t) {
                    alert.dismiss();
                    Snackbar snackbar = Snackbar
                            .make(findViewById(R.id.ll), "No Network", Snackbar.LENGTH_INDEFINITE).setAction("Retry", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    start(branchselected);
                                }
                            });
                    View snackbarView = snackbar.getView();
                    snackbarView.setMinimumHeight(25);
                    snackbarView.setBackgroundResource(R.color.orange);
                    TextView textView = snackbarView.findViewById(R.id.snackbar_action);
                    textView.setTextColor(Color.BLACK);
                    TextView textView1 = snackbarView.findViewById(R.id.snackbar_text);
                    textView1.setTextSize(25);
                    textView.setTextSize(15);
                    snackbar.show();
                }
            });
            setupsearch();
        }
        catch (Exception e){

        }
    }
    public void getDeleted(){

        try {
            List<Integer> deletedPositions = new ArrayList<>();
            String e = "{$or:[";
            deletedPositions = SurveyAdapter.getDeletedItems();
            for (int i = 0; i < deletedPositions.size(); i++) {
                Log.i("Position: ", deletedPositions.get(i).toString());

                if (i == deletedPositions.size() - 1) {
                    e = e + "{username:'" + username + "',name:'" + copylist.get(deletedPositions.get(i)).getName() + "',phone:'" + copylist.get(deletedPositions.get(i)).getPhone() + "',exam:'"+branchselected+"'}]}";
                } else {
                    e = e + "{username:'" + username + "',name:'" + copylist.get(deletedPositions.get(i)).getName() + "',phone:'" + copylist.get(deletedPositions.get(i)).getPhone() + "',exam:'"+branchselected+"'},";
                }
            }


            ApiInterfacePut apiInterfacePut= ApiClient.getClient().create(ApiInterfacePut.class);
            Call<List<Void>> call = apiInterfacePut.getDeleteItems(e);

            call.enqueue(new Callback<List<Void>>() {
                @Override
                public void onResponse(Call<List<Void>> call, Response<List<Void>> response) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<List<Void>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Not done", Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch (Exception e){

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
        List<SurveyData> filterdNames =new ArrayList<>();

        //looping through existing elements
        for (SurveyData s : list) {
            //if the existing elements contains the search input
            if (s.getName().contains(text.toUpperCase())||s.getName().contains(text.toLowerCase())||s.getCollege().contains(text.toLowerCase())||s.getCollege().contains(text.toUpperCase())||s.getIntermarks().contains(text.toUpperCase())||s.getIntermarks().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }
        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(filterdNames);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        branchselected=parent.getItemAtPosition(position).toString();

        //Toast.makeText(Eamcet_Cutoff_Result.this, "Swipe Down to Refresh", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                start(branchselected);
            }
        },2000);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
