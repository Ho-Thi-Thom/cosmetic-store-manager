/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.KhachhangDAL;
import DTO.KhachhangDTO;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author MYPC
 */
public class KhachhangBLL {
     KhachhangDAL khDAL = new KhachhangDAL();
   
   public ArrayList<KhachhangDTO> getAllKhachhangDTO(){
       return khDAL.getAllKhachhangDTO();
   }
   public boolean addKhachhangDTO(KhachhangDTO khDTO){
       return khDAL.addKhachhangDTO(khDTO);
   }
    public boolean suaKhachhangDTO(KhachhangDTO khDTO){
 
        return khDAL.suaKhachhangDTO(khDTO);
    }
    public boolean xoaKhachhangDTO(KhachhangDTO khDTO){ 
        return khDAL.xoaKhachhangDTO(khDTO);
    }
    public String SearchDTO(String Makh){
        return khDAL.SearchDTO(Makh);
    }
    public ArrayList<KhachhangDTO> SearchTenDTO(String Tenkh){
        return khDAL.SearchTenDTO(Tenkh);
    }
    public void loadCombobox(JComboBox cb){
        khDAL.loadCombobox(cb);
    }
}
