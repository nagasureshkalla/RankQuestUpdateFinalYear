package com.example.admin.data.Homepage.Model;

import com.google.gson.annotations.SerializedName;

public class DevelopersModel {

    @SerializedName("developername")
    private String developername;
    @SerializedName("image")
    private String image;
    @SerializedName("mail")
    private String mail;


    public String getDevelopername() {
        return developername;
    }

    public void setDevelopername(String developername) {
        this.developername = developername;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public DevelopersModel(String developername, String image, String mail) {
        this.developername = developername;
        this.image = image;
        this.mail = mail;
    }
}
