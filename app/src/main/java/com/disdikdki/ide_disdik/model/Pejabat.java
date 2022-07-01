package com.disdikdki.ide_disdik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pejabat {

    @SerializedName("_id")
    @Expose
    private String id;

    @SerializedName("eselon")
    @Expose
    private String eselon;

    @SerializedName("jabatan")
    @Expose
    private String jabatan;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("nip")
    @Expose
    private String nip;

    @SerializedName("pangkat")
    @Expose
    private String pangkat;

    @SerializedName("unit")
    @Expose
    private String unit;

    public Pejabat(String id, String eselon, String jabatan, String nama, String nip, String pangkat, String unit) {
        this.id = id;
        this.eselon = eselon;
        this.jabatan = jabatan;
        this.nama = nama;
        this.nip = nip;
        this.pangkat = pangkat;
        this.unit = unit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEselon() {
        return eselon;
    }

    public void setEselon(String eselon) {
        this.eselon = eselon;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPangkat() {
        return pangkat;
    }

    public void setPangkat(String pangkat) {
        this.pangkat = pangkat;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}

