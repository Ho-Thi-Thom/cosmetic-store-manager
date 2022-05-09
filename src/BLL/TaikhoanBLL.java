/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.TaikhoanDAL;
import DTO.TaikhoanDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MYPC
 */
public class TaikhoanBLL {
    TaikhoanDAL tkDAL=new TaikhoanDAL();
     public ArrayList<TaikhoanDTO> getAllTKSLBDDTO() {
        return tkDAL.getAllTaikhoanDTO();
    }
     public String laymk(String username){
         return tkDAL.laymk(username);
     }
     
     public String getRole(String username){
         return tkDAL.getRole(username);
     }
     public boolean addNhanvienDTO(TaikhoanDTO nvDTO){
         return tkDAL.addNhanvienDTO(nvDTO);
     }
     public boolean suaNhanvienDTO(TaikhoanDTO nvDTO){
         return tkDAL.suaNhanvienDTO(nvDTO);
     }
     public boolean xoaNhanvienDTO(TaikhoanDTO nvDTO){
         return tkDAL.xoaNhanvienDTO(nvDTO);
                 
     }
}
