/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.ChuongtrinhkhuyenmaiDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author MYPC
 */
public class ChuongtrinhkhuyenmaiDAL {

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
    public ArrayList<ChuongtrinhkhuyenmaiDTO> getAllCTKMDTO() {
        //Doc tu trong bang ra
        ConnectDB();
        ArrayList<ChuongtrinhkhuyenmaiDTO> listCTKM = new ArrayList<ChuongtrinhkhuyenmaiDTO>();//tao cai mang 
        String sql = "SELECT *FROM ChuongtrinhKM";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//doc bo dau tien
            while (rs.next()) {
                ChuongtrinhkhuyenmaiDTO ctkmDTO = new ChuongtrinhkhuyenmaiDTO();
                ctkmDTO.setMaKM(rs.getString(1));
                ctkmDTO.setTenCT(rs.getString(2));
                ctkmDTO.setNgayBD(rs.getString(3));
                ctkmDTO.setNgayKT(rs.getString(4));
                ctkmDTO.setLoaiCT(rs.getString(5));
                ctkmDTO.setNdGG(rs.getString(6));
                listCTKM.add(ctkmDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTKM;
    }
//    //-------------------------------------

    public boolean addCTKMDTO(ChuongtrinhkhuyenmaiDTO ctkmDTO) {//luu csdl vao bang  
        ConnectDB();
        String sql = "INSERT INTO ChuongtrinhKM(MaKM,TenCT,ThoigianBD,ThoigianKT,LoaiCT,NDgiamgia)"
                + " VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ctkmDTO.getMaKM());
            ps.setString(2, ctkmDTO.getTenCT());
            ps.setString(3, ctkmDTO.getNgayBD());
            ps.setString(4, ctkmDTO.getNgayKT());
            ps.setString(5, ctkmDTO.getLoaiCT());
            ps.setString(6, ctkmDTO.getNdGG());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //----------------------------------------

    public boolean suaCTKMDTO(ChuongtrinhkhuyenmaiDTO ctkmDTO) {
        ConnectDB();
        try {
            String sql = "update ChuongtrinhKM set TenCT=?,ThoigianBD=?,ThoigianKT=?,LoaiCT=?,NDgiamgia=? where MaKM=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(6, ctkmDTO.getMaKM());
            ps.setString(1, ctkmDTO.getTenCT());
            ps.setString(2, ctkmDTO.getNgayBD());
            //ps.setDate(4,new java.sql.Date(khDTO.getNgaysinh().getTime()) );
            ps.setString(3, ctkmDTO.getNgayKT());
            ps.setString(4, ctkmDTO.getLoaiCT());
            ps.setString(5, ctkmDTO.getNdGG());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //----------------------------------------

    public boolean xoaCTKMDTO(ChuongtrinhkhuyenmaiDTO ctkmDTO) {
        ConnectDB();
        try {
            String sql = "Delete ChuongtrinhKM  where MaKM=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ctkmDTO.getMaKM());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Date layngayKT(String makm) {
        ConnectDB();
        String sql = "SELECT * FROM ChuongtrinhKM WHERE  MaKM='" + makm + "'";
        Date t = new Date();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t = rs.getDate("ThoigianKT");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    //--------------Lây ngay bat dau--------------------------------------

    public Date layngayBD(String makm) {
        ConnectDB();
        String sql = "SELECT * FROM ChuongtrinhKM WHERE  MaKM='" + makm + "'";
        Date t = new Date();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t = rs.getDate("ThoigianBD");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
