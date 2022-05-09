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
public class NhanvienDTO {
    private String MaNV,TenNV,Diachi,Sdt,Email;
    private String Gioitinh;
    private String Ngaysinh;

    public NhanvienDTO() {
    }

    public NhanvienDTO(String MaNV, String TenNV, String Diachi, String Sdt, String Email,String Gioitinh, String Ngaysinh) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.Diachi = Diachi;
        this.Sdt = Sdt;
        this.Email = Email;
        this.Gioitinh = Gioitinh;
        this.Ngaysinh = Ngaysinh;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
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
