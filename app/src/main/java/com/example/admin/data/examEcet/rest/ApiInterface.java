package com.example.admin.data.examEcet.rest;

import com.example.admin.data.examEamcet.model.BranchStatatics;
import com.example.admin.data.examEamcet.model.CasteStatatics;
import com.example.admin.data.examEamcet.model.ReportingCenters;
import com.example.admin.data.examEamcet.model.Statastics;
import com.example.admin.data.examEamcet.model.TotalSeats;
import com.example.admin.data.examEcet.model.Branch;
import com.example.admin.data.examEcet.model.CollegeDetails;
import com.example.admin.data.examPgecet.model.CollegeBranchDetails;
import com.example.admin.data.examPgecet.model.Exam;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {




    @GET("collections/branch_analysis/")
    Call<List<Branch>> getData(@Query("apiKey") String apiKey);

    @GET("collections/branch_analysis/")
    Call<List<CollegeDetails>> getDataBranch(@Query("apiKey") String apiKey);


    @GET("collections/collegesNoduplicates/")
    Call<List<CollegeDetails>> getCollege(@Query("apiKey") String apiKey);

    @GET("collections/collegesNoduplicates/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeDetails>> getCollegeDetails(@Query("q") String q);

    @GET("collections/ecetRank_analysis_council2/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeBranchDetails>> getData2(@Query("q") String q);
    @GET("collections/ecetRank_analysis_council1/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeBranchDetails>> getData1(@Query("q") String q);

    @GET("collections/reportingcentres/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<ReportingCenters>> getCentre(@Query("apiKey") String apiKey);



    @GET("collections/Colleges_Ecet/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeDetails>> getColleg(@Query("apiKey") String apiKey);

    @GET("collections/exam/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<Exam>> getExam(@Query("q") String q);


    @GET("collections/ecetRank_analysis_without_branchname/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeBranchDetails>> getData5(@Query("q") String q);
    @GET("collections/ecetRank_analysis2_without_branchname/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeBranchDetails>> getData6(@Query("q") String q);

    @GET("collections/branchstatatics/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<BranchStatatics>> getBranchStatics(@Query("q") String q);

    @GET("collections/castestatatics/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CasteStatatics>> getCasteStatics(@Query("q") String q);

    @GET("collections/collegeseats/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<TotalSeats>> getSeats(@Query("q") String q);
}