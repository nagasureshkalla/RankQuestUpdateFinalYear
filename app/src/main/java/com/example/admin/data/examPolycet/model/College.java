package com.example.admin.data.examPolycet.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class College implements Comparable<College>{

    @SerializedName("code")
    private String code;
    @SerializedName("name")
    private String name;
    @SerializedName("place")
    private String place;
    @SerializedName("dist")
    private String dist;
    @SerializedName("type")
    private String type;
    @SerializedName("region")
    private  String region;
    @SerializedName("coed")
    private  String coed;

    @SerializedName("branch")
    private String branch;
    @SerializedName("fee")
    private String fee;
    @SerializedName("affil")
    private String affil;
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
    public College(String code, String name, String place, String dist, String type, String region, String coed, String branch, String fee, String affil) {
        this.code = code;
        this.name = name;
        this.place = place;
        this.dist = dist;
        this.type = type;
        this.region = region;
        this.coed = coed;
        this.branch = branch;
        this.fee = fee;
        this.affil = affil;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCoed() {
        return coed;
    }

    public void setCoed(String coed) {
        this.coed = coed;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getAffil() {
        return affil;
    }

    public void setAffil(String affil) {
        this.affil = affil;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public int compareTo(@NonNull College o) {
        return getName().compareTo(o.getName());
    }
}
