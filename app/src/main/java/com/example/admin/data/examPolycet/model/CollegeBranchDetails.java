package com.example.admin.data.examPolycet.model;

import com.google.gson.annotations.SerializedName;

public class CollegeBranchDetails implements Comparable<CollegeBranchDetails>{

    @SerializedName("name")
    private String name;
    @SerializedName("branch_name")
    private String branch_name;
    @SerializedName("colcode")
    private String colcode;
    @SerializedName("branch")
    private String branch;
    @SerializedName("oc_m_min")
    private String oc_m_min;
    @SerializedName("oc_m_max")
    private String oc_m_max;
    @SerializedName("bc_a_m_min")
    private String bc_a_m_min;
    @SerializedName("bc_a_m_max")
    private String bc_a_m_max;
    @SerializedName("bc_b_m_min")
    private String bc_b_m_min;
    @SerializedName("bc_b_m_max")
    private String bc_b_m_max;
    @SerializedName("bc_c_m_min")
    private String bc_c_m_min;
    @SerializedName("bc_c_m_max")
    private String bc_c_m_max;
    @SerializedName("bc_d_m_min")
    private String bc_d_m_min;
    @SerializedName("bc_d_m_max")
    private String bc_d_m_max;
    @SerializedName("bc_e_m_min")
    private String bc_e_m_min;
    @SerializedName("bc_e_m_max")
    private String bc_e_m_max;
    @SerializedName("sc_m_min")
    private String sc_m_min;
    @SerializedName("sc_m_max")
    private String sc_m_max;
    @SerializedName("st_m_min")
    private String st_m_min;
    @SerializedName("st_m_max")
    private String st_m_max;
    @SerializedName("oc_f_min")
    private String oc_f_min;
    @SerializedName("oc_f_max")
    private String oc_f_max;
    @SerializedName("bc_a_f_min")
    private String bc_a_f_min;
    @SerializedName("bc_a_f_max")
    private String bc_a_f_max;
    @SerializedName("bc_b_f_min")
    private String bc_b_f_min;
    @SerializedName("bc_b_f_max")
    private String bc_b_f_max;
    @SerializedName("bc_c_f_min")
    private String bc_c_f_min;
    @SerializedName("bc_c_f_max")
    private String bc_c_f_max;
    @SerializedName("bc_d_f_min")
    private String bc_d_f_min;
    @SerializedName("bc_d_f_max")
    private String bc_d_f_max;
    @SerializedName("bc_e_f_min")
    private String bc_e_f_min;
    @SerializedName("bc_e_f_max")
    private String bc_e_f_max;
    @SerializedName("sc_f_min")
    private String sc_f_min;
    @SerializedName("sc_f_max")
    private String sc_f_max;
    @SerializedName("st_f_min")
    private String st_f_min;
    @SerializedName("st_f_max")
    private String st_f_max;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColcode() {
        return colcode;
    }

