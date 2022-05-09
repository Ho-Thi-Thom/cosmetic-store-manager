/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NHASXDAL;
import DTO.NHASXDTO;
import java.util.ArrayList;

public class NHASXBLL {
   NHASXDAL nsxDAL = new NHASXDAL();
   
   public ArrayList<NHASXDTO> getALLNHASXDTO(){
       nsxDAL.ConnectDB();
       return nsxDAL.getALLNHASXDTO();
   }
   public boolean addNHASXDTO(NHASXDTO nsx){
       nsxDAL.ConnectDB();
       return nsxDAL.addNHASXDTO(nsx);
   }
    public boolean suaNHASXDTO(NHASXDTO nsx){
        nsxDAL.ConnectDB();
        return nsxDAL.suaNHASXDTO(nsx);
    }
    public boolean xoaNHASXDTO(NHASXDTO nsx){
        nsxDAL.ConnectDB();
        return nsxDAL.xoaNHASXDTO(nsx);
    }
    public NHASXDTO getNhaSxDTO(String mansx) {
        nsxDAL.ConnectDB();
        return nsxDAL.getNhaSxDTO(mansx);
    }
}
