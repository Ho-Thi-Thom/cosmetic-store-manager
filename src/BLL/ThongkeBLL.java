/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ThongkeDAL;
import DTO.ThongkeDTO;
import java.util.ArrayList;

/**
 *
 * @author MYPC
 */
public class ThongkeBLL {

    ThongkeDAL tkDAL = new ThongkeDAL();

    public ArrayList<ThongkeDTO> getAllTKSLBDDTO(String tungay, String denngay) {
        return tkDAL.getAllTKSLBDDTO(tungay, denngay);
    }
    public ArrayList<ThongkeDTO> getAlldoanhthuDTO(String nam) {
        return tkDAL.getAlldoanhthuDTO(nam);
    }
}
