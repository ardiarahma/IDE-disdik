package com.disdikdki.ide_disdik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CutoffResponse {

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("result")
    @Expose
    private ArrayList<CutOff> cutOffs;

    public CutoffResponse(String error, ArrayList<CutOff> cutOffs) {
        this.error = error;
        this.cutOffs = cutOffs;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ArrayList<CutOff> getCutOffs() {
        return cutOffs;
    }

    public void setCutOffs(ArrayList<CutOff> cutOffs) {
        this.cutOffs = cutOffs;
    }
}
