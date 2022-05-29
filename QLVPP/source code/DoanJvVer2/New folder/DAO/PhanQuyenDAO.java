/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.PhanQuyenDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Nam
 */
public class PhanQuyenDAO {
    MyDBConnection conn = new MyDBConnection();

    public PhanQuyenDAO() 
    {
        
    }  
    public ArrayList docUserInfo()
            //ham lay thong in user
    {
        ArrayList dsuser = new ArrayList<PhanQuyenDTO>();
        try
        {
            String query = "Select iduser, username, pass, idquyen, fname, lname, trangthai from user";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                PhanQuyenDTO dto = new PhanQuyenDTO();
                dto.setIduser(rs.getString(1));//ghi du lieu tu databse vao DTO
                dto.setUsername(rs.getString(2));//ghi du lieu tu databse vao DTO
                dto.setPass(rs.getString(3));
                dto.setQuyen(rs.getString(4));
                dto.setFname(rs.getString(5));
                dto.setLname(rs.getString(6));
                dto.setTrangthai(rs.getString(7));
                dsuser.add(dto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dsuser;
    }
//    public static void main(String[] args) {
//        PhanQuyenDAO q = new PhanQuyenDAO();
//        q.docUserInfo();
//    }
}

