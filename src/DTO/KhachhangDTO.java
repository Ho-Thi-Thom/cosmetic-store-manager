/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author MYPC
 */
public class KhachhangDTO {
    private String MaKH,TenKH,Diachi,Sdt,Email;
    private String Gioitinh;
    private String Ngaysinh;

    public KhachhangDTO() {
    }

    public KhachhangDTO(String MaKH, String TenKH, String Diachi, String Sdt, String Email,String Gioitinh, String Ngaysinh) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.Diachi = Diachi;
        this.Sdt = Sdt;
        this.Email = Email;
        this.Gioitinh = Gioitinh;
        this.Ngaysinh = Ngaysinh;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }
    
    
}
