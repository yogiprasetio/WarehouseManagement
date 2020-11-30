package com.warehousemanajemen;

import warehousemanajemen.view.Insert;
import database.koneksi;
import java.sql.SQLException;
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        new Insert().show();
//System.out.println("Tes");
//            koneksi con = new koneksi();
    }
    
}
