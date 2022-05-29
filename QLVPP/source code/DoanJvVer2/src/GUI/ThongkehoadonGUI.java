/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.HoadonBUS;
import BUS.MonanBUS;
import DTO.ComboBoxList;
import static GUI.ThanhtoanGUI.loaimonan;
import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import static BUS.MonanBUS.dsmonan;
import DTO.MonanDTO;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static BUS.HoadonBUS.dshoadon;
import DTO.HoadonDTO;
import com.toedter.calendar.JTextFieldDateEditor;

/**
 *
 * @author USER
 */
public class ThongkehoadonGUI extends JPanel implements ActionListener,MouseListener,ItemListener{
    private JTable datatable;
    private JLabel infolbl,printlbl,searchinfolbl,searchbtn,reloadbtn,ngaylaplbl,hyphenlbl,hyphenlbl1,
            tongtienlbl,infolbl2,idhdlbl,idnvlbl,tongtienlbl2,soldlbl,datelbl,datatablelbl,tongtiendetail,
            idhddetail,idnvdetail,solddetail,datedetail,soldlbl2,solddetail2;
    private JTextField idmontxt,tenmontxt,idloaitxt,dongiatxt,searchtxt,ngay1txt,ngay2txt,tien1txt,tien2txt,
            sold1txt,sold2txt,tonkho1txt,tonkho2txt,ngaylap2txt,ngaylap1txt;
    private JPanel infoPanel,tablePanel,searchPanel;
    private Font f = new Font("Arial",Font.BOLD,21);
    private Font f2 = new Font("Arial",Font.PLAIN,18);
    private JComboBox categorycb;
    private JCheckBox promotion;
    private String[] category = {"Tất cả","Theo IDHD","Theo IDNV","Theo ngày lập",
        "Theo tổng tiền"};
    private String[] hoadonheader = {"IDHD","IDNV","Ngày lập","Tổng tiền","S.Lượng đã bán"};
    private String[] detailheader = {"IDHD","ID món","Số lượng","Đơn giá","Thành tiền","Tổng tiền"};
    private JScrollPane jsp;
    private DefaultTableModel datamodel;
    private QuanlimonanGUI home;
    private ArrayList<MonanDTO> dstimkim;
    private int gia1,gia2,tonkho1,tonkho2,sold1,sold2,sl,tongtien,slsp,slnv,slid;
    private JDateChooser ngaylap1,ngaylap2;
    //private Icon editicon,removeicon;
    //public static String idmon,tenloai,idloai,tenmon,dongia,sldaban,giamgia,tonkho;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private ArrayList<String> dsidhd,dsidnv,dsngaylap;
    private static String ngaylap,idnv;
    private String datemin,datemax,idhd,ngay1,ngay2;
    private ImageIcon datatableicon,detailicon,idhdicon,idnvicon1,idnvicon2,dateicon,
            soldicon1,tienicon,soldicon2;
    
    public ThongkehoadonGUI(){
        init();
    }
    
