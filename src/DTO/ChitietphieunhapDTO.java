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
public class ChitietphieunhapDTO {
    private String MaHDNH,MaSP;
    private int Soluong;
    private float Dongianhap,Thanhtien;

    public ChitietphieunhapDTO() {
    }

    public ChitietphieunhapDTO(String MaHDNH, String MaSP, int Soluong, float Dongianhap, float Thanhtien) {
        this.MaHDNH = MaHDNH;
        this.MaSP = MaSP;
        this.Soluong = Soluong;
        this.Dongianhap = Dongianhap;
        this.Thanhtien = Thanhtien;
    }

    public String getMaHDNH() {
        return MaHDNH;
    }

    public void setMaHDNH(String MaHDNH) {
        this.MaHDNH = MaHDNH;
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

    public float getDongianhap() {
        return Dongianhap;
    }

    public void setDongianhap(float Dongianhap) {
        this.Dongianhap = Dongianhap;
    }

    public float getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien(float Thanhtien) {
        this.Thanhtien = Thanhtien;
    }
    
    
}
