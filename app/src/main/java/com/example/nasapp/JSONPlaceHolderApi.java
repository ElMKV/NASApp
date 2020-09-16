package com.example.nasapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {
    @GET("/planetary/apod?")
    public Call<Post> getPostWithID(@Query("api_key") String KEY);


}
