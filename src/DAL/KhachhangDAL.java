/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.KhachhangDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class KhachhangDAL {

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
    public ArrayList<KhachhangDTO> getAllKhachhangDTO() {
        //Doc tu trong bang ra
        ConnectDB();
        ArrayList<KhachhangDTO> listKH = new ArrayList<KhachhangDTO>();//tao cai mang 
        String sql = "SELECT *FROM Khachhang";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//doc bo dau tien
            while (rs.next()) {
                KhachhangDTO khDTO = new KhachhangDTO();
                khDTO.setMaKH(rs.getString(1));
                khDTO.setTenKH(rs.getString(2));
                khDTO.setGioitinh(rs.getString(3));
                khDTO.setNgaysinh(rs.getString(4));
                khDTO.setDiachi(rs.getString(5));
                khDTO.setSdt(rs.getString(6));
                khDTO.setEmail(rs.getString(7));
                listKH.add(khDTO);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }
    //-------------------------------------

    public boolean addKhachhangDTO(KhachhangDTO khDTO) {//luu csdl vao bang  
        ConnectDB();
        String sql = "INSERT INTO Khachhang(MaKH,TenKH,Gioitinh,Ngaysinh,Diachi,"
                + "Sdt,Email)"
                + " VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, khDTO.getMaKH());
            ps.setString(2, khDTO.getTenKH());
            ps.setString(3, khDTO.getGioitinh());
            ps.setString(4, khDTO.getNgaysinh());
            // ps.setDate(4,new java.sql.Date(khDTO.getNgaysinh().getTime()) );
            ps.setString(5, khDTO.getDiachi());
            ps.setString(6, khDTO.getSdt());
            ps.setString(7, khDTO.getEmail());

            // conn.close() ;
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //--------------------------------------------

    public boolean suaKhachhangDTO(KhachhangDTO khDTO) {
        ConnectDB();
        try {
            String sql = "update Khachhang set TenKH=?,Gioitinh=?,Ngaysinh=?,"
                    + "Diachi=?,Sdt=?,Email=? "
                    + "where MaKH=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(7, khDTO.getMaKH());
            ps.setString(1, khDTO.getTenKH());
            ps.setString(2, khDTO.getGioitinh());
            ps.setString(3, khDTO.getNgaysinh());
            //ps.setDate(4,new java.sql.Date(khDTO.getNgaysinh().getTime()) );
            ps.setString(4, khDTO.getDiachi());
            ps.setString(5, khDTO.getSdt());
            ps.setString(6, khDTO.getEmail());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //----------------------------------------

    public boolean xoaKhachhangDTO(KhachhangDTO khDTO) {
        ConnectDB();
        try {
            String sql = "Delete Khachhang  where MaKH=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, khDTO.getMaKH());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //------------------------Search theo ten, không cần ----------------

    public String SearchDTO(String Makh) {
       ConnectDB();
        ArrayList<KhachhangDTO> list = new ArrayList<KhachhangDTO>();//tao cai mang
        try {
            String sql = "SELECT * FROM Khachhang WHERE MaKH='" + Makh + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachhangDTO khDTO = new KhachhangDTO();
                khDTO.setMaKH(rs.getString(1));
                khDTO.setTenKH(rs.getString(2));
                khDTO.setGioitinh(rs.getString(3));
                khDTO.setNgaysinh(rs.getString(4));
                khDTO.setDiachi(rs.getString(5));
                khDTO.setSdt(rs.getString(6));
                khDTO.setEmail(rs.getString(7));
                list.add(khDTO);
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
        return list.get(0).getTenKH();
    }
    //--------------------------------Không cần------------------

    public ArrayList<KhachhangDTO> SearchTenDTO(String Tenkh) {
        ArrayList<KhachhangDTO> list = new ArrayList<KhachhangDTO>();//tao cai mang
        ConnectDB();
        try {
            //String sql="SELECT * FROM Khachhang WHERE TenKH like=N'%"+Tenkh+"%'" ;
            String sql = "SELECT * FROM Khachhang WHERE TenKH =N'%" + Tenkh + "%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachhangDTO khDTO = new KhachhangDTO();
                khDTO.setMaKH(rs.getString(1));
                khDTO.setTenKH(rs.getString(2));
                khDTO.setGioitinh(rs.getString(3));
                khDTO.setNgaysinh(rs.getString(4));
                khDTO.setDiachi(rs.getString(5));
                khDTO.setSdt(rs.getString(6));
                khDTO.setEmail(rs.getString(7));
                list.add(khDTO);
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
        return list;
    }
    //--------------------------

    public void loadCombobox(JComboBox cb) {//load duw lieu tu khoa len combobox

        // cbKhoa.addItem(rs.getString("Khoa"));
        ConnectDB();
        String sql = "Select Gioitinh from Khachhang group by Gioitinh";
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
