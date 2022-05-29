/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author USER
 */
public class HoadonDTO {
    public String idnv,idhd,tenmonan,loaimonan,ngaylap,idmon;
    public int dongia,soluong,trangthai,thanhtien,tongtien;

    public HoadonDTO(){
        
    }
    
    public HoadonDTO(String idnv,String idhd,String tenmonan,String idmon,int dongia,int soluong,int thanhtien,int tongtien,String ngaylap,int trangthai){
        setIdnv(idnv);
        setIdhd(idhd);
        setTenmonan(tenmonan);
        setIdmon(idmon);
        setGiatien(dongia);
        setSoluong(soluong);
        setNgaylap(ngaylap);
        setTrangthai(trangthai);
        setThanhtien(thanhtien);
        setTongtien(tongtien);
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setIdmon(String idmon) {
        this.idmon = idmon;
    }

    public String getIdmon() {
        return idmon;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public void setIdhd(String idhd) {
        this.idhd = idhd;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public String getIdhd() {
        return idhd;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public int getDongia() {
        return dongia;
    }


    public void setTenmonan(String tenmonan) {
        this.tenmonan = tenmonan;
    }

    public void setLoaimonan(String loaimonan) {
        this.loaimonan = loaimonan;
    }

    public void setGiatien(int giatien) {
        this.dongia = giatien;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getIdnv() {
        return idnv;
    }

    public String getTenmonan() {
        return tenmonan;
    }

    public String getLoaimonan() {
        return loaimonan;
    }

    public int getGiatien() {
        return dongia;
    }

    public int getSoluong() {
        return soluong;
    }
    
    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public int getTongtien() {
        return tongtien;
    }
}
