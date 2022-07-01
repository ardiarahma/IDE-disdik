package com.disdikdki.ide_disdik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rekap {

    @SerializedName("JUMLAH_GURU")
    @Expose
    private int jumlahGuru;

    @SerializedName("JUMLAH_PD")
    @Expose
    private int jumlahPesdik;

    @SerializedName("JUMLAH_SEKOLAH")
    @Expose
    private int jumlahSekolah;

    @SerializedName("JUMLAH_TENDIK")
    @Expose
    private int jumlahTendik;

    public Rekap(int jumlahGuru, int jumlahPesdik, int jumlahSekolah, int jumlahTendik) {
        this.jumlahGuru = jumlahGuru;
        this.jumlahPesdik = jumlahPesdik;
        this.jumlahSekolah = jumlahSekolah;
        this.jumlahTendik = jumlahTendik;
    }

    public int getJumlahGuru() {
        return jumlahGuru;
    }

    public void setJumlahGuru(int jumlahGuru) {
        this.jumlahGuru = jumlahGuru;
    }

    public int getJumlahPesdik() {
        return jumlahPesdik;
    }

    public void setJumlahPesdik(int jumlahPesdik) {
        this.jumlahPesdik = jumlahPesdik;
    }

    public int getJumlahSekolah() {
        return jumlahSekolah;
    }

    public void setJumlahSekolah(int jumlahSekolah) {
        this.jumlahSekolah = jumlahSekolah;
    }

    public int getJumlahTendik() {
        return jumlahTendik;
    }

    public void setJumlahTendik(int jumlahTendik) {
        this.jumlahTendik = jumlahTendik;
    }
}
