package com.example.admin.data.examEamcet.model;

import com.google.gson.annotations.SerializedName;

public class BranchStatatics {

    @SerializedName("branch")
    private  String branch;
    @SerializedName("code")
    private  String id;

    @SerializedName("female")
    private  int female;
    @SerializedName("male")
    private int male;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        this.female = female;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public BranchStatatics(String branch, String id, int female, int male) {
        this.branch = branch;
        this.id = id;
        this.female = female;
        this.male = male;
    }
}
