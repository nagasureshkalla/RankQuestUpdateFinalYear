package com.example.admin.data.Homepage.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Exam_Name_MainPage implements Serializable {


    @SerializedName("dbname")
    private String dbname;
    @SerializedName("examname")
    private String exam_name;
    @SerializedName("state")
    private String state;
    @SerializedName("color")
    private String color;
    @SerializedName("collection")
    private String collection;

    @SerializedName("counsellings")
    private String[] counsellings;

    @SerializedName("branches")
    private String branches;
    @SerializedName("collegedetails")
    private String collegedetails;
    @SerializedName("reportingcenters")
    private String reportingcenters;
    @SerializedName("castestatistics")
    private String castestatistics;

    @SerializedName("branchstatistics")
    private String branchstatistics;
    @SerializedName("checklist")
    private String checklist;

    public Exam_Name_MainPage(String dbname,String exam_name,String checklist, String state, String color, String collection, String[] counsellings, String branches, String collegedetails, String reportingcenters, String castestatistics, String branchstatistics) {
        this.exam_name = exam_name;
        this.state = state;
        this.color = color;
        this.collection = collection;
        this.counsellings = counsellings;
        this.branches = branches;
        this.collegedetails = collegedetails;
        this.reportingcenters = reportingcenters;
        this.castestatistics = castestatistics;
        this.branchstatistics = branchstatistics;
        this.checklist=checklist;
        this.dbname=dbname;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getChecklist() {
        return checklist;
    }

    public void setChecklist(String checklist) {
        this.checklist = checklist;
    }

    public String getCastestatistics() {
        return castestatistics;
    }

    public void setCastestatistics(String castestatistics) {
        this.castestatistics = castestatistics;
    }

    public String getBranchstatistics() {
        return branchstatistics;
    }

    public void setBranchstatistics(String branchstatistics) {
        this.branchstatistics = branchstatistics;
    }

    public String getReportingcenters() {
        return reportingcenters;
    }

    public void setReportingcenters(String reportingcenters) {
        this.reportingcenters = reportingcenters;
    }

    public String getCollegedetails() {
        return collegedetails;
    }

    public void setCollegedetails(String collegedetails) {
        this.collegedetails = collegedetails;
    }

    public String getBranches() {
        return branches;
    }

    public void setBranches(String branches) {
        this.branches = branches;
    }

    public String[] getCounsellings() {
        return counsellings;
    }

    public void setCounsellings(String[] counsellings) {
        this.counsellings = counsellings;
    }

    public String getExam_name() {
        return exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }
}
