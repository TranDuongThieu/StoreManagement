/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class LichLamViec {
     private String maNhanVien;
    private int thuTrongTuan;
    private int maCa;
    private Date ngayBatDau;
    private Date ngayKetThua;

    public LichLamViec() {
    }

    public LichLamViec(String maNhanVien, int thuTrongTuan, int maCa, Date ngayBatDau, Date ngayKetThua) {
        this.maNhanVien = maNhanVien;
        this.thuTrongTuan = thuTrongTuan;
        this.maCa = maCa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThua = ngayKetThua;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getThuTrongTuan() {
        return thuTrongTuan;
    }

    public void setThuTrongTuan(int thuTrongTuan) {
        this.thuTrongTuan = thuTrongTuan;
    }

    public int getMaCa() {
        return maCa;
    }

    public void setMaCa(int maCa) {
        this.maCa = maCa;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThua() {
        return ngayKetThua;
    }

    public void setNgayKetThua(Date ngayKetThua) {
        this.ngayKetThua = ngayKetThua;
    }
    
    
}
