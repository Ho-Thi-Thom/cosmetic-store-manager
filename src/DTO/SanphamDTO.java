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
public class SanphamDTO {
    private String Masp, Tensp,Dongia,Donvitinh,MaNSX,Maloai;
    private int Soluong;
    public SanphamDTO() {
    }
   

    public SanphamDTO(String Masp, String Tensp, String Dongia, String Donvitinh, String MaNSX, String Maloai, int Soluong) {
        this.Masp = Masp;
        this.Tensp = Tensp;
        this.Dongia = Dongia;
        this.Donvitinh = Donvitinh;
        this.MaNSX = MaNSX;
        this.Maloai = Maloai;
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

    public String getMaNSX() {
        return MaNSX;
    }

    public void setMaNSX(String MaNSX) {
        this.MaNSX = MaNSX;
    }

    public String getMaloai() {
        return Maloai;
    }

    public void setMaloai(String Maloai) {
        this.Maloai = Maloai;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

   
    
    
}
