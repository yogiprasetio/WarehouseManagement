package warehousemanajemen.view;

import controller.*;
import model.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Insert extends JFrame {

    private JLabel lblJdl, lblJdl1, lblNmProduk, lblKtgrProduk, lblNmUser, lblDateIn, lblDateOut, lblJml, jlblNmUser;
    private JTextField jtNmProduk, jtKtgrProduk, jtDateIn, jtDateOut, jtJml;
    private JButton btnsave, btnCancel, btnTopMn, btnUpdate, btnDelete, btnUpdate1;
    private JTable tbllIST;
    private String s;
    private int a;
    JPanel pane1;
    JPanel pane2;
    JPanel pane3;
    JPanel pane4;
    JPanel pane5;
    JPanel pane6;
    private static Object[] col = {"Id Produk", "Nama Produk", "Kategori", "jumlah", "date In", "Date Out", "PIC"};
    private static Object[][] row = {};
    private JTableHeader header = new JTableHeader();
    contTransaksi transaksi;

    public Insert() throws SQLException {
        this.transaksi = new contTransaksi();
        this.showTblList();
        showBtnSave();
        showForm();
        showPane2();
        showPane3();
        showPane4();
        showPane5();
        showPane6();

        pane1 = new JPanel();
        pane1.setLayout(new BorderLayout());
        pane1.add(pane2, BorderLayout.SOUTH);
        pane1.add(pane3, BorderLayout.WEST);
        pane1.add(pane4, BorderLayout.CENTER);
        pane1.add(pane5, BorderLayout.EAST);
        pane1.add(pane6, BorderLayout.NORTH);

        add(pane1);
        setTitle("My Admin");
        setSize(1350, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void showTblList() throws SQLException{
        DefaultTableModel table = new DefaultTableModel(row,col);
        table.setRowCount(0);
        System.out.println("show");
        for ( transaksi tr : this.transaksi.getTransaksi()) {
            String id = String.valueOf(tr.getId());
            String jumlah = String.valueOf(tr.getJumlah());
            String user = String.valueOf(tr.getUser());
            String tgl_masuk;
            if(tr.getTgl_masuk() == null){
                tgl_masuk = "-";
            }
            else{
                tgl_masuk = new SimpleDateFormat("dd/MM/yyyy").format(tr.getTgl_masuk());
            }
            
            String tgl_keluar;
            if(tr.getTgl_keluar() == null){
                tgl_keluar = "-";
            }
            else{
                tgl_keluar = new SimpleDateFormat("dd/MM/yyyy").format(tr.getTgl_keluar());
            }
            table.addRow(new String[]{id, tr.getProduk(), tr.getKategori(), jumlah, tgl_masuk, tgl_keluar, user});
        }
        tbllIST = new JTable(table);
        header = tbllIST.getTableHeader();
        header.setBackground(Color.YELLOW);
        header.setBounds(20, 10, 760, 20);
        tbllIST.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbllIST.setBackground(Color.lightGray);
        tbllIST.getColumnModel().getColumn(0).setPreferredWidth(70);
        tbllIST.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbllIST.getColumnModel().getColumn(2).setPreferredWidth(80);
        tbllIST.getColumnModel().getColumn(3).setPreferredWidth(75);
        tbllIST.getColumnModel().getColumn(4).setPreferredWidth(75);
        tbllIST.getColumnModel().getColumn(5).setPreferredWidth(100);
        tbllIST.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Choose you're action for UPDATE or DELETE this data ...");
                btnUpdate.setVisible(true);
                btnDelete.setVisible(true);
            }
            
        });
        tbllIST.setCellEditor(null);
        tbllIST.setBounds(0,0,500,620);
    }
    
    private void showBtnSave(){
        btnTopMn = new JButton("Log Out");
        btnTopMn.setFont(new Font("Arial",Font.BOLD,14));
        btnTopMn.setBackground(Color.RED);
    
        btnTopMn = new JButton("Log Out");
        btnTopMn.setFont(new Font("Arial", Font.BOLD, 14));
        btnTopMn.setBackground(Color.cyan);
        btnTopMn.setBounds(0, 0, 40, 5);

        btnUpdate1 = new JButton("Update");
        btnUpdate1.setFont(new Font("Arial", Font.BOLD, 14));
        btnUpdate1.setBackground(Color.cyan);
        btnUpdate1.setEnabled(false);
        btnUpdate1.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                try {
                    btnUpdateAction(e);
                } catch (SQLException ex) {
                    Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
                }
                btnUpdate1.setEnabled(false);
                btnsave.setEnabled(true);
                btnUpdate.setEnabled(true);
                jtDateIn.setEditable(true);
                JOptionPane.showMessageDialog(null, "Update Succesfully !");
                try {
                    showTblList();
                } catch (SQLException ex) {
                    Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
                }
        }  
    });
        
        
        btnUpdate = new JButton("Update list Barang");
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 14));
        btnUpdate.setBackground(Color.cyan);
        btnUpdate.setBounds(0, 0, 50, 10);
        btnUpdate.setVisible(false);
        btnUpdate.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                btnSetUpdateAction(e);
                jtDateOut.setEnabled(true);
                btnUpdate1.setEnabled(true);
                btnsave.setEnabled(false);
                btnUpdate.setEnabled(false);
        }  
    });
        
        btnDelete = new JButton("Delete List Barang");
        btnDelete.setFont(new Font("Arial",Font.BOLD,14));
        btnDelete.setBackground(Color.cyan);
        btnDelete.setBounds(0, 0, 40, 5);
        btnDelete.setVisible(false);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnDeleteAction(e);
                } catch (SQLException ex) {
                    Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Data has been DELETED !");
                btnDelete.setVisible(false);
                
            }
        });
        
        btnsave = new JButton("ADD Stock");
        btnsave.setFont(new Font("Arial",Font.BOLD,14));
        btnsave.setBackground(Color.GREEN);
        btnsave.setEnabled(true);
        btnsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    CreateData(ae);
