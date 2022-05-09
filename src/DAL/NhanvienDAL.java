/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.NhanvienDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class NhanvienDAL {

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
    public ArrayList<NhanvienDTO> getAllNhanvienDTO() {
        ConnectDB();
        ArrayList<NhanvienDTO> listNV = new ArrayList<NhanvienDTO>();//tao cai mang 
        String sql = "SELECT *FROM Nhanvien";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//doc bo dau tien
            while (rs.next()) {
                NhanvienDTO nvDTO = new NhanvienDTO();
                nvDTO.setMaNV(rs.getString(1));
                nvDTO.setTenNV(rs.getString(2));
                nvDTO.setGioitinh(rs.getString(3));
                nvDTO.setNgaysinh(rs.getString(4));
                nvDTO.setDiachi(rs.getString(5));
                nvDTO.setSdt(rs.getString(6));
                nvDTO.setEmail(rs.getString(7));
                listNV.add(nvDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }
    //-------------------------------------

    public boolean addNhanvienDTO(NhanvienDTO nvDTO) {
        ConnectDB();
        String sql = "INSERT INTO Nhanvien(MaNV,TenNV,Gioitinh,Ngaysinh,Diachi,"
                + "Sdt,Email)"
                + " VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nvDTO.getMaNV());
            ps.setString(2, nvDTO.getTenNV());
            ps.setString(3, nvDTO.getGioitinh());
            ps.setString(4, nvDTO.getNgaysinh());
            // ps.setDate(4,new java.sql.Date(nvDTO.getNgaysinh().getTime()) );
            ps.setString(5, nvDTO.getDiachi());
            ps.setString(6, nvDTO.getSdt());
            ps.setString(7, nvDTO.getEmail());

            // conn.close() ;
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //--------------------------------------------

    public boolean suaNhanvienDTO(NhanvienDTO nvDTO) {
        ConnectDB();
        try {
            String sql = "update Nhanvien set TenNV=?,Gioitinh=?,Ngaysinh=?,"
                    + "Diachi=?,Sdt=?,Email=? "
                    + "where MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(7, nvDTO.getMaNV());
            ps.setString(1, nvDTO.getTenNV());
            ps.setString(2, nvDTO.getGioitinh());
            ps.setString(3, nvDTO.getNgaysinh());
            //ps.setDate(4,new java.sql.Date(nvDTO.getNgaysinh().getTime()) );
            ps.setString(4, nvDTO.getDiachi());
            ps.setString(5, nvDTO.getSdt());
            ps.setString(6, nvDTO.getEmail());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //----------------------------------------

    public boolean xoaNhanvienDTO(NhanvienDTO nvDTO) {
        ConnectDB();
        try {
            String sql = "Delete Nhanvien  where MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nvDTO.getMaNV());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //-----------------------bỏ-----------------

    public String SearchDTO(String Manv) {
        ArrayList<NhanvienDTO> list = new ArrayList<NhanvienDTO>();//tao cai mang
        ConnectDB();
        try {
            String sql = "SELECT * FROM Nhanvien WHERE MaNV='" + Manv + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanvienDTO nvDTO = new NhanvienDTO();
                nvDTO.setMaNV(rs.getString(1));
                nvDTO.setTenNV(rs.getString(2));
                nvDTO.setGioitinh(rs.getString(3));
                nvDTO.setNgaysinh(rs.getString(4));
                nvDTO.setDiachi(rs.getString(5));
                nvDTO.setSdt(rs.getString(6));
                nvDTO.setEmail(rs.getString(7));
                list.add(nvDTO);
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
        return list.get(0).getTenNV();
    }
    //---------------------------bỏ-----------------------

    public ArrayList<NhanvienDTO> SearchTenDTO(String Tennv) {
        ArrayList<NhanvienDTO> list = new ArrayList<NhanvienDTO>();//tao cai mang
        ConnectDB();
        try {
            //String sql="SELECT * FROM Nhanvien WHERE TenNV like=N'%"+Tennv+"%'" ;
            String sql = "SELECT * FROM Nhanvien WHERE TenNV =N'%" + Tennv + "%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanvienDTO nvDTO = new NhanvienDTO();
                nvDTO.setMaNV(rs.getString(1));
                nvDTO.setTenNV(rs.getString(2));
                nvDTO.setGioitinh(rs.getString(3));
                nvDTO.setNgaysinh(rs.getString(4));
                nvDTO.setDiachi(rs.getString(5));
                nvDTO.setSdt(rs.getString(6));
                nvDTO.setEmail(rs.getString(7));
                list.add(nvDTO);
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
        return list;
    }
    //--------------------------

    public void loadCombobox(JComboBox cb) {//load duw lieu tu nvoa len combobox

        // cbKhoa.addItem(rs.getString("Khoa"));
        ConnectDB();
        String sql = "Select Gioitinh from Nhanvien group by Gioitinh";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cb.addItem(rs.getString("Gioitinh"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
