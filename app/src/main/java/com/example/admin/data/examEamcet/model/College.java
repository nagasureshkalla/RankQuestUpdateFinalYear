package com.example.admin.data.examEamcet.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class College implements Comparable<College>{

    @SerializedName("college_name")
    private String collegename;
    @SerializedName("seat _filled")
    private String seatFilled;
    @SerializedName("seats_avaliable")
    private String seats_avaliable;
    @SerializedName("filled_per")
    private String filled_per;
    @SerializedName("dist")
    private String dist;
    @SerializedName("code")
    private  String code;

     static int  size;

    public static int getSize() {
        return size;
    }

    public static void setSize(int size1) {
        size = size1;
    }

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

    public College(String collegename, String seatFilled, String seats_avaliable, String filled_per, String dist, String code) {
        this.collegename = collegename;
        this.seatFilled = seatFilled;
        this.seats_avaliable = seats_avaliable;
        this.filled_per = filled_per;
        this.dist = dist;
        this.code = code;
    }

    public String getSeatFilled() {
        return seatFilled;
    }

    public void setSeatFilled(String seatFilled) {
        this.seatFilled = seatFilled;
    }

    public String getSeats_avaliable() {
        return seats_avaliable;
    }

    public void setSeats_avaliable(String seats_avaliable) {
        this.seats_avaliable = seats_avaliable;
    }

    public String getFilled_per() {
        return filled_per;
    }

    public void setFilled_per(String filled_per) {
        this.filled_per = filled_per;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public int compareTo(@NonNull College o) {
        return getCollegename().compareTo(o.getCollegename());
    }
}