    public void init(){
        setSize(950,650);
        setLayout(null);
        setBackground(new Color(0, 255, 204));
        //Panel tìm kiếm

        //searchPanel.setBackground(Color.yellow);
        ImageIcon foodinfoicon = new ImageIcon(this.getClass().getResource("/Icons/thongkelbl.png"));

        infolbl = new JLabel("Thống kê hóa đơn");
        infolbl.setIcon(foodinfoicon);
        infolbl.setFont(new Font("Arial",Font.BOLD,24));
        infolbl.setForeground(new Color(255,51,0));
        infolbl.setBounds(350,10,300,50);
       
        searchPanel = new JPanel(new FlowLayout(1,0,15));
        //searchPanel.setBackground(Color.yellow);
        searchPanel.setBounds(400,50,500,200);
        searchPanel.setBackground(new Color(0,255,204));
        //searchPanel.setBorder(new LineBorder(black,3,true));
        
        ImageIcon infoicon = new ImageIcon(this.getClass().getResource("/Icons/infoicon.png"));
        searchinfolbl = new JLabel("Thông tin tìm kiếm");
        
        searchinfolbl.setForeground(new Color(255,51,0));
        searchinfolbl.setIcon(infoicon);
        searchinfolbl.setFont(f);
        searchinfolbl.setPreferredSize(new Dimension(400,35));
        searchtxt = new JTextField(18);
        searchtxt.setPreferredSize(new Dimension(200,28));
        searchtxt.setEditable(false);
        searchbtn = new JLabel();
        searchbtn.setPreferredSize(new Dimension(30,28));
        ImageIcon searchicon1 = new ImageIcon(this.getClass().getResource("/Icons/searchicon1.png"));
        searchbtn.setIcon(searchicon1);
        searchbtn.addMouseListener(this);
        ImageIcon refreshicon1 = new ImageIcon(this.getClass().getResource("/Icons/refreshicon1.png"));
        reloadbtn = new JLabel(refreshicon1);
        reloadbtn.setPreferredSize(new Dimension(30,28));
        reloadbtn.addMouseListener(this);
        //combobox loại
        ImageIcon loaimonanicon = new ImageIcon(this.getClass().getResource("/Icons/foodcategoryicon.png"));
        categorycb = new JComboBox(category);
        categorycb.setPreferredSize(new Dimension(120,28));
        categorycb.addItemListener(this);
        //ngày
        ImageIcon hyphenicon = new ImageIcon(this.getClass().getResource("/Icons/hyphenicon.png"));
        dateicon = new ImageIcon(this.getClass().getResource("/Icons/calendericon.png"));
        ngaylaplbl = new JLabel("Theo ngày lập");
        ngaylaplbl.setIcon(dateicon);
        ngaylaplbl.setPreferredSize(new Dimension(180,30));
        ngaylaplbl.setFont(f2);
        ngaylap1 = new JDateChooser();
        ngaylap1.setForeground(red);
        ngaylap1.setDateFormatString("yyyy-MM-dd");
        ngaylap1.setPreferredSize(new Dimension(100,25));
        ngaylap2 = new JDateChooser();
        ngaylap2.setForeground(red);
        ngaylap2.setDateFormatString("yyyy-MM-dd");
        ngaylap2.setPreferredSize(new Dimension(100,25));
        hyphenlbl = new JLabel(hyphenicon);
        hyphenlbl.setPreferredSize(new Dimension(40,30));
        
        // tiền
        ImageIcon giaicon = new ImageIcon(this.getClass().getResource("/Icons/moneyicon.png"));
        tongtienlbl = new JLabel("Theo tổng tiền");
        tongtienlbl.setIcon(giaicon);
        tongtienlbl.setPreferredSize(new Dimension(190,35));
        tongtienlbl.setFont(f2);
        tien1txt = new JTextField(8);
        tien1txt.setPreferredSize(new Dimension(40,30));
        tien2txt = new JTextField(8);
        tien2txt.setPreferredSize(new Dimension(40,30));
        hyphenlbl1 = new JLabel(hyphenicon);
        hyphenlbl1.setPreferredSize(new Dimension(40,30));
      
        //search panel
        searchPanel.add(searchinfolbl);
        searchPanel.add(categorycb);
        searchPanel.add(searchtxt);
        searchPanel.add(searchbtn);
        searchPanel.add(reloadbtn);
        searchPanel.add(ngaylaplbl);
        searchPanel.add(ngaylap1);
        searchPanel.add(hyphenlbl);
        searchPanel.add(ngaylap2);
        searchPanel.add(tongtienlbl);
        searchPanel.add(tien1txt);
        searchPanel.add(hyphenlbl1);
        searchPanel.add(tien2txt);
        

        //table list tìm kiếm
        datatableicon = new ImageIcon(this.getClass().getResource("/Icons/datatable.png"));
        
        datatablelbl = new JLabel("Bảng thống kê hóa đơn");
        datatablelbl.setForeground(new Color(255,51,0));
        datatablelbl.setIcon(datatableicon);
        datatablelbl.setBounds(480,280,300,40);
        datatablelbl.setFont(f);

        DefaultTableModel model = new DefaultTableModel(hoadonheader,0);
        datatable = new JTable(model);
        datatable.getTableHeader().setOpaque(false);
        datatable.setRowHeight(30);
        jsp = new JScrollPane(datatable);
        //jsp.setViewportView(monantable);
        //searchjsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //searchjsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setBounds(360,320,570,220);
        //jsp.setBorder(new LineBorder(black,3,true));

        //infoPanel
        infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout(1,10,10));
        infoPanel.setBounds(0,50,360,550);
        //infoPanel.setBorder(new LineBorder(Color.black,3,true));
        
