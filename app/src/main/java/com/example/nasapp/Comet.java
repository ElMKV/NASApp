package com.example.nasapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Comet {


    @SerializedName("near_earth_objects")
    @Expose
    private List<NearEarthObject> nearEarthObjects = new ArrayList<>();

    public List<NearEarthObject> getNearEarthObjects() {
        return nearEarthObjects;
    }

    public void setNearEarthObjects(List<NearEarthObject> nearEarthObjects) {
        this.nearEarthObjects = nearEarthObjects;
    }
}
