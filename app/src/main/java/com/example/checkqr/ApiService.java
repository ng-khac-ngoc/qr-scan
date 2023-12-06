package com.example.checkqr;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    //Link API: http://localhost:7777/api/urlRepost
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://2538-14-232-123-15.ngrok-free.app/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @POST("api/urlScan")
    Call<QrResponse> sendRequest(@Body QrRequest qrRequest);

    @POST("api/urlRepost")
    Call<ReportResponse> sendPosts(@Body ReportRequest reportRequest);
}
