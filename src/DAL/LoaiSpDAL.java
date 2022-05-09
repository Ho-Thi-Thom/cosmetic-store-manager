/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.LoaiSpDTO;
import DTO.NHASXDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MYPC
 */
public class LoaiSpDAL {

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

    public ArrayList<LoaiSpDTO> getAllLoaiSpDTO() {
        //Doc tu trong bang ra
        //ConnectDB();
        ArrayList<LoaiSpDTO> listLoaiSp = new ArrayList<LoaiSpDTO>();//tao cai mang 
        String sql = "SELECT *FROM LoaiSP";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//doc bo dau tien
            while (rs.next()) {
                LoaiSpDTO loaiSp = new LoaiSpDTO();
                loaiSp.setMALOAI(rs.getString(1));
                loaiSp.setTENLOAI(rs.getString(2));
                listLoaiSp.add(loaiSp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLoaiSp;
    }
    //------------------------------------

    public boolean addLoaiSpDTO(LoaiSpDTO loaiSp) {//luu csdl vao bang  
       // ConnectDB();
        String sql = "INSERT INTO LoaiSP(MALOAI,TENLOAI)"
                + " VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, loaiSp.getMALOAI());
            ps.setString(2, loaiSp.getTENLOAI());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //--------------------------------------------
    public boolean suaLoaiSpDTO(LoaiSpDTO loaiSp) {
       // ConnectDB();
        try {
            String sql = "UPDATE LoaiSP SET TENLOAI=? WHERE MALOAI=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, loaiSp.getMALOAI());
            ps.setString(1, loaiSp.getTENLOAI());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //----------------------------------------

    public boolean xoaLoaiSpDTO(LoaiSpDTO loaiSp) {
       // ConnectDB();
        try {
            String sql = "Delete LOAISP  where MALOAI=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, loaiSp.getMALOAI());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //----------------------------------------
    public LoaiSpDTO getLoaiSpDTO(String maloai) {
        //Doc tu trong bang ra
       // ConnectDB();
        LoaiSpDTO loai = new LoaiSpDTO();
        String sql = "SELECT * FROM LoaiSP WHERE MALOAI=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maloai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                loai.setMALOAI(rs.getString(1));
                loai.setTENLOAI(rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return loai;
    }
}
