/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NhanvienDAL;
import DTO.NhanvienDTO;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author MYPC
 */
public class NhanvienBLL {
     NhanvienDAL nvDAL = new NhanvienDAL();
   
   public ArrayList<NhanvienDTO> getAllNhanvienDTO(){
       return nvDAL.getAllNhanvienDTO();
   }
   public boolean addNhanvienDTO(NhanvienDTO nvDTO){
       return nvDAL.addNhanvienDTO(nvDTO);
   }
    public boolean suaNhanvienDTO(NhanvienDTO nvDTO){
 
        return nvDAL.suaNhanvienDTO(nvDTO);
    }
    public boolean xoaNhanvienDTO(NhanvienDTO nvDTO){
 
        return nvDAL.xoaNhanvienDTO(nvDTO);
    }
    public String SearchDTO(String Manv){
        return nvDAL.SearchDTO(Manv);
    }
    public ArrayList<NhanvienDTO> SearchTenDTO(String Tennv){
        return nvDAL.SearchTenDTO(Tennv);
    }
    public void loadCombobox(JComboBox cb){
        nvDAL.loadCombobox(cb);
    }
}
