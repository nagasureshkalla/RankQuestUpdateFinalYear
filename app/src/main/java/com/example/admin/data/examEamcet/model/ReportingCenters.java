package com.example.admin.data.examEamcet.model;

import com.google.gson.annotations.SerializedName;

public class ReportingCenters {

    @SerializedName("centres")
    private String center;
    @SerializedName("place")
    private String place;

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public ReportingCenters(String center, String place) {
        this.center = center;
        this.place = place;
    }
}
