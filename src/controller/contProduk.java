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
import model.produk;
import model.transaksi;
import model.user;

/**
 *
 * @author LENOVO
 */
public class contProduk {
    koneksi koneksi;
    ArrayList<produk> arrProduk;

    public contProduk() {
        this.koneksi = koneksi;
        this.arrProduk = new ArrayList<>();
    }
    
    public ArrayList<produk> getProduk() throws SQLException{
        this.arrProduk.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM dataproduk");
        while(rs.next()){
            produk arrProduk = new produk();
            arrProduk.setId(rs.getInt("Id"));
            arrProduk.setNama(rs.getString("nama"));
            arrProduk.setKategori(rs.getString("kategori"));
            this.arrProduk.add(arrProduk);
        }
        return this.arrProduk;
    }
   
}
