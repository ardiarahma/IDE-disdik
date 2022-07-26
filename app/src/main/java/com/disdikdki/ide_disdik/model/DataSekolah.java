package com.disdikdki.ide_disdik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataSekolah {

    @SerializedName("limit")
    @Expose
    private int limit;

    @SerializedName("offset")
    @Expose
    private int offset;

    @SerializedName("nama_satuan_pendidikan")
    @Expose
    private String namaSekolah;

    public DataSekolah(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public DataSekolah(String namaSekolah) {
        this.namaSekolah = namaSekolah;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getNamaSekolah() {
        return namaSekolah;
    }

    public void setNamaSekolah(String namaSekolah) {
        this.namaSekolah = namaSekolah;
    }
}
