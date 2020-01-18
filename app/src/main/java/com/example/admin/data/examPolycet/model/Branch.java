package com.example.admin.data.examPolycet.model;


import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Branch implements  Comparable<Branch>{

    @SerializedName("seat_fill")
    private String seat_fill;
    @SerializedName("branch")
    private String branch;
    @SerializedName("seat_avail")
    private String seat_avail;
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
    private boolean isSelected;

    public String getSeat_fill() {
        return seat_fill;
    }

    public void setSeat_fill(String seat_fill) {
        this.seat_fill = seat_fill;
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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Branch(String seat_fill, String branch, String seat_avail, String percent, String name, boolean isSelected) {
        this.seat_fill = seat_fill;
        this.branch = branch;
        this.seat_avail = seat_avail;
        this.percent = percent;
        this.name = name;
        this.isSelected = isSelected;
    }

    @Override
    public int compareTo(@NonNull Branch o) {
        return getBranch().compareTo(o.getBranch());
    }
}
