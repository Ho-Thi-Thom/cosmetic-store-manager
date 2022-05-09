/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ChuongtrinhkhuyenmaiDAL;
import DTO.ChuongtrinhkhuyenmaiDTO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author MYPC
 */
public class ChuongtrinhkhuyenmaiBLL {

    ChuongtrinhkhuyenmaiDAL ctkmDAL = new ChuongtrinhkhuyenmaiDAL();

    public ArrayList<ChuongtrinhkhuyenmaiDTO> getAllCTKMDTO() {
        return ctkmDAL.getAllCTKMDTO();
    }
     public boolean addCTKMDTO(ChuongtrinhkhuyenmaiDTO ctkmDTO) {
         return ctkmDAL.addCTKMDTO(ctkmDTO);
     }
    public boolean suaCTKMDTO(ChuongtrinhkhuyenmaiDTO ctkmDTO){
        return ctkmDAL.suaCTKMDTO(ctkmDTO);
    }
    public boolean xoaCTKMDTO(ChuongtrinhkhuyenmaiDTO ctkmDTO) {
        return ctkmDAL.xoaCTKMDTO(ctkmDTO);
    }
     public Date layngayBD( String makm){
         return ctkmDAL.layngayBD(makm);
     }
}
