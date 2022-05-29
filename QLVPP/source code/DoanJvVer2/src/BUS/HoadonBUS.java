package BUS;

import static BUS.ChiTietGiamBUS.dschitiet;
import java.util.ArrayList;
import DTO.HoadonDTO;
import DAO.HoadonDAO;
import DTO.ChiTietGiamDTO;
import DTO.MonanDTO;
import javax.swing.JOptionPane;
import static BUS.MonanBUS.dsmonan;
import DAO.MonanDAO;

/**
 *
 * @author USER
 */
public class HoadonBUS {
    public static ArrayList<HoadonDTO> giohang;
    private ArrayList<String> dsidmon;
    public static int tongtien;
    public int max;
    private int thanhtien;
    private String idhd;
    public static ArrayList<HoadonDTO> dshoadon; 
    public static ArrayList<HoadonDTO> dshd; 
    //public static String idhd;
    
    public HoadonBUS(){};
    
    public void docDshoadon(){
        HoadonDAO data = new HoadonDAO();
        dshoadon = new ArrayList<HoadonDTO>();
        dshoadon = data.DocDshoadon();
    }
    public String loadIdhd(){
        HoadonDAO data = new HoadonDAO();
        dsidmon = new ArrayList();
        dsidmon = data.getIdhd();
        
        if(dsidmon.size() == 0)
        {
            idhd = "HD1";
        }
        else
        {
            max = Integer.parseInt(dsidmon.get(0).substring(2));
        for(int i = 0;i<dsidmon.size();i++){
            int idnext = Integer.parseInt(dsidmon.get(i).substring(2));
            if(idnext > max){
                max = idnext;
            }
        }
        idhd = "HD" + Integer.toString(max+1);
        }
        return idhd;
    }
    public void dochoadon(String id)
    {
        HoadonDAO dao = new HoadonDAO();
        dao.dochoadon(id);
        dshd = new ArrayList<HoadonDTO>();
        dshd = HoadonDAO.dshd;

    }
    public void addCart(String idnv,String idhd1,String tenmonan,int sl,String ngaylap){
        if(giohang == null) giohang = new ArrayList<HoadonDTO>();
        Boolean loop = false;
        MonanBUS monanbus = new MonanBUS();
        MonanDAO data = new MonanDAO();
        ChiTietGiamBUS ctgbus = new ChiTietGiamBUS();
        if(dsmonan == null) monanbus.docDsmonan();
        ctgbus.docChitiet();
        for(MonanDTO monan : monanbus.dsmonan){
            if(monan.cogiamgia.equals("1")){
                for(ChiTietGiamDTO ctg : dschitiet){
                    if(monan.idmon.equals(ctg.getIdMon())){
                        monan.dongia -= monan.dongia/100*Integer.parseInt(ctg.getTileGiam());
                        System.out.println(ctg.getTileGiam());
                    }
                }
            }
        }
        for(MonanDTO monan : dsmonan){
            if(monan.tenmon.equals(tenmonan)){
                if(monan.tonkho >= sl){
                    for(HoadonDTO hd : giohang){
                        if(hd.tenmonan.equals(tenmonan)){
                            hd.soluong += sl;
                            System.out.println(monan.tonkho);
                            monan.tonkho -= sl;
                            monan.soluongdaban += sl;
                            hd.thanhtien = hd.soluong*hd.dongia;
                            System.out.println("Thành tiền" +hd.thanhtien);
                            tongtien += sl*monan.dongia;  
                            data.update(monan);
                            loop = true;
                        }
                    } 
                    if (loop == false){
                        monan.tonkho -= sl;
                        monan.soluongdaban += sl;
                        thanhtien = sl*monan.dongia;
                        tongtien += sl*monan.dongia;
                        giohang.add(new HoadonDTO(idnv,idhd1,tenmonan,monan.idmon,monan.dongia,
                                sl,sl*monan.dongia,tongtien,ngaylap,1)); 
                        data.update(monan);
                    }            
                }else{
                    JOptionPane.showMessageDialog(null,"Trong kho không đủ",null,JOptionPane.INFORMATION_MESSAGE);
                }
            }
       }
    }

