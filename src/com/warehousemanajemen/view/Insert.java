package com.warehousemanajemen.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;


public class Insert extends JFrame {
    private JLabel lblJdl, lblNmProduk,lblKtgrProduk, lblNmUser, lblDateIn,lblDateOut,lblJml ;
    private JTextField jtNmProduk,jtKtgrProduk, jtNmUser, jtDateIn,jtDateOut,jtJml ;
    private JButton btnsave, btnCancel, btnTopMn;
    private JTable tbl;
    private String s;
    private int a;
    private JPanel pane1,pane2,pane3,pane4,pane5,pane6;
    
    public Insert(){
        showBtnSave();
        showForm();
        
//        pane4 = new JPanel();
//        pane4.setLayout(new GridLayout(6,1));
//        
//        pane4.add(lblNmProduk);
//        pane4.add(lblKtgrProduk);
//        pane4.add(lblJml);
//        pane4.add(lblDateIn);
//        pane4.add(lblDateOut);
//        pane4.add(lblNmUser);
        
        pane3 = new JPanel();
        GroupLayout layout = new GroupLayout(pane3);          
        pane3.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblNmProduk)
                .addComponent(lblKtgrProduk)
                .addComponent(lblJml)
                .addComponent(lblDateIn)
                .addComponent(lblDateOut)
                .addComponent(lblNmUser))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(jtNmProduk)
                .addComponent(jtKtgrProduk)
                .addComponent(jtJml)
                .addComponent(jtDateIn)
                .addComponent(jtDateOut)
                .addComponent(jtNmUser))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblNmProduk)
                .addComponent(jtNmProduk))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblKtgrProduk)
                .addComponent(jtKtgrProduk))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblJml)
                .addComponent(jtJml))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblDateIn)
                .addComponent(jtDateIn))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblDateOut)
                .addComponent(jtDateOut))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblNmUser)
                .addComponent(jtNmUser))
        );
        
//        pane3.setLayout(new GridLayout(6,1));
//        pane3.add(jtNmProduk);
//        pane3.add(jtKtgrProduk);
//        pane3.add(jtJml);
//        pane3.add(jtDateIn);
//        pane3.add(jtDateOut);
//        pane3.add(jtNmUser);
        
        pane2 = new JPanel();
        pane2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pane2.add(btnCancel);
        pane2.add(btnsave);
        
        pane5 = new JPanel();
        pane5.add(btnTopMn);
        
        pane6 = new JPanel();
        pane6.add(lblJdl);
        
        pane1 = new JPanel();
        pane1.setLayout(new BorderLayout());
        pane1.add(pane2, BorderLayout.SOUTH);
//        pane1.add(pane4, BorderLayout.WEST);
        pane1.add(pane3, BorderLayout.CENTER);
        pane1.add(pane5, BorderLayout.EAST);
        pane1.add(pane6, BorderLayout.NORTH);
        
        add(pane1);
        setTitle("My Admin");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void showBtnSave(){
        btnTopMn = new JButton("Main Menu");
        btnTopMn.setFont(new Font("Arial",Font.BOLD,14));
        btnTopMn.setBackground(Color.cyan);
        
        btnsave = new JButton("Save");
        btnsave.setFont(new Font("Arial",Font.BOLD,14));
        btnsave.setBackground(Color.GREEN);
        
        btnCancel = new JButton("Clear");
        btnCancel.setFont(new Font("Arial",Font.BOLD,14));
        btnCancel.setBackground(Color.red);
    }
    
    private void showForm(){
        lblJdl = new JLabel("Input Data");
        lblJdl.setFont(new Font("Arial",Font.BOLD,36));
        lblJdl.setBackground(Color.BLUE);
        
        lblNmProduk= new JLabel("Nama Produk"); 
        lblKtgrProduk= new JLabel("Kategori Produk");
        lblNmUser= new JLabel("Nama User");
        lblDateIn= new JLabel("Tanggal Masuk");
        lblDateOut= new JLabel("Tanggal Keluar");
        lblJml= new JLabel("Jumlah Barang");
        
        lblNmProduk.setFont(new Font("Arial",Font.BOLD,14)); 
        lblKtgrProduk.setFont(new Font("Arial",Font.BOLD,14));
        lblNmUser.setFont(new Font("Arial",Font.BOLD,14));
        lblDateIn.setFont(new Font("Arial",Font.BOLD,14));
        lblDateOut.setFont(new Font("Arial",Font.BOLD,14));
        lblJml.setFont(new Font("Arial",Font.BOLD,14));
        
        jtNmProduk= new JTextField(20);
        jtKtgrProduk= new JTextField(20);
        jtNmUser= new JTextField(20);
        jtDateIn= new JTextField(20);
        jtDateOut= new JTextField(20);
        jtJml= new JTextField(20);
    }
    
}
//
//layout.putConstraint(SpringLayout.WEST, lblNmProduk, 5, SpringLayout.WEST, pane2);
//        layout.putConstraint(SpringLayout.NORTH, lblNmProduk, 5, SpringLayout.NORTH, pane2);
//        layout.putConstraint(SpringLayout.SOUTH, lblNmProduk, 10, SpringLayout.SOUTH, lblKtgrProduk);
//        
//        layout.putConstraint(SpringLayout.WEST, jtNmProduk, 20, SpringLayout.EAST, lblNmProduk);
//        layout.putConstraint(SpringLayout.NORTH, jtNmProduk, 5, SpringLayout.NORTH, pane2);
//        
//        layout.putConstraint(SpringLayout.WEST, lblKtgrProduk, 5, SpringLayout.WEST, pane2);
//        layout.putConstraint(SpringLayout.SOUTH, lblKtgrProduk, 10, SpringLayout.SOUTH, lblJml);
//        
//        layout.putConstraint(SpringLayout.WEST, jtKtgrProduk, 20, SpringLayout.EAST, lblKtgrProduk);
//        layout.putConstraint(SpringLayout.NORTH, jtKtgrProduk, 5, SpringLayout.NORTH, jtNmProduk);