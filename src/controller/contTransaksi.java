/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import model.transaksi;

/**
 *
 * @author LENOVO
 */
public class contTransaksi {
    koneksi koneksi;
    ArrayList<transaksi> arrTransaksi;

    public contTransaksi() {
        this.koneksi = new koneksi();
        this.arrTransaksi = new ArrayList<>();
        System.out.println("SELECT * FROM transaksi");
    }
    
    public ArrayList<transaksi> getTransaksi() throws SQLException{
        this.arrTransaksi.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM transaksi");
        while(rs.next()){
            transaksi arrTransaksi = new transaksi();
            arrTransaksi.setId(rs.getInt("Id"));
            arrTransaksi.setProduk(rs.getString("produk"));
            arrTransaksi.setKategori(rs.getString("kategori"));
            arrTransaksi.setTgl_masuk(rs.getDate("tgl_masuk"));
            arrTransaksi.setTgl_keluar(rs.getDate("tgl_keluar"));
            arrTransaksi.setJumlah(rs.getInt("jumlah"));
            arrTransaksi.setUser(rs.getInt("id_user"));
            this.arrTransaksi.add(arrTransaksi);
        }
        return this.arrTransaksi;
    }
    
    public void insertTransaksi(transaksi trans){
        if (trans.getTgl_keluar() == null) {
            String tgl_keluar = "NULL";
        }
        else{
            String tgl_keluar = new SimpleDateFormat("yyyy-MM-dd").format(trans.getTgl_keluar());
        }
        
        int id = trans.getUser();
        System.out.println("sebelum format : " + trans.getTgl_masuk());
        String formated = new SimpleDateFormat("yyyy-MM-dd").format(trans.getTgl_masuk());
        System.out.println("Setelah format : " + formated);
        this.koneksi.ManipulasiData("INSERT INTO transaksi (id, produk, kategori, jumlah, tgl_masuk, tgl_keluar, id_user) VALUES (NULL, '" + trans.getProduk() + "', '" + trans.getKategori() + "', '" +  trans.getJumlah() + "', '" + formated + "', NULL, '" + id + "')");
        System.out.println("INSERT INTO transaksi (`id`, `produk`, `kategori`, `jumlah`, `tgl_masuk`, `tgl_keluar`, `id_user`) VALUES (NULL, '" + trans.getProduk() + "', '" + trans.getKategori() + "', '" +  trans.getJumlah() + "', '" + formated + "', NULL, '" + id + "')");
    }
    
    public void updateTransaksi(transaksi trans){
        String tgl_keluar = new SimpleDateFormat("yyyy-MM-dd").format(trans.getTgl_keluar());
        System.out.println("Update");
        this.koneksi.ManipulasiData("UPDATE `transaksi` SET `produk` = '" + trans.getProduk() + "', `kategori` = '" + trans.getKategori() + "', `jumlah` = '" + trans.getJumlah() + "', `tgl_keluar` = '" + tgl_keluar + "' WHERE `transaksi`.`id` = " + trans.getId());
        System.out.println("UPDATE `transaksi` SET `produk` = '" + trans.getProduk() + "', `kategori` = '" + trans.getKategori() + "', `jumlah` = '" + trans.getJumlah() + "', `tgl_keluar` = '" + tgl_keluar + "' WHERE `transaksi`.`id` = " + trans.getId());
    }
    
    public void deleteTransaksi(int id){
        this.koneksi.ManipulasiData("DELETE FROM `transaksi` WHERE `transaksi`.`id` = " + id);
    }
    
}
