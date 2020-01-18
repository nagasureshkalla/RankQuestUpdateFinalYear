package com.example.admin.data.Homepage.rest;

import com.example.admin.data.Homepage.LoginData;
import com.example.admin.data.Homepage.Model.ChecklistModel;
import com.example.admin.data.Homepage.Model.DevelopersModel;
import com.example.admin.data.Homepage.Model.Exam_Name_MainPage;
import com.example.admin.data.Homepage.Model.WebsitesModel;
import com.example.admin.data.Homepage.SurveyData;
import com.example.admin.data.examEamcet.model.BranchStatatics;
import com.example.admin.data.examEamcet.model.CasteStatatics;
import com.example.admin.data.examEamcet.model.ReportingCenters;
import com.example.admin.data.examEcet.model.Branch;
import com.example.admin.data.examEcet.model.CollegeDetails;
import com.example.admin.data.examPgecet.model.CollegeBranchDetails;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterfacePut {
    //feedback
    @POST("collections/posts/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> feedback(@Body String str);
  //register
    @POST("collections/users/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> Registration(@Body String str);
  @GET("collections/users/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
  Call<List<LoginData>> check(@Query("q") String q);

    //login
    @GET("collections/users/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<LoginData>> Login(@Query("q") String q);


    //forget Password
    @GET("sms.php")
    Call<String> getOTP_Login(@Query("username") String un,@Query("password") String pass,@Query("from") String from,@Query("to")String to,@Query("msg") String msg,@Query("type") String type);

    @GET("collections/users/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<LoginData>> getUser(@Query("q") String q);

    //survey
    @POST("collections/survey/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> Survey(@Body String str);
    @GET("collections/survey/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<SurveyData>> getSurveyDetails(@Query("q") String q);


    //delete from database
    @DELETE("collections/survey/?apiKey=VNNk2xmBYia8LLhNcaUAQNckrMlXiLCI")
    Call<List<Void>> getDeleteItems(@Query("q") String q);


// get all exams
  @GET("databases/{dbname}/collections/{col}")
  Call<List<Exam_Name_MainPage>> getExams(@Path("dbname") String dbname,@Path("col")String col,@Query("apiKey") String apiKey);


  @GET("databases/{dbname}/collections/{col}")
  Call<List<Branch>> getExam(@Path("dbname") String dbname,@Path("col") String col, @Query("apiKey") String key);

  @GET("databases/{dbname}/collections/{col}")
  Call<List<CollegeBranchDetails>> getBranch(@Path("dbname") String dbname, @Path("col") String col, @Query("apiKey") String key,@Query("q") String q);

  @GET("databases/{dbname}/collections/{col}")
  Call<List<CollegeDetails>> getCollege(@Path("dbname") String dbname, @Path("col") String col, @Query("apiKey") String key);

  @GET("databases/{dbname}/collections/{col}")
  Call<List<ReportingCenters>> getCenter(@Path("dbname") String dbname, @Path("col") String col, @Query("apiKey") String key);

  @GET("databases/{dbname}/collections/{col}")
  Call<List<CollegeDetails>> getCollegeDetails(@Path("dbname") String dbname, @Path("col") String col, @Query("apiKey") String key,@Query("q") String q);


  @GET("databases/{dbname}/collections/{col}")
  Call<List<CasteStatatics>> getStatastics(@Path("dbname") String dbname, @Path("col") String col, @Query("apiKey") String key,@Query("q") String q);

  @GET("databases/{dbname}/collections/{col}")
  Call<List<BranchStatatics>>getBranchStatastics(@Path("dbname") String dbname, @Path("col") String col, @Query("apiKey") String key, @Query("q") String q);

  @GET("databases/{dbname}/collections/{col}")
  Call<List<ChecklistModel>> getChecklist(@Path("dbname") String dbname, @Path("col") String col, @Query("apiKey") String key);

  @GET("databases/{dbname}/collections/{col}")
  Call<List<DevelopersModel>> getDevelopers(@Path("dbname") String dbname, @Path("col") String col, @Query("apiKey") String key);

  @GET("databases/{dbname}/collections/{col}")
  Call<List<WebsitesModel>> getWebsites(@Path("dbname") String dbname, @Path("col") String col, @Query("apiKey") String key);

}
