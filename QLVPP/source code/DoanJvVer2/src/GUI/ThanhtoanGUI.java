package GUI;

import BUS.HoadonBUS;
import static BUS.HoadonBUS.giohang;
import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import DTO.ComboBoxList;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import javax.swing.table.*;
import DAO.HoadonDAO;
import DAO.MonanDAO;
import BUS.MonanBUS;
import DTO.MonanDTO;
import java.lang.Object;
import java.util.ArrayList;
import DTO.HoadonDTO;
import static java.lang.Integer.parseInt;
import java.util.Date;
import java.util.EventObject;
import javax.swing.event.CellEditorListener;
import GUI.DsnvdialogGUI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import static BUS.MonanBUS.dsmonan;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import static GUI.OverallFrame.currentIdnv;
import static BUS.HoadonBUS.tongtien;


public class ThanhtoanGUI extends JPanel implements ItemListener,MouseListener{
    private JLabel idnvlbl,idhdlbl,giatienlbl,thongbaolbl,cartlbl,infolbl,
            ngaylaplbl,gialbl,hyphenlbl,loaimonanlbl,getgialbl,searchbtn,checkoutbtn,
            reloadbtn,printbtn,loaddatabtn,btnHistory,tongtienlbl;
    private JTextField searchtxt,idnvtxt,idhdtxt,ngaylaptxt,gia1txt,gia2txt;
    private JTextArea searchlbl;
    private JButton removebtn,
            addbtn,renderbtn;
    private JCheckBox promotion,hot;
    private JPanel searchPanel,cartPanel,infoPanel;
    private JComboBox loaimonancb,categorycb;
    private ImageIcon searchicon1,removeicon,giamgiaicon1,giamgiaicon2,hoticon1,
            hoticon2,addicon,thucanicon,nuocuongicon;
    public JTable searchtable;
    private JScrollPane searchjsp,cartjsp;
    static String[] loaimonan = {"Tất cả","Bánh","Nước"}; 
    static String[] loaimonan1 = {"Bánh","Nước"}; 
    static String[] giatien = {"Tất cả","Từ 20.000VND trở lên","Từ 10.000VND-20.000VND","Từ 10.000VND trở xuống"}; 
    static String[] searchheader = {"Tên món ăn","Loại","Đơn giá","Tồn kho","Khuyến mãi",""};
    static String[] cartheader = {"IDNV","IDHD","Tên món ăn","Đơn giá","Số lượng","Thành tiền","Tổng tiền",""};
    private  String[] category1 = {"Tất cả","ID món","Tên món","Loại món","Khuyến mãi","Bán chạy","Đơn giá"};
    private Font f = new Font("Arial",Font.BOLD,18);
    private Font f2 = new Font("Arial",Font.PLAIN,14);
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DefaultTableModel cartmodel,searchmodel;
    private boolean promotionselected = false,hotselected = false;
    private JSlider giaslider;
    public ArrayList<MonanDTO> dstimkim;
    public Action addCart;
    public static String idnv1,idhd1;
    private LocalDateTime ngaylap;
    private int sl,gia1,gia2;
    public static JTable carttable;
    private DefaultComboBoxModel loaicbModel,loaicbModel1;
    OverallFrame home;
    CheckLoi cl = new CheckLoi();
    private ArrayList<String> dsidnv,dsidmon,dstenmon;
    public ThanhtoanGUI(){
        inits();
        
    }
  
