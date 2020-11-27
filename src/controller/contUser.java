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
import model.user;

/**
 *
 * @author LENOVO
 */
public class contUser {
    koneksi koneksi;
    ArrayList<user> arrUser;

    public contUser() {
        this.koneksi = new koneksi();
        this.arrUser = new ArrayList<>();
    }
    
    public ArrayList<user> getUser() throws SQLException{
        this.arrUser.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM user");
        while(rs.next()){
            user arrUser = new user();
            arrUser.setId(rs.getInt("Id"));
            arrUser.setNama(rs.getString("nama"));
            this.arrUser.add(arrUser);
        }
        return this.arrUser;
    }
    
}
