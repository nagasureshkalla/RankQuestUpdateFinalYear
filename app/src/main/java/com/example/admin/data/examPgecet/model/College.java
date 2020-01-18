package com.example.admin.data.examPgecet.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class College implements Comparable<College>{

    @SerializedName("inst_name")
    private String collegename;
    @SerializedName("inst_code")
    private  String code;
    @SerializedName("dist_name")
    private String dist_name;
    @SerializedName("region")
    private String region;

    private boolean checked;
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public College(String collegename, String code, String dist_name, String region) {
        this.collegename = collegename;
        this.code = code;
        this.dist_name = dist_name;
        this.region = region;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDist_name() {
        return dist_name;
    }

    public void setDist_name(String dist_name) {
        this.dist_name = dist_name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public int compareTo(@NonNull College o) {
        return getCollegename().compareTo(o.getCollegename());
    }
}
