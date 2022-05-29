/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Nam
 */
public class PhanQuyenDTO {
    private String username;
    private String pass;
    private String quyen;
    private String fname;
    private String lname;
    private String iduser;
    private String trangthai;

    public PhanQuyenDTO()
    {
        this.username = "";
        this.pass = "";
        this.quyen = null;
        this.fname = null;
        this.lname = null;
        this.iduser = null;
        this.trangthai = null;
    }

    public PhanQuyenDTO(String username, String pass, String quyen, 
            String fname, String lname, String iduser, String trangthai) {
        this.username = username;
        this.pass = pass;
        this.quyen = quyen;
        this.fname = fname;
        this.lname = lname;
        this.iduser = iduser;
        this.trangthai = trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getTrangthai() {
        return trangthai;
    }
    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }
}