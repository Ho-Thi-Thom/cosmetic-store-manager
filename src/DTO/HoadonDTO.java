/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @Hồ Thị Thơm
 * DCT1187
 */
public class HoadonDTO {
    private String MaHD, MaKH, MaNV, MaKM,TienKM,Tongtien,Ngaylap;

    public HoadonDTO() {
    }

    public HoadonDTO(String MaHD, String MaKH, String MaNV, String MaKM, String TienKM, String Tongtien, String Ngaylap) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
        this.MaKM = MaKM;
        this.TienKM = TienKM;
        this.Tongtien = Tongtien;
        this.Ngaylap = Ngaylap;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getTienKM() {
        return TienKM;
    }

    public void setTienKM(String TienKM) {
        this.TienKM = TienKM;
    }

    public String getTongtien() {
        return Tongtien;
    }

    public void setTongtien(String Tongtien) {
        this.Tongtien = Tongtien;
    }

    public String getNgaylap() {
        return Ngaylap;
    }

    public void setNgaylap(String Ngaylap) {
        this.Ngaylap = Ngaylap;
    }
   
}
