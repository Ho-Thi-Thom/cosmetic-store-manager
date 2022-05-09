/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author MYPC
 */
public class PhieunhapDTO {
    private String  MaHDNH,MaNV,MaNCC,Ngaylap ,Tongtien;
  

    public PhieunhapDTO() {
    }

    public PhieunhapDTO(String MaHDNH, String MaNV, String MaNCC, String Ngaylap, String Tongtien) {
        this.MaHDNH = MaHDNH;
        this.MaNV = MaNV;
        this.MaNCC = MaNCC;
        this.Ngaylap = Ngaylap;
        this.Tongtien = Tongtien;
    }

    public String getMaHDNH() {
        return MaHDNH;
    }

    public void setMaHDNH(String MaHDNH) {
        this.MaHDNH = MaHDNH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getNgaylap() {
        return Ngaylap;
    }

    public void setNgaylap(String Ngaylap) {
        this.Ngaylap = Ngaylap;
    }

    public String getTongtien() {
        return Tongtien;
    }

    public void setTongtien(String Tongtien) {
        this.Tongtien = Tongtien;
    }
    
   
}
