package com.example.admin.data.examEamcet.model;


import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("s_No")
    private String  s_no;
    @SerializedName("hall_Ticket")
    private String  hallTicket;
    @SerializedName("rank")
    private String  rank;
    @SerializedName("name")
    private String  name;
    @SerializedName("sex")
    private String sex;
    @SerializedName("caste")
    private String caste;
    @SerializedName("region")
    private String  region;
    @SerializedName("seat_Category")
    private String  seat_category;
    @SerializedName("branch")
    private String  branch;
    @SerializedName("collegeCode")
    private String  collegecode;

    public String getS_no() {
        return s_no;
    }

    public String getHallTicket() {
        return hallTicket;
    }

    public String getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getCaste() {
        return caste;
    }

    public String getRegion() {
        return region;
    }

    public String getSeat_category() {
        return seat_category;
    }

    public String getBranch() {
        return branch;
    }

    public String getCollegecode() {
        return collegecode;
    }

    public void setS_no(String s_no) {
        this.s_no = s_no;
    }

    public void setHallTicket(String hallTicket) {
        this.hallTicket = hallTicket;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Data(String s_no, String hallTicket, String rank, String name, String sex, String caste, String region, String seat_category, String branch, String collegecode) {
        this.s_no = s_no;
        this.hallTicket = hallTicket;
        this.rank = rank;
        this.name = name;
        this.sex = sex;
        this.caste = caste;
        this.region = region;
        this.seat_category = seat_category;
        this.branch = branch;
        this.collegecode = collegecode;
    }

    public void setSeat_category(String seat_category) {
        this.seat_category = seat_category;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setCollegecode(String collegecode) {
        this.collegecode = collegecode;
    }


}


