/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BUS.HoadonBUS;
import BUS.MonanBUS;
import BUS.chitiethoadonBUS;
import DTO.HoadonDTO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JTextFieldDateEditor;
import DTO.ChiTietGiamDTO;
import DTO.chitiethoadonDTO;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MY PC
 */
public class hoadonGUI extends javax.swing.JPanel {
DefaultTableModel model =new DefaultTableModel();
DefaultTableModel modelTb2 =new DefaultTableModel();
ImageIcon xemchitiet
            = new ImageIcon("./src/img/icons8-view-more-30 (1).png");
    /**
     * Creates new form hoadonGUI
     */
    public hoadonGUI() {
        initComponents();
        FormatTable render = new FormatTable();
        render.formatTablenoIcon(tablehoadon);
        render.formatTablenoIcon(tableChitiet);
        inTable();
    }

    
    public void inTable()//doc du lieu in vao table
    {
        try
        {
        //render();
        HoadonBUS bus = new HoadonBUS();
        bus.dochoadon(OverallFrame.currentIdnv);
            int rowCount = model.getRowCount();//remove all row
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
        Vector header = new Vector();
        header.add("ID Hóa đơn");
        header.add("ID Nhân viên");
        header.add("Ngày lập");
        header.add("Tổng tiền");
        header.add("Trạng thái");
        if (model.getRowCount()==0)
            { 
                model=new DefaultTableModel(header,0);
            } 
        for(HoadonDTO ct : HoadonBUS.dshd)
        {
                Vector row = new Vector();
                row.add(ct.getIdhd());
                row.add(ct.getIdnv());
                row.add(ct.getNgaylap());
                row.add(ct.getTongtien());
                row.add("Thành công");
                model.addRow(row);
        }
        //add model to jtable
        tablehoadon.setModel(model);
        
        } catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Lỗi đọc hóa đơn");
        }
    }

    
    public void docChitiet()
    {
        int j = tablehoadon.getSelectedRow();
        
        chitiethoadonBUS bus = new chitiethoadonBUS();
        chitiethoadonDTO dto = new chitiethoadonDTO();
        bus.docChitiet1((String)tablehoadon.getValueAt(j, 0));
        
            int rowCount = modelTb2.getRowCount();//remove all row
            for (int i = rowCount - 1; i >= 0; i--) {
                modelTb2.removeRow(i);
            }
            Vector header = new Vector();
        header.add("Id hóa đơn");
        header.add("Id Món");
        header.add("Số lượng");
        header.add("Đơn giá");
        header.add("Thành tiền");
        
        if (modelTb2.getRowCount()==0)
            { 
                modelTb2=new DefaultTableModel(header,0);
            } 
        for(chitiethoadonDTO ct : chitiethoadonBUS.dschitiet1)
        {
            
            Vector row = new Vector();
                row.add(ct.getIdhd());
                row.add(ct.getIdmon());
                row.add(ct.getSoluong());
                row.add(ct.getDongia());
                row.add(ct.getThanhtien());
                modelTb2.addRow(row);
        }
        tableChitiet.setModel(modelTb2);
    }
    public void timkiem(ArrayList<HoadonDTO> arr)
    {
        //hien thong tin tim kiem
    int rowCount = model.getRowCount();//remove all row
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
        Vector header = new Vector();
        header.add("ID Hóa đơn");
        header.add("ID Nhân viên");
        header.add("Ngày lập");
        header.add("Tổng tiền");
        header.add("Trạng thái");

        if (model.getRowCount()==0)
            { 
                model=new DefaultTableModel(header,0);
            } 
        for(HoadonDTO ct : arr)//duyet arr chua cac ket qua tìm kiếm
        {
                Vector row = new Vector();
                row.add(ct.getIdhd());
                row.add(ct.getIdnv());
                row.add(ct.getNgaylap());
                row.add(ct.getTongtien());
                row.add("Thành công");

                model.addRow(row);
        }
        //add model to jtable
        tablehoadon.setModel(model);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        docBtn = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JLabel();
        ChitietBtn = new javax.swing.JLabel();
        timkiemIcon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablehoadon = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableChitiet = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(950, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(950, 650));

        leftPanel.setBackground(new java.awt.Color(0, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-check-50.png"))); // NOI18N
        jLabel1.setText("Lịch sử bán hàng");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Danh sách hóa đơn");

        docBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-process-35.png"))); // NOI18N
        docBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        docBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                docBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                docBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                docBtnMouseExited(evt);
            }
        });

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-delete-35.png"))); // NOI18N
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteBtnMouseExited(evt);
            }
        });

        ChitietBtn.setBackground(new java.awt.Color(255, 153, 0));
        ChitietBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ChitietBtn.setForeground(new java.awt.Color(255, 255, 255));
        ChitietBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ChitietBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-back-arrow-30.png"))); // NOI18N
        ChitietBtn.setText("Quay lại");
        ChitietBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ChitietBtn.setOpaque(true);
        ChitietBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChitietBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ChitietBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ChitietBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(docBtn)
                .addGap(18, 18, 18)
                .addComponent(deleteBtn)
                .addContainerGap(164, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(ChitietBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ChitietBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(docBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );

        timkiemIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-search-35.png"))); // NOI18N
        timkiemIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        timkiemIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timkiemIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                timkiemIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                timkiemIconMouseExited(evt);
            }
        });

        tablehoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Hóa đơn", "ID Nhân viên", "Ngày lập", "Tổng tiền", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablehoadon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablehoadon.setRowHeight(20);
        tablehoadon.setShowVerticalLines(false);
        tablehoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablehoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablehoadon);

        tableChitiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id hóa đơn", "Id món", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(tableChitiet);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Chi tiết hóa đơn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(649, 649, 649)
                                .addComponent(timkiemIcon))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel3))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(timkiemIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(216, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 962, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void timkiemIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timkiemIconMouseClicked
//        // TODO add your handling code here:
//        HoadonBUS bus = new HoadonBUS();
//        if(combobox.getSelectedItem().equals("All"))
//        {
//            //thêm txt cần tìm vào hàm timtheo... của bus sau đó truyền hàm đó vào hàm timkiem ở gui de in len jtable
//            timkiem(bus.timtheoAll(txtTimkiem.getText()));
//        }
//        if(combobox.getSelectedItem().equals("id hd"))
//        {
//            //thêm txt cần tìm vào hàm timtheo... của bus sau đó truyền hàm đó vào hàm timkiem ở gui de in len jtable
//            timkiem(bus.timtheoMa(txtTimkiem.getText()));
//        }
//        if(combobox.getSelectedItem().equals("ngaylap"))
//        {
//            //thêm txt cần tìm vào hàm timtheo... của bus sau đó truyền hàm đó vào hàm timkiem ở gui de in len jtable
//            timkiem(bus.timtheongaylap(txtTimkiem.getText()));
//        }
//

    }//GEN-LAST:event_timkiemIconMouseClicked

    private void timkiemIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timkiemIconMouseEntered
        // TODO add your handling code here:
        timkiemIcon.getDisabledIcon();
        ImageIcon logo = new ImageIcon("./src/img/search.png");
        timkiemIcon.setIcon(logo);
    }//GEN-LAST:event_timkiemIconMouseEntered

    private void timkiemIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timkiemIconMouseExited
        // TODO add your handling code here:
        timkiemIcon.getDisabledIcon();
        ImageIcon logo = new ImageIcon("./src/img/icons8-search-35.png");
        timkiemIcon.setIcon(logo);
    }//GEN-LAST:event_timkiemIconMouseExited

    private void docBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docBtnMouseClicked
        // TODO add your handling code here:
        inTable();
        int rowCount = modelTb2.getRowCount();//remove all row
            for (int i = rowCount - 1; i >= 0; i--) 
            {
                modelTb2.removeRow(i);
            }
    }//GEN-LAST:event_docBtnMouseClicked

    private void docBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docBtnMouseEntered
        // TODO add your handling code here:
        docBtn.getDisabledIcon();
        ImageIcon logo = new ImageIcon("./src/img/icons8-process-35 (1).png");
        docBtn.setIcon(logo);
    }//GEN-LAST:event_docBtnMouseEntered

    private void docBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docBtnMouseExited
        // TODO add your handling code here:
        docBtn.getDisabledIcon();
        ImageIcon logo = new ImageIcon("./src/img/icons8-process-35.png");
        docBtn.setIcon(logo);
    }//GEN-LAST:event_docBtnMouseExited

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        // TODO add your handling code here:
        //delete click
