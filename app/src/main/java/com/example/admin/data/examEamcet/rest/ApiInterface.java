package com.example.admin.data.examEamcet.rest;


import com.example.admin.data.FragmentsExams.EAMCET.Model.Statatics;
import com.example.admin.data.examEamcet.model.BranchStatatics;
import com.example.admin.data.examEamcet.model.Branches;
import com.example.admin.data.examEamcet.model.CasteStatatics;
import com.example.admin.data.examEamcet.model.CollegeBranchDetails;
import com.example.admin.data.examEamcet.model.CollegeDetails;
import com.example.admin.data.examEamcet.model.Data;
import com.example.admin.data.examEamcet.model.College;
import com.example.admin.data.examEamcet.model.ReportingCenters;
import com.example.admin.data.examEamcet.model.Statastics;
import com.example.admin.data.examEamcet.model.TotalSeats;
import com.example.admin.data.examPgecet.model.Exam;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

   @GET("collections/rank_analysis_council1/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeBranchDetails>> getData1(@Query("q") String q);
   @GET("collections/rank_analysis_council2/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
   Call<List<CollegeBranchDetails>> getData2(@Query("q") String q);
   @GET("collections/rank_analysis_council3/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
   Call<List<CollegeBranchDetails>> getData3(@Query("q") String q);


    @GET("collections/rank_analysis1_without_branchname/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeBranchDetails>> getData(@Query("q") String q);
    @GET("collections/rank_analysis2_without_branchname/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeBranchDetails>> getData5(@Query("q") String q);
    @GET("collections/rank_analysis3_without_branchname/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeBranchDetails>> getData6(@Query("q") String q);



    @GET("collections/stateanalysis/")
    Call<List<College>> getCollege(@Query("apiKey") String apikey);

    @GET("collections/branchesdata/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<Branches>> getBran(@Query("apiKey") String apiKey);

    @GET("collections/branchesdata/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<Branches>> getBran1(@Query("q") String q);

    @GET("collections/college_analysis_council1/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeDetails>> getCollegeDetails(@Query("q") String q);


    @GET("collections/fullcollegedetails/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeDetails>> getCollegeDetail(@Query("q") String q);

    @GET("collections/collegedetailBranches/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeDetails>> getCol(@Query("q") String q);

 @GET("collections/branchesdata/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
 Call<List<CollegeDetails>> getCollegeBranch(@Query("apiKey") String apiKey);

    @GET("collections/counselling3/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<Data>> getData4(@Query("q") String q);

    @GET("collections/rank_analysis_council3/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeBranchDetails>> getCollegeBranches(@Query("q") String q);



    @GET("collections/college_analysis_council1/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeDetails>> getDataCollege1(@Query("apiKey") String apiKey);
    @GET("collections/college_analysis_council2/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeDetails>> getDataCollege2(@Query("q") String q);
    @GET("collections/college_analysis_council3/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeDetails>> getDataCollege3(@Query("q") String q);


    //statastics
    @GET("collections/exam/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<Exam>> getExam(@Query("q") String q);

    @GET("collections/castestatatics/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CasteStatatics>> getCasteStatics(@Query("q") String q);
    @GET("collections/branchstatatics/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<BranchStatatics>> getBranchStatics(@Query("q") String q);

    @GET("collections/statatics/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<Statastics>> getStataticsBranchs(@Query("q") String q);

 @GET("collections/reportingcentres/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
 Call<List<ReportingCenters>> getCentre(@Query("apiKey") String apiKey);


    @GET("collections/statatics/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<Statatics>> getStat(@Query("q") String q);

    @GET("collections/collegeseats/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<TotalSeats>> getSeats(@Query("q") String q);

}