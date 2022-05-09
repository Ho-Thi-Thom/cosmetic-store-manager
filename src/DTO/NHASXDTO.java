/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

public class NHASXDTO {
    private String MANSX,TENNSX,DIACHI,EMAIL,SDT;

    public  NHASXDTO(String MANSX, String TENNSX, String DIACHI, String EMAIL, String SDT) {
        this.MANSX = MANSX;
        this.TENNSX = TENNSX;
        this.DIACHI = DIACHI;
        this.EMAIL = EMAIL;
        this.SDT = SDT;
    }

    public NHASXDTO() {
        
    }

    public NHASXDTO(String MANSX, String TENNSX) {
        this.MANSX = MANSX;
        this.TENNSX = TENNSX;
    }
    
    
    public String getMANSX() {
        return MANSX;
    }

    public void setMANSX(String MANSX) {
        this.MANSX = MANSX;
    }

    public String getTENNSX() {
        return TENNSX;
    }

    public void setTENNSX(String TENNSX) {
        this.TENNSX = TENNSX;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    
}
