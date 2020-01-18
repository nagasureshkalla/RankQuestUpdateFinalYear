package com.example.admin.data.examPgecet.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class CollegeDetalsBranches implements Comparable<CollegeDetalsBranches>{

    @SerializedName("inst_code")
    private String code;
    @SerializedName("inst_name")
    private String name;
    @SerializedName("course_type")
    private String course_type;
    @SerializedName("dist_name")
    private String dist_name;
    @SerializedName("region")
    private String region;
    @SerializedName("branch_code")
    private String branch_code;
    @SerializedName("branch_name")
    private String branch_name;
    @SerializedName("total_seats")
    private String total_seats;

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getTotal_seats() {
        return total_seats;
    }

    public void setTotal_seats(String total_seats) {
        this.total_seats = total_seats;
    }

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

    public String getCourse_type() {
        return course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
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

    public CollegeDetalsBranches(String code, String name, String course_type, String dist_name, String region, String branch_code, String branch_name, String total_seats, String fee, String affil, String codenew, String type, String place, String dist, String coed, String namenew) {
        this.code = code;
        this.name = name;
        this.course_type = course_type;
        this.dist_name = dist_name;
        this.region = region;
        this.branch_code = branch_code;
        this.branch_name = branch_name;
        this.total_seats = total_seats;
        this.fee = fee;
        this.affil = affil;
        this.codenew = codenew;

        this.type = type;
        this.place = place;
        this.dist = dist;
        this.coed = coed;
        this.namenew = namenew;
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

    public String getCodenew() {
        return codenew;
    }

    public void setCodenew(String codenew) {
        this.codenew = codenew;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getCoed() {
        return coed;
    }

    public void setCoed(String coed) {
        this.coed = coed;
    }

    public String getNamenew() {
        return namenew;
    }

    public void setNamenew(String namenew) {
        this.namenew = namenew;
    }

    @SerializedName("fee")
    private String fee;
    @SerializedName("affil")
    private String affil;
    @SerializedName("code")
    private String codenew;
    @SerializedName("type")
    private String type;
    @SerializedName("place")
    private String place;
    @SerializedName("dist")
    private String dist;
    @SerializedName("coed")
    private String coed;
    @SerializedName("name")
    private String namenew;

    @Override
    public int compareTo(@NonNull CollegeDetalsBranches o) {
        return getBranch_name().compareTo(o.getBranch_name());
    }
}
