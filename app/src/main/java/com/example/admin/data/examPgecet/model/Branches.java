package com.example.admin.data.examPgecet.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Branches implements  Comparable<Branches>{

    @SerializedName("seat_fill")
    private String seat_fill;

    @SerializedName("percent")
    private String percent;

    @SerializedName("branch")
    private String branch;
    @SerializedName("seat_avail")
    private String seat_avail;
    @SerializedName("branch_name")
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


    public Branches(String seat_fill, String percent, String branch, String seat_avail, String name) {
        this.seat_fill = seat_fill;
        this.percent = percent;
        this.branch = branch;
        this.seat_avail = seat_avail;
        this.name = name;
    }

    public String getSeat_fill() {
        return seat_fill;
    }

    public void setSeat_fill(String seat_fill) {
        this.seat_fill = seat_fill;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSeat_avail() {
        return seat_avail;
    }

    public void setSeat_avail(String seat_avail) {
        this.seat_avail = seat_avail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(@NonNull Branches o) {
        return getBranch().compareTo(o.getBranch());
    }
}
