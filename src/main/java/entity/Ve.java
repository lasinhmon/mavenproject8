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
public class Ve {
    private String mave;   
    private String sdt;
// lay thong tin kh tạo vé 
// lấy mã vé insert so ghe đã có
    public Ve(String mave, String sdt) {
        this.mave = mave;
        this.sdt = sdt;
    }

    public String getMave() {
        return mave;
    }

    public void setMave(String mave) {
        this.mave = mave;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

   
}
