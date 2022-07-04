package com.disdikdki.ide_disdik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SekolahBody {

    @SerializedName("jenjang")
    @Expose
    private String jenjang;

    @SerializedName("kota")
    @Expose
    private String kota;

    @SerializedName("limit")
    @Expose
    private int limit;

    @SerializedName("offset")
    @Expose
    private int offset;

    public SekolahBody(String jenjang, String kota, int limit, int offset) {
        this.jenjang = jenjang;
        this.kota = kota;
        this.limit = limit;
        this.offset = offset;
    }

    public String getJenjang() {
        return jenjang;
    }

    public void setJenjang(String jenjang) {
        this.jenjang = jenjang;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
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
}