//                    showTblList();
                } catch (SQLException ex) {
                    Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Data failed to save !");
                }
            }
        });
        
        btnCancel = new JButton("Clear");
        btnCancel.setFont(new Font("Arial",Font.BOLD,14));
        btnCancel.setBackground(Color.red);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               jtNmProduk.setText("");
                jtKtgrProduk.setText("");
                jtDateIn.setText("");
                jtDateOut.setText("");
                jtJml.setText("");
                btnUpdate.setEnabled(true);
                
            }
            
        });
    }
    
    private void btnSetUpdateAction(ActionEvent e){
        
//        String data = (String) this.tbllIST.getValueAt(this.tbllIST.getSelectedRow(), 0);
        this.jtNmProduk.setText(this.tbllIST.getValueAt(this.tbllIST.getSelectedRow(), 1).toString());
        this.jtKtgrProduk.setText(this.tbllIST.getValueAt(this.tbllIST.getSelectedRow(), 2).toString());
        this.jtJml.setText(this.tbllIST.getValueAt(this.tbllIST.getSelectedRow(), 3).toString());
        this.jtDateIn.setEditable(false);
        this.jtDateOut.setText(this.tbllIST.getValueAt(this.tbllIST.getSelectedRow(), 5).toString());
//        this.lblNmUser.setText(this.tbllIST.getValueAt(this.tbllIST.getSelectedRow(), 5).toString());

        
    }
    
    private void btnUpdateAction(ActionEvent e) throws SQLException {
                transaksi trans = new transaksi();
                trans.setId(Integer.parseInt(this.tbllIST.getValueAt(this.tbllIST.getSelectedRow(), 0).toString()));
                trans.setProduk(this.jtNmProduk.getText());
                trans.setKategori(this.jtKtgrProduk.getText());
                trans.setJumlah(Integer.parseInt(this.jtJml.getText()));
//                trans.setTgl_masuk(new Date((String) this.tbllIST.getValueAt(this.tbllIST.getSelectedRow(), 4)));
                System.out.println("tgl_keluar : " + this.jtDateOut.getText());
                trans.setTgl_keluar(new Date(this.jtDateOut.getText()));
                System.out.println("tgl_keluar1 : " + trans.getTgl_keluar());
                this.transaksi.updateTransaksi(trans);
                this.showTblList();
            }
    
    private void btnDeleteAction(ActionEvent e) throws SQLException{
        this.transaksi.deleteTransaksi(Integer.parseInt(this.tbllIST.getValueAt(this.tbllIST.getSelectedRow(), 0).toString()));
        this.showTblList();
    }
    
    private void CreateData(ActionEvent e) throws SQLException {
        transaksi tr = new transaksi();
        try {
            tr.setProduk(this.jtNmProduk.getText());
            tr.setKategori(this.jtKtgrProduk.getText());
            tr.setJumlah(Integer.parseInt(this.jtJml.getText()));
//            String tgl = new SimpleDateFormat("yyyy-MM-dd").format(this.jtDateIn.getText());
            Date tgl = new Date(this.jtDateIn.getText());
            System.out.println("tgl : " + this.jtDateIn.getText() + "Jadi : " + tgl);
            tr.setTgl_masuk(new Date(this.jtDateIn.getText()));
//            tr.setTgl_keluar(new Date(this.jtDateOut.getText()));
            System.out.println("tgl Masuk : " + tr.getTgl_masuk());
            this.transaksi.insertTransaksi(tr);
            this.showTblList();
        } catch (Exception err) {
            System.out.println("Error : " + err);
            this.showTblList();
        }
        this.showTblList();
        
    }
    
    private void showForm(){
        lblJdl = new JLabel("Warehouse Management");
        lblJdl.setFont(new Font("Arial",Font.BOLD,36));
        lblJdl.setForeground(Color.BLUE);
        
        lblJdl1 = new JLabel("Beta Version");
        lblJdl1.setFont(new Font("Arial",Font.BOLD,14));
        lblJdl1.setForeground(Color.red);
        
        lblNmProduk= new JLabel("Nama Produk"); 
        lblKtgrProduk= new JLabel("Kategori Produk");
        lblNmUser= new JLabel("Nama User");
        lblDateIn= new JLabel("Tanggal Masuk");
        lblDateOut= new JLabel("Tanggal Keluar");
        lblJml= new JLabel("Jumlah Barang");
        /* isi dari database username*/
        jlblNmUser = new JLabel("Lorem");
        
        
        lblNmProduk.setFont(new Font("Arial",Font.BOLD,14)); 
        lblKtgrProduk.setFont(new Font("Arial",Font.BOLD,14));
        lblNmUser.setFont(new Font("Arial",Font.BOLD,14));
        lblDateIn.setFont(new Font("Arial",Font.BOLD,14));
        lblDateOut.setFont(new Font("Arial",Font.BOLD,14));
        lblJml.setFont(new Font("Arial",Font.BOLD,14));
        
        jtNmProduk= new JTextField(20);
        jtKtgrProduk= new JTextField(20);
        jtDateIn= new JTextField(20);
        jtDateOut= new JTextField(20);
        jtDateOut.setEnabled(false);
        jtJml= new JTextField(20);
    }
    
    

    private void showPane3() {
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
                .addComponent(lblNmUser)
                .addComponent(btnCancel))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(jtNmProduk)
                .addComponent(jtKtgrProduk)
                .addComponent(jtJml)
                .addComponent(jtDateIn)
                .addComponent(jtDateOut)
                .addComponent(jlblNmUser, GroupLayout.Alignment.LEADING)
                .addComponent(btnsave,GroupLayout.Alignment.LEADING)
                .addComponent(btnUpdate1,GroupLayout.Alignment.TRAILING))
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
                .addComponent(jlblNmUser))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnCancel)
                .addComponent(btnsave)
                .addComponent(btnUpdate1))
        );    
    }

    private void showPane4() {
        pane4 = new JPanel();
        pane4.add(header);
        pane4.add(tbllIST);
    }

    private void showPane5() {
        pane5 = new JPanel();
        pane5.setLayout(new GridLayout(12, 1, 10, 5));
        pane5.add(btnUpdate);
        pane5.add(btnDelete);    
    
    }

    private void showPane2() {
        pane2 = new JPanel();
        pane2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pane2.add(btnTopMn);
           
    }

    private void showPane6() {
        pane6 = new JPanel();
        pane6.add(lblJdl);
        pane6.add(lblJdl1);
        
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