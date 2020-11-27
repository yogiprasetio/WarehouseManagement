package com.warehousemanajemen.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author alyho
 */
public class Update extends Insert {
    
    public Update(){
        
        
        pane1 = new JPanel();
        pane1.setLayout(new BorderLayout());
        pane1.add(pane2, BorderLayout.SOUTH);
        pane1.add(pane3, BorderLayout.WEST);
        pane1.add(pane4, BorderLayout.CENTER);
        pane1.add(pane5, BorderLayout.EAST);
        pane1.add(pane6, BorderLayout.NORTH);
        
        add(pane1);
        setTitle("My Admin");
        setSize(1150,720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}