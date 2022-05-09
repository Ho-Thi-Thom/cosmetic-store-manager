/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.CTHDDTO;
import DTO.HoadonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @Hồ Thị Thơm DCT1187s
 */
public class HoadonDAL {

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
    public ArrayList<HoadonDTO> getAllHoadonDTO() {
        ConnectDB();
        ArrayList<HoadonDTO> listHD = new ArrayList<HoadonDTO>();//tao cai mang 
        String sql = "SELECT *FROM Hoadon";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//doc bo dau tien
            while (rs.next()) {
                HoadonDTO hdDTO = new HoadonDTO();
                hdDTO.setMaHD(rs.getString(1));
                hdDTO.setMaKH(rs.getString(2));
                hdDTO.setMaNV(rs.getString(3));
                hdDTO.setMaKM(rs.getString(4));
                hdDTO.setTienKM(rs.getString(5));
                hdDTO.setTongtien(rs.getString(6));
                hdDTO.setNgaylap(rs.getString(7));
                listHD.add(hdDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }
    //-------------------------------------

    public boolean addHoadonDTO(HoadonDTO hdDTO) {//luu csdl vao bang  
        ConnectDB();
        String sql = "INSERT INTO Hoadon(MaHD,MaKH,MaNV,MaKM,Tienkhuyenmai,"
                + "Tongtien,Ngaylap)"
                + " VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, hdDTO.getMaHD());
            ps.setString(2, hdDTO.getMaKH());
            ps.setString(3, hdDTO.getMaNV());
            ps.setString(4, hdDTO.getMaKM());
            ps.setString(5, hdDTO.getTienKM());
            ps.setString(6, hdDTO.getTongtien());
            ps.setString(7, hdDTO.getNgaylap());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //--------------------------------------------

    public boolean suaHoadonDTO(HoadonDTO hdDTO) {
        ConnectDB();
        try {
            String sql = "update Hoadon set MaKH=?,MaNV=?,MaKM=?,"
                    + "Tienkhuyenmai=?,Tongtien=?,Ngaylap=? where MaHD=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(7, hdDTO.getMaHD());
            ps.setString(1, hdDTO.getMaKH());
            ps.setString(2, hdDTO.getMaNV());
            ps.setString(3, hdDTO.getMaKM());
            ps.setString(4, hdDTO.getTienKM());
            ps.setString(5, hdDTO.getTongtien());
            ps.setString(6, hdDTO.getNgaylap());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //----------------------------------------

    public boolean xoaHoadonDTO(HoadonDTO hdDTO) {
        ConnectDB();
        try {
            String sql = "Delete Hoadon  where MaHD=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hdDTO.getMaHD());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoaCTHDDTO(CTHDDTO cthdDTO) {
        ConnectDB();
        try {
            String sql = "Delete ChitietHD  where MaHD=? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cthdDTO.getMaHD());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //---------------------------------

    public void loadComboboxMaKH(JComboBox cb) {//load duw lieu tu khoa len combobox

        // cbKhoa.addItem(rs.getString("Khoa"));
        ConnectDB();
        String sql = "Select MaKH from Khachhang";
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
    //-------------------------------

    public void loadComboboxMaNV(JComboBox cb) {//load duw lieu tu khoa len combobox
        ConnectDB();
        String sql = "Select MaNV from Nhanvien";
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

    public void loadComboboxMaKM(JComboBox cb) {//load duw lieu tu khoa len combobox
        ConnectDB();
        String sql = "Select MaKM from ChuongtrinhKM ";
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
