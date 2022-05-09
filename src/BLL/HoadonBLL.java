/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.HoadonDAL;
import DTO.CTHDDTO;
import DTO.HoadonDTO;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * Hồ Thị Thơm
 * DCT1187
 * Ngay 14/05/2000
 */
public class HoadonBLL {
   HoadonDAL hdDAL = new HoadonDAL();
   
   public ArrayList<HoadonDTO> getAllHoadonDTO(){
       return hdDAL.getAllHoadonDTO();
   }
   public boolean addHoadonDTO(HoadonDTO hdDTO){
       return hdDAL.addHoadonDTO(hdDTO);
   }
    public boolean suaHoadonDTO(HoadonDTO hdDTO){
 
        return hdDAL.suaHoadonDTO(hdDTO);
    }
    public boolean xoaHoadonDTO(HoadonDTO hdDTO){
 
        return hdDAL.xoaHoadonDTO(hdDTO);
    }
    public void loadComboboxMaKH(JComboBox cb){
        hdDAL.loadComboboxMaKH(cb);
    }
     public void loadComboboxMaNV(JComboBox cb){
        hdDAL.loadComboboxMaNV(cb);
    }
      public void loadComboboxMaKM(JComboBox cb){
        hdDAL.loadComboboxMaKM(cb);
    }
    public boolean xoaCTHDDTO(CTHDDTO cthdDTO){
       return  hdDAL.xoaCTHDDTO(cthdDTO);
    }
}
