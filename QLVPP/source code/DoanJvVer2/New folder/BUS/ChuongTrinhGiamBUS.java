/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChuongTrinhGiamDAO;
import DTO.ChiTietGiamDTO;
import DTO.ChuongTrinhGiamDTO;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class ChuongTrinhGiamBUS {
    public static ArrayList<ChuongTrinhGiamDTO> dsgiamgia; 
    public static ArrayList<ChiTietGiamDTO> dschitiet; 
    public ChuongTrinhGiamBUS()
    {
    }
    public void docGiamgia()
    {
        ChuongTrinhGiamDAO dao = new ChuongTrinhGiamDAO();
        if(dsgiamgia == null)//neu array rong thi them moi 
        {
            dsgiamgia = new ArrayList<ChuongTrinhGiamDTO>();
            dsgiamgia = dao.docGiamgia();//ghi arraylist cua DAO vao arraylist cua BUS
        }
    }
    public void docChitiet()
    {
        ChuongTrinhGiamDAO dao = new ChuongTrinhGiamDAO();
        if(dschitiet == null)//neu array rong thi them moi 
        {
            dschitiet = new ArrayList<ChiTietGiamDTO>();
            dschitiet = dao.docChitiet();//ghi arraylist cua DAO vao arraylist cua BUS
        }
    }
    public void themChuongtrinh(ChuongTrinhGiamDTO ct)
    {
//        for(ChuongTrinhGiamDTO a : dsgiamgia)
//        {
//            if(ct.getIdgiam().equals(a.getIdgiam()))
//            {
//                JOptionPane.showMessageDialog(null, "Mã giảm giá trùng");
//            }
//        }
        ChuongTrinhGiamDAO dao = new ChuongTrinhGiamDAO();
        dao.themChuongtrinh(ct);//truyền bien ct xuog lớp dao
        dsgiamgia.add(ct);// them vao arr cua bus
    }
    public void themChitiet(ChiTietGiamDTO ctg)
    {
        ChuongTrinhGiamDAO dao = new ChuongTrinhGiamDAO();
        dao.themChitiet(ctg);
        dschitiet.add(ctg);
    }
    public void suaChuongtrinh(ChuongTrinhGiamDTO ct)
    {
        ChuongTrinhGiamDAO dao = new ChuongTrinhGiamDAO();
        dao.suaChuongTrinh(ct);// truyền ct vào dao để update
        for(ChuongTrinhGiamDTO a : dsgiamgia)//duyet arraylist cua bus
        {
            if(a.getIdgiam().equals(ct.getIdgiam()))//so sanh id trong array vs biến truyền từ gui
            {
                a.setTenchuongtrinh(ct.getTenchuongtrinh());//gan' bien tu GUI vao arraylist
                a.setThoigianbatdau(ct.getThoigianbatdau());
                a.setThoigianketthuc(ct.getThoigianketthuc());
                a.setNoidung(ct.getNoidung());
                a.setTrangthai(ct.getTrangthai());
            }
        }
    }
    public void suaChiTiet(ChiTietGiamDTO ctg)
    {
        ChuongTrinhGiamDAO dao = new ChuongTrinhGiamDAO();
        dao.suaChiTiet(ctg);// truyền biến vào dao để update
        for(ChiTietGiamDTO a : dschitiet)//duyet arraylist cua bus
        {
            if(a.getIdGiam().equals(ctg.getIdGiam()))//so sanh id trong array vs biến truyền từ gui
            {
                a.setIdMon(ctg.getIdMon());//gan' bien tu GUI vao arraylist
                a.setTileGiam(ctg.getTileGiam());
                
            }
        }
    }
    
//    public static void main(String[] args) {
//        ChuongTrinhGiamBUS bus = new ChuongTrinhGiamBUS();
//        if(ChuongTrinhGiamBUS.dschitiet == null);//neu array rong thi goi ham doc trong BUS de them moi
//        {
//            bus.docChitiet();
//        }
//        for(ChiTietGiamDTO a : dschitiet)
//        {
//            System.out.println(a.getIdMon());
//            System.out.println(a.getIdGiam());
//            System.out.println(a.getTileGiam());
//        }
//    }
}
