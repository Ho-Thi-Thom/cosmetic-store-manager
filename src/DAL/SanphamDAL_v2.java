/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.LoaiSpBLL;
import BLL.NHASXBLL;
import BLL.SanphamBLL_v2;
import DTO.ComboItem;
import DTO.LoaiSpDTO;
import DTO.NHASXDTO;
import DTO.SanphamDTO_v2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author MYPC
 */
public class SanphamDAL_v2 {

    Connection conn = null;
    sqlConnection connect = new sqlConnection();
    LoaiSpBLL loaiBLL = new LoaiSpBLL();
    NHASXBLL nhasxBLL = new NHASXBLL();
    private ArrayList<LoaiSpDTO> listLoai;

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
    public ArrayList<SanphamDTO_v2> getAllSanphamDTO_test() {
        ConnectDB();
        ArrayList<SanphamDTO_v2> listSP = new ArrayList<SanphamDTO_v2>();//tao cai mang 
        listLoai = loaiBLL.getALLLoaiSpDTO();
        String sql = "SELECT * FROM Sanpham";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//doc bo dau tien
            while (rs.next()) {
                SanphamDTO_v2 spDTO = new SanphamDTO_v2();
                LoaiSpDTO loaispDTO = loaiBLL.getLoaiSpDTO(rs.getString(6));
                NHASXDTO nhasxDTO = nhasxBLL.getNhaSxDTO(rs.getString(7));
                spDTO.setMasp(rs.getString(1));
                spDTO.setTensp(rs.getString(2));
                spDTO.setSoluong(rs.getInt(3));
                spDTO.setDongia(rs.getString(4));
                spDTO.setLoaisp(loaispDTO);
                spDTO.setNhasx(nhasxDTO);
                spDTO.setDonvitinh(rs.getString(5));
                listSP.add(spDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }
    //-------------------------------------

    public boolean addSanphamDTO_test(SanphamDTO_v2 spDTO) {//luu csdl vao bang 
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
            ps.setString(6, spDTO.getLoaisp().getMALOAI());
            ps.setString(7, spDTO.getNhasx().getMANSX());

            // conn.close() ;
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //--------------------------------------------

    public boolean suaSanphamDTO_test(SanphamDTO_v2 spDTO) {
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
            //ps.setDate(4,new java.sql.Date(khDTO.getNgaysinh().getTime()) );
            ps.setString(4, spDTO.getDonvitinh());
            ps.setString(5, spDTO.getLoaisp().getMALOAI());
            ps.setString(6, spDTO.getNhasx().getMANSX());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //----------------------------------------

    public boolean xoaSanphamDTO_test(SanphamDTO_v2 spDTO) {
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
    public void loadCombobox(JComboBox cb) {//load duw lieu tu khoa len combobox

        // cbKhoa.addItem(rs.getString("Khoa"));
        ConnectDB();
        String sql = "Select * from LoaiSP";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ComboItem item = new ComboItem(rs.getString(2), rs.getString(1));
                cb.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadComboboxMaNSX(JComboBox cb) {//load duw lieu tu khoa len combobox

        // cbKhoa.addItem(rs.getString("Khoa"));
        ConnectDB();
        String sql1 = "Select * from NhaSX";
        try {
            PreparedStatement ps = conn.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ComboItem item = new ComboItem(rs.getString(2), rs.getString(1));
                cb.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //----------------------------------------------

    public ArrayList<SanphamDTO_v2> getInRangeSanphamDTO_test(String min, String max) {
        ConnectDB();
        ArrayList<SanphamDTO_v2> listSP = new ArrayList<SanphamDTO_v2>();//tao cai mang 
        listLoai = loaiBLL.getALLLoaiSpDTO();
        String sql = "SELECT * FROM Sanpham WHERE Dongia between " + min + " and " + max;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//doc bo dau tien
            while (rs.next()) {
                SanphamDTO_v2 spDTO = new SanphamDTO_v2();
                LoaiSpDTO loaispDTO = loaiBLL.getLoaiSpDTO(rs.getString(6));
                NHASXDTO nhasxDTO = nhasxBLL.getNhaSxDTO(rs.getString(7));
                spDTO.setMasp(rs.getString(1));
                spDTO.setTensp(rs.getString(2));
                spDTO.setSoluong(rs.getInt(3));
                spDTO.setDongia(rs.getString(4));
                spDTO.setLoaisp(loaispDTO);
                spDTO.setNhasx(nhasxDTO);
                spDTO.setDonvitinh(rs.getString(5));
                listSP.add(spDTO);
            }
            System.out.println("OK");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public boolean DeleteAll() {
        ConnectDB();
        try {
            String sql = "Delete from Sanpham ";
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