//        try
//        {
            if(tablehoadon.getSelectionModel().isSelectionEmpty())//neu khong chọn row trong table
            {
                JOptionPane.showMessageDialog(null, "Chưa chọn mã cần xóa");
            } else
            {
                int yn = JOptionPane.showConfirmDialog(
                    null,
                    "Bạn có chắc hủy hóa đơn này?",
                    "Are you sure?",
                    JOptionPane.YES_NO_OPTION);
                if (yn == JOptionPane.YES_OPTION)
                {
                    int  i=tablehoadon.getSelectedRow();
                        HoadonDTO dto = new HoadonDTO();
                        //dto.setIdhd(txtidhd.getText());
                        int rowCount = modelTb2.getRowCount();
                    for (int k = 0; k < rowCount; k++) {
                        //công lại tồn kho
                        MonanBUS monan = new MonanBUS();
                        monan.congTonkho((int) (tableChitiet.getValueAt(k, 2)),
                                (String) tableChitiet.getValueAt(k, 1));
                        //trừ so lượng da bán
                        monan.truSoluongdaban((int) (tableChitiet.getValueAt(k, 2)),
                                (String) tableChitiet.getValueAt(k, 1));
                    }
                        HoadonBUS bus = new HoadonBUS();
                    bus.xoaHoadon((String)tablehoadon.getValueAt(i,0));
                    //remove o table
                    model.removeRow(i);
                    int rowCount1 = modelTb2.getRowCount();//remove all row
                    for (int dem = rowCount1 - 1; dem >= 0; dem--) {
                        modelTb2.removeRow(dem);
                    }
                } 
            }

