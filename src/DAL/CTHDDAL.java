/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.CTHDDTO;
import DTO.SanphamDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * Ho Thi Thom DCT1187
 */
public class CTHDDAL {

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

    /*
     public ArrayList<CTHDDTO> getAllCTHDDTO(){
      ArrayList<CTHDDTO> listCTHD= new ArrayList<CTHDDTO>();
      String sql="SELECT *FROM ChitietHD";
        try {
            ConnectDB();
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                CTHDDTO cthdDTO = new CTHDDTO();
                cthdDTO.setMaHD(rs.getString(1));
                cthdDTO.setMaSP(rs.getString(2));
                cthdDTO.setSoluong(rs.getInt(3));
                cthdDTO.setDongiaban(rs.getString(4));
                cthdDTO.setTienkhuyenmaisp(rs.getString(5));
                cthdDTO.setThanhtien(rs.getString(6));
                listCTHD.add(cthdDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTHD;
    }
     */
    //-------------------------------------------
    public ArrayList<CTHDDTO> getCTHDDTO(String id) {
        ArrayList<CTHDDTO> listCTHD = new ArrayList<CTHDDTO>();
        ConnectDB();
        String sql = "SELECT * FROM ChitietHD WHERE MaHD = '" + id + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CTHDDTO cthdDTO = new CTHDDTO();
                cthdDTO.setMaHD(rs.getString(1));
                cthdDTO.setMaSP(rs.getString(2));
                cthdDTO.setSoluong(rs.getInt(3));
                cthdDTO.setDongiaban(rs.getFloat(4));
                cthdDTO.setTienkhuyenmaisp(rs.getFloat(5));
                cthdDTO.setThanhtien(rs.getFloat(6));
                listCTHD.add(cthdDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTHD;
    }
    //-------------------

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
    //---------------------------------

    public boolean addCTHDDTO(CTHDDTO cthdDTO) {
        ConnectDB();
        String sql = "INSERT INTO ChitietHD(MaHD,MaSP,Soluong,Dongia,TienKM,Thanhtien)"
                + " VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cthdDTO.getMaHD());
            ps.setString(2, cthdDTO.getMaSP());
            ps.setInt(3, cthdDTO.getSoluong());
            ps.setFloat(4, cthdDTO.getDongiaban());
            ps.setFloat(5, cthdDTO.getTienkhuyenmaisp());
            ps.setFloat(6, cthdDTO.getThanhtien());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //----------------------------------

    public boolean suaCTHDDTO(CTHDDTO cthdDTO) {
        ConnectDB();
        try {
            String sql = "update ChitietHD set Soluong=?,Dongia=?, TienKM=?,Thanhtien=? where MaHD=? and MaSP=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(5, cthdDTO.getMaHD());
            ps.setString(6, cthdDTO.getMaSP());
            ps.setInt(1, cthdDTO.getSoluong());
            ps.setFloat(2, cthdDTO.getDongiaban());
            ps.setFloat(3, cthdDTO.getTienkhuyenmaisp());
            ps.setFloat(4, cthdDTO.getThanhtien());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //---------------------------------------

    public boolean xoaCTHDDTO(CTHDDTO cthdDTO) {
        ConnectDB();
        try {
            String sql = "Delete ChitietHD  where MaHD=? and  MASP=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cthdDTO.getMaHD());
            ps.setString(2, cthdDTO.getMaSP());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //--------------------------------------------

    public void loadComboboxMaHD(JComboBox cb) {
        ConnectDB();
        String sql = "Select MaHD from Hoadon";
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
        String sql = "Select MaSP from Sanpham";
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

    public Float Tongtien(String Mahd) {
        ConnectDB();
        String sql = "SELECT sum(Thanhtien) AS Tongtien FROM ChitietHD WHERE MaHD = '" + Mahd + "'";
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
      public float tongkmct(String mahd) {
       ConnectDB();
        String sql = "SELECT sum(TienKM) AS Tongtien FROM ChitietHD WHERE MaHD = '" + mahd + "'";
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
//--------------------------------------------------------------------------
    public boolean suaTongtien(Float tongtien, String mahd) {
        ConnectDB();
        try {
            String sql = "update Hoadon set Tongtien=? where MaHD=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, tongtien);
            ps.setString(2, mahd);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //----------------------------------------------------------------------
    public int laysoluongsp(String masp, String mahd){
        ConnectDB();  
        String sql = "SELECT Soluong FROM ChitietHD WHERE MaSP = '"+masp+"'"+" and MaHD='"+mahd+"'";
       int t =0;
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
    //----------------------------------------------------------------------
    public boolean suasoluong(int soluong, String masp) {
        ConnectDB();
        try {
           String sql="UPDATE Sanpham SET Soluong=? WHERE MaSP=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, soluong);
            ps.setString(2, masp);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //--------------Lây ngay bat dau--------------------------------------
    public Date layngayBD( String makm){
        ConnectDB();  
        String sql = "SELECT * FROM ChuongtrinhKM WHERE  MaKM='"+makm+"'";
      Date t= new Date();
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
    //----------------------------------------------------------------
    public Date layngayKT( String makm){
        ConnectDB();  
        String sql = "SELECT * FROM ChuongtrinhKM WHERE  MaKM='"+makm+"'";
      Date t= new Date();
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
    //-----------------------------------------------------------------
    public Date layngayCT( String mahd){
        ConnectDB();  
        String sql = "SELECT * FROM Hoadon WHERE  MaHD='"+mahd+"'";
      Date t= new Date();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t = rs.getDate("Ngaylap");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    //--------------------------------------------------------------------
    public String laymaKM( String mahd){
        ConnectDB();  
        String sql = "SELECT * FROM Hoadon WHERE  MaHD='"+mahd+"'";
        String t=null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t = rs.getString("MaKM");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    //-------------------------------------------------------------
    public int laycachgiam(String makmhd, String masp){
        ConnectDB();  
        String sql = "SELECT * FROM SP_KhuyenMai WHERE  MaKM = '"+makmhd+"'"+" and MaSP='"+masp+"'";
        int  t=0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t = rs.getInt("Cachgiam");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    




















public boolean abc (String makmhd, String masp){
    String sql = "Select * from SP_Khuyenmai where Makm='"+makmhd+"' and MASP='"+masp+"'";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              int t;
              t=rs.getInt("cachgiam");
            }
        ps.executeQuery();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}



//-------------------------------------------------------------
    public boolean suaTienkm(Float t, String mahd) {
        ConnectDB();
        try {
            String sql = "update Hoadon set Tienkhuyenmai=? where MaHD=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, t);
            ps.setString(2, mahd);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
