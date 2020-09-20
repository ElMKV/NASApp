package com.example.nasapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NearEarthObject {


    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("absolute_magnitude_h")
    @Expose
    private String absolute_magnitude_h;

    @SerializedName("is_sentry_object")
    @Expose
    private Boolean is_sentry_object;

    public Boolean getIs_sentry_object() {
        return is_sentry_object;
    }

    public void setIs_sentry_object(Boolean is_sentry_object) {
        this.is_sentry_object = is_sentry_object;
    }



    public String getAbsolute_magnitude_h() {
        return absolute_magnitude_h;
    }

    public void setAbsolute_magnitude_h(String absolute_magnitude_h) {
        this.absolute_magnitude_h = absolute_magnitude_h;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
