package com.disdikdki.ide_disdik.model;

import com.disdikdki.ide_disdik.model.DataSekolah;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListSekolahResponse {

    @SerializedName("result")
    @Expose
    private ArrayList<DataSekolah> dataSekolahs;

    public ListSekolahResponse(ArrayList<DataSekolah> dataSekolahs) {
        this.dataSekolahs = dataSekolahs;
    }

    public ArrayList<DataSekolah> getDataSekolahs() {
        return dataSekolahs;
    }

    public void setDataSekolahs(ArrayList<DataSekolah> dataSekolahs) {
        this.dataSekolahs = dataSekolahs;
    }
}
