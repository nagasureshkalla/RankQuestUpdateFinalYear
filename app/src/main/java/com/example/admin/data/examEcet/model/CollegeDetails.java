package com.example.admin.data.examEcet.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class CollegeDetails implements Comparable<CollegeDetails> {

    @SerializedName("institute_code")
    private String code;
    @SerializedName("institute_name")
    private String name;
    @SerializedName("place")
    private String place;
    @SerializedName("dist_name")
    private String dist;
    @SerializedName("region")
    private String region;
    @SerializedName("college")
    private String type;
    @SerializedName("minority")
    private String minority;
    @SerializedName("coed")
    private String coed;
    @SerializedName("affil")
    private String afflicted;
    @SerializedName("fee")
    private String fee;
    @SerializedName("branch")
    private String branch;


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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMinority() {
        return minority;
    }

    public void setMinority(String minority) {
        this.minority = minority;
    }

    public String getCoed() {
        return coed;
    }

    public void setCoed(String coed) {
        this.coed = coed;
    }

    public String getAfflicted() {
        return afflicted;
    }

    public void setAfflicted(String afflicted) {
        this.afflicted = afflicted;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public CollegeDetails(String code, String name, String place, String dist, String region, String type, String minority, String coed, String afflicted, String fee, String branch) {
        this.code = code;
        this.name = name;
        this.place = place;
        this.dist = dist;
        this.region = region;
        this.type = type;
        this.minority = minority;
        this.coed = coed;
        this.afflicted = afflicted;
        this.fee = fee;
        this.branch = branch;
    }

    @Override
    public int compareTo(@NonNull CollegeDetails o) {
        return getName().compareTo(o.getName());
    }
}