    public void inits() {
        
        setSize(945,650);
        setLayout(null);
        setBackground(new Color(0, 255, 204));
        //Panel tìm kiếm
        searchPanel = new JPanel(new FlowLayout(1,0,10));
        //searchPanel.setBackground(Color.yellow);
        searchPanel.setBounds(0,20,350,270);
        searchPanel.setBackground(new Color(0,255,204));
        //searchPanel.setBorder(new LineBorder(black,3,true));
        
        categorycb = new JComboBox(category1);
        categorycb.setPreferredSize(new Dimension(100,28));
        categorycb.addItemListener(this);
        searchtxt = new JTextField(11);
        searchtxt.setPreferredSize(new Dimension(120,28));
        searchbtn = new JLabel();
        searchbtn.setPreferredSize(new Dimension(30,28));
        searchicon1 = new ImageIcon(this.getClass().getResource("/Icons/searchicon1.png"));
        searchbtn.setIcon(searchicon1);
        searchbtn.addMouseListener(this);
        ImageIcon refreshicon1 = new ImageIcon(this.getClass().getResource("/Icons/refreshicon1.png"));
        reloadbtn = new JLabel(refreshicon1);
        reloadbtn.setPreferredSize(new Dimension(30,28));
        reloadbtn.addMouseListener(this);
        //combobox loại
        ImageIcon loaimonanicon = new ImageIcon(this.getClass().getResource("/Icons/foodcategoryicon.png"));
        loaimonanlbl = new JLabel("Loại món ăn");
        loaimonanlbl.setIcon(loaimonanicon);
        loaimonanlbl.setPreferredSize(new Dimension(130,35));
        loaimonanlbl.setFont(f2);
        loaimonancb = new JComboBox(loaimonan);
        loaimonancb.setPreferredSize(new Dimension(130,35));
        loaicbModel = new DefaultComboBoxModel(); 
        loaicbModel1 = new DefaultComboBoxModel();
        thucanicon = new ImageIcon(this.getClass().getResource("/Icons/thucanicon.png"));
        nuocuongicon = new ImageIcon(this.getClass().getResource("/Icons/nuocuongicon.png"));
        ImageIcon tatcaicon = new ImageIcon(this.getClass().getResource("/Icons/tatcaicon.png"));
        Icon[] loaiicons = {tatcaicon,thucanicon,nuocuongicon};
        Icon[] loaiicons1 = {thucanicon,nuocuongicon};
        for(int i=0;i<loaimonan.length;i++){
            loaicbModel.addElement(new ComboBoxList(loaiicons[i],loaimonan[i]));
        } 
         for(int i=0;i<loaimonan1.length;i++){
            loaicbModel1.addElement(new ComboBoxList(loaiicons1[i],loaimonan1[i]));
        }   
        loaimonancb.setModel(loaicbModel);
        loaimonancb.setRenderer(new ComboBoxRender());
        //giá
        ImageIcon hyphenicon = new ImageIcon(this.getClass().getResource("/Icons/hyphenicon.png"));
        ImageIcon giaicon = new ImageIcon(this.getClass().getResource("/Icons/moneyicon.png"));
        gialbl = new JLabel("Theo đơn giá");
        gialbl.setIcon(giaicon);
        gialbl.setPreferredSize(new Dimension(260,35));
        gialbl.setFont(f2);
        gia1txt = new JTextField(9);
        gia2txt = new JTextField(9);
        hyphenlbl = new JLabel(hyphenicon);
        gia1txt.setFont(f2);
        gia2txt.setFont(f2);
        gia1txt.setPreferredSize(new Dimension(40,30));
        gia2txt.setPreferredSize(new Dimension(40,30));
        hyphenlbl.setPreferredSize(new Dimension(30,35));
        //checkbox
        giamgiaicon1 = new ImageIcon(this.getClass().getResource("/Icons/saleicon.png"));
        hoticon1 = new ImageIcon(this.getClass().getResource("/Icons/hoticon.png"));
        hoticon2 = new ImageIcon(this.getClass().getResource("/Icons/hoticon2.png"));
        giamgiaicon2 = new ImageIcon(this.getClass().getResource("/Icons/saleicon2.png"));
        hot = new JCheckBox("Bán chạy",hoticon1);
        promotion = new JCheckBox("Giảm giá",giamgiaicon1);
        hot.setPreferredSize(new Dimension(130,50));
        hot.setContentAreaFilled(false);
        hot.setForeground(red);
        promotion.setPreferredSize(new Dimension(130,50));
        promotion.setForeground(red);
        //promotion.setContentAreaFilled(false);
        hot.addItemListener(this);
        promotion.addItemListener(this);
        
        
        //table list tìm kiếm
        ImageIcon searchlbl2 = new ImageIcon(this.getClass().getResource("/Icons/searchlbl2.png"));
        addicon = new ImageIcon(this.getClass().getResource("/Icons/addcart.png"));
        JLabel searchlbl1 = new JLabel("Danh sách món ăn tìm kiếm");
        searchlbl1.setIcon(searchlbl2);
        searchlbl1.setForeground(new Color(255,51,0));
        searchlbl1.setBounds(450,5,300,30);
        searchlbl1.setFont(f);
        
        searchtable = new JTable();
        searchtable.setSelectionBackground(Color.yellow);
        searchtable.getTableHeader().setOpaque(false);
        /*DefaultTableCellRenderer align = new DefaultTableCellRenderer();
        align.setHorizontalAlignment(JLabel.CENTER);
        searchtable.getColumnModel().getColumn(0).setCellRenderer(align);
        searchtable.getColumnModel().getColumn(2).setCellRenderer(align);
        searchtable.getColumnModel().getColumn(3).setCellRenderer(align);
        searchtable.getColumnModel().getColumn(1).setCellRenderer(align);
        searchtable.addMouseListener(this);*/

        //searchtable.setEnabled(false);
        //searchtable.setRowSelectionAllowed(true)
        searchtable.setRowHeight(35);
        searchjsp = new JScrollPane();
        searchjsp.setViewportView(searchtable);
        //searchjsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //searchjsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        searchjsp.setBounds(400,40,400,200);
        //searchjsp.setBorder(new LineBorder(black,3,true));
        //table giỏ hàng
        ImageIcon carticon = new ImageIcon(this.getClass().getResource("/Icons/shoppingcart.png"));
        ImageIcon checkouticon1 = new ImageIcon(this.getClass().getResource("/Icons/checkouticon1.png"));
        ImageIcon printericon1 = new ImageIcon(this.getClass().getResource("/Icons/printericon1.png"));
        cartlbl = new JLabel("Giỏ hàng");
        cartlbl.setIcon(carticon);
        cartlbl.setForeground(new Color(255,51,0));
        cartlbl.setBounds(560,260,150,30);
        cartlbl.setFont(f);
        tongtienlbl = new JLabel("Tổng tiền: 0 VND");
        tongtienlbl.setIcon(carticon);
        tongtienlbl.setForeground(new Color(255,51,0));
        tongtienlbl.setBounds(710,260,300,30);
        tongtienlbl.setFont(f);
        removebtn = new JButton();
        printbtn = new JLabel("In hóa đơn");
        printbtn.setIcon(printericon1);
        printbtn.setBounds(700,550,150,45);
        printbtn.setForeground(new Color(255,153,0));
        printbtn.setFont(f);
        printbtn.addMouseListener(this);
        checkoutbtn = new JLabel("Thanh toán");
        checkoutbtn.setForeground(new Color(255,153,0));
        checkoutbtn.setIcon(checkouticon1);
        checkoutbtn.setBounds(500,550,150,45);
        checkoutbtn.setFont(f);
        checkoutbtn.addMouseListener(this);
        
        btnHistory = new JLabel("Lịch sử bán hàng");
        btnHistory.setIcon(printericon1);
        btnHistory.setForeground(new Color(255,153,0));
        btnHistory.setBounds(500,600,200,45);
        btnHistory.setFont(f);
        btnHistory.addMouseListener(this);
        
        DefaultTableModel cartmodel = new DefaultTableModel(cartheader,0);
        carttable = new JTable(cartmodel);
        //DefaultTableCellEditor cellRender = new DefaultTableCellEditor();
        //cellRender.add(removebtn);
        //searchtable.getColumnModel().getColumn(4).setCellRenderer(new ButtonRender());
        //{public boolean isCellEditable(int row, int column){return false;}}
        carttable.getColumnModel().getColumn(7).setPreferredWidth(50);
        carttable.getColumnModel().getColumn(2).setPreferredWidth(150);
        carttable.setRowHeight(30);
        
        cartjsp = new JScrollPane(carttable);
        //cartjsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //cartjsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        cartjsp.setBounds(350,300,580,230);
        //cartjsp.setBorder(new LineBorder(black,3,true));
        //search panel
        searchPanel.add(categorycb);
        searchPanel.add(searchtxt);
        searchPanel.add(searchbtn);
        searchPanel.add(reloadbtn);
        searchPanel.add(loaimonanlbl);
        searchPanel.add(loaimonancb);
        searchPanel.add(hot);
        searchPanel.add(promotion);
        searchPanel.add(gialbl);
        searchPanel.add(gia1txt);
        searchPanel.add(hyphenlbl);
        searchPanel.add(gia2txt);
        
        
        //Panel thông tin hóa đơn
        infoPanel = new JPanel(new FlowLayout(1,0,15));
        //infoPanel.setBorder(new LineBorder(black,3,true));
        infoPanel.setBounds(0,270,350,340);
  
        ImageIcon infoicon = new ImageIcon(this.getClass().getResource("/Icons/infoicon.png"));
        ImageIcon usericon = new ImageIcon(this.getClass().getResource("/Icons/usericon.png"));
        ImageIcon receipticon = new ImageIcon(this.getClass().getResource("/Icons/receipticon.png"));
        ImageIcon calendericon = new ImageIcon(this.getClass().getResource("/Icons/calendericon.png"));
        ImageIcon extendsionicon1 = new ImageIcon(this.getClass().getResource("/Icons/extendsion1.png"));
        infolbl = new JLabel("Thông tin giỏ hàng");
        infolbl.setIcon(infoicon);
        infolbl.setIcon(infoicon);
        infolbl.setPreferredSize(new Dimension(300,40));
        infolbl.setHorizontalAlignment(JLabel.CENTER);
        infolbl.setFont(f);
        idnvlbl = new JLabel("ID Nhân viên");
        idnvlbl.setIcon(usericon);
        idnvlbl.setPreferredSize(new Dimension(170,50));
        idnvlbl.setFont(f2);
        idnvtxt = new JTextField(9);
        idnvtxt.setPreferredSize(new Dimension(100,30));
        idnvtxt.setHorizontalAlignment(JLabel.CENTER);
        idnvtxt.setFont(f2);
        idnvtxt.setEnabled(false);
        idnvtxt.setForeground(red);
        loaddatabtn = new JLabel(extendsionicon1);
        loaddatabtn.setPreferredSize(new Dimension(35,30));
        loaddatabtn.addMouseListener(this);
        idhdlbl = new JLabel("ID Hóa đơn");
        idhdlbl.setIcon(receipticon);
        idhdlbl.setPreferredSize(new Dimension(170,50));
        idhdlbl.setFont(f2);
        idhdtxt = new JTextField(9);
        idhdtxt.setPreferredSize(new Dimension(120,30));
        idhdtxt.setHorizontalAlignment(JLabel.CENTER);
        idhdtxt.setFont(f2);
        idhdtxt.setEnabled(false);
        idhdtxt.setForeground(red);
        ngaylaplbl = new JLabel("Ngày lập hóa đơn");
        ngaylaplbl.setIcon(calendericon);
        ngaylaplbl.setFont(f2);
        ngaylaplbl.setPreferredSize(new Dimension(170,30));
        ngaylap = LocalDateTime.now();
        ngaylaptxt = new JTextField();
        ngaylaptxt.setPreferredSize(new Dimension(100,30));
        ngaylaptxt.setHorizontalAlignment(JLabel.CENTER);
        ngaylaptxt.setFont(f2);
        ngaylaptxt.setText(dtf.format(ngaylap));
        ngaylaptxt.setForeground(red);
        ngaylaptxt.setEditable(false);
        
        infoPanel.setBackground(new Color(0,255,204));
        infoPanel.add(infolbl);
        infoPanel.add(idnvlbl);
        infoPanel.add(idnvtxt);
        //infoPanel.add(loaddatabtn);
        infoPanel.add(idhdlbl);
        infoPanel.add(idhdtxt);
        infoPanel.add(ngaylaplbl);
        infoPanel.add(ngaylaptxt);
        
        //thêm panel
        add(searchPanel);
        add(searchlbl1);
        add(searchjsp);
        add(cartlbl);
        add(cartjsp);
        add(checkoutbtn);
        add(printbtn);
        add(infoPanel);
        add(btnHistory);
        loadIdhd();
        //checkIdnv();
        loadDsmonan();
        loadIdnv();
    }  
    public void loadDsmonan(){
        MonanBUS bus = new MonanBUS();
        if(dsmonan == null) bus.docDsmonan();
        searchmodel = new DefaultTableModel(searchheader,0){
           public boolean isCellEditable(int row, int column) {
                if(column == 5){
                    return true;
                }else return false;
            }     
        };
        searchtable.setModel(searchmodel);
        String ngaylap = ngaylaptxt.getText();
        searchtable.getColumnModel().getColumn(5).setCellRenderer(new ButtonRender(searchtable,ngaylap));
        searchtable.getColumnModel().getColumn(5).setCellEditor(new ButtonRender(searchtable,ngaylap));
        for(MonanDTO monan : dsmonan){
            if(monan.getTrangthai().equals("1")){
                Object[] data = {monan.getTenmon(),monan.getTenloai(),monan.getDongia(),monan.getTonkho(),monan.getCogiamgia(),addicon};
                if(monan.getCogiamgia().equals("1")){
                    data[4] = "Có";
                }else{
                    data[4] = "Không";
                }
                searchmodel.addRow(data);
            }
        }
        searchtable.getColumnModel().getColumn(0).setPreferredWidth(150);
        searchtable.getColumnModel().getColumn(1).setPreferredWidth(70);
        searchtable.getColumnModel().getColumn(2).setPreferredWidth(70);
        searchtable.getColumnModel().getColumn(3).setPreferredWidth(100);
        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
        searchtable.getColumnModel().getColumn(5).setPreferredWidth(50);
    }
    
