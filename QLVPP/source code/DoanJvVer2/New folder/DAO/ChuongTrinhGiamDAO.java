/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietGiamDTO;
import DTO.ChuongTrinhGiamDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class ChuongTrinhGiamDAO {
    MyDBConnection conn = new MyDBConnection();
    public ChuongTrinhGiamDAO() 
    {
        
    }  
    public ArrayList docGiamgia()
            //ham lay thong in user
    {
        ArrayList dsgiamgia = new ArrayList<ChuongTrinhGiamDTO>();
        try
        {
            String query = "Select * from chuongtrinhgiam";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                ChuongTrinhGiamDTO dto = new ChuongTrinhGiamDTO();
                dto.setIdgiam(rs.getString(1));//ghi du lieu tu databse vao DTO
                dto.setTenchuongtrinh(rs.getString(2));//ghi du lieu tu databse vao DTO
                dto.setThoigianbatdau(rs.getString(3));
                dto.setThoigianketthuc(rs.getString(4));
                dto.setNoidung(rs.getString(5));
                dto.setTrangthai(rs.getString(6));
                
                dsgiamgia.add(dto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dsgiamgia;
    }
    public ArrayList docChitiet()
            //ham lay thong in user
    {
        ArrayList dschitiet = new ArrayList<ChiTietGiamDTO>();
        try
        {
            String query = "Select * from chitietgiam";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                ChiTietGiamDTO dto = new ChiTietGiamDTO();
                dto.setIdMon(rs.getString(1));//ghi du lieu tu databse vao DTO
                dto.setIdGiam(rs.getString(2));//ghi du lieu tu databse vao DTO
                dto.setTileGiam(rs.getString(3));
                
                
                dschitiet.add(dto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dschitiet;
    }
    public void themChuongtrinh(ChuongTrinhGiamDTO ct)
    {
        try
        {
        String query = "INSERT INTO `chuongtrinhgiam` VALUES ("
                + "'" +ct.getIdgiam()+ "',"
                + "'" +ct.getTenchuongtrinh()+ "',"
                + "'" +ct.getThoigianbatdau()+ "',"
                + "'" +ct.getThoigianketthuc()+ "',"
                + "'" +ct.getNoidung()+ "',"
                + "'" +ct.getTrangthai()+ "')";
        conn.executeQuery(query);
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void themChitiet(ChiTietGiamDTO ctg)
    {
        try
        {
        String query = "INSERT INTO `chitietgiam` VALUES ("
                + "'" +ctg.getIdMon()+ "',"
                + "'" +ctg.getIdGiam()+ "',"
                + "'" +ctg.getTileGiam()+ "')";
        conn.executeQuery(query);
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void suaChuongTrinh(ChuongTrinhGiamDTO ct)
    {
        try
        {
            String query = "UPDATE `chuongtrinhgiam` SET "
                    +"tenchuongtrinh="+"'"+ct.getTenchuongtrinh()+"'"
                    +",thoigianbatdau="+"'"+ct.getThoigianbatdau()+"'"
                    +",thoigianketthuc="+"'"+ct.getThoigianketthuc()+"'"
                    +",noidung="+"'"+ct.getNoidung()+"'"
                    +",trangthai="+"'"+ct.getTrangthai()
                    +"' where idgiam='"+ct.getIdgiam()+"'";
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa chương trình giảm giá");
        }
    }
    public void suaChiTiet(ChiTietGiamDTO ctg)
    {
        try
        {
            String query = "UPDATE `chitietgiam` SET "
                    +"idmon="+"'"+ctg.getIdMon()+"'"
                    +",giam="+"'"+ctg.getTileGiam()+"'"
                    +"' where idgiam='"+ctg.getIdGiam()+"'";// sua theo id
            conn.executeQuery(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa chi tiết giảm giá");
        }
    }
}
