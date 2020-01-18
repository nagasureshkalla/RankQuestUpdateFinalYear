package com.example.admin.data.examEamcet.model;

import com.google.gson.annotations.SerializedName;

public class TotalSeats {

    @SerializedName("code")
    private String code;

    @SerializedName("totalseats")
    private String totalseats;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTotalseats() {
        return totalseats;
    }

    public void setTotalseats(String totalseats) {
        this.totalseats = totalseats;
    }

    public TotalSeats(String code, String totalseats) {
        this.code = code;
        this.totalseats = totalseats;
    }
}
