/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.LoaiSpDAL;
import DTO.LoaiSpDTO;
import java.util.ArrayList;

public class LoaiSpBLL {
   LoaiSpDAL loaiSpDAL = new LoaiSpDAL();
   
   public ArrayList<LoaiSpDTO> getALLLoaiSpDTO(){
       loaiSpDAL.ConnectDB();
       return loaiSpDAL.getAllLoaiSpDTO();
   }
   public boolean addLoaiSpDTO(LoaiSpDTO loai){
       loaiSpDAL.ConnectDB();
       return loaiSpDAL.addLoaiSpDTO(loai);
   }
    public boolean suaLoaiSpDTO(LoaiSpDTO loai){
        loaiSpDAL.ConnectDB();
        return loaiSpDAL.suaLoaiSpDTO(loai);
    }
    public boolean xoaLoaiSpDTO(LoaiSpDTO loai){
        loaiSpDAL.ConnectDB();
        return loaiSpDAL.xoaLoaiSpDTO(loai);
    }
    public LoaiSpDTO getLoaiSpDTO(String maloai) {
        loaiSpDAL.ConnectDB();
        return loaiSpDAL.getLoaiSpDTO(maloai);
    }
}
