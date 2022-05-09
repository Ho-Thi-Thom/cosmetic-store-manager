/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ChitietphieunhapDAL;
import DTO.ChitietphieunhapDTO;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author MYPC
 */
public class ChitietphieunhapBLL {
    ChitietphieunhapDAL ctpnDAL=new ChitietphieunhapDAL();
     public ArrayList<ChitietphieunhapDTO> getChitietphieunhapDTO(String id){
       return ctpnDAL.getChitietphieunhapDTO(id);
   }
   public String getDongianhap(String masp){
       return  ctpnDAL.getDongianhap(masp);
   }
   public Float Tongtien(String Mahd){
       return ctpnDAL.Tongtien(Mahd);
   }
   public boolean suaTongtien(Float tongtien, String mahd){
       return ctpnDAL.suaTongtien(tongtien, mahd);
   }
    public boolean addChitietphieunhapDTO(ChitietphieunhapDTO ctpnDTO){
       return ctpnDAL.addChitietphieunhapDTO(ctpnDTO);
   }
    public boolean suaChitietphieunhapDTO(ChitietphieunhapDTO ctpnDTO){
 
        return ctpnDAL.suaChitietphieunhapDTO(ctpnDTO);
    }
    public boolean xoaChitietphieunhapDTO(ChitietphieunhapDTO ctpnDTO){
 
        return ctpnDAL.xoaChitietphieunhapDTO(ctpnDTO);
    } 
    public void loadComboboxMaHDNH(JComboBox cb){
        ctpnDAL.loadComboboxMaHDNH(cb);
    }
     public void loadComboboxMaSP(JComboBox cb){
        ctpnDAL.loadComboboxMaSP(cb);
    }

   public boolean suasoluong(int soluong, String masp){
       return ctpnDAL.suasoluong(soluong, masp);
   }

    public int getSoluong(String masp){
       return  ctpnDAL.getSoluong(masp);
   }
    public int laysoluongsp(String masp,String mahdnh){
       return ctpnDAL.laysoluongsp(masp,mahdnh);
   }
}
