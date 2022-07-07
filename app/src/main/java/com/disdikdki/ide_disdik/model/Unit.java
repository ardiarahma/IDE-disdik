package com.disdikdki.ide_disdik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Unit {

    @SerializedName("periode_id")
    @Expose
    private String periode_id;

    @SerializedName("unit")
    @Expose
    private String unit;

    public Unit(String periode_id, String unit) {
        this.periode_id = periode_id;
        this.unit = unit;
    }

    public String getPeriode_id() {
        return periode_id;
    }

    public void setPeriode_id(String periode_id) {
        this.periode_id = periode_id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
