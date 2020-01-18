package com.example.admin.data.examEamcet.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class CollegeDetails implements Comparable<CollegeDetails> {

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    @SerializedName("collegeCode")
    private String college_code;
    @SerializedName("distName")
    private String distName;
    @SerializedName("tuitionFee")
    private String tuition_Fee;
    @SerializedName("coEducation")
    private String coEducation;
    @SerializedName("noofseatsAvaliable")
    private String no_of_seats_Avaliable;
    @SerializedName("noofseatsfilled")
    private String no_of_seats_filled;
    @SerializedName("branch")
    private String branch;
    @SerializedName("bestRank")
    private String best_Rank_is;
    @SerializedName("lastRank")
    private String last_Rank_is;
    @SerializedName("meanRank")
    private String mean_Rank;
    @SerializedName("medianRank")
    private String median_Rank;
    @SerializedName("oC_Students")
    private String oC_Students;
    @SerializedName("bC_A_Students")
    private String bC_A_Students;
    @SerializedName("bC_B_Students")
    private String bC_B_Students;
    @SerializedName("bC_C_Students")
    private String bC_C_Students;
    @SerializedName("bC_D_Students")
    private String bC_D_Students;
    @SerializedName("bC_E _Students")
    private String bC_E_Students;
    @SerializedName("sC_Students")
    private String sC_Students;
    @SerializedName("sT_Students")
    private String sT_Students;
    @SerializedName("oU_Region")
    private String oU_Region;
    @SerializedName("sVU_Region")
    private String sVU_Region;
    @SerializedName("aU_Region")
    private String aU_Region;



@SerializedName("fee")
private String fee;
@SerializedName("affil")
private String affil;
@SerializedName("code")
private String code;
@SerializedName("region")
private String region;
@SerializedName("type")
private String type;
@SerializedName("place")
private String place;
@SerializedName("dist")
private String dist;
@SerializedName("coed")
private String coed;
@SerializedName("name")
private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege_code() {
        return college_code;
    }

    public void setCollege_code(String college_code) {
        this.college_code = college_code;
    }

    public String getDistName() {
        return distName;
    }

    public void setDistName(String distName) {
        this.distName = distName;
    }

    public String getTuition_Fee() {
        return tuition_Fee;
    }

    public void setTuition_Fee(String tuition_Fee) {
        this.tuition_Fee = tuition_Fee;
    }

    public String getCoEducation() {
        return coEducation;
    }

    public void setCoEducation(String coEducation) {
        this.coEducation = coEducation;
    }

    public String getNo_of_seats_Avaliable() {
        return no_of_seats_Avaliable;
    }

    public void setNo_of_seats_Avaliable(String no_of_seats_Avaliable) {
        this.no_of_seats_Avaliable = no_of_seats_Avaliable;
    }

    public String getNo_of_seats_filled() {
        return no_of_seats_filled;
    }

    public void setNo_of_seats_filled(String no_of_seats_filled) {
        this.no_of_seats_filled = no_of_seats_filled;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBest_Rank_is() {
        return best_Rank_is;
    }

    public void setBest_Rank_is(String best_Rank_is) {
        this.best_Rank_is = best_Rank_is;
    }

    public String getLast_Rank_is() {
        return last_Rank_is;
    }

    public void setLast_Rank_is(String last_Rank_is) {
        this.last_Rank_is = last_Rank_is;
    }

    public String getMean_Rank() {
        return mean_Rank;
    }

    public void setMean_Rank(String mean_Rank) {
        this.mean_Rank = mean_Rank;
    }

    public String getMedian_Rank() {
        return median_Rank;
    }

    public void setMedian_Rank(String median_Rank) {
        this.median_Rank = median_Rank;
    }

    public String getoC_Students() {
        return oC_Students;
    }

    public void setoC_Students(String oC_Students) {
        this.oC_Students = oC_Students;
    }

    public String getbC_A_Students() {
        return bC_A_Students;
    }

    public void setbC_A_Students(String bC_A_Students) {
        this.bC_A_Students = bC_A_Students;
    }

    public String getbC_B_Students() {
        return bC_B_Students;
    }

    public void setbC_B_Students(String bC_B_Students) {
        this.bC_B_Students = bC_B_Students;
    }

    public String getbC_C_Students() {
        return bC_C_Students;
    }

    public void setbC_C_Students(String bC_C_Students) {
        this.bC_C_Students = bC_C_Students;
    }

    public String getbC_D_Students() {
        return bC_D_Students;
    }

    public void setbC_D_Students(String bC_D_Students) {
        this.bC_D_Students = bC_D_Students;
    }

    public String getbC_E_Students() {
        return bC_E_Students;
    }

    public void setbC_E_Students(String bC_E_Students) {
        this.bC_E_Students = bC_E_Students;
    }

    public String getsC_Students() {
        return sC_Students;
    }

    public void setsC_Students(String sC_Students) {
        this.sC_Students = sC_Students;
    }

    public String getsT_Students() {
        return sT_Students;
    }

    public void setsT_Students(String sT_Students) {
        this.sT_Students = sT_Students;
    }

    public String getoU_Region() {
        return oU_Region;
    }

    public void setoU_Region(String oU_Region) {
        this.oU_Region = oU_Region;
    }

    public String getsVU_Region() {
        return sVU_Region;
    }

    public void setsVU_Region(String sVU_Region) {
        this.sVU_Region = sVU_Region;
    }

    public String getaU_Region() {
        return aU_Region;
    }

    public void setaU_Region(String aU_Region) {
        this.aU_Region = aU_Region;
    }

    public CollegeDetails(String college_code, String distName, String tuition_Fee, String coEducation, String no_of_seats_Avaliable, String no_of_seats_filled, String branch, String best_Rank_is, String last_Rank_is, String mean_Rank, String median_Rank, String oC_Students, String bC_A_Students, String bC_B_Students, String bC_C_Students, String bC_D_Students, String bC_E_Students, String sC_Students, String sT_Students, String oU_Region, String sVU_Region, String aU_Region, String fee, String affil, String code, String region, String type, String place, String dist, String coed, String name) {
        this.college_code = college_code;
        this.distName = distName;
        this.tuition_Fee = tuition_Fee;
        this.coEducation = coEducation;
        this.no_of_seats_Avaliable = no_of_seats_Avaliable;
        this.no_of_seats_filled = no_of_seats_filled;
        this.branch = branch;
        this.best_Rank_is = best_Rank_is;
        this.last_Rank_is = last_Rank_is;
        this.mean_Rank = mean_Rank;
        this.median_Rank = median_Rank;
        this.oC_Students = oC_Students;
        this.bC_A_Students = bC_A_Students;
        this.bC_B_Students = bC_B_Students;
        this.bC_C_Students = bC_C_Students;
        this.bC_D_Students = bC_D_Students;
        this.bC_E_Students = bC_E_Students;
        this.sC_Students = sC_Students;
        this.sT_Students = sT_Students;
        this.oU_Region = oU_Region;
        this.sVU_Region = sVU_Region;
        this.aU_Region = aU_Region;
        this.fee = fee;
        this.affil = affil;
        this.code = code;
        this.region = region;
        this.type = type;
        this.place = place;
        this.dist = dist;
        this.coed = coed;
        this.name = name;
    }

    @Override
    public int compareTo(@NonNull CollegeDetails o) {
        return getName().compareTo(o.getName());
    }
}
