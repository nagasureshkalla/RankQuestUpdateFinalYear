package com.example.admin.data.examEamcet.model;

import com.google.gson.annotations.SerializedName;

public class Statastics {

    @SerializedName("branch")
    private String branch;
    @SerializedName("sex")
    private String m;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }



    public Statastics(String branch, String m) {
        this.branch = branch;
        this.m = m;

    }
}
