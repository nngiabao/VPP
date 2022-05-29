/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/**
 *
 * @author Nam
 */
public class thongketong extends JPanel{
    public thongketong(){
        JTabbedPane tabbedPane = new JTabbedPane();
        setSize(950,650);
        setLayout(new FlowLayout());
        tabbedPane.setPreferredSize(new Dimension(950,650));
        ThongkehoadonGUI hoadonGUI = new ThongkehoadonGUI();
        ThongkephieunhapGUI phieunhapGUI = new ThongkephieunhapGUI();
        JPanel p1 = new ThongkehoadonGUI();
        JPanel p2 = new ThongkephieunhapGUI();
        tabbedPane.add("Thong ke hoa don",p1);
        tabbedPane.add("Thong ke phieu nhap",p2);
        
        add(tabbedPane);
     
       
        
    }
    public static void main(String[] args) {
        thongketong a = new thongketong();
        a.setVisible(true);
        
    }
}
