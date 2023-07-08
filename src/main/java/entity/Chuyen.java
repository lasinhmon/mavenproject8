/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author lasin
 */
public class Chuyen {
    private int machuyen;
    private Timestamp ngay;
    private String maxe;
    private String mataixe;
    public Chuyen() {
    }

    public Chuyen(int machuyen, Timestamp ngay, String maxe, String mataixe) {
        this.machuyen = machuyen;
        this.ngay = ngay;
        this.maxe = maxe;
        this.mataixe=mataixe;
    }

    public int getMachuyen() {
        return machuyen;
    }

    public void setMachuyen(int machuyen) {
        this.machuyen = machuyen;
    }

    public Timestamp getNgay() {
        return ngay;
    }

    public void setNgay(Timestamp ngay) {
        this.ngay = ngay;
    }

    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }

    public String getMataixe() {
        return mataixe;
    }

    public void setMataixe(String mataixe) {
        this.mataixe = mataixe;
    }
    
    
}