        detailicon = new ImageIcon(this.getClass().getResource("/Icons/detaildata.png"));
        tienicon = new ImageIcon(this.getClass().getResource("/Icons/moneyicon.png"));
        idnvicon1 = new ImageIcon(this.getClass().getResource("/Icons/usericon.png"));
        idnvicon2 = new ImageIcon(this.getClass().getResource("/Icons/datatable.png"));
        idhdicon = new ImageIcon(this.getClass().getResource("/Icons/idhd.png"));
        soldicon1 = new ImageIcon(this.getClass().getResource("/Icons/soldicon.png"));
        soldicon2 = new ImageIcon(this.getClass().getResource("/Icons/soldicon2.png"));
        tienicon = new ImageIcon(this.getClass().getResource("/Icons/moneyicon.png"));

        infolbl2 = new JLabel("Chi tiết bảng thống kê");
        infolbl2.setPreferredSize(new Dimension(250,40));
        infolbl2.setFont(f2);
        infolbl2.setForeground(new Color(255,51,0));
        infolbl2.setIcon(detailicon);
        idhdlbl = new JLabel("Số hóa đơn đã lập");
        idhdlbl.setPreferredSize(new Dimension(250,30));
        idhdlbl.setFont(f2);
        idhdlbl.setForeground(new Color(255,102,0));
        idhdlbl.setIcon(idhdicon);
        idhddetail = new JLabel();
        idhddetail.setPreferredSize(new Dimension(250,30));
        idhddetail.setFont(f2);
        idnvlbl = new JLabel("Số NV lập hóa đơn");
        idnvlbl.setPreferredSize(new Dimension(250,30));
        idnvlbl.setFont(f2);
        idnvlbl.setForeground(new Color(255,102,0));
        idnvlbl.setIcon(idnvicon1);
        idnvdetail = new JLabel();
        idnvdetail.setPreferredSize(new Dimension(250,30));
        idnvdetail.setFont(f2);
        tongtienlbl2 = new JLabel("Tổng tiền");
        tongtienlbl2.setForeground(new Color(255,102,0));
        tongtienlbl2.setPreferredSize(new Dimension(250,30));
        tongtienlbl2.setFont(f2);
        tongtienlbl2.setIcon(tienicon);
        tongtiendetail = new JLabel();
        tongtiendetail.setPreferredSize(new Dimension(250,30));
        tongtiendetail.setFont(f2);
        soldlbl = new JLabel("Số lượng đã bán");
        soldlbl.setForeground(new Color(255,102,0));
        soldlbl.setPreferredSize(new Dimension(250,30));
        soldlbl.setFont(f2);
        soldlbl.setIcon(soldicon1);
        solddetail = new JLabel();
        solddetail.setPreferredSize(new Dimension(250,30));
        solddetail.setFont(f2);
        datelbl = new JLabel("Ngày lập hóa đơn");
        datelbl.setForeground(new Color(255,102,0));
        datelbl.setPreferredSize(new Dimension(250,30));
        datelbl.setFont(f2);
        datelbl.setIcon(dateicon);
        datedetail = new JLabel();
        datedetail.setPreferredSize(new Dimension(250,30));
        datedetail.setFont(f2);
        soldlbl2 = new JLabel("Số lượng đã bán");
        soldlbl2.setForeground(new Color(255,102,0));
        soldlbl2.setPreferredSize(new Dimension(250,30));
        soldlbl2.setFont(f2);
        solddetail2 = new JLabel();
        solddetail2.setPreferredSize(new Dimension(250,30));
        solddetail2.setFont(f2);
        