    public void loadTongtien(){
        tongtienlbl.setText("Tổng tiền: "+tongtien+" VND");
    }
    //
    //xử lí checkbox
    public void itemStateChanged(ItemEvent e){
        if(promotion.isSelected()){
            promotion.setIcon(null);
            promotion.setForeground(blue);
            System.out.println(promotionselected);
        }else{
            promotion.setForeground(red);
            promotion.setIcon(giamgiaicon1);
        }
        if(hot.isSelected()){
            hot.setIcon(null);
            hot.setForeground(blue);
            System.out.println(hotselected);
        }else{
            hot.setForeground(red);
            hot.setIcon(hoticon1);
        }
        

        if(e.getSource() == categorycb){
            boolean trung;
            MonanDTO monan = new MonanDTO();
            dsidmon = new ArrayList<String>();
            for(int i=0;i<dsmonan.size();i++){
                    trung = false;
                    monan = dsmonan.get(i);
                    for(int j=0;j<dsidmon.size();j++){
                        if(monan.getIdmon().equals(dsidmon.get(j))){
                            trung = true;
                            break;
                        }
                    }
                    if(trung == false) dsidmon.add(monan.getIdmon());
                }   
            JComboBox idmoncb = new JComboBox(dsidmon.toArray());
            if(categorycb.getSelectedIndex()==0){
                searchtxt.setText("");
                searchtxt.setEditable(true);
                hot.setEnabled(true);
                promotion.setEnabled(true);
                gia1txt.setEnabled(true);
                gia2txt.setEnabled(true);
                loaimonancb.setEnabled(true);
                promotion.setSelected(false);
                hot.setSelected(false);
                loaimonancb.setModel(loaicbModel);
                loaimonancb.setRenderer(new ComboBoxRender());
                loaimonancb.setEnabled(true);
            }else if(categorycb.getSelectedIndex()==1){
                int answer = JOptionPane.showConfirmDialog(this,idmoncb,null,JOptionPane.DEFAULT_OPTION);
                if(answer == JOptionPane.OK_OPTION){
                    searchtxt.setText(idmoncb.getSelectedItem().toString());
                    searchtxt.setEditable(true);
                    hot.setEnabled(false);
                    promotion.setEnabled(false);
                    gia1txt.setEnabled(false);
                    gia2txt.setEnabled(false);
                    gia1txt.setText("");
                    gia2txt.setText("");
                    loaimonancb.setEnabled(false);
                    loaimonancb.setModel(loaicbModel);
                    loaimonancb.setRenderer(new ComboBoxRender());
                }
            }else if(categorycb.getSelectedIndex()==2){
                searchtxt.setText("");
                searchtxt.setEditable(true);
                hot.setEnabled(false);
                promotion.setEnabled(false);
                gia1txt.setEnabled(false);
                gia2txt.setEnabled(false);
                loaimonancb.setEnabled(false);
                gia1txt.setText("");
                gia2txt.setText("");
            }else if(categorycb.getSelectedIndex()==3){
                searchtxt.setText("");
                searchtxt.setEditable(false);
                hot.setEnabled(false);
                promotion.setEnabled(false);
                promotion.setSelected(false);
                gia1txt.setEnabled(false);
                gia2txt.setEnabled(false);
                loaimonancb.setModel(loaicbModel1);
                loaimonancb.setRenderer(new ComboBoxRender());
                loaimonancb.setEnabled(true);
                gia1txt.setText("");
                gia2txt.setText("");
            }else if(categorycb.getSelectedIndex()==4){
                searchtxt.setEditable(false);
                searchtxt.setText("");
                hot.setEnabled(false);
                promotion.setEnabled(false);
                promotion.setSelected(true);
                hot.setSelected(false);
                gia1txt.setEnabled(false);
                gia2txt.setEnabled(false);
                loaimonancb.setModel(loaicbModel);
                loaimonancb.setRenderer(new ComboBoxRender());
                loaimonancb.setEnabled(false); 
                gia1txt.setText("");
                gia2txt.setText("");
            }else if(categorycb.getSelectedIndex()==5){
                searchtxt.setEditable(false);
                searchtxt.setText("");
                hot.setEnabled(false);
                hot.setSelected(true);
                promotion.setSelected(false);
                promotion.setEnabled(false);
                gia1txt.setEnabled(false);
                gia2txt.setEnabled(false);
                loaimonancb.setModel(loaicbModel1);
                loaimonancb.setRenderer(new ComboBoxRender());
                loaimonancb.setEnabled(false);
                gia1txt.setText("");
                gia2txt.setText("");
            }else if(categorycb.getSelectedIndex()==6){
                searchtxt.setText("");
                hot.setEnabled(false);
                promotion.setEnabled(false);
                promotion.setSelected(false);
                hot.setSelected(false);
                gia1txt.setEnabled(true);
                gia2txt.setEnabled(true);
                loaimonancb.setModel(loaicbModel1);
                loaimonancb.setRenderer(new ComboBoxRender());
                loaimonancb.setEnabled(false);
                searchtxt.setEditable(false);
                searchtxt.setText("");
            }
        }
    }

