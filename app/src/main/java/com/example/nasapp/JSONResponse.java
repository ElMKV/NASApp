package com.example.nasapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONResponse {
    @SerializedName("near_earth_objects")
    @Expose
    private NearNarthObjects[] NearNarthObjects;



    public NearNarthObjects[] getNearNarthObjects() {
        return NearNarthObjects;
    }
}
