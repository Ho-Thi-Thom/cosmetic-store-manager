/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

public class NHACCDTO {
    private String MANCC,TENNCC,DIACHI,EMAIL,SDT;

    public  NHACCDTO(String MANCC, String TENNCC, String DIACHI, String EMAIL, String SDT) {
        this.MANCC = MANCC;
        this.TENNCC = TENNCC;
        this.DIACHI = DIACHI;
        this.EMAIL = EMAIL;
        this.SDT = SDT;
    }

    public NHACCDTO() {
        
    }

    public NHACCDTO(String MANCC, String TENNCC) {
        this.MANCC = MANCC;
        this.TENNCC = TENNCC;
    }
    
    
    public String getMANCC() {
        return MANCC;
    }

    public void setMANCC(String MANCC) {
        this.MANCC = MANCC;
    }

    public String getTENNCC() {
        return TENNCC;
    }

    public void setTENNCC(String TENNCC) {
        this.TENNCC = TENNCC;
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
