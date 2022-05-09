/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NHACCDAL;
import DTO.NHACCDTO;
import java.util.ArrayList;

public class NHACCBLL {
   NHACCDAL nccDAL = new NHACCDAL();
   
   public ArrayList<NHACCDTO> getALLNHACCDTO(){
       nccDAL.ConnectDB();
       return nccDAL.getALLNHACCDTO();
   }
   public boolean addNHACCDTO(NHACCDTO ncc){
       nccDAL.ConnectDB();
       return nccDAL.addNHACCDTO(ncc);
   }
    public boolean suaNHACCDTO(NHACCDTO ncc){
        nccDAL.ConnectDB();
        return nccDAL.suaNHACCDTO(ncc);
    }
    public boolean xoaNHACCDTO(NHACCDTO ncc){
        nccDAL.ConnectDB();
        return nccDAL.xoaNHACCDTO(ncc);
    }
    public NHACCDTO getNhaSxDTO(String mancc) {
        nccDAL.ConnectDB();
        return nccDAL.getNhaSxDTO(mancc);
    }
}
