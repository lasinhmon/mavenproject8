/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author lasin
 */
public class Ghe {
    private int soghe;
    private String machang;
    private int trangthai;
    private int machuyen;
    private String mave;

    public Ghe() {

    }

    public Ghe(int soghe, String machang, int trangthai, int machuyen, String mave) {
        this.soghe = soghe;
        this.machang = machang;
        this.trangthai = trangthai;
        this.machuyen = machuyen;
        this.mave = mave;
    }

    public int getSoghe() {
        return soghe;
    }

    public void setSoghe(int soghe) {
        this.soghe = soghe;
    }

    public String getMachang() {
        return machang;
    }

    public void setMachang(String machang) {
        this.machang = machang;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public int getMachuyen() {
        return machuyen;
    }

    public void setMachuyen(int machuyen) {
        this.machuyen = machuyen;
    }

    public String getMave() {
        return mave;
    }

    public void setMave(String mave) {
        this.mave = mave;
    }

    

}
