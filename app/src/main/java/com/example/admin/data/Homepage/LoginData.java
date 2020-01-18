package com.example.admin.data.Homepage;

import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("profession")
    private String profession;
    @SerializedName("Name")
    private String phone;

    public LoginData(String username, String password, String profession, String phone) {
        this.username = username;
        this.password = password;
        this.profession = profession;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
