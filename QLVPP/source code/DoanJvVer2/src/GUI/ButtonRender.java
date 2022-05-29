/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChuongTrinhGiamBUS;
import BUS.MonanBUS;
import DTO.HoadonDTO;
import DTO.MonanDTO;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
//import static BUS.HoadonBUS.idhd;
import static GUI.ThanhtoanGUI.idnv1;
import static GUI.ThanhtoanGUI.idhd1;
import static GUI.ThanhtoanGUI.carttable;
import DTO.ChiTietGiamDTO;
import static BUS.ChiTietGiamBUS.dschitiet;
import BUS.HoadonBUS;
import DTO.ChuongTrinhGiamDTO;
import java.util.ArrayList;
import static BUS.HoadonBUS.giohang;
import static BUS.HoadonBUS.tongtien;
import static GUI.OverallFrame.currentIdnv;
import static GUI.ThanhtoanGUI.idhd1;
/**
 *
 * @author USER
 */
public class ButtonRender extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JButton renderbtn;
    private JTable table;
    private String idnv,idhd,ngaylap;
    private int sl;
    private DefaultTableModel cartmodel;
    private String[] cartheader = {"IDNV","IDHD","Tên món ăn","Đơn giá","Số lượng","Thành tiền","Tổng tiền",""};
    private boolean loop=false;

    public ButtonRender(JTable table,String ngaylap){
        this.table = table;
        this.ngaylap = ngaylap;
        renderbtn = new JButton();
        renderbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HoadonBUS hdbus = new HoadonBUS();
                    try{
                        String idl = JOptionPane.showInputDialog("Nhập số lượng");
                        sl = Integer.parseInt(idl);     
                        if(sl < 1){
                            JOptionPane.showMessageDialog(null,"Số lượng phải lớn hơn 0",null,JOptionPane.ERROR_MESSAGE); 
                        }else{ 
                            int i = table.getSelectedRow();
                            String tenmonan = table.getValueAt(i,0).toString();
                            String giamgia = table.getValueAt(i,4).toString();
                            int sl1 = Integer.parseInt(table.getValueAt(i,3).toString());
                            table.setValueAt((sl1-sl),i,3);
                            hdbus.addCart(currentIdnv,idhd1,tenmonan,sl,ngaylap);
                            loadCart();
                        }    
                    }catch(NumberFormatException err){
                        JOptionPane.showMessageDialog(null,"Hãy nhập số lượng",null,JOptionPane.ERROR_MESSAGE);
                    }
                    
            }
        });
    }
    
    public void loadCart(){
        ImageIcon removeicon = new ImageIcon(this.getClass().getResource("/Icons/removeicon.png"));
        cartmodel = new DefaultTableModel(cartheader,0){
            public boolean isCellEditable(int row,int col){
                if(col == 7){
                    return true;
                }return false;
            }
        };
        carttable.setModel(cartmodel);
        carttable.getColumnModel().getColumn(7).setCellRenderer(new RemoveButtonRender());
        carttable.getColumnModel().getColumn(7).setCellEditor(new RemoveButtonRender());
        for(HoadonDTO hd : giohang){
            Object[] data = {hd.getIdnv(),hd.getIdhd(),
                hd.getTenmonan(),hd.getDongia(),hd.getSoluong(),hd.getDongia()*hd.getSoluong(),tongtien,removeicon};
            cartmodel.addRow(data);
        }
        carttable.getColumnModel().getColumn(7).setPreferredWidth(50);
        carttable.getColumnModel().getColumn(2).setPreferredWidth(150);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof Icon) renderbtn.setIcon((Icon)value);
        return renderbtn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Icon) renderbtn.setIcon((Icon)value);
        return renderbtn;
    }
     
    @Override
        public Object getCellEditorValue() {
            return null;
        }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}