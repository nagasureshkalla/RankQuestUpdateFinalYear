package com.example.admin.data.FragmentsExams.EAMCET.Model;

import com.google.gson.annotations.SerializedName;

public class Statatics {

    @SerializedName("branch")
    private String branch;
    @SerializedName("male")
    private String male;
    @SerializedName("female")
    private String female;
    @SerializedName("code")
    private String code;

    public Statatics(String branch, String male, String female, String code) {
        this.branch = branch;
        this.male = male;
        this.female = female;
        this.code = code;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
