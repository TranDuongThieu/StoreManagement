/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.models;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class LichLamViec {
     private String maNhanVien;
    private Date ngayLamViec;
        private int maCa;


    public LichLamViec() {
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public Date getNgayLamViec() {
        return ngayLamViec;
    }

    public void setNgayLamViec(Date ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }

    public int getMaCa() {
        return maCa;
    }

    public void setMaCa(int maCa) {
        this.maCa = maCa;
    }

    public LichLamViec(String maNhanVien, Date ngayLamViec, int maCa) {
        this.maNhanVien = maNhanVien;
        this.ngayLamViec = ngayLamViec;
        this.maCa = maCa;
    }

    
}
