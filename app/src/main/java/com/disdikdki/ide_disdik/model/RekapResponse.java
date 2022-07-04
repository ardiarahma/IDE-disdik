package com.disdikdki.ide_disdik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RekapResponse {

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("result")
    @Expose
    private ArrayList<Rekap> rekapArrayList;

    public RekapResponse(String error, ArrayList<Rekap> rekapArrayList) {
        this.error = error;
        this.rekapArrayList = rekapArrayList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ArrayList<Rekap> getRekapArrayList() {
        return rekapArrayList;
    }

    public void setRekapArrayList(ArrayList<Rekap> rekapArrayList) {
        this.rekapArrayList = rekapArrayList;
    }
}
