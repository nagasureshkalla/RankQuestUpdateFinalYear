package com.example.admin.data.examEcet.model;


import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Branch implements Comparable<Branch>{

    @SerializedName("seat_avail")
    private String seat_avail;
    @SerializedName("branch")
    private String branch;
    @SerializedName("total_seat")
    private String total_seat;
    @SerializedName("percent")
    private String percent;
    @SerializedName("name")
    private String name;

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


    public String getSeat_avail() {
        return seat_avail;
    }

    public void setSeat_avail(String seat_avail) {
        this.seat_avail = seat_avail;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getTotal_seat() {
        return total_seat;
    }

    public void setTotal_seat(String total_seat) {
        this.total_seat = total_seat;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Branch(String seat_avail, String branch, String total_seat, String percent, String name) {
        this.seat_avail = seat_avail;
        this.branch = branch;
        this.total_seat = total_seat;
        this.percent = percent;
        this.name = name;
    }

    @Override
    public int compareTo(@NonNull Branch o) {
        return getBranch().compareTo(o.getBranch());
    }
}