    public void removeCart(String tenmonan,int soluong){
        int i=0;
        MonanBUS monanbus = new MonanBUS();
        MonanDAO data = new MonanDAO();
        HoadonDTO spxoa = new HoadonDTO();
        for(HoadonDTO sp : giohang){
            if(tenmonan.equals(sp.tenmonan)){
                spxoa=giohang.get(i);
                for(MonanDTO monan : dsmonan){
                    if(tenmonan.equals(monan.tenmon)){
                        monan.soluongdaban -= soluong;
                        monan.tonkho += soluong;
                        data.update(monan);
                    }
                }
                tongtien -= sp.thanhtien;
            }
            i++;
        }
        giohang.remove(spxoa);
    }
   public void checkOut(ArrayList<HoadonDTO> giohang){
        HoadonDAO data = new HoadonDAO();
        HoadonDTO hd = new HoadonDTO();
        data.ThemHoadon(giohang.get(0));
        for(int i=0;i<giohang.size();i++){
            hd = giohang.get(i);
            data.ThemChitietHoadon(hd);
        }
        tongtien=0;
        giohang.clear();
    }
    public ArrayList<HoadonDTO> search(String strsearch,String dateStart,String dateEnd,int gia1,int gia2){
         System.out.println("ngay1"+ dateStart);
          System.out.println("ngay2"+ dateEnd); 
          System.out.println("gia1"+ gia1);
           System.out.println("gia2"+ gia2);
           System.out.println("str"+ strsearch);
        ArrayList<HoadonDTO> dstimkim = new ArrayList();
        for(HoadonDTO hd : dshoadon){
            if(strsearch.equals("")){
                if(dateStart.equals("")){
                    if((hd.tongtien >= gia1) && (hd.tongtien <= gia2)){
                        dstimkim.add(hd);
                    } 
                }else if(gia1==0){
                    if(((hd.ngaylap.compareTo(dateStart) >= 0) && (hd.ngaylap.compareTo(dateEnd) <= 0))){
                        dstimkim.add(hd);
                    } 
                }else {
                    if(((hd.ngaylap.compareTo(dateStart) >= 0) && (hd.ngaylap.compareTo(dateEnd) <= 0))
                        && ((hd.tongtien >= gia1) && (hd.tongtien <= gia2))){
                        dstimkim.add(hd);
                   }
                }
            }else{
                String first = strsearch.substring(0,2);
                System.out.println(first);
                if(first.equals("HD")){
                   if(hd.idhd.equals(strsearch)) dstimkim.add(hd);
                }else{
                   if(hd.idnv.equals(strsearch)) dstimkim.add(hd);
                }
            }
        }
        return dstimkim;
    }
    public ArrayList<HoadonDTO> timtheoAll(String ma)
    {
        docDshoadon();
        ArrayList<HoadonDTO> kq = new ArrayList<HoadonDTO>();
        for (HoadonDTO a : dshoadon)
        {
            if(    a.getIdhd().indexOf(ma) >=0
                || a.getIdnv().indexOf(ma) >=0
                || a.getNgaylap().indexOf(ma) >=0
               )
            {
                kq.add(a);
            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Không tìm thấy");
//                break;
//            }
        }
        return kq;
    }
        
        public ArrayList<HoadonDTO> timtheoMa(String ma)
    {
        docDshoadon();
        ArrayList<HoadonDTO> kq = new ArrayList<HoadonDTO>();
        for (HoadonDTO a : dshoadon)
        {
            if(a.getIdhd().indexOf(ma) >=0)
            {
                kq.add(a);
            }

        }
        return kq;
    }
        
        public ArrayList<HoadonDTO> timtheongaylap(String ma)
    {
        docDshoadon();
        ArrayList<HoadonDTO> kq = new ArrayList<HoadonDTO>();
        for (HoadonDTO a : dshoadon)
        {
            if(a.getNgaylap().indexOf(ma) >=0)
            {
                kq.add(a);
            }

        }
        return kq;
    }
        
     public void xoaHoadon(String hd)
    {
        HoadonDAO dao = new HoadonDAO();
        
        for(HoadonDTO a : dshd)//duyet arraylist cua bus
        {
            if(a.getIdhd().equals(hd))//so sanh id trong array vs biến truyền từ gui
            {               
                dshd.remove(a);
                break;
            }
        }
        dao.xoaHoadon(hd);// truyền ct vào dao để update
    }
}
