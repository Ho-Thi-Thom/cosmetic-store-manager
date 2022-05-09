/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.NHACCDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MYPC
 */
public class NHACCDAL {

    Connection conn = null;
    sqlConnection connect = new sqlConnection();

    public void ConnectDB() {
        if (conn == null) {
            try {
                conn = connect.getConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//    ---------------------------------

    public ArrayList<NHACCDTO> getALLNHACCDTO() {
        //Doc tu trong bang ra
       // ConnectDB();
        ArrayList<NHACCDTO> listNCC = new ArrayList<NHACCDTO>();//tao cai mang 
        String sql = "SELECT *FROM NHACC";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//doc bo dau tien
            while (rs.next()) {
                NHACCDTO nhasx = new NHACCDTO();
                nhasx.setMANCC(rs.getString(1));
                nhasx.setTENNCC(rs.getString(2));
                nhasx.setDIACHI(rs.getString(3));
                nhasx.setEMAIL(rs.getString(4));
                nhasx.setSDT(rs.getString(5));
                listNCC.add(nhasx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNCC;
    }
    //------------------------------------

    public boolean addNHACCDTO(NHACCDTO nsx) {
        //ConnectDB();
        String sql = "INSERT INTO NHACC(MANCC,TENNCC,DIACHI,EMAIL,SDT)"
                + " VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nsx.getMANCC());
            ps.setString(2, nsx.getTENNCC());
            ps.setString(3, nsx.getDIACHI());
            ps.setString(4, nsx.getEMAIL());
            ps.setString(5, nsx.getSDT());
            ps.executeUpdate();
            // conn.close() ;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //--------------------------------------------
    public boolean suaNHACCDTO(NHACCDTO nsx) {
        //ConnectDB();
        try {
            String sql = "update NHACC set TENNCC=?,DIACHI=?,EMAIL=?,SDT=? where MANCC=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(5, nsx.getMANCC());
            ps.setString(1, nsx.getTENNCC());
            ps.setString(2, nsx.getDIACHI());
            ps.setString(3, nsx.getEMAIL());
            ps.setString(4, nsx.getSDT());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //----------------------------------------

    public boolean xoaNHACCDTO(NHACCDTO nsx) {
       // ConnectDB();
        try {
            String sql = "Delete NHACC  where MANCC=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nsx.getMANCC());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //----------------------------------------
    public NHACCDTO getNhaSxDTO(String mansx) {
       // ConnectDB();
        NHACCDTO nhasx = new NHACCDTO();
        String sql = "SELECT * FROM NHACC WHERE MANCC=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mansx);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nhasx.setMANCC(rs.getString(1));
                nhasx.setTENNCC(rs.getString(2));
                nhasx.setDIACHI(rs.getString(3));
                nhasx.setEMAIL(rs.getString(4));
                nhasx.setSDT(rs.getString(5));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhasx;
    }
}
