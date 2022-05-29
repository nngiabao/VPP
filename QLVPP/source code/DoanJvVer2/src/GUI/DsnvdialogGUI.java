/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.TableModel;
import GUI.ThanhtoanGUI;
import BUS.nhanvienBUS;
import static BUS.nhanvienBUS.dsnv;
import DTO.nhanvienDTO;
import static GUI.ThanhtoanGUI.idnv1;
/**
 *
 * @author USER
 */
public class DsnvdialogGUI extends JDialog implements MouseListener{
    DefaultTableModel model;
    JTable table;
    String[] header = {"IDNV","Họ","Tên","Số điện thoại","Email","Địa chỉ","Lương"};
    JScrollPane jsp;
    OverallFrame home;
    
    public DsnvdialogGUI(JFrame parent,boolean modal){
        super(parent,modal);
        setTitle("Danh sách nhân viên");
        setSize(600,400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        parent = (OverallFrame) home;

        model = new DefaultTableModel(header,0){
            public boolean isCellEditable(int row,int col){
                return false; 
            }
        };
        table = new JTable(model);
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                tableMouseClicked(e);
            }
        });
        jsp = new JScrollPane(table);
        jsp.setPreferredSize(new Dimension(600,300));
        add(jsp);
        loadDsnv();
    }   

    public void tableMouseClicked(MouseEvent e){
        //int a = JOptionPane.showConfirmDialog(null,"Bạn có chắc chứ?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        int i = table.getSelectedRow();
        TableModel model = table.getModel();
        idnv1 = model.getValueAt(i,0).toString();
        this.setVisible(false);
    }
    
    public void loadDsnv(){
        nhanvienBUS bus = new nhanvienBUS();
        if (dsnv == null) bus.docnhanvien();
        model = new DefaultTableModel(header,0);
        table.setModel(model);
        for(nhanvienDTO nv : dsnv){
            Object[] data ={nv.getIdnv(),nv.getFname(),nv.getLname(),nv.getPhone(),nv.getEmail(),
                nv.getAddress(),nv.getLuong()};
            model.addRow(data);
        }
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

}
