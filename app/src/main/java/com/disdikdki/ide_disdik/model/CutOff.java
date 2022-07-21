package com.disdikdki.ide_disdik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CutOff {

    @SerializedName("_id")
    @Expose
    private String id;

    @SerializedName("bulan")
    @Expose
    private int bulan;

    @SerializedName("semester_id")
    @Expose
    private String semester_id;

    @SerializedName("tahun_anggaran")
    @Expose
    private int tahun_anggaran;

    @SerializedName("tahun_pelajaran")
    @Expose
    private String tahun_pelajaran;

    @SerializedName("triwulan")
    @Expose
    private int triwulan;

    public CutOff(String id, int bulan, String semester_id, int tahun_anggaran, String tahun_pelajaran, int triwulan) {
        this.id = id;
        this.bulan = bulan;
        this.semester_id = semester_id;
        this.tahun_anggaran = tahun_anggaran;
        this.tahun_pelajaran = tahun_pelajaran;
        this.triwulan = triwulan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBulan() {
        return bulan;
    }

    public void setBulan(int bulan) {
        this.bulan = bulan;
    }

    public String getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(String semester_id) {
        this.semester_id = semester_id;
    }

    public int getTahun_anggaran() {
        return tahun_anggaran;
    }

    public void setTahun_anggaran(int tahun_anggaran) {
        this.tahun_anggaran = tahun_anggaran;
    }

    public String getTahun_pelajaran() {
        return tahun_pelajaran;
    }

    public void setTahun_pelajaran(String tahun_pelajaran) {
        this.tahun_pelajaran = tahun_pelajaran;
    }

    public int getTriwulan() {
        return triwulan;
    }

    public void setTriwulan(int triwulan) {
        this.triwulan = triwulan;
    }
}



