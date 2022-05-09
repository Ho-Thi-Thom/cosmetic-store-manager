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
public class ThongkeDTO {
   private String MaSP,TenSP,Soluongbd;
   private String thang;
      private float doanhthuthang;

    public ThongkeDTO(String thang, float doanhthuthang) {
        this.thang = thang;
        this.doanhthuthang = doanhthuthang;
    }
    
    public ThongkeDTO() {
    }

    public ThongkeDTO(String MaSP, String TenSP, String Soluongbd) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.Soluongbd = Soluongbd;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getSoluongbd() {
        return Soluongbd;
    }

    public void setSoluongbd(String Soluongbd) {
        this.Soluongbd = Soluongbd;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public float getDoanhthuthang() {
        return doanhthuthang;
    }

    public void setDoanhthuthang(float doanhthuthang) {
        this.doanhthuthang = doanhthuthang;
    }
   
}
