package com.disdikdki.ide_disdik.model;

import com.disdikdki.ide_disdik.model.DataSekolah;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SekolahResponse {

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("result")
    @Expose
    private ArrayList<Sekolah> sekolahs;

    public SekolahResponse(String error, ArrayList<Sekolah> sekolahs) {
        this.error = error;
        this.sekolahs = sekolahs;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ArrayList<Sekolah> getSekolahs() {
        return sekolahs;
    }

    public void setSekolahs(ArrayList<Sekolah> sekolahs) {
        this.sekolahs = sekolahs;
    }
}
