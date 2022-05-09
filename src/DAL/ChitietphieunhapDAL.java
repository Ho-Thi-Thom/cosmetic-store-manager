/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.ChitietphieunhapDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author MYPC
 */
public class ChitietphieunhapDAL {

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
    public ArrayList<ChitietphieunhapDTO> getChitietphieunhapDTO(String id) {
        ArrayList<ChitietphieunhapDTO> listCTPN = new ArrayList<ChitietphieunhapDTO>();
         ConnectDB();
        String sql = "SELECT * FROM Chitietphieunhap WHERE MaHDNH = '" + id + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChitietphieunhapDTO ctpnDTO = new ChitietphieunhapDTO();
                ctpnDTO.setMaHDNH(rs.getString(1));
                ctpnDTO.setMaSP(rs.getString(2));
                ctpnDTO.setSoluong(rs.getInt(3));
                ctpnDTO.setDongianhap(rs.getFloat(4));
                ctpnDTO.setThanhtien(rs.getFloat(5));
                listCTPN.add(ctpnDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTPN;
    }

    public String getDongianhap(String masp) {
        ConnectDB();
        String sql = "SELECT Dongia FROM Sanpham WHERE MaSP = '" + masp + "'";
        String t = "";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t = (rs.getString("Dongia"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    //---------------------------------

    public boolean addChitietphieunhapDTO(ChitietphieunhapDTO ctpnDTO) {
        ConnectDB();
        String sql = "INSERT INTO Chitietphieunhap(MaHDNH,MaSP,Soluong,Dongianhap,Thanhtien)"
                + " VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ctpnDTO.getMaHDNH());
            ps.setString(2, ctpnDTO.getMaSP());
            ps.setInt(3, ctpnDTO.getSoluong());
            ps.setFloat(4, ctpnDTO.getDongianhap());
            ps.setFloat(5, ctpnDTO.getThanhtien());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //----------------------------------

    public boolean suaChitietphieunhapDTO(ChitietphieunhapDTO ctpnDTO) {
        ConnectDB();
        try {
            String sql = "update Chitietphieunhap set Soluong=?,Dongianhap=?,Thanhtien=? where MaHDNH=? and MaSP=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(4, ctpnDTO.getMaHDNH());
            ps.setString(5, ctpnDTO.getMaSP());
            ps.setInt(1, ctpnDTO.getSoluong());
            ps.setFloat(2, ctpnDTO.getDongianhap());
            ps.setFloat(3, ctpnDTO.getThanhtien());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //---------------------------------------

    public boolean xoaChitietphieunhapDTO(ChitietphieunhapDTO ctpnDTO) {
        ConnectDB();
        try {
            String sql = "Delete Chitietphieunhap  where MaHDNH=? and  MASP=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ctpnDTO.getMaHDNH());
            ps.setString(2, ctpnDTO.getMaSP());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //--------------------------------------------

    public void loadComboboxMaHDNH(JComboBox cb) {
        ConnectDB();
        String sql = "Select MaHDNH from Phieunhap";
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
    //------------------------------------------------

    public void loadComboboxMaSP(JComboBox cb) {
        ConnectDB();
        String sql = "Select MaSP from Phieunhap";
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
    //------------------------------------------------

    public Float Tongtien(String Mahdnh) {
        ConnectDB();
        String sql = "SELECT sum(Thanhtien) AS Tongtien FROM Chitietphieunhap WHERE MaHDNH = '" + Mahdnh + "'";
        float t = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t = rs.getFloat("Tongtien");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public boolean suaTongtien(Float tongtien, String mahdnh) {
        ConnectDB();
        try {
            String sql = "update Phieunhap set Tongtien=? where MaHDNH=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, tongtien);
            ps.setString(2, mahdnh);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean suasoluong(int soluong, String masp) {
        ConnectDB();
        try {
            String sql = "UPDATE Sanpham SET Soluong=? WHERE MaSP=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, soluong);
            ps.setString(2, masp);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getSoluong(String masp) {
        ConnectDB();
        String sql = "SELECT Soluong FROM Sanpham WHERE MaSP = '" + masp + "'";
        int t = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t = rs.getInt("Soluong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public int laysoluongsp(String masp, String mahdnh) {
        ConnectDB();
        String sql = "SELECT Soluong FROM Chitietphieunhap WHERE MaSP = '" + masp + "'" + " and MaHDNH='" + mahdnh + "'";
        int t = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t = (rs.getInt("Soluong"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