    public void loadIdhd(){
        HoadonBUS bus = new HoadonBUS();
        idhd1 = bus.loadIdhd();
        idhdtxt.setText(idhd1);
        idhdtxt.setForeground(red);
    }
    public void checkIdnv(){
        if(idnvtxt.getText().equals(""))
            idnv1 = "";
    }
    public void loadIdnv(){
        idnvtxt.setText(currentIdnv);
    }
    public void search(String searchstr,String loaimon,int gia1,int gia2,String dkkm,String dkhot){
        MonanBUS bus = new MonanBUS();
        dstimkim = new ArrayList<MonanDTO>();
        ArrayList<String> dsid = new ArrayList();
        MonanDTO pn = new MonanDTO();
        dstimkim = bus.search1(searchstr,loaimon,gia1,gia2,dkkm,dkhot);
        if(dstimkim.size()==0){
            JOptionPane.showMessageDialog(null,"Không tìm thấy kết quả phù hợp");
        }else{
            searchmodel = new DefaultTableModel(searchheader,0){
                public boolean isCellEditable(int row,int col){
                    if(col == 5){
                        return true;
                    }else return false;
                }
            };
            String ngaylap = ngaylaptxt.getText();
            searchtable.setModel(searchmodel);
            searchtable.getColumnModel().getColumn(5).setCellRenderer(new ButtonRender(searchtable,ngaylap));
            searchtable.getColumnModel().getColumn(5).setCellEditor(new ButtonRender(searchtable,ngaylap));
                for(MonanDTO monan : dstimkim){
                Object[] data= {monan.getTenmon(),monan.getTenloai(),monan.getDongia(),monan.getTonkho(),monan.getCogiamgia(),addicon};
                if(monan.getCogiamgia().equals("1")){
                    data[4] = "Có";
                }else{
                    data[4] = "Không";
                }
                searchmodel.addRow(data);
            }
            searchtable.getColumnModel().getColumn(0).setPreferredWidth(150);
            searchtable.getColumnModel().getColumn(1).setPreferredWidth(70);
            searchtable.getColumnModel().getColumn(2).setPreferredWidth(70);
            searchtable.getColumnModel().getColumn(3).setPreferredWidth(100);
            searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
            searchtable.getColumnModel().getColumn(5).setPreferredWidth(50);
        }
    }

