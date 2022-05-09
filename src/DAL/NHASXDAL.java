/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.NHASXDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MYPC
 */
public class NHASXDAL {
    Connection conn=null;
      sqlConnection connect = new sqlConnection();
      
    public void ConnectDB(){
            if(conn==null){
            try {
                conn=connect.getConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
         }
    }
//    ---------------------------------
    public ArrayList<NHASXDTO> getALLNHASXDTO(){
      ConnectDB();
      ArrayList<NHASXDTO> listNSX= new ArrayList<NHASXDTO>();//tao cai mang 
      String sql="SELECT *FROM NHASX";
        try {
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();//doc bo dau tien
            while (rs.next()){
                NHASXDTO nhasx =new NHASXDTO(); 
                nhasx.setMANSX(rs.getString(1));
                nhasx.setTENNSX(rs.getString(2));
                nhasx.setDIACHI(rs.getString(3));
                nhasx.setEMAIL(rs.getString(4));
                nhasx.setSDT(rs.getString(5));
                listNSX.add(nhasx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNSX;
    }
 //------------------------------------
    public boolean addNHASXDTO(NHASXDTO nsx){
         ConnectDB();
        String sql ="INSERT INTO NHASX(MANSX,TENNSX,DIACHI,EMAIL,SDT)"
                + " VALUES(?,?,?,?,?)";   
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
               
               ps.setString(1,nsx.getMANSX());
               ps.setString(2,nsx.getTENNSX());
               ps.setString(3,nsx.getDIACHI());
               ps.setString(4,nsx.getEMAIL());
               ps.setString(5,nsx.getSDT()); 
               ps.executeUpdate();
              // conn.close() ;
               return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return false;
    }
    //--------------------------------------------
     public boolean suaNHASXDTO(NHASXDTO nsx){
          ConnectDB();
         try {
             String sql="update NHASX set TENNSX=?,DIACHI=?,EMAIL=?,SDT=? where MANSX=?";
             PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(5,nsx.getMANSX());
                ps.setString(1,nsx.getTENNSX());
                ps.setString(2,nsx.getDIACHI());
                ps.setString(3,nsx.getEMAIL());
                ps.setString(4,nsx.getSDT());     
               return ps.executeUpdate()>0;
               
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
     }
     //----------------------------------------
     public boolean xoaNHASXDTO(NHASXDTO nsx){
          ConnectDB();
         try {
             String sql="Delete NHASX  where MANSX=?";
             PreparedStatement ps= conn.prepareStatement(sql);
             ps.setString(1,nsx.getMANSX());
             
             return ps.executeUpdate()>0;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
     }
     
     //----------------------------------------
    
    public NHASXDTO getNhaSxDTO(String mansx) {
        ConnectDB();
        NHASXDTO nhasx = new NHASXDTO();
        String sql = "SELECT * FROM NHASX WHERE MANSX=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mansx);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nhasx.setMANSX(rs.getString(1));
                nhasx.setTENNSX(rs.getString(2));
                nhasx.setDIACHI(rs.getString(3));
                nhasx.setEMAIL(rs.getString(4));
                nhasx.setSDT(rs.getString(5));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhasx;
    }
}
