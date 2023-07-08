/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author lasin
 */
public class Chang {
    private String machang;
    private String gadi;
    private String gaden;
    private int gia;

    public Chang(String machang, String gadi, String gaden, int gia) {
        this.machang = machang;
        this.gadi = gadi;
        this.gaden = gaden;
        this.gia = gia;
    }

    public Chang() {
    }

    public String getMachang() {
        return machang;
    }

    public void setMachang(String machang) {
        this.machang = machang;
    }

    public String getGadi() {
        return gadi;
    }

    public void setGadi(String gadi) {
        this.gadi = gadi;
    }

    public String getGaden() {
        return gaden;
    }

    public void setGaden(String gaden) {
        this.gaden = gaden;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
   

}
