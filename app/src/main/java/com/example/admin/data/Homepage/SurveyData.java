package com.example.admin.data.Homepage;

import com.google.gson.annotations.SerializedName;

public class SurveyData {
    @SerializedName("username")
    private String username;
    @SerializedName("mail")
    private String mail;
    @SerializedName("name")
    private String name;
    @SerializedName("phone")
    private String phone;
    @SerializedName("college")
    private String college;
    @SerializedName("intermarks")
    private String intermarks;
    @SerializedName("10marks")
    private String tenthmarks;
    @SerializedName("address")
    private String address;
    @SerializedName("exam")
    private String exam;

    int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getIntermarks() {
        return intermarks;
    }

    public void setIntermarks(String intermarks) {
        this.intermarks = intermarks;
    }

    public String getTenthmarks() {
        return tenthmarks;
    }

    public void setTenthmarks(String tenthmarks) {
        this.tenthmarks = tenthmarks;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public SurveyData(String username, String mail, String name, String phone, String college, String intermarks, String tenthmarks, String address, String exam) {
        this.username = username;
        this.mail = mail;
        this.name = name;
        this.phone = phone;
        this.college = college;
        this.intermarks = intermarks;
        this.tenthmarks = tenthmarks;
        this.address = address;
        this.exam = exam;
    }
}
