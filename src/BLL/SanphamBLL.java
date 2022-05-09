/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.SanphamDAL;
import DTO.SanphamDTO;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author MYPC
 */
public class SanphamBLL {
     SanphamDAL spDAL = new SanphamDAL();
   
   public ArrayList<SanphamDTO> getAllSanphamDTO(){
       return spDAL.getAllSanphamDTO();
   }
   public boolean addSanphamDTO(SanphamDTO spDTO){
       return spDAL.addSanphamDTO(spDTO);
   }
    public boolean suaSanphamDTO(SanphamDTO spDTO){
 
        return spDAL.suaSanphamDTO(spDTO);
    }
    public boolean xoaSanphamDTO(SanphamDTO spDTO){
 
        return spDAL.xoaSanphamDTO(spDTO);
    }
    public ArrayList<SanphamDTO> SearchMaspDTO(String Masp){
        return spDAL.SearchMaspDTO(Masp);
    }
    public ArrayList<SanphamDTO> SearchMaloaiDTO(String Maloai){
        return spDAL.SearchMaloaiDTO(Maloai);
    }
     public ArrayList<SanphamDTO> SearchMaNSXDTO(String MaNSX){
        return spDAL.SearchMaNSXDTO(MaNSX);
    }
     public void loadCombobox(JComboBox cb){
        spDAL.loadCombobox( cb);
     }
     public void loadComboboxMaNSX(JComboBox cb){
          spDAL.loadComboboxMaNSX(cb);
     }
     public String SearchDTO(String masp){
         return spDAL.SearchDTO(masp);
     }
}
