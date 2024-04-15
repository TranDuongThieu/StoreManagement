/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.models;

import java.util.Date;

/**
 *
 * @author thieu
 */
public class GeneralSchedule {
    private String hoten;
    private Date NgayLamViec;
    private int maCa;

    public GeneralSchedule() {
    }

    public GeneralSchedule(String hoten, Date NgayLamViec, int maCa) {
        this.hoten = hoten;
        this.NgayLamViec = NgayLamViec;
        this.maCa = maCa;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Date getNgayLamViec() {
        return NgayLamViec;
    }

    public void setNgayLamViec(Date NgayLamViec) {
        this.NgayLamViec = NgayLamViec;
    }

    public int getMaCa() {
        return maCa;
    }

    public void setMaCa(int maCa) {
        this.maCa = maCa;
    }
    
    
}
