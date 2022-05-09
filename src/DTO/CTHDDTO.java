/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * Ho Thi Thom 
 * DCT1187
*/
public class CTHDDTO {
    String MaHD, MaSP;
    int Soluong;
    float Dongiaban,tienkhuyenmaisp,Thanhtien;
    public CTHDDTO() {
    }

    public CTHDDTO(String MaHD, String MaSP, int Soluong, float Dongiaban, float tienkhuyenmaisp, float Thanhtien) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.Soluong = Soluong;
        this.Dongiaban = Dongiaban;
        this.tienkhuyenmaisp = tienkhuyenmaisp;
        this.Thanhtien = Thanhtien;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public float getDongiaban() {
        return Dongiaban;
    }

    public void setDongiaban(float Dongiaban) {
        this.Dongiaban = Dongiaban;
    }

    public float getTienkhuyenmaisp() {
        return tienkhuyenmaisp;
    }

    public void setTienkhuyenmaisp(float tienkhuyenmaisp) {
        this.tienkhuyenmaisp = tienkhuyenmaisp;
    }

    public float getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien(float Thanhtien) {
        this.Thanhtien = Thanhtien;
    }
    
   
    
}
