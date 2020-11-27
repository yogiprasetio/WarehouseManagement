/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class transaksi {
    private int id;
    private String produk;
    private String kategori;
    private Date tgl_masuk;
    private Date tgl_keluar;
    private int jumlah;
    private int user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public Date getTgl_masuk() {
        return tgl_masuk;
    }

    public void setTgl_masuk(Date tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }

    public Date getTgl_keluar() {
        return tgl_keluar;
    }

    public void setTgl_keluar(Date tgl_keluar) {
        this.tgl_keluar = tgl_keluar;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
    
    
}
