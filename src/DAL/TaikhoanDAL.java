package DAL;

import DTO.TaikhoanDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MYPC
 */
public class TaikhoanDAL {

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

    public ArrayList<TaikhoanDTO> getAllTaikhoanDTO() {
        //Doc tu trong bang ra
        ArrayList<TaikhoanDTO> listNV = new ArrayList<TaikhoanDTO>();//tao cai mang 
        String sql = "SELECT * FROM Taikhoandangnhap";
        try {
            ConnectDB();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//doc bo dau tien
            while (rs.next()) {
                TaikhoanDTO nvDTO = new TaikhoanDTO();
                nvDTO.setUsername(rs.getString(1));
                nvDTO.setPassword(rs.getString(2));
                nvDTO.setRole(rs.getString(3));
                listNV.add(nvDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }

    public String laymk(String username) {
        ConnectDB();
        String sql = "SELECT password FROM Taikhoandangnhap WHERE username = '" + username + "'";
        String t = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t = (rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;

    }

    public String getRole(String username) {
        ConnectDB();
        String sql = "SELECT role FROM Taikhoandangnhap WHERE username = '" + username + "'";
        String t = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t = (rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
     public boolean addNhanvienDTO(TaikhoanDTO nvDTO){//luu csdl vao bang  
        String sql ="INSERT INTO Taikhoandangnhap(Username,Password,role)  VALUES(?,?,?)";   
        ConnectDB();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
               
               ps.setString(1,nvDTO.getUsername());
               ps.setString(2,nvDTO.getPassword());
               ps.setString(3,nvDTO.getRole());
               return  ps.executeUpdate()>0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return false;
    }
     //--------------------------------------------
     public boolean suaNhanvienDTO(TaikhoanDTO nvDTO){
         ConnectDB();
         try {
             String sql="update Taikhoandangnhap set Password=?,Role=? where Username=?";
             PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(3,nvDTO.getUsername());
                ps.setString(1,nvDTO.getPassword());
                ps.setString(2,nvDTO.getRole());  
               return ps.executeUpdate()>0;
               
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
     }
     //----------------------------------------
     public boolean xoaNhanvienDTO(TaikhoanDTO nvDTO){
         ConnectDB();
         try {
             String sql="Delete Taikhoandangnhap  where Username=?";
             PreparedStatement ps= conn.prepareStatement(sql);
             ps.setString(1,nvDTO.getUsername());
             
             return ps.executeUpdate()>0;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
     }
}
