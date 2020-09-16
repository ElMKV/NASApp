package com.example.nasapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comet {

    @SerializedName("links")
    @Expose
    private String links;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("neo_reference_id")
    @Expose
    private String neoReferenceId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nasa_jpl_url")
    @Expose
    private String nasaJplUrl;
    @SerializedName("absolute_magnitude_h")
    @Expose
    private Double absoluteMagnitudeH;
    @SerializedName("estimated_diameter")
    @Expose
    private float estimatedDiameter;
    @SerializedName("is_potentially_hazardous_asteroid")

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNeoReferenceId() {
        return neoReferenceId;
    }

    public void setNeoReferenceId(String neoReferenceId) {
        this.neoReferenceId = neoReferenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public void setNasaJplUrl(String nasaJplUrl) {
        this.nasaJplUrl = nasaJplUrl;
    }

    public Double getAbsoluteMagnitudeH() {
        return absoluteMagnitudeH;
    }

    public void setAbsoluteMagnitudeH(Double absoluteMagnitudeH) {
        this.absoluteMagnitudeH = absoluteMagnitudeH;
    }

    public float getEstimatedDiameter() {
        return estimatedDiameter;
    }

    public void setEstimatedDiameter(float estimatedDiameter) {
        this.estimatedDiameter = estimatedDiameter;
    }


}

