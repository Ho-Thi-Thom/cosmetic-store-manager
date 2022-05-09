/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.SanphamDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author MYPC
 */
public class SanphamDAL {

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
    public ArrayList<SanphamDTO> getAllSanphamDTO() {
        ConnectDB();
        ArrayList<SanphamDTO> listSP = new ArrayList<SanphamDTO>();//tao cai mang 
        String sql = "SELECT *FROM Sanpham";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//doc bo dau tien
            while (rs.next()) {
                SanphamDTO spDTO = new SanphamDTO();
                spDTO.setMasp(rs.getString(1));
                spDTO.setTensp(rs.getString(2));
                spDTO.setSoluong(rs.getInt(3));
                spDTO.setDongia(rs.getString(4));
                spDTO.setDonvitinh(rs.getString(5));
                spDTO.setMaloai(rs.getString(6));
                spDTO.setMaNSX(rs.getString(7));
                listSP.add(spDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }
    //-------------------------------------

    public boolean addSanphamDTO(SanphamDTO spDTO) {
        ConnectDB();
        String sql = "INSERT INTO Sanpham(MaSP,TenSP,Soluong,Dongia,Donvitinh,"
                + "Maloai,MaNSX)"
                + " VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, spDTO.getMasp());
            ps.setString(2, spDTO.getTensp());
            ps.setInt(3, spDTO.getSoluong());
            ps.setString(4, spDTO.getDongia());
            ps.setString(5, spDTO.getDonvitinh());
            ps.setString(6, spDTO.getMaloai());
            ps.setString(7, spDTO.getMaNSX());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //--------------------------------------------

    public boolean suaSanphamDTO(SanphamDTO spDTO) {
        ConnectDB();
        try {
            String sql = "update Sanpham set TenSP=?,Soluong=?,Dongia=?,"
                    + "Donvitinh=?,Maloai=?,MaNSX=? "
                    + "where MaSP=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(7, spDTO.getMasp());
            ps.setString(1, spDTO.getTensp());
            ps.setInt(2, spDTO.getSoluong());
            ps.setString(3, spDTO.getDongia());
            ps.setString(4, spDTO.getDonvitinh());
            ps.setString(5, spDTO.getMaloai());
            ps.setString(6, spDTO.getMaNSX());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //-----------------------bỏ-----------------

    public boolean xoaSanphamDTO(SanphamDTO spDTO) {
        ConnectDB();
        try {
            String sql = "Delete Sanpham  where MaSP=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, spDTO.getMasp());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //--------------------------bỏ--------------

    public ArrayList<SanphamDTO> SearchMaspDTO(String Masp) {
        ArrayList<SanphamDTO> list = new ArrayList<SanphamDTO>();
        ConnectDB();
        try {
            String sql = "SELECT * FROM Sanpham WHERE MaSP='" + Masp + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanphamDTO spDTO = new SanphamDTO();
                spDTO.setMasp(rs.getString(1));
                spDTO.setTensp(rs.getString(2));
                spDTO.setSoluong(rs.getInt(3));
                spDTO.setDongia(rs.getString(4));
                spDTO.setDonvitinh(rs.getString(5));
                spDTO.setMaloai(rs.getString(6));
                spDTO.setMaNSX(rs.getString(7));
                list.add(spDTO);
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
        return list;
    }

    //----------------------------bỏ----------------------
    public ArrayList<SanphamDTO> SearchMaloaiDTO(String Maloai) {
        ArrayList<SanphamDTO> list = new ArrayList<SanphamDTO>();//tao cai mang
        ConnectDB();
        try {
            String sql = "SELECT * FROM Sanpham WHERE Maloai='" + Maloai + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanphamDTO spDTO = new SanphamDTO();
                spDTO.setMasp(rs.getString(1));
                spDTO.setTensp(rs.getString(2));
                spDTO.setSoluong(rs.getInt(3));
                spDTO.setDongia(rs.getString(4));
                spDTO.setDonvitinh(rs.getString(5));
                spDTO.setMaloai(rs.getString(6));
                spDTO.setMaNSX(rs.getString(7));
                list.add(spDTO);
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
        return list;
    }

    //-----------------------------bỏ---------------------------
    public ArrayList<SanphamDTO> SearchMaNSXDTO(String MaNSX) {
        ArrayList<SanphamDTO> list = new ArrayList<SanphamDTO>();//tao cai mang
        ConnectDB();
        try {
            String sql = "SELECT * FROM Sanpham WHERE MaNSX='" + MaNSX + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanphamDTO spDTO = new SanphamDTO();
                spDTO.setMasp(rs.getString(1));
                spDTO.setTensp(rs.getString(2));
                spDTO.setSoluong(rs.getInt(3));
                spDTO.setDongia(rs.getString(4));
                spDTO.setDonvitinh(rs.getString(5));
                spDTO.setMaloai(rs.getString(6));
                spDTO.setMaNSX(rs.getString(7));
                list.add(spDTO);
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
        return list;
    }

    //-----------------------------------------------------------------------
    public void loadCombobox(JComboBox cb) {//load duw lieu tu khoa len combobox

        // cbKhoa.addItem(rs.getString("Khoa"));
        ConnectDB();
        String sql = "Select Maloai from LoaiSP";
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

    public void loadComboboxMaNSX(JComboBox cb) {//load duw lieu tu khoa len combobox
        ConnectDB();
        String sql1 = "Select MaNSX from NhaSX";
        try {
            PreparedStatement ps = conn.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cb.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String SearchDTO(String Masp) {
        ArrayList<SanphamDTO> list = new ArrayList<SanphamDTO>();
        ConnectDB();
        try {
            String sql = "SELECT * FROM Sanpham WHERE MaSP='" + Masp + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanphamDTO spDTO = new SanphamDTO();
                spDTO.setMasp(rs.getString(1));
                spDTO.setTensp(rs.getString(2));
                spDTO.setSoluong(rs.getInt(3));
                spDTO.setDongia(rs.getString(4));
                spDTO.setDonvitinh(rs.getString(5));
                spDTO.setMaloai(rs.getString(6));
                spDTO.setMaNSX(rs.getString(7));
                list.add(spDTO);
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
        return list.get(0).getTensp();
    }
}
