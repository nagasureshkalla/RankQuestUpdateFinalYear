package com.example.admin.data.examPolycet.model;

import com.google.gson.annotations.SerializedName;

public class SeatsBranches {

    @SerializedName("code")
    private String code;
    @SerializedName("branch")
    private String branch;
    @SerializedName("conveyseats")
    private String conveyseats;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getConveyseats() {
        return conveyseats;
    }

    public void setConveyseats(String conveyseats) {
        this.conveyseats = conveyseats;
    }

    public SeatsBranches(String code, String branch, String conveyseats) {
        this.code = code;
        this.branch = branch;
        this.conveyseats = conveyseats;
    }
}
