package com.example.admin.data.examEamcet.model;

import com.google.gson.annotations.SerializedName;

public class CasteStatatics {


    @SerializedName("code")
    private String code;
    @SerializedName("BC_A")
    private int BC_A;
    @SerializedName("BC_B")
    private int BC_B;
    @SerializedName("BC_C")
    private int BC_C;
    @SerializedName("BC_D")
    private int BC_D;
    @SerializedName("BC_E")
    private int BC_E;
    @SerializedName("SC")
    private int SC;
    @SerializedName("ST")
    private int ST;
    @SerializedName("OC")
    private int OC;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getBC_A() {
        return BC_A;
    }

    public void setBC_A(int BC_A) {
        this.BC_A = BC_A;
    }

    public int getBC_B() {
        return BC_B;
    }

    public void setBC_B(int BC_B) {
        this.BC_B = BC_B;
    }

    public int getBC_C() {
        return BC_C;
    }

    public void setBC_C(int BC_C) {
        this.BC_C = BC_C;
    }

    public int getBC_D() {
        return BC_D;
    }

    public void setBC_D(int BC_D) {
        this.BC_D = BC_D;
    }

    public int getBC_E() {
        return BC_E;
    }

    public void setBC_E(int BC_E) {
        this.BC_E = BC_E;
    }

    public int getSC() {
        return SC;
    }

    public void setSC(int SC) {
        this.SC = SC;
    }

    public int getST() {
        return ST;
    }

    public void setST(int ST) {
        this.ST = ST;
    }

    public int getOC() {
        return OC;
    }

    public void setOC(int OC) {
        this.OC = OC;
    }

    public CasteStatatics(String code, int BC_A, int BC_B, int BC_C, int BC_D, int BC_E, int SC, int ST, int OC) {
        this.code = code;
        this.BC_A = BC_A;
        this.BC_B = BC_B;
        this.BC_C = BC_C;
        this.BC_D = BC_D;
        this.BC_E = BC_E;
        this.SC = SC;
        this.ST = ST;
        this.OC = OC;
    }
}
