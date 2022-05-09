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
public class ChuongtrinhkhuyenmaiDTO {
    private String MaKM,TenCT,LoaiCT,NdGG,NgayBD,NgayKT;
  
    public ChuongtrinhkhuyenmaiDTO() {
    }

    public ChuongtrinhkhuyenmaiDTO(String MaKM, String TenCT, String LoaiCT, String NdGG, String NgayBD, String NgayKT) {
        this.MaKM = MaKM;
        this.TenCT = TenCT;
        this.LoaiCT = LoaiCT;
        this.NdGG = NdGG;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getTenCT() {
        return TenCT;
    }

    public void setTenCT(String TenCT) {
        this.TenCT = TenCT;
    }

    public String getLoaiCT() {
        return LoaiCT;
    }

    public void setLoaiCT(String LoaiCT) {
        this.LoaiCT = LoaiCT;
    }

    public String getNdGG() {
        return NdGG;
    }

    public void setNdGG(String NdGG) {
        this.NdGG = NdGG;
    }

    public String getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(String NgayBD) {
        this.NgayBD = NgayBD;
    }

    public String getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(String NgayKT) {
        this.NgayKT = NgayKT;
    }

   
   
    
}
