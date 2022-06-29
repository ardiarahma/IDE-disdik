package com.disdikdki.ide_disdik.model;

public class Sekolah {

   String nama_satuan_pendidikan;
   int npsn;
   String alamat;

    public Sekolah(String nama_satuan_pendidikan, int npsn, String alamat) {
        this.nama_satuan_pendidikan = nama_satuan_pendidikan;
        this.npsn = npsn;
        this.alamat = alamat;
    }

    public String getNama_satuan_pendidikan() {
        return nama_satuan_pendidikan;
    }

    public void setNama_satuan_pendidikan(String nama_satuan_pendidikan) {
        this.nama_satuan_pendidikan = nama_satuan_pendidikan;
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
