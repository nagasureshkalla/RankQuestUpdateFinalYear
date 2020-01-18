package com.example.admin.data.examPolycet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.admin.data.R;
import com.example.admin.data.examEamcet.model.BranchStatatics;
import com.example.admin.data.examEamcet.model.TotalSeats;
import com.example.admin.data.examPolycet.rest.ApiClient;
import com.example.admin.data.examPolycet.rest.ApiInterface;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Polycet_Statastics_Graphs extends AppCompatActivity {
    List<BranchStatatics> list;
    List<TotalSeats> list1;
    Call<List<TotalSeats>> call1;
    String pi="Pie";
    Description description1=new Description();
    Description description2=new Description();
    Description description3=new Description();
    int m=0,f=0;
    Call<List<BranchStatatics>> call;
    TextView t,total;
    String code;
    ApiInterface apiService,apiService1;
    int[] color= new int[]{Color.rgb(255,165,0), Color.RED};
    int[] color1= new int[]{ Color.rgb(255,69,0),Color.rgb(255,165,0)};
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polycet__statastics__graphs);

        description1.setTextSize(8);
        description2.setTextSize(8);
        description3.setTextSize(8);

        total=findViewById(R.id.totalseats);

        Bundle bundle = getIntent().getExtras();
        int m = bundle.getInt("male");
        int f = bundle.getInt("female");
        String exam=bundle.getString("exam");
        String name=bundle.getString("name");
        code=bundle.getString("code");
        int oc=bundle.getInt("oc");
        int bca=bundle.getInt("bca");
        int bcb=bundle.getInt("bcb");
        int bcc=bundle.getInt("bcc");
        int bcd=bundle.getInt("bcd");
        int bce=bundle.getInt("bce");
        int sc=bundle.getInt("sc");
        int st=bundle.getInt("st");

        try {
            apiService = ApiClient.getClient().create(ApiInterface.class);
            String q = "{code:'" + code + "'}";
            call = apiService.getBranchStatics(q);
            call.enqueue(new Callback<List<BranchStatatics>>() {
                @Override
                public void onResponse(Call<List<BranchStatatics>> call, Response<List<BranchStatatics>> response) {

                    list = response.body();

                    Log.i("List ", String.valueOf(list));
                    Drawbar();
                    TotalSeats();
                    //recyclerView.setAdapter(new Adapter(list, R.layout.list_item_movie, getApplicationContext()));
                    // Toast.makeText(MainActivity.this, "Succesfully Loaded", Toast.LENGTH_SHORT).show();


                }

                @Override
                public void onFailure(Call<List<BranchStatatics>> call, Throwable t) {
                    // Toast.makeText(MainActivity.this, "Failed to Load data", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }







        pie(oc,bca,bcb,bcc,bcd,bce,sc,st);

        t=findViewById(R.id.statCollegeName);
        t.setText(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    void Drawbar(){

        ArrayList<BarEntry> bargroup1 = new ArrayList<>();
        ArrayList<BarEntry> bargroup2 = new ArrayList<>();
        final ArrayList<String> labels = new ArrayList<>();

        int j=0;

        for (int i=0;i<list.size();i++){
            bargroup1.add(new BarEntry(j,list.get(i).getFemale()));
            bargroup2.add(new BarEntry(j+1,list.get(i).getMale()));
            m=m+list.get(i).getMale();
            f=f+list.get(i).getFemale();
            labels.add(list.get(i).getBranch());
            labels.add(list.get(i).getBranch());
            j=j+2;
        }


        BarDataSet barDataSet1 = new BarDataSet(bargroup1, "Female");
        barDataSet1.setColors(color[0]);
        BarDataSet barDataSet2 = new BarDataSet(bargroup2, "Male");
        barDataSet2.setColors(color[1]);

        ArrayList<IBarDataSet> dataSets1 = new ArrayList<IBarDataSet>();
        dataSets1.add(barDataSet1);
        dataSets1.add(barDataSet2);

        BarData data = new BarData(dataSets1);




        BarChart chart = (BarChart) findViewById(R.id.branchbarchart);


        chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
        chart.setLabelFor(0);
        chart.setData(data);
        chart.setMinimumWidth(5);
        description3.setText(" ");
        chart.setDescription(description3);
        chart.setDrawBarShadow(true);
        chart.setFitBars(false);
        chart.getLabelFor();
        chart.setHorizontalScrollBarEnabled(true);
        chart.setVerticalScrollBarEnabled(true);
        chart.animateXY(2000, 2000);

        chart.invalidate();

        statastics(m,f);
    }

    public  void pie(int oc,int bca,int bcb,int bcc,int bcd,int bce,int sc,int st){
        List<PieEntry> yvalues = new ArrayList<PieEntry>();
        yvalues.add(new PieEntry(oc, "OC"));
        yvalues.add(new PieEntry(bca, "BC_A"));
        yvalues.add(new PieEntry(bcb, "BC_B"));
        yvalues.add(new PieEntry(bcc, "BC_C"));
        yvalues.add(new PieEntry(bcd, "BC_D"));
        yvalues.add(new PieEntry(bce, "BC_E"));
        yvalues.add(new PieEntry(sc, "SC"));
        yvalues.add(new PieEntry(st, "ST"));

        PieDataSet dataSet = new PieDataSet(yvalues,"");
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData(dataSet);

        PieChart pieChart = (PieChart) findViewById(R.id.pieChart);
        data.setValueFormatter(new PercentFormatter(pieChart));
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        pieChart.setUsePercentValues(true);
        Log.i("Percent ", String.valueOf(pieChart.isUsePercentValuesEnabled()));
        pieChart.setData(data);
        pieChart.setEntryLabelColor(Color.BLACK);
        description2.setText(" ");
        pieChart.setDescription(description2);
        pieChart.animateX(2000);
        pieChart.setHighlightPerTapEnabled(true);
        pieChart.invalidate();
    }


    void statastics(int m,int f){
        // Toast.makeText(getApplicationContext(), m+" "+f, Toast.LENGTH_SHORT).show();

        if (m==0&&f==0){
            AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
            AlertDialog alert = alertDialog.create();
            alert.setMessage("No Student Joined in this College");
            alert.setCancelable(true);
            alert.show();
        }
        BarChart barChart = (BarChart) findViewById(R.id.barchart);

        // create BarEntry for Bar Group 1
        ArrayList<BarEntry> bargroup1 = new ArrayList<>();
        bargroup1.size();
        bargroup1.add(new BarEntry(0,m));
        bargroup1.add(new BarEntry(1,f));


// creating dataset for Bar Group1
        BarDataSet barDataSet1 = new BarDataSet(bargroup1, "Boys\t\tGirls");

//barDataSet1.setColor(Color.rgb(0, 155, 0));
        barDataSet1.setColors(color1);

        barDataSet1.setValueTextSize(15);

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Number of Boys Joined");
        labels.add("Number of Girls Joined");

        ArrayList<BarDataSet> dataSets = new ArrayList<>();  // combined all dataset into an arraylist
        dataSets.add(barDataSet1);

// initialize the Bardata with argument labels and dataSet
        BarData data = new BarData(barDataSet1);
        data.setValueFormatter(new MyValueFormatter());
        barChart.setData(data);

        // barChart.getXAxis().setAxisMinValue(0);
        barChart.setTouchEnabled(false);
        barChart.setMinimumWidth(30);

        description1.setText(" ");
        barChart.setDescription(description1);

        // barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
        barChart.setFitBars(true);
        barChart.animateXY(2000,2000);
        barChart.invalidate();

    }
    public class MyValueFormatter extends ValueFormatter implements IValueFormatter {

        private DecimalFormat mFormat;

        public MyValueFormatter() {
            mFormat = new DecimalFormat("###,###,0"); // use one decimal
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            // write your logic here
            return mFormat.format(value) + " $"; // e.g. append a dollar-sign
        }
    }
    public class PercentFormatter extends ValueFormatter
    {

        public DecimalFormat mFormat;
        private PieChart pieChart;

        public PercentFormatter() {
            mFormat = new DecimalFormat("###,###,##0.0");
        }

        // Can be used to remove percent signs if the chart isn't in percent mode
        public PercentFormatter(PieChart pieChart) {
            this();
            this.pieChart = pieChart;
        }

        @Override
        public String getFormattedValue(float value) {
            return mFormat.format(value) + " %";
        }

        @Override
        public String getPieLabel(float value, PieEntry pieEntry) {
            if (pieChart != null && pieChart.isUsePercentValuesEnabled()) {
                // Converted to percent
                return getFormattedValue(value);
            } else {
                // raw value, skip percent sign
                return mFormat.format(value);
            }
        }

    }
    void TotalSeats(){
        try {
            apiService1 = ApiClient.getClient().create(ApiInterface.class);
            String q = "{code:'" + code + "'}";
            call1 = apiService1.getSeats(q);

            call1.enqueue(new Callback<List<TotalSeats>>() {
                @Override
                public void onResponse(Call<List<TotalSeats>> call, Response<List<TotalSeats>> response) {
                    list1 = response.body();

                    int y=m+f;
                    total.setText("Total Seats Filled is : " + y + "/" + list1.get(0).getTotalseats());
                }

                @Override
                public void onFailure(Call<List<TotalSeats>> call, Throwable t) {

                }
            });
        }
        catch (Exception e){

        }
    }
}