        infoPanel.setBackground(new Color(0, 255, 204));
        infoPanel.add(infolbl2);
        infoPanel.add(idhdlbl);
        infoPanel.add(idhddetail);
        infoPanel.add(idnvlbl);
        infoPanel.add(idnvdetail);
        infoPanel.add(tongtienlbl2);
        infoPanel.add(tongtiendetail);
        infoPanel.add(soldlbl);
        infoPanel.add(solddetail);
        infoPanel.add(datelbl);
        infoPanel.add(datedetail);
        infoPanel.add(soldlbl2);
        infoPanel.add(solddetail2);
        
        //thêm panel
        add(infolbl);
        add(searchPanel);
        add(datatablelbl);
        add(jsp);
        add(infoPanel);
        loadDshoadon();
        editDate();
    }

    public void loadDshoadon(){
        datamodel = new DefaultTableModel(hoadonheader,0){
            public boolean isCellEditable(int row,int col){
                return false;
            }
        };
        datatable.setModel(datamodel);
        datatable.setSelectionBackground(Color.yellow);
        datatable.addMouseListener(this);
        HoadonBUS bus = new HoadonBUS();
        if(dshoadon == null) bus.docDshoadon();
        sl=0;
        HoadonDTO hd = new HoadonDTO();
        
        for(int i=0;i<dshoadon.size();i++){
            hd = dshoadon.get(i);
            if(i == dshoadon.size()-1){
                sl += hd.soluong;
                Object [] data = {hd.getIdhd(),hd.getIdnv(),hd.getNgaylap(),hd.getTongtien(),sl};
                datamodel.addRow(data);
            }else{
                if(hd.idhd.equals(dshoadon.get(i+1).idhd)){
                    sl += hd.soluong;
                }else{
                    sl += hd.soluong;
                    Object [] data = {hd.getIdhd(),hd.getIdnv(),hd.getNgaylap(),hd.getTongtien(),sl};
                    datamodel.addRow(data);
                    sl =0;
                }
            }
        }
        loadDetail();
    }
        /*monantable.getColumnModel().getColumn(0).setPreferredWidth(70);
        monantable.getColumnModel().getColumn(1).setPreferredWidth(70);
        monantable.getColumnModel().getColumn(2).setPreferredWidth(150);
        monantable.getColumnModel().getColumn(5).setPreferredWidth(130);
        monantable.getColumnModel().getColumn(7).setPreferredWidth(50);
        monantable.getColumnModel().getColumn(8).setPreferredWidth(50);*/
        
    //}
    public void loadDetailHoadon(String idhd){
        ImageIcon detailhd = new ImageIcon(this.getClass().getResource("/Icons/detailhd.png")); 
        datatablelbl.setText("Chi tiết hóa đơn");
        infolbl2.setText("Thống kê chi tiết");
        idhdlbl.setText("IDHD");
        datatablelbl.setIcon(detailhd);
        datamodel = new DefaultTableModel(detailheader,0){
            public boolean isCellEditable(int row,int col){
                return false;
            }
        };
        datatable.setModel(datamodel);
        for(HoadonDTO hd : dshoadon){
            if(idhd.equals(hd.idhd)){
                Object [] data = {hd.getIdhd(),hd.getIdmon(),hd.getSoluong(),hd.getDongia(),hd.getThanhtien(),hd.getTongtien()};
                datamodel.addRow(data);
            }
        }
        datatable.removeMouseListener(this);
        datatable.setSelectionBackground(Color.white);
        loadDetailTable();
    }

    public void loadDetail(){
        ArrayList<String> dsidhd = new ArrayList();
        ArrayList<String> dsidnv = new ArrayList();
        ArrayList<String> dsngaylap = new ArrayList();
        tongtien=0;
        sl=0;
        boolean trung;
        for(int i=0;i<datatable.getRowCount();i++){
            trung = false;
            dsidhd.add(datatable.getValueAt(i,0).toString());
            String idnv = datatable.getValueAt(i,1).toString();

            if(dsidnv.size()==0){ 
                dsidnv.add(idnv);
            }else{
                for(int j=0;j<dsidnv.size();j++){
                    if(idnv.equals(dsidnv.get(j))){
                        trung=true;
                        break;
                    }
                }
                if(trung == false) dsidnv.add(idnv);
            }
            tongtien += Integer.parseInt(datatable.getValueAt(i,3).toString());
            sl += Integer.parseInt(datatable.getValueAt(i,4).toString());
            dsngaylap.add(datatable.getValueAt(i,2).toString());
        }

        slnv = dsidnv.size();
        slid = dsidhd.size();
        if(dsidhd.size()==1){
            idhddetail.setText(dsidhd.get(0));
        }else if(dsidhd.size()>1){
            String id1 = getIDmin(dsidhd);
            String id2 = getIDmax(dsidhd);
            idhddetail.setText(slid+" hóa đơn("+id1+" => "+id2+")");
        }else{
            idhddetail.setText(dsidhd.get(0));
        }
        idnvdetail.setText(Integer.toString(slnv) +" người");
        tongtiendetail.setText(tongtien+" VND");
        solddetail.setText(sl+ " Sản phẩm");
        if(dsngaylap.size()==1){
            datedetail.setText(dsngaylap.get(0));
        }else if(dsngaylap.size()>2){
            String date1 = getDatemin(dsngaylap);
            String date2 = getDatemax(dsngaylap);
            datedetail.setText(date1+" => "+ date2);
        }else{
            datedetail.setText(dsngaylap.get(0));
        }
        datatablelbl.setText("Bảng thống kê hóa đơn");
        infolbl2.setText("Chi tiết bảng thống kê");
        idhdlbl.setText("Số hóa đơn đã lập");
        idnvlbl.setText("Số NV lập hóa đơn");
        tongtienlbl2.setText("Tổng tiền");
        soldlbl.setText("Số lượng đã bán");
        soldlbl2.setText("");
        solddetail2.setText("");
        soldlbl2.setIcon(null); 
    }
    
    public void loadDetailTable(){
        ArrayList<String> dssp = new ArrayList();
        tongtien=0;
        sl=0;
        boolean trung;
        for(int i=0;i<datatable.getRowCount();i++){
            trung = false;
            idhd = datatable.getValueAt(i,0).toString();
            String sanpham = datatable.getValueAt(i,1).toString();
            if(dssp.size()==0){ 
                dssp.add(sanpham);
            }else{
                for(int j=0;j<dssp.size();j++){
                    if(sanpham.equals(dssp.get(j))){
                        trung=true;
                        break;
                    }
                }
                if(trung == false) dssp.add(sanpham);
            }
            sl += Integer.parseInt(datatable.getValueAt(i,2).toString());
            tongtien = Integer.parseInt(datatable.getValueAt(i,5).toString());
        }
        slsp = dssp.size();
        idhddetail.setText(idhd);
        idnvlbl.setText("IDNV lập hóa đơn");
        idnvdetail.setText(idnv);
        tongtienlbl2.setText("Tổng tiền");
        tongtiendetail.setText(Integer.toString(tongtien)+" VND");
        soldlbl.setText("S.Lượng sản phẩm đã bán");
        solddetail.setText(Integer.toString(sl)+ " món");
        datedetail.setText(ngaylap);
        soldlbl2.setText("Số sản phẩm bán");
        soldlbl2.setIcon(soldicon2);
        solddetail2.setText(Integer.toString(slsp)+" sản phẩm");
    }
    
    public String getIDmax(ArrayList<String> ds){
        String id;
        int max;
        String first = ds.get(0).substring(0,2);
        max = Integer.parseInt(ds.get(0).substring(2));
        for(int i = 0;i<ds.size();i++){
            int idnext = Integer.parseInt(ds.get(i).substring(2));
            if(idnext > max){
                max = idnext;
            }
        }
        id = first + Integer.toString(max);
        return id;
    }
    
    public String getIDmin(ArrayList<String> ds){
        String id;
        int min;
        String first = ds.get(0).substring(0,2);
        min = Integer.parseInt(ds.get(0).substring(2));
        for(int i = 0;i<ds.size();i++){
            int idnext = Integer.parseInt(ds.get(i).substring(2));
            if(idnext < min){
                min = idnext;
            }
        }
        id = first + Integer.toString(min);
        return id;
    }
    
    public String getDatemin(ArrayList<String> ds){
       datemin = ds.get(0);
        for(int i = 0;i<ds.size();i++){
            if(datemin.compareTo(ds.get(i)) > 0)
                datemin = ds.get(i);
        }
        return datemin;
    }
    
    public String getDatemax(ArrayList<String> ds){
        datemax = ds.get(0);
        for(int i = 0;i<ds.size();i++){
            if(datemax.compareTo(ds.get(i)) < 0)
                datemax = ds.get(i);
        }
        return datemax;
    }
    
    public void editDate(){
        ngaylap1txt = (JTextFieldDateEditor) ngaylap1.getDateEditor();
        ngaylap1txt.setEditable(false);
        ngaylap2txt = (JTextFieldDateEditor) ngaylap2.getDateEditor();
        ngaylap2txt.setEditable(false);
    }
    
    public void search(String searchstr,String dateStart,String dateEnd,int gia1,int gia2){
        HoadonBUS bus = new HoadonBUS();
        ArrayList<HoadonDTO> dstimkim = new ArrayList();
        ArrayList<String> dsid = new ArrayList();
        HoadonDTO hd = new HoadonDTO();
        dstimkim = bus.search(searchstr,dateStart,dateEnd,gia1,gia2);
        sl=0;
        if(dstimkim.size()==0){
            JOptionPane.showMessageDialog(null,"Không tìm thấy kết quả phù hợp");
        }else{
            datatablelbl.setText("Bảng thống kê hóa đơn");
            datatablelbl.setIcon(datatableicon);
            datamodel = new DefaultTableModel(hoadonheader,0){
                public boolean isCellEditable(int row,int col){
                    return false;
                    }
                };
            datatable.setModel(datamodel);
            slid=1;
            String idhd = dstimkim.get(0).idhd;
            for(int i=1;i<dstimkim.size()-1;i++){
                if(!idhd.equals(dstimkim.get(i).idhd)){
                    slid++;
                }
            }
            if(slid==1){
                hd = dstimkim.get(0);
                for(int i=0;i<dstimkim.size();i++){
                    sl += dstimkim.get(i).soluong;
                }
                Object [] data = {hd.getIdhd(),hd.getIdnv(),hd.getNgaylap(),hd.getTongtien(),sl};
                datamodel.addRow(data);
            }else{
                for(int i=0;i<dstimkim.size()-1;i++){
                    hd = dstimkim.get(i);
                    if(hd.idhd.equals(dstimkim.get(i+1).idhd)){
                        sl += hd.soluong;
                    }else{
                        sl += hd.soluong;
                        Object [] data = {hd.getIdhd(),hd.getIdnv(),hd.getNgaylap(),hd.getTongtien(),sl};
                        datamodel.addRow(data);
                        sl =0;
                        }
                    }
               }
            }
        loadDetail();
    }

    public static void main(String[] args) {
        ThongkehoadonGUI a = new ThongkehoadonGUI();
        a.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==categorycb){
            dsidhd = new ArrayList();
            dsidnv = new ArrayList();
            boolean trung;
            HoadonDTO hd = new HoadonDTO();
            dsidhd.add(dshoadon.get(0).idhd);
            dsidnv.add(dshoadon.get(0).idnv);
            for(int i=0;i<dshoadon.size();i++){
                trung = false;
                hd = dshoadon.get(i);
                for(int j=0;j<dsidhd.size();j++){
                    if(hd.idhd.equals(dsidhd.get(j))){
                        trung = true;
                        break;
                    }
                }
                if(trung == false) dsidhd.add(hd.idhd);
            } 
                
            for(int i=0;i<dshoadon.size();i++){
                trung = false;
                hd = dshoadon.get(i);
                for(int j=0;j<dsidnv.size();j++){
                    if(hd.idnv.equals(dsidnv.get(j))){
                        trung = true;
                        break;
                    }
                }
                if(trung == false) dsidnv.add(hd.idnv);
            } 
            
            JComboBox idhdcb = new JComboBox(dsidhd.toArray());
            JComboBox idnvcb = new JComboBox(dsidnv.toArray());
            if(categorycb.getSelectedIndex()==0){
                ngaylap1.setEnabled(true);
                ngaylap2.setEnabled(true);
                tien1txt.setEditable(true);
                tien2txt.setEditable(true);
                searchtxt.setText("");
                searchtxt.setEditable(false);
            }else if(categorycb.getSelectedIndex()==1){
                int answer = JOptionPane.showConfirmDialog(this,idhdcb,null,JOptionPane.DEFAULT_OPTION);
                if(answer == JOptionPane.OK_OPTION){
                    searchtxt.setText(idhdcb.getSelectedItem().toString());
                    ngaylap1.setEnabled(false);
                    ngaylap2.setEnabled(false);
                    tien1txt.setEditable(false);
                    tien2txt.setEditable(false);
                    tien2txt.setText("");
                    tien1txt.setText("");
                    ngaylap1.setCalendar(null);
                    ngaylap2.setCalendar(null);
                    searchtxt.setEditable(true);
                }
            }else if(categorycb.getSelectedIndex()==2){
                int answer = JOptionPane.showConfirmDialog(this,idnvcb,null,JOptionPane.DEFAULT_OPTION);
                if(answer == JOptionPane.OK_OPTION){
                    searchtxt.setText(idnvcb.getSelectedItem().toString());
                    ngaylap1.setEnabled(false);
                    ngaylap2.setEnabled(false);
                    tien1txt.setEditable(false);
                    tien2txt.setEditable(false);
                    tien2txt.setText("");
                    tien1txt.setText("");
                    ngaylap1.setCalendar(null);
                    ngaylap2.setCalendar(null);
                    searchtxt.setEditable(true);
                }
            }else if(categorycb.getSelectedIndex()==3){
                tien1txt.setEditable(false);
                tien2txt.setEditable(false);
                ngaylap1.setEnabled(true);
                ngaylap2.setEnabled(true);
                searchtxt.setText("");
                searchtxt.setEditable(false);
            }else if(categorycb.getSelectedIndex()==4){
                ngaylap1.setEnabled(false);
                ngaylap2.setEnabled(false);
                tien1txt.setEditable(true);
                tien2txt.setEditable(true);
                searchtxt.setText("");
                searchtxt.setEditable(false);
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==datatable){
            int answer = JOptionPane.showConfirmDialog(null,"Bạn có muốn xem chi tiết hóa đơn?",null,JOptionPane.YES_NO_OPTION);
            if(answer == JOptionPane.YES_OPTION){
                int i = datatable.getSelectedRow();
                String idhd = datatable.getValueAt(i,0).toString();
                idnv = datatable.getValueAt(i,1).toString();
                ngaylap = datatable.getValueAt(i,2).toString();
                loadDetailHoadon(idhd);
            }else{
                return;
            }
        }else if(e.getSource()==reloadbtn){
            loadDshoadon();
            JOptionPane.showMessageDialog(null,"Làm mới thành công");
        }else if(e.getSource()==searchbtn){
            String searchstr = searchtxt.getText();
            if(categorycb.getSelectedIndex()==0){
                try{
                    ngay1 = sdf.format(ngaylap1.getDate());
                    ngay2  = sdf.format(ngaylap2.getDate());
                }catch(Exception err){
                    //System.out.println(err);
                }
                try{
                    gia1 = Integer.parseInt(tien1txt.getText());
                    gia2 = Integer.parseInt(tien2txt.getText());
                }catch(NumberFormatException err){
                    JOptionPane.showMessageDialog(null,"Hãy nhập số vào ô đơn giá");
                    return;
                }
                if((ngaylap1.getDate()==null) ||(ngaylap2.getDate()==null)){
                    JOptionPane.showMessageDialog(null,"Không được để ngày trống");
                }else if(gia1 > gia2){
                    JOptionPane.showMessageDialog(null,"Ô giá trước không được lớn hơn ô sau");
                }else if(ngay1.compareTo(ngay2)>0){
                    JOptionPane.showMessageDialog(null,"Ô ngày trước không được lớn hơn ô sau");
                }else{
                    search(searchstr,ngay1,ngay2,gia1,gia2);
                }
            }else if (categorycb.getSelectedIndex()==1){
                if((searchstr.equals("")) || searchstr.length()<3 || (!searchstr.substring(0,2).equals("HD"))){
                    JOptionPane.showMessageDialog(null,"ID hóa đơn không hợp lệ");
                    JOptionPane.showMessageDialog(null,"ID hóa đơn có mã bắt đầu là 'HĐ' ");
                }else{
                    ngay1 = "";
                    ngay2 = "";
                    gia1=0;gia2=0;
                    search(searchstr,ngay1,ngay2,gia1,gia2);
                }
            }else if(categorycb.getSelectedIndex()==2){
                if((searchstr.equals("")) || (searchstr.length()<3) || (!searchstr.substring(0,2).equals("NV"))){
                    JOptionPane.showMessageDialog(null,"ID nhân viên không hợp lệ");
                    JOptionPane.showMessageDialog(null,"ID nhân viên có mã bắt đầu là 'NV'");
                }else{
                    ngay1 = "";
                    ngay2 = "";
                    gia1=0;gia2=0;   
                    search(searchstr,"","",0,0);
                }
            }else if(categorycb.getSelectedIndex()==3){
                if((ngaylap1.getDate()==null) ||(ngaylap2.getDate()==null)){
                    JOptionPane.showMessageDialog(null,"Ngày không được để trống");
                }else{
                    ngay1 = sdf.format(ngaylap1.getDate());
                    ngay2 = sdf.format(ngaylap2.getDate());
                    gia1=0;gia2=0;
                    search(searchstr,ngay1,ngay2,gia1,gia2);
                }
            }else if(categorycb.getSelectedIndex()==4){
                if((tien1txt.getText().equals("")) || (tien2txt.getText().equals(""))){
                    JOptionPane.showMessageDialog(null,"Ô đơn giá không được để trống");
                }else{
                    try{
                        gia1 = Integer.parseInt(tien1txt.getText());
                        gia2 = Integer.parseInt(tien2txt.getText());
                        if(gia1 > gia2){
                            JOptionPane.showMessageDialog(null,"Ô giá trước không được lớn hơn ô sau");
                        }
                    }catch(NumberFormatException err){
                        JOptionPane.showMessageDialog(null,"Hãy nhập số vào ô đơn giá");
                    }
                    search(searchstr,"","",gia1,gia2);
                }
            }
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
        if(e.getSource() == searchbtn){
            ImageIcon searchicon2 = new ImageIcon(this.getClass().getResource("/Icons/searchicon2.png"));
            searchbtn.setIcon(searchicon2);
        }else if(e.getSource() == reloadbtn){
            ImageIcon refreshicon2 = new ImageIcon(this.getClass().getResource("/Icons/refreshicon2.png"));
            reloadbtn.setIcon(refreshicon2);
        }
    }

    @Override
    public void mouseExited(MouseEvent e){
        if(e.getSource() == searchbtn){
            ImageIcon searchicon1 = new ImageIcon(this.getClass().getResource("/Icons/searchicon1.png"));
            searchbtn.setIcon(searchicon1);
        }else if(e.getSource() == reloadbtn){
            ImageIcon refreshicon1 = new ImageIcon(this.getClass().getResource("/Icons/refreshicon1.png"));
            reloadbtn.setIcon(refreshicon1);
        }
    } 
}
