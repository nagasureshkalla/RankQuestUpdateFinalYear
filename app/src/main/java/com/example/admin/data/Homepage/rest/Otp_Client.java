package com.example.admin.data.Homepage.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Otp_Client {

    private static Retrofit retrofit = null;
    private static String url1 = "https://www.smsstriker.com/API/";
    public static Retrofit getOtp() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url1)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