    public void setColcode(String colcode) {
        this.colcode = colcode;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getOc_m_min() {
        return oc_m_min;
    }

    public void setOc_m_min(String oc_m_min) {
        this.oc_m_min = oc_m_min;
    }

    public String getOc_m_max() {
        return oc_m_max;
    }

    public void setOc_m_max(String oc_m_max) {
        this.oc_m_max = oc_m_max;
    }

    public String getBc_a_m_min() {
        return bc_a_m_min;
    }

    public void setBc_a_m_min(String bc_a_m_min) {
        this.bc_a_m_min = bc_a_m_min;
    }

    public String getBc_a_m_max() {
        return bc_a_m_max;
    }

    public void setBc_a_m_max(String bc_a_m_max) {
        this.bc_a_m_max = bc_a_m_max;
    }

    public String getBc_b_m_min() {
        return bc_b_m_min;
    }

    public void setBc_b_m_min(String bc_b_m_min) {
        this.bc_b_m_min = bc_b_m_min;
    }

    public String getBc_b_m_max() {
        return bc_b_m_max;
    }

    public void setBc_b_m_max(String bc_b_m_max) {
        this.bc_b_m_max = bc_b_m_max;
    }

    public String getBc_c_m_min() {
        return bc_c_m_min;
    }

    public void setBc_c_m_min(String bc_c_m_min) {
        this.bc_c_m_min = bc_c_m_min;
    }

    public String getBc_c_m_max() {
        return bc_c_m_max;
    }

    public void setBc_c_m_max(String bc_c_m_max) {
        this.bc_c_m_max = bc_c_m_max;
    }

    public String getBc_d_m_min() {
        return bc_d_m_min;
    }

    public void setBc_d_m_min(String bc_d_m_min) {
        this.bc_d_m_min = bc_d_m_min;
    }

    public String getBc_d_m_max() {
        return bc_d_m_max;
    }

    public void setBc_d_m_max(String bc_d_m_max) {
        this.bc_d_m_max = bc_d_m_max;
    }

    public String getBc_e_m_min() {
        return bc_e_m_min;
    }

    public void setBc_e_m_min(String bc_e_m_min) {
        this.bc_e_m_min = bc_e_m_min;
    }

    public String getBc_e_m_max() {
        return bc_e_m_max;
    }

    public void setBc_e_m_max(String bc_e_m_max) {
        this.bc_e_m_max = bc_e_m_max;
    }

    public String getSc_m_min() {
        return sc_m_min;
    }

    public void setSc_m_min(String sc_m_min) {
        this.sc_m_min = sc_m_min;
    }

    public String getSc_m_max() {
        return sc_m_max;
    }

    public void setSc_m_max(String sc_m_max) {
        this.sc_m_max = sc_m_max;
    }

    public String getSt_m_min() {
        return st_m_min;
    }

    public void setSt_m_min(String st_m_min) {
        this.st_m_min = st_m_min;
    }

    public String getSt_m_max() {
        return st_m_max;
    }

    public void setSt_m_max(String st_m_max) {
        this.st_m_max = st_m_max;
    }

    public String getOc_f_min() {
        return oc_f_min;
    }

    public void setOc_f_min(String oc_f_min) {
        this.oc_f_min = oc_f_min;
    }

    public String getOc_f_max() {
        return oc_f_max;
    }

    public void setOc_f_max(String oc_f_max) {
        this.oc_f_max = oc_f_max;
    }

    public String getBc_a_f_min() {
        return bc_a_f_min;
    }

    public void setBc_a_f_min(String bc_a_f_min) {
        this.bc_a_f_min = bc_a_f_min;
    }

    public String getBc_a_f_max() {
        return bc_a_f_max;
    }

    public void setBc_a_f_max(String bc_a_f_max) {
        this.bc_a_f_max = bc_a_f_max;
    }

    public String getBc_b_f_min() {
        return bc_b_f_min;
    }

    public void setBc_b_f_min(String bc_b_f_min) {
        this.bc_b_f_min = bc_b_f_min;
    }

    public String getBc_b_f_max() {
        return bc_b_f_max;
    }

    public void setBc_b_f_max(String bc_b_f_max) {
        this.bc_b_f_max = bc_b_f_max;
    }

    public String getBc_c_f_min() {
        return bc_c_f_min;
    }

    public void setBc_c_f_min(String bc_c_f_min) {
        this.bc_c_f_min = bc_c_f_min;
    }

    public String getBc_c_f_max() {
        return bc_c_f_max;
    }

    public void setBc_c_f_max(String bc_c_f_max) {
        this.bc_c_f_max = bc_c_f_max;
    }

    public String getBc_d_f_min() {
        return bc_d_f_min;
    }

    public void setBc_d_f_min(String bc_d_f_min) {
        this.bc_d_f_min = bc_d_f_min;
    }

    public String getBc_d_f_max() {
        return bc_d_f_max;
    }

    public void setBc_d_f_max(String bc_d_f_max) {
        this.bc_d_f_max = bc_d_f_max;
    }

    public String getBc_e_f_min() {
        return bc_e_f_min;
    }

    public void setBc_e_f_min(String bc_e_f_min) {
        this.bc_e_f_min = bc_e_f_min;
    }

    public String getBc_e_f_max() {
        return bc_e_f_max;
    }

    public void setBc_e_f_max(String bc_e_f_max) {
        this.bc_e_f_max = bc_e_f_max;
    }

    public String getSc_f_min() {
        return sc_f_min;
    }

    public void setSc_f_min(String sc_f_min) {
        this.sc_f_min = sc_f_min;
    }

    public String getSc_f_max() {
        return sc_f_max;
    }

    public void setSc_f_max(String sc_f_max) {
        this.sc_f_max = sc_f_max;
    }

    public String getSt_f_min() {
        return st_f_min;
    }

    public void setSt_f_min(String st_f_min) {
        this.st_f_min = st_f_min;
    }

    public String getSt_f_max() {
        return st_f_max;
    }

    public void setSt_f_max(String st_f_max) {
        this.st_f_max = st_f_max;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public CollegeBranchDetails(String name, String branch_name, String colcode, String branch, String oc_m_min, String oc_m_max, String bc_a_m_min, String bc_a_m_max, String bc_b_m_min, String bc_b_m_max, String bc_c_m_min, String bc_c_m_max, String bc_d_m_min, String bc_d_m_max, String bc_e_m_min, String bc_e_m_max, String sc_m_min, String sc_m_max, String st_m_min, String st_m_max, String oc_f_min, String oc_f_max, String bc_a_f_min, String bc_a_f_max, String bc_b_f_min, String bc_b_f_max, String bc_c_f_min, String bc_c_f_max, String bc_d_f_min, String bc_d_f_max, String bc_e_f_min, String bc_e_f_max, String sc_f_min, String sc_f_max, String st_f_min, String st_f_max) {
        this.name = name;
        this.branch_name = branch_name;
        this.colcode = colcode;
        this.branch = branch;
        this.oc_m_min = oc_m_min;
        this.oc_m_max = oc_m_max;
        this.bc_a_m_min = bc_a_m_min;
        this.bc_a_m_max = bc_a_m_max;
        this.bc_b_m_min = bc_b_m_min;
        this.bc_b_m_max = bc_b_m_max;
        this.bc_c_m_min = bc_c_m_min;
        this.bc_c_m_max = bc_c_m_max;
        this.bc_d_m_min = bc_d_m_min;
        this.bc_d_m_max = bc_d_m_max;
        this.bc_e_m_min = bc_e_m_min;
        this.bc_e_m_max = bc_e_m_max;
        this.sc_m_min = sc_m_min;
        this.sc_m_max = sc_m_max;
        this.st_m_min = st_m_min;
        this.st_m_max = st_m_max;
        this.oc_f_min = oc_f_min;
        this.oc_f_max = oc_f_max;
        this.bc_a_f_min = bc_a_f_min;
        this.bc_a_f_max = bc_a_f_max;
        this.bc_b_f_min = bc_b_f_min;
        this.bc_b_f_max = bc_b_f_max;
        this.bc_c_f_min = bc_c_f_min;
        this.bc_c_f_max = bc_c_f_max;
        this.bc_d_f_min = bc_d_f_min;
        this.bc_d_f_max = bc_d_f_max;
        this.bc_e_f_min = bc_e_f_min;
        this.bc_e_f_max = bc_e_f_max;
        this.sc_f_min = sc_f_min;
        this.sc_f_max = sc_f_max;
        this.st_f_min = st_f_min;
        this.st_f_max = st_f_max;
    }

    @Override
    public int compareTo(CollegeBranchDetails o) {
        return getName().compareTo(o.getName());
    }
}