    public static void main(String[] args) {
        ThanhtoanGUI a = new ThanhtoanGUI();
        a.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        MonanBUS bus = new MonanBUS(); 
        if(e.getSource() == searchbtn){
            String dkhot,dkkm;
            String searchstr = searchtxt.getText();
            String loaimon = ((ComboBoxList)loaimonancb.getSelectedItem()).getName();
            if(hot.isSelected()){
                dkhot = "Có";
            }else{
                dkhot = "Không";
            };
            if(promotion.isSelected()){
                dkkm = "1";
            }else{
                dkkm = "0";
            }
            //System.out.println("món get"loaimon);
            //System.out.println(loaimon.length());
            //if(searchstr.equals("")) System.out.println("rỗng");
            System.out.println(categorycb.getSelectedIndex());
            
            /* try{
                if(gia1txt.getText().equals("") || gia2txt.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Ô đơn giá trước phải bé hơn ô sau",
                            "Cảnh báo",JOptionPane.WARNING_MESSAGE);
                }else if(cl.kiemtraSophay(gia1txt.getText()) == false || cl.kiemtraSophay(gia2txt.getText()) == false){
                        JOptionPane.showMessageDialog(null,"Vui long nhap so nguyen",
                            "Cảnh báo",JOptionPane.WARNING_MESSAGE);
                }
                        else if(cl.kiemtraSokitu(gia1txt.getText(), 11) == false || cl.kiemtraSokitu(gia2txt.getText(), 11) == false){
                        JOptionPane.showMessageDialog(null,"Gia khong duoc vuot qua 11 so",
                            "Cảnh báo",JOptionPane.WARNING_MESSAGE);
                }else{
                    gia1 = Integer.parseInt(gia1txt.getText());
                    gia2 = Integer.parseInt(gia2txt.getText());
                    if(gia1 > gia2){
                        JOptionPane.showMessageDialog(null,"Ô đơn giá trước phải bé hơn ô sau",
                                "Cảnh báo",JOptionPane.WARNING_MESSAGE);
                    }else{
                        System.out.println(gia1);
                        System.out.println(gia2);
                        dstimkim = bus.search1(search,loaimon,gia1,gia2,dkkm,dkhot);
                        if(dstimkim.size()==0){ 
                            JOptionPane.showMessageDialog(null,"Không tìm thấy kết quả phù hợp");
                        }else{
                            searchmodel = new DefaultTableModel(searchheader,0){
                                public boolean isCellEditable(int row,int col){
                                    if(col == 4){
                                        return true;
                                    }else return false;
                                }
                            };
                            String ngaylap = ngaylaptxt.getText();
                            searchtable.setModel(searchmodel);
                            searchtable.getColumnModel().getColumn(4).setCellRenderer(new ButtonRender(searchtable,ngaylap));
                            searchtable.getColumnModel().getColumn(4).setCellEditor(new ButtonRender(searchtable,ngaylap));
                                for(MonanDTO monan : dstimkim){
                                Object[] data= {monan.getTenmon(),monan.getTenloai(),monan.getDongia(),monan.getCogiamgia(),addicon};
                                if(monan.getCogiamgia().equals("1")){
                                    data[3] = "Có";
                                }else{
                                    data[3] = "Không";
                                }
                                searchmodel.addRow(data);
                            }
                            searchtable.getColumnModel().getColumn(0).setPreferredWidth(150);
                            searchtable.getColumnModel().getColumn(1).setPreferredWidth(70);
                            searchtable.getColumnModel().getColumn(2).setPreferredWidth(70);
                            searchtable.getColumnModel().getColumn(3).setPreferredWidth(100);
                            searchtable.getColumnModel().getColumn(4).setPreferredWidth(50);
                        }
                    }
                }
            }catch(NumberFormatException err){
                JOptionPane.showMessageDialog(null,"Vui lòng nhập số vào đơn giá","Cảnh báo",JOptionPane.WARNING_MESSAGE);
            }*/
            if(categorycb.getSelectedIndex()==0){
                try{
                    gia1 = Integer.parseInt(gia1txt.getText());
                    gia2 = Integer.parseInt(gia2txt.getText());
                    if(gia1 > gia2){
                        JOptionPane.showMessageDialog(null,"Ô giá trước không được lớn hơn ô sau");
                    }else if(gia1<1000 || gia2<1000){
                        JOptionPane.showMessageDialog(null,"Ô gía không hợp lệ");
                    }else{
                        search(searchstr,loaimon,gia1,gia2,dkkm,dkhot);
                    }
                }catch(NumberFormatException err){
                    JOptionPane.showMessageDialog(null,"Hãy nhập số vào ô đơn giá");
                }
            }else if (categorycb.getSelectedIndex()==1){
                if((searchstr.equals("")) || searchstr.length()<3 || (!searchstr.substring(0,2).equals("SP"))){
                    JOptionPane.showMessageDialog(null,"ID sản phẩm không hợp lệ");
                    JOptionPane.showMessageDialog(null,"ID sản phẩm có mã bắt đầu là 'SP' ");
                }else{
                    search(searchstr,"",0,0,"0","Không");
                }
            }else if (categorycb.getSelectedIndex()==2){
                if(searchstr.equals("")){
                    JOptionPane.showMessageDialog(null,"Ô tìm kiếm không được để rỗng");
                }else{
                    search(searchstr,"",0,0,"0","Không");
                }    
            }else if(categorycb.getSelectedIndex()==3){
                System.out.println("loại món get: "+loaimon);
                search(searchstr,loaimon,0,0,"0","Không");
            }else if(categorycb.getSelectedIndex()==4){
                search(searchstr,"",0,0,"1","Không");
            }else if(categorycb.getSelectedIndex()==5){
                search(searchstr,"",0,0,"0","Có");
            }else if(categorycb.getSelectedIndex()==6){
                if((gia1txt.getText().equals("")) || (gia2txt.getText().equals(""))){
                    JOptionPane.showMessageDialog(null,"Ô đơn giá không được để trống");
                }else{
                    try{
                        gia1 = Integer.parseInt(gia1txt.getText());
                        gia2 = Integer.parseInt(gia2txt.getText());
                        if(gia1 > gia2){
                            JOptionPane.showMessageDialog(null,"Ô giá trước không được lớn hơn ô sau");
                        }else if( gia1<1000 || gia2<1000){
                            JOptionPane.showMessageDialog(null,"Ô giá không hợp lệ");
                        }
                    }catch(NumberFormatException err){
                        JOptionPane.showMessageDialog(null,"Hãy nhập số vào ô đơn giá");
                    }
                    search(searchstr,"",gia1,gia2,"0","Không");
                }
            }
        }else if(e.getSource() == loaddatabtn){
            DsnvdialogGUI dsnv = new DsnvdialogGUI(home,true);
            dsnv.setVisible(true);
            if(!dsnv.isVisible()){
                idnvtxt.setText(idnv1);
            }
        }else if(e.getSource() == reloadbtn){
            searchtxt.setText("");
            loadDsmonan();   
            JOptionPane.showMessageDialog(null,"Làm mới thành công");
        }else if(e.getSource()== checkoutbtn){
            HoadonBUS hdbus = new HoadonBUS();
            int i = carttable.getRowCount();
            if(i==0){
                JOptionPane.showMessageDialog(null,"Vui lòng mua hàng trước khi thanh toán","Cảnh báo",JOptionPane.WARNING_MESSAGE);
	    }else{
		int answer = JOptionPane.showConfirmDialog(null,"Bạn có muốn thanh toán không ?",null,JOptionPane.WARNING_MESSAGE);
                if(answer == JOptionPane.YES_OPTION){
                hdbus.checkOut(giohang);
                cartmodel = new DefaultTableModel(cartheader,0);
                carttable.setModel(cartmodel);
                loadIdhd();
                loadDsmonan();
                }
            }    
        }else if(e.getSource() == printbtn){
            String path="";
            JFileChooser j = new JFileChooser();
            j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int answer = j.showSaveDialog(this);
            if(answer == JFileChooser.APPROVE_OPTION){
                path = j.getSelectedFile().getPath();
            
                String name = JOptionPane.showInputDialog(null,"Nhập tên muốn lưu");
                Document doc = new Document();
                try{
                   PdfWriter.getInstance(doc,new FileOutputStream(path+name+".pdf"));

                   doc.open();

                   PdfPTable table = new PdfPTable(7);
                   table.addCell("IDNV");
                   table.addCell("IDHD");
                   table.addCell("Tên món ăn");
                   table.addCell("Đơn giá");
                   table.addCell("Số lượng");
                   table.addCell("Thành tiền");
                   table.addCell("Tổng tiền");

                   for(int i=0;i<carttable.getRowCount();i++){
                        String idnv = carttable.getValueAt(i,0).toString();
                        String idhd2 = carttable.getValueAt(i,1).toString();
                        String tenmonan = carttable.getValueAt(i,2).toString();
                        String dongia = carttable.getValueAt(i,3).toString();
                        String soluong = carttable.getValueAt(i,4).toString();
                        String thanhtien = carttable.getValueAt(i,5).toString();
                        String tongtien = carttable.getValueAt(i,6).toString();

                        table.addCell(idnv);
                        table.addCell(idhd2);
                        table.addCell(tenmonan);
                        table.addCell(dongia);
                        table.addCell(soluong);
                        table.addCell(thanhtien);
                        table.addCell(tongtien);
                   }

                   doc.add(table);
                    JOptionPane.showMessageDialog(null,"Lưu thành công");

                }catch(FileNotFoundException er){
                    JOptionPane.showMessageDialog(null,"không tìm thấy file");
                }catch(DocumentException ex){
                    JOptionPane.showMessageDialog(null,"không tìm thấy thư mục");
                }
                doc.close();
            }
        } else if(e.getSource() == btnHistory)
        {
            OverallFrame.changeMainInfo(3);
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
        }else if(e.getSource() == printbtn){
            ImageIcon printicon2 = new ImageIcon(this.getClass().getResource("/Icons/printericon2.png"));
            printbtn.setIcon(printicon2);
        }else if(e.getSource() == loaddatabtn){
            ImageIcon extendsionicon2 = new ImageIcon(this.getClass().getResource("/Icons/extendsion2.png"));
            loaddatabtn.setIcon(extendsionicon2);
        }else if(e.getSource() == checkoutbtn){
            ImageIcon checkouticon2 = new ImageIcon(this.getClass().getResource("/Icons/checkouticon2.png"));
            checkoutbtn.setIcon(checkouticon2);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == searchbtn){
            ImageIcon searchicon1 = new ImageIcon(this.getClass().getResource("/Icons/searchicon1.png"));
            searchbtn.setIcon(searchicon1);
        }else if(e.getSource() == reloadbtn){
            ImageIcon refreshicon1 = new ImageIcon(this.getClass().getResource("/Icons/refreshicon1.png"));
            reloadbtn.setIcon(refreshicon1);
        }else if(e.getSource() == printbtn){
            ImageIcon printicon1 = new ImageIcon(this.getClass().getResource("/Icons/printericon1.png"));
            printbtn.setIcon(printicon1);
        }else if(e.getSource() == loaddatabtn){
            ImageIcon extendsionicon1 = new ImageIcon(this.getClass().getResource("/Icons/extendsion1.png"));
            loaddatabtn.setIcon(extendsionicon1);
        }else if(e.getSource() == checkoutbtn){
            ImageIcon checkouticon1 = new ImageIcon(this.getClass().getResource("/Icons/checkouticon1.png"));
            checkoutbtn.setIcon(checkouticon1);
        }
    }

}
     
