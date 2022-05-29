/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhanQuyenDAO;
import DTO.PhanQuyenDTO;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class PhanQuyenBUS {
    public static ArrayList<PhanQuyenDTO> dsuser; 
    public PhanQuyenBUS()
    {
    }
    public void docUserInfo()
    {
        PhanQuyenDAO dao = new PhanQuyenDAO();
        if(dsuser == null)//neu array rong thi them moi 
        {
            dsuser = new ArrayList<PhanQuyenDTO>();
            dsuser = dao.docUserInfo();//ghi arraylist cua DAO vao arraylist cua BUS
        }
    }
}
