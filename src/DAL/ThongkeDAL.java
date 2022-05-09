/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.ThongkeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MYPC
 */
public class ThongkeDAL {

    /**
     * @param args the command line arguments
     */
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

    public ArrayList<ThongkeDTO> getAllTKSLBDDTO(String tungay, String denngay) {
        //Doc tu trong bang ra
        ArrayList<ThongkeDTO> listSLBD = new ArrayList<ThongkeDTO>();//tao cai mang 
        String sql = "SELECT ChitietHD.MaSP,Sanpham.TenSP,Sum(ChitietHD.Soluong)as slbanduoc\n"
                + "FROM Sanpham,ChitietHD,Hoadon\n"
                + "WHERE Sanpham.MaSP=ChitietHD.MaSP and Hoadon.MaHD=ChitietHD.MaHD AND Hoadon.Ngaylap between '" + tungay + "' and '" + denngay + "'\n"
                + "group by ChitietHD.MaSP , Sanpham.TenSP";
        try {
            ConnectDB();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//doc bo dau tien
            while (rs.next()) {
                ThongkeDTO tkDTO = new ThongkeDTO();
                tkDTO.setMaSP(rs.getString(1));
                tkDTO.setTenSP(rs.getString(2));
                tkDTO.setSoluongbd(rs.getString(3));
                listSLBD.add(tkDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSLBD;
    }

    public ArrayList<ThongkeDTO> getAlldoanhthuDTO(String nam) {
        //Doc tu trong bang ra
        ArrayList<ThongkeDTO> listDT = new ArrayList<ThongkeDTO>();//tao cai mang 
        String sql = "select MONTH (Hoadon.Ngaylap)as month , SUM(Hoadon.Tongtien) as doanhthu\n"
                + "from Hoadon\n"
                + "where year(Hoadon.Ngaylap)='"+nam+"' \n"
                + "group by month(Hoadon.Ngaylap)";
        try {
            ConnectDB();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//doc bo dau tien
            while (rs.next()) {
                ThongkeDTO tkDTO = new ThongkeDTO();
                tkDTO.setThang(rs.getString(1));
                tkDTO.setDoanhthuthang(rs.getFloat(2));
                listDT.add(tkDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDT;
    }
}
