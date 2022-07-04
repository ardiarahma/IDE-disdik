package com.disdikdki.ide_disdik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Periode {

    @SerializedName("periode_id")
    @Expose
    private String periode_id;

    public Periode(String periode_id) {
        this.periode_id = periode_id;
    }

    public String getPeriode_id() {
        return periode_id;
    }

    public void setPeriode_id(String periode_id) {
        this.periode_id = periode_id;
    }
}
