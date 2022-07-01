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

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("nip")
    @Expose
    private String nip;

    @SerializedName("pangkat")
    @Expose
    private String pangkat;

    public Pejabat(String id, String eselon, String nama, String nip, String pangkat) {
        this.id = id;
        this.eselon = eselon;
        this.nama = nama;
        this.nip = nip;
        this.pangkat = pangkat;
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
}
