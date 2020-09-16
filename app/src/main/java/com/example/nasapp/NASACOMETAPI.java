package com.example.nasapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NASACOMETAPI {
    @GET("/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&?")
    public Call<Post> getData(@Query("api_key") String KEY);
}
