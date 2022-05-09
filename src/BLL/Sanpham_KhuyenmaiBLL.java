/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Sanpham_KhuyenmaiDAL;
import DTO.Sanpham_KhuyenmaiDTO;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author MYPC
 */
public class Sanpham_KhuyenmaiBLL {
     Sanpham_KhuyenmaiDAL spkmDAL = new Sanpham_KhuyenmaiDAL();
      public ArrayList<Sanpham_KhuyenmaiDTO> getAllsp_kmDTO(){
          return spkmDAL.getAllsp_kmDTO();
      }
       public boolean addspkmDTO(Sanpham_KhuyenmaiDTO spkmDTO){
           return spkmDAL.addspkmDTO(spkmDTO);
       }
       public boolean suaspkmDTO(Sanpham_KhuyenmaiDTO spkmDTO) {
           return spkmDAL.suaspkmDTO(spkmDTO);
       }
       public boolean xoaspkmDTO(Sanpham_KhuyenmaiDTO spkmDTO){
           return spkmDAL.xoaspkmDTO(spkmDTO);
       }
        public void loadCombobox(JComboBox cb){
        spkmDAL.loadCombobox(cb);
        }
}
