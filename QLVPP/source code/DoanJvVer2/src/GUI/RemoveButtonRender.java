/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.HoadonBUS;
import DTO.HoadonDTO;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.Icon;
import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.*;
import static GUI.ThanhtoanGUI.carttable;
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import static BUS.HoadonBUS.tongtien;
/**
 *
 * @author USER
 */
public class RemoveButtonRender extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JTable table;
    private JButton removebtn;
    ThanhtoanGUI a;
    public RemoveButtonRender(){
        this.table = table;
        removebtn = new JButton();
        removebtn.setOpaque(false);
        removebtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HoadonDTO spxoa = new HoadonDTO();
                int answer = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Thông báo",JOptionPane.WARNING_MESSAGE);
                if(answer == JOptionPane.YES_OPTION){
                    DefaultTableModel tablemodel = (DefaultTableModel) carttable.getModel();
                    int i = carttable.getSelectedRow();
                    String tenmonan = carttable.getValueAt(i,2).toString();
  
                    int soluong = Integer.parseInt(carttable.getValueAt(i,4).toString());
                    a = new ThanhtoanGUI();
                    /*for(int j=0;j<a.searchtable.getRowCount();j++){
                        if(tenmonan.equals(a.searchtable.getValueAt(j,0).toString())){
                            int sl1 = Integer.parseInt(a.searchtable.getValueAt(j,3).toString());
                            a.searchtable.setValueAt((sl1+soluong),i,3);
                        }
                    }*/
                    HoadonBUS bus = new HoadonBUS();
                    bus.removeCart(tenmonan,soluong);
                    tablemodel.removeRow(i);
                    JOptionPane.showMessageDialog(null,"Bạn đã xóa thành công");
                    for(int j=0;j<carttable.getRowCount();j++){
                        carttable.setValueAt(tongtien,j,6);
                    }
                    a.loadDsmonan();
                    stopCellEditing();
                }
            }   
        }); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        stopCellEditing();
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof Icon) removebtn.setIcon((Icon)value);
        return removebtn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Icon) removebtn.setIcon((Icon)value);
        return removebtn;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }

    @Override
    public void cancelCellEditing() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {
    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {
    }
    
    @Override
    public void fireEditingStopped(){
    }
    
}
