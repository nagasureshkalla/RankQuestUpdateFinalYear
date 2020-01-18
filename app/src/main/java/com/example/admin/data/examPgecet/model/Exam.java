package com.example.admin.data.examPgecet.model;

import com.google.gson.annotations.SerializedName;

public class Exam {

    @SerializedName("s_no")
    private String s_no;
    @SerializedName("sex")
    private String sex;
    @SerializedName("branch")
    private String branch;
    @SerializedName("code")
    private String code;

    public Exam(String s_no, String sex, String branch, String code) {
        this.s_no = s_no;
        this.sex = sex;
        this.branch = branch;
        this.code = code;
    }

    public String getS_no() {
        return s_no;
    }

    public void setS_no(String s_no) {
        this.s_no = s_no;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
