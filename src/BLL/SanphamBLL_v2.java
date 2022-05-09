/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.SanphamDAL_v2;
import DTO.SanphamDTO_v2;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author MYPC
 */
public class SanphamBLL_v2 {
     SanphamDAL_v2 spDAL = new SanphamDAL_v2();
   
   public ArrayList<SanphamDTO_v2> getAllSanphamDTO_test(){
       return spDAL.getAllSanphamDTO_test();
   }
   
   public boolean addSanphamDTO_test(SanphamDTO_v2 spDTO){
       return spDAL.addSanphamDTO_test(spDTO);
   }
    public boolean suaSanphamDTO_test(SanphamDTO_v2 spDTO){
 
        return spDAL.suaSanphamDTO_test(spDTO);
    }
    public boolean xoaSanphamDTO_test(SanphamDTO_v2 spDTO){
 
        return spDAL.xoaSanphamDTO_test(spDTO);
    }
    /*
    public ArrayList<SanphamDTO_test> SearchMaspDTO(String Masp){
        return spDAL.SearchMaspDTO(Masp);
    }
    public ArrayList<SanphamDTO_test> SearchMaloaiDTO(String Maloai){
        return spDAL.SearchMaloaiDTO(Maloai);
    }*/
    /*
     public ArrayList<SanphamDTO_test> SearchMaNSXDTO(String MaNSX){
        return spDAL.SearchMaNSXDTO(MaNSX);
    }*/
     public void loadCombobox(JComboBox cb){
        spDAL.loadCombobox(cb);
     }
     public void loadComboboxMaNSX(JComboBox cb){
        spDAL.loadComboboxMaNSX(cb);
     }
     
     public ArrayList<SanphamDTO_v2> getInRangeSanphamDTO_test(String min, String max){
         return spDAL.getInRangeSanphamDTO_test(min, max);
     }

    public boolean DeleteAll() {
       return spDAL.DeleteAll();
    }
   
}
