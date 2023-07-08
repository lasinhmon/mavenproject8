/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author lasin
 */
public class Xe {
    private String maxe;
    private String biensoxe;
    //tim tat ca cac ghe tren xe di sg dl voi trang thai la 1 hoac 2
//tim tat ca cac ghe tren xe di ga di ga den da chon voi trang thai 1 hoac 2

    public Xe(String maxe, String biensoxe) {
        this.maxe = maxe;
        this.biensoxe = biensoxe;
    }

    public Xe() {
    }

    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }

    public String getBiensoxe() {
        return biensoxe;
    }

    public void setBiensoxe(String biensoxe) {
        this.biensoxe = biensoxe;
    }

    

}
