package com.example.admin.data.Homepage.Model;

import com.google.gson.annotations.SerializedName;

public class WebsitesModel {
    @SerializedName("examname")
    private String examname;
    @SerializedName("link")
    private String link;

    public WebsitesModel(String examname, String link) {
        this.examname = examname;
        this.link = link;
    }

    public String getExamname() {
        return examname;
    }

    public void setExamname(String examname) {
        this.examname = examname;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
