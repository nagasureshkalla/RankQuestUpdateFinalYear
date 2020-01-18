package com.example.admin.data.Homepage.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Register_Client {

    private static Retrofit retrofit = null;
    private static String url2="https://api.mlab.com/api/1/databases/naga/";

    public static Retrofit getService(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(url2)
                    .addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
