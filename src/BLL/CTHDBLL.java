/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.CTHDDAL;
import DTO.CTHDDTO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author MYPC
 */
public class CTHDBLL {
    CTHDDAL hdDAL = new CTHDDAL();
   /*
   public ArrayList<CTHDDTO> getAllCTHDDTO(){
       return hdDAL.getAllCTHDDTO();
   }*/
   public ArrayList<CTHDDTO> getCTHDDTO(String id){
       return hdDAL.getCTHDDTO(id);
   }
   public int getSoluong(String masp){
       return  hdDAL.getSoluong(masp);
   }
   public int laysoluongsp(String masp,String mahd){
       return hdDAL.laysoluongsp(masp,mahd);
   }
   public Float Tongtien(String Mahd){
       return hdDAL.Tongtien(Mahd);
   }
   public boolean suaTongtien(Float tongtien, String mahd){
       return hdDAL.suaTongtien(tongtien, mahd);
   }
   public boolean suasoluong(int soluong, String masp){
       return hdDAL.suasoluong(soluong, masp);
   }
   public boolean addCTHDDTO(CTHDDTO hdDTO){
       return hdDAL.addCTHDDTO(hdDTO);
   }
    public boolean suaCTHDDTO(CTHDDTO hdDTO){
 
        return hdDAL.suaCTHDDTO(hdDTO);
    }
    public boolean xoaCTHDDTO(CTHDDTO hdDTO){
 
        return hdDAL.xoaCTHDDTO(hdDTO);
    } 
    public void loadComboboxMaHD(JComboBox cb){
        hdDAL.loadComboboxMaHD(cb);
    }
     public void loadComboboxMaSP(JComboBox cb){
        hdDAL.loadComboboxMaSP(cb);
    }//--------------Khuyến mãi----------------------
     public boolean suaTienkm(Float t, String mahd) {
        return hdDAL.suaTienkm(t, mahd);
     }
     public Date layngayBD( String makm){
      return hdDAL.layngayBD(makm);
     }
     public Date layngayKT( String makm){
          return hdDAL.layngayKT(makm);
     }
     public Date layngayCT( String mahd){
         return hdDAL.layngayCT(mahd);
     }
     public String laymaKM(String mahd){
         return hdDAL.laymaKM(mahd);
     }
     public int laycachgiam(String makmhd, String masp){
         return hdDAL.laycachgiam(makmhd,masp);
     }

    public float tongkmct(String mahd) {
       return hdDAL.tongkmct(mahd);
    }

    public boolean suaTienkm(float z, String mahd) {
      return hdDAL.suaTienkm(z, mahd);
    }

}
