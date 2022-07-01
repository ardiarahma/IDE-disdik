package com.disdikdki.ide_disdik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.disdikdki.ide_disdik.model.Pejabat;


import java.util.ArrayList;

public class PejabatResponse {

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("result")
    @Expose
    private ArrayList<Pejabat> pejabatArrayList;

    public PejabatResponse(String error, ArrayList<Pejabat> pejabatArrayList) {
        this.error = error;
        this.pejabatArrayList = pejabatArrayList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ArrayList<Pejabat> getPejabatArrayList() {
        return pejabatArrayList;
    }

    public void setPejabatArrayList(ArrayList<Pejabat> pejabatArrayList) {
        this.pejabatArrayList = pejabatArrayList;
    }
}
