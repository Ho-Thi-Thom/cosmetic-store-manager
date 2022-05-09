/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.ChitietphieunhapDTO;
import DTO.PhieunhapDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author MYPC
 */
public class PhieunhapDAL {
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
    //-------------------------------------------
    public ArrayList<PhieunhapDTO> getAllPhieunhapDTO() {
        ConnectDB();
        ArrayList<PhieunhapDTO> listPN = new ArrayList<PhieunhapDTO>();//tao cai mang 
        String sql = "SELECT *FROM Phieunhap";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//doc bo dau tien
            while (rs.next()) {
                PhieunhapDTO pnDTO = new PhieunhapDTO();
                pnDTO.setMaHDNH(rs.getString(1));
                pnDTO.setMaNV(rs.getString(2));
                pnDTO.setMaNCC(rs.getString(3));
                pnDTO.setTongtien(rs.getString(4));
                pnDTO.setNgaylap(rs.getString(5));
                listPN.add(pnDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPN;
    }
    //-------------------------------------

    public boolean addPhieunhapDTO(PhieunhapDTO pnDTO) {
         ConnectDB();
        String sql = "INSERT INTO Phieunhap(MaHDNH,MaNV,MaNCC,Tongtien,Ngaylap)"
                + " VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, pnDTO.getMaHDNH());
            ps.setString(2, pnDTO.getMaNV());
            ps.setString(3, pnDTO.getMaNCC());
            ps.setString(4, pnDTO.getTongtien());
            ps.setString(5, pnDTO.getNgaylap());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //--------------------------------------------

    public boolean suaPhieunhapDTO(PhieunhapDTO pnDTO) {
        ConnectDB();
        try {
            String sql = "update Phieunhap set MaNV=?, MaNCC=?, Tongtien=?, Ngaylap=? where MaHDNH=?";
                   
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(5, pnDTO.getMaHDNH());
            ps.setString(1, pnDTO.getMaNV());
            ps.setString(2, pnDTO.getMaNCC());
            ps.setString(3, pnDTO.getTongtien());
            ps.setString(4, pnDTO.getNgaylap());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //---------------------bỏ-------------------

    public boolean xoaPhieunhapDTO(PhieunhapDTO pnDTO) {
        ConnectDB();
        try {
            String sql = "Delete Phieunhap  where MaHDNH=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,pnDTO.getMaHDNH());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean xoaChitietphieunhapDTO(ChitietphieunhapDTO ctpnDTO){
         ConnectDB();
         try {
             String sql="Delete Chitietphieunhap  where MaHDNH=? ";
             PreparedStatement ps= conn.prepareStatement(sql);
             ps.setString(1,ctpnDTO.getMaHDNH()); 
             return ps.executeUpdate()>0;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
     }
    //---------------------------------

    public void loadComboboxMaNV(JComboBox cb) {
        ConnectDB();
        String sql = "Select MaNV from Phieunhap";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cb.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadComboboxMaNCC(JComboBox cb) {

        // cbKhoa.addItem(rs.getString("Khoa"));
        ConnectDB();
        String sql = "Select MaNCC from Phieunhap";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cb.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
