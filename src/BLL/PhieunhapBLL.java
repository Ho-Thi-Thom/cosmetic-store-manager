/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.PhieunhapDAL;
import DTO.ChitietphieunhapDTO;
import DTO.PhieunhapDTO;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author MYPC
 */
public class PhieunhapBLL {
    PhieunhapDAL pnDAL = new PhieunhapDAL();
   
   public ArrayList<PhieunhapDTO> getAllPhieunhapDTO(){
       return pnDAL.getAllPhieunhapDTO();
   }
   public boolean addPhieunhapDTO(PhieunhapDTO pnDTO){
       return pnDAL.addPhieunhapDTO(pnDTO);
   }
    public boolean suaPhieunhapDTO(PhieunhapDTO pnDTO){
 
        return pnDAL.suaPhieunhapDTO(pnDTO);
    }
    public boolean xoaPhieunhapDTO(PhieunhapDTO pnDTO){
 
        return pnDAL.xoaPhieunhapDTO(pnDTO);
    }
    public void loadComboboxMaNCC(JComboBox cb){
        pnDAL.loadComboboxMaNCC(cb);
    }
     public void loadComboboxMaNV(JComboBox cb){
        pnDAL.loadComboboxMaNV(cb);
    }
    public boolean xoaChitietphieunhapDTO(ChitietphieunhapDTO ctpnDTO){
       return  pnDAL.xoaChitietphieunhapDTO(ctpnDTO);
    }
}
