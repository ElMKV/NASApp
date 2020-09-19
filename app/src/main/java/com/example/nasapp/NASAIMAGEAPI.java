package com.example.nasapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NASAIMAGEAPI {
    @GET("/planetary/apod?")
    public Call<Post> getPostWithID(@Query("api_key") String KEY);

    @GET("/neo/rest/v1/neo/browse?")
    public Call<JSONResponse> getJSON(@Query("api_key") String KEY);

}
