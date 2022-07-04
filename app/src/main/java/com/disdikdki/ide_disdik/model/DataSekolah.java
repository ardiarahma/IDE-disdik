package com.disdikdki.ide_disdik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataSekolah {

    @SerializedName("data")
    @Expose
    private ArrayList<Sekolah> sekolahs;

    public DataSekolah(ArrayList<Sekolah> sekolahs) {
        this.sekolahs = sekolahs;
    }

    public ArrayList<Sekolah> getSekolahs() {
        return sekolahs;
    }

    public void setSekolahs(ArrayList<Sekolah> sekolahs) {
        this.sekolahs = sekolahs;
    }
}
