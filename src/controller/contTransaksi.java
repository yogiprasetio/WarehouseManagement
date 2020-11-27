/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        System.out.println("SELECT * FROM transaksi");
        ResultSet rs = this.koneksi.GetData("SELECT * FROM transaksi");
        System.out.println("SELECT * FROM transaksi");
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
    
}
