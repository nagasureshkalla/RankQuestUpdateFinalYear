package com.example.admin.data.examPgecet.rest;


import com.example.admin.data.examEamcet.model.BranchStatatics;
import com.example.admin.data.examEamcet.model.CasteStatatics;
import com.example.admin.data.examEamcet.model.ReportingCenters;
import com.example.admin.data.examEamcet.model.Statastics;
import com.example.admin.data.examEamcet.model.TotalSeats;
import com.example.admin.data.examPgecet.model.Branches;
import com.example.admin.data.examPgecet.model.College;
import com.example.admin.data.examPgecet.model.CollegeBranchDetails;
import com.example.admin.data.examPgecet.model.CollegeDetails;
import com.example.admin.data.examPgecet.model.CollegeDetalsBranches;
import com.example.admin.data.examPgecet.model.Exam;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

   @GET("collections/branch_analysis/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<Branches>> getBran(@Query("apiKey") String apiKey);

    @GET("collections/branch_analysis/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<Branches>> getBran1(@Query("q") String q);
 @GET("collections/branches/")
 Call<List<CollegeDetails>> getData3(@Query("apiKey") String apiKey);

    @GET("collections/college/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<College>> getCollege(@Query("apiKey") String apiKey);

    @GET("collections/branches/")
    Call<List<CollegeDetalsBranches>> getData4(@Query("apiKey") String apiKey);


    @GET("collections/fullcollegedetails/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeDetails>> getCollegeDetails(@Query("q") String q);

    @GET("collections/rannk_analysis/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeBranchDetails>> getCollegeBranches(@Query("q") String q);

 @GET("collections/COLLEGES/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
 Call<List<CollegeDetails>> getStatatics(@Query("q") String q);


 @GET("collections/rannk_analysis/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
 Call<List<CollegeBranchDetails>> getData1(@Query("q") String q);


 @GET("collections/reportingcentres/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
 Call<List<ReportingCenters>> getCentre(@Query("apiKey") String apiKey);


    @GET("collections/exam/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<Exam>> getExam(@Query("q") String q);



    @GET("collections/rank_analysis_without_branchname/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeBranchDetails>> getData6(@Query("q") String q);

    @GET("collections/college/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<College>> getColleges(@Query("apiKey") String apiKey);

    @GET("collections/branchstatatics/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<BranchStatatics>> getBranchStatics(@Query("q") String q);

    @GET("collections/castestatatics/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CasteStatatics>> getCasteStatics(@Query("q") String q);

    @GET("collections/collegeseats/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<TotalSeats>> getSeats(@Query("q") String q);
}