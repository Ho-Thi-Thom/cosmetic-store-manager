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
public class Sanpham_KhuyenmaiDTO {
    private String MaKM,MaSP;
    private int cachtinh;

    public Sanpham_KhuyenmaiDTO() {
    }

    public Sanpham_KhuyenmaiDTO(String MaKM, String MaSP, int cachtinh) {
        this.MaKM = MaKM;
        this.MaSP = MaSP;
        this.cachtinh = cachtinh;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public int getCachtinh() {
        return cachtinh;
    }

    public void setCachtinh(int cachtinh) {
        this.cachtinh = cachtinh;
    }
    
}
