package com.disdikdki.ide_disdik.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sekolah {

    @SerializedName("JUMLAH_GURU")
    @Expose
    private int jumlah_guru;

    @SerializedName("JUMLAH_PD")
    @Expose
    private int jumlah_pesdik;

    @SerializedName("JUMLAH_TENDIK")
    @Expose
    private int jumlah_tendik;

    @SerializedName("KECAMATAN")
    @Expose
    private String kecamatan;

    @SerializedName("KELURAHAN")
    @Expose
    private String kelurahan;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("bentuk_pendidikan")
    @Expose
    private String bentuk_pendidikan;

    @SerializedName("jenjang")
    @Expose
    private String jenjang;

    @SerializedName("kota")
    @Expose
    private String kota;

    @SerializedName("nama_kepala_sekolah")
    @Expose
    private String nama_kepsek;

    @SerializedName("nama_satuan_pendidikan")
    @Expose
    private String nama_sekolah;

    @SerializedName("nomor_hp_kepala_sekolah")
    @Expose
    private String noHp_kepsek;

    @SerializedName("nomor_telepon")
    @Expose
    private String noTelp;

    @SerializedName("npsn")
    @Expose
    private String npsn;

    @SerializedName("status_sekolah")
    @Expose
    private String status;

    @SerializedName("sudin")
    @Expose
    private String sudin;

    public Sekolah(int jumlah_guru, int jumlah_pesdik, int jumlah_tendik, String kecamatan, String kelurahan, String alamat, String bentuk_pendidikan, String jenjang, String kota, String nama_kepsek, String nama_sekolah, String noHp_kepsek, String noTelp, String npsn, String status, String sudin) {
        this.jumlah_guru = jumlah_guru;
        this.jumlah_pesdik = jumlah_pesdik;
        this.jumlah_tendik = jumlah_tendik;
        this.kecamatan = kecamatan;
        this.kelurahan = kelurahan;
        this.alamat = alamat;
        this.bentuk_pendidikan = bentuk_pendidikan;
        this.jenjang = jenjang;
        this.kota = kota;
        this.nama_kepsek = nama_kepsek;
        this.nama_sekolah = nama_sekolah;
        this.noHp_kepsek = noHp_kepsek;
        this.noTelp = noTelp;
        this.npsn = npsn;
        this.status = status;
        this.sudin = sudin;
    }

    public int getJumlah_guru() {
        return jumlah_guru;
    }

    public void setJumlah_guru(int jumlah_guru) {
        this.jumlah_guru = jumlah_guru;
    }

    public int getJumlah_pesdik() {
        return jumlah_pesdik;
    }

    public void setJumlah_pesdik(int jumlah_pesdik) {
        this.jumlah_pesdik = jumlah_pesdik;
    }

    public int getJumlah_tendik() {
        return jumlah_tendik;
    }

    public void setJumlah_tendik(int jumlah_tendik) {
        this.jumlah_tendik = jumlah_tendik;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getBentuk_pendidikan() {
        return bentuk_pendidikan;
    }

    public void setBentuk_pendidikan(String bentuk_pendidikan) {
        this.bentuk_pendidikan = bentuk_pendidikan;
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

    public String getNama_kepsek() {
        return nama_kepsek;
    }

    public void setNama_kepsek(String nama_kepsek) {
        this.nama_kepsek = nama_kepsek;
    }

    public String getNama_sekolah() {
        return nama_sekolah;
    }

    public void setNama_sekolah(String nama_sekolah) {
        this.nama_sekolah = nama_sekolah;
    }

    public String getNoHp_kepsek() {
        return noHp_kepsek;
    }

    public void setNoHp_kepsek(String noHp_kepsek) {
        this.noHp_kepsek = noHp_kepsek;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getNpsn() {
        return npsn;
    }

    public void setNpsn(String npsn) {
        this.npsn = npsn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSudin() {
        return sudin;
    }

    public void setSudin(String sudin) {
        this.sudin = sudin;
    }
}