//        } catch(Exception e)
//        {
//            System.out.println("Loi xóa");
//            System.out.println(e);
//        }
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseEntered
        // TODO add your handling code here:
        deleteBtn.getDisabledIcon();
        ImageIcon logo = new ImageIcon("./src/img/icons8-delete-35 (1).png");
        deleteBtn.setIcon(logo);
    }//GEN-LAST:event_deleteBtnMouseEntered

    private void deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseExited
        // TODO add your handling code here:
        deleteBtn.getDisabledIcon();
        ImageIcon logo = new ImageIcon("./src/img/icons8-delete-35.png");
        deleteBtn.setIcon(logo);
    }//GEN-LAST:event_deleteBtnMouseExited

    private void tablehoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablehoadonMouseClicked
        // TODO add your handling code here:
        docChitiet();
    }//GEN-LAST:event_tablehoadonMouseClicked

    private void ChitietBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChitietBtnMouseClicked
        // TODO add your handling code here:
        OverallFrame.changeMainInfo(8);
    }//GEN-LAST:event_ChitietBtnMouseClicked

    private void ChitietBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChitietBtnMouseEntered
        // TODO add your handling code here:
        ChitietBtn.getDisabledIcon();
        ImageIcon logo = new ImageIcon("./src/img/icons8-back-arrow-30.png");
        ChitietBtn.setIcon(logo);
        ChitietBtn.setBackground(Color.blue);
    }//GEN-LAST:event_ChitietBtnMouseEntered

    private void ChitietBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChitietBtnMouseExited
        // TODO add your handling code here:
        ChitietBtn.getDisabledIcon();
        ImageIcon logo = new ImageIcon("./src/img/icons8-back-arrow-30.png");
        ChitietBtn.setIcon(logo);
        ChitietBtn.setBackground(new Color(255, 153, 0));
    }//GEN-LAST:event_ChitietBtnMouseExited

public static void main(String[] args) {
        JFrame j = new JFrame();
        j.setSize(1000,700);
        j.setLayout(null);
        JPanel p =new hoadonGUI();
        p.setBounds(0, 0, 960, 700);
        //j.add(g);
        //j.pack();
        j.add(p);
        j.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ChitietBtn;
    private javax.swing.JLabel deleteBtn;
    private javax.swing.JLabel docBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JTable tableChitiet;
    private javax.swing.JTable tablehoadon;
    private javax.swing.JLabel timkiemIcon;
    // End of variables declaration//GEN-END:variables
}
