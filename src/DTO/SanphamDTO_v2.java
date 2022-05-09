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
public class SanphamDTO_v2 {
    private String Masp, Tensp,Dongia,Donvitinh;
    private LoaiSpDTO loaisp;
    private NHASXDTO nhasx;
    private int Soluong;
    public SanphamDTO_v2() {
    }

    public SanphamDTO_v2(String Masp, String Tensp, String Dongia, String Donvitinh, LoaiSpDTO loaisp, NHASXDTO nhasx, int Soluong) {
        this.Masp = Masp;
        this.Tensp = Tensp;
        this.Dongia = Dongia;
        this.Donvitinh = Donvitinh;
        this.loaisp = loaisp;
        this.nhasx = nhasx;
        this.Soluong = Soluong;
    }
    
    public String getMasp() {
        return Masp;
    }

    public void setMasp(String Masp) {
        this.Masp = Masp;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String Tensp) {
        this.Tensp = Tensp;
    }

    public String getDongia() {
        return Dongia;
    }

    public void setDongia(String Dongia) {
        this.Dongia = Dongia;
    }

    public String getDonvitinh() {
        return Donvitinh;
    }

    public void setDonvitinh(String Donvitinh) {
        this.Donvitinh = Donvitinh;
    }

    public NHASXDTO getNhasx() {
        return nhasx;
    }

    public void setNhasx(NHASXDTO nhasx) {
        this.nhasx = nhasx;
    }

    public LoaiSpDTO getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(LoaiSpDTO loaisp) {
        this.loaisp = loaisp;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }     
}
