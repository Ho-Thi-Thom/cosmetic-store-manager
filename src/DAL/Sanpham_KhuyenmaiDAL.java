/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.Sanpham_KhuyenmaiDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author MYPC
 */
public class Sanpham_KhuyenmaiDAL {

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

    public ArrayList<Sanpham_KhuyenmaiDTO> getAllsp_kmDTO() {
        //Doc tu trong bang ra
        ArrayList<Sanpham_KhuyenmaiDTO> listspkm = new ArrayList<Sanpham_KhuyenmaiDTO>();//tao cai mang 
        String sql = "SELECT *FROM SP_KhuyenMai";
        try {
            ConnectDB();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//doc bo dau tien
            while (rs.next()) {
                Sanpham_KhuyenmaiDTO spkmDTO = new Sanpham_KhuyenmaiDTO();
                spkmDTO.setMaKM(rs.getString(1));
                spkmDTO.setMaSP(rs.getString(2));
                spkmDTO.setCachtinh(rs.getInt(3));
                listspkm.add(spkmDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listspkm;
    }
    //-------------------------------------

    public boolean addspkmDTO(Sanpham_KhuyenmaiDTO spkmDTO) {//luu csdl vao bang  
        String sql = "INSERT INTO SP_KhuyenMai(MaKM,MaSP,Cachgiam)"
                + " VALUES(?,?,?)";
        ConnectDB();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, spkmDTO.getMaKM());
            ps.setString(2, spkmDTO.getMaSP());
            ps.setInt(3, spkmDTO.getCachtinh());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean suaspkmDTO(Sanpham_KhuyenmaiDTO spkmDTO) {
        ConnectDB();
        try {
            String sql = "update SP_KhuyenMai set cachgiam=? where MaKM=? and MaSP=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, spkmDTO.getCachtinh());
            ps.setString(2, spkmDTO.getMaKM());
            ps.setString(3, spkmDTO.getMaSP());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //----------------------------------------

    public boolean xoaspkmDTO(Sanpham_KhuyenmaiDTO spkmDTO) {
        ConnectDB();
        try {
            String sql = "Delete SP_KhuyenMai  where MaKM=? and MaSP=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, spkmDTO.getMaKM());
            ps.setString(2, spkmDTO.getMaSP());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void loadCombobox(JComboBox cb) {

        // cbKhoa.addItem(rs.getString("Khoa"));
        ConnectDB();
        String sql = "Select MaKM from ChuongtrinhKM where ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cb.addItem(rs.getString("MaKM"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
