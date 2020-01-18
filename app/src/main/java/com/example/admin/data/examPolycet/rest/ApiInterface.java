package com.example.admin.data.examPolycet.rest;

import com.example.admin.data.examEamcet.model.BranchStatatics;
import com.example.admin.data.examEamcet.model.CasteStatatics;
import com.example.admin.data.examEamcet.model.ReportingCenters;
import com.example.admin.data.examEamcet.model.Statastics;
import com.example.admin.data.examEamcet.model.TotalSeats;
import com.example.admin.data.examPgecet.model.Exam;
import com.example.admin.data.examPolycet.model.Branch;
import com.example.admin.data.examPolycet.model.College;
import com.example.admin.data.examPolycet.model.CollegeBranchDetails;
import com.example.admin.data.examPolycet.model.SeatsBranches;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("collections/detailscolleges/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<College>> getCollege(@Query("apiKey") String apiKey);

    @GET("collections/fullcollegedetails/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<College>> getColleg(@Query("q") String q);

    @GET("collections/branch_analysis/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<Branch>> getData(@Query("apiKey") String apiKey);

    @GET("collections/detailscolleges/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<College>> getColleges(@Query("q") String q);

    @GET("collections/seatsconveybranches/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<SeatsBranches>> getDataSeats(@Query("q") String q);

    @GET("collections/poly_rank_analysis_councli1/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeBranchDetails>> getCollegeBranches(@Query("q") String q);

    @GET("collections/statastics/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<Statastics>> getStatatics(@Query("apiKey") String apiKey);

    @GET("collections/poly_rank_analysis_councli1/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeBranchDetails>> getData1(@Query("q") String q);
    @GET("collections/polyRank_analysis_council2/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeBranchDetails>> getData2(@Query("q") String q);

    @GET("collections/reportingcenters/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<ReportingCenters>> getCentre(@Query("apiKey") String apiKey);

    @GET("collections/exam/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<Exam>> getExam(@Query("q") String q);



    @GET("collections/polycet_rank_analysis1_without_branchname/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeBranchDetails>> getData5(@Query("q") String q);
    @GET("collections/polycet_rank_analysis2_without_branchname/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CollegeBranchDetails>> getData6(@Query("q") String q);



    @GET("collections/detailscolleges/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<College>> getColleges1(@Query("apiKey") String apiKey);
    @GET("collections/branchstatatics/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<BranchStatatics>> getBranchStatics(@Query("q") String q);

    @GET("collections/castestatatics/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<CasteStatatics>> getCasteStatics(@Query("q") String q);

    @GET("collections/collegeseats/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<TotalSeats>> getSeats(@Query("q") String q);
}