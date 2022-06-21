package com.disdikdki.ide_disdik.network.model;

public class Sekolah {

    String nama_sekolah;
    int npsn;
    String alamat;

    public Sekolah(String nama_sekolah, int npsn, String alamat) {
        this.nama_sekolah = nama_sekolah;
        this.npsn = npsn;
        this.alamat = alamat;
    }

    public String getNama_sekolah() {
        return nama_sekolah;
    }

    public void setNama_sekolah(String nama_sekolah) {
        this.nama_sekolah = nama_sekolah;
    }

    public int getNpsn() {
        return npsn;
    }

    public void setNpsn(int npsn) {
        this.npsn = npsn;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
