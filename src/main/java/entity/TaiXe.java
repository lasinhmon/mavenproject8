/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author lasin
 */
public class TaiXe {
    private String ma;
    private String tentaixe;
    private String sdt;

    public TaiXe(String ma, String tentaixe, String sdt) {
        this.ma = ma;
        this.tentaixe = tentaixe;
        this.sdt = sdt;
    }

    public TaiXe() {
    }

    public String getMa() {
        return this.ma;
        //return "TX07";
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTentaixe() {
        return tentaixe;
    }

    public void setTentaixe(String tentaixe) {
        this.tentaixe = tentaixe;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    
}
