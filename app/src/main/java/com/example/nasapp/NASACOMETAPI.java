package com.example.nasapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static android.provider.Contacts.SettingsColumns.KEY;

public interface NASACOMETAPI {
    @GET("/neo/rest/v1/neo/browse?")
    public Call<Comet>getData(@Query("api_key") String KEY);
}
