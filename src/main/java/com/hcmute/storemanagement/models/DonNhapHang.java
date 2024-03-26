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
public class DonNhapHang {
     private String maDonNhapHang;
    private Date ngayNhapHang;
    private int tongGiaTri;
    private String maNhaCungCap;

    public DonNhapHang() {
    }

    public DonNhapHang(String maDonNhapHang, Date ngayNhapHang, int tongGiaTri, String maNhaCungCap) {
        this.maDonNhapHang = maDonNhapHang;
        this.ngayNhapHang = ngayNhapHang;
        this.tongGiaTri = tongGiaTri;
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getMaDonNhapHang() {
        return maDonNhapHang;
    }

    public void setMaDonNhapHang(String maDonNhapHang) {
        this.maDonNhapHang = maDonNhapHang;
    }

    public Date getNgayNhapHang() {
        return ngayNhapHang;
    }

    public void setNgayNhapHang(Date ngayNhapHang) {
        this.ngayNhapHang = ngayNhapHang;
    }

    public int getTongGiaTri() {
        return tongGiaTri;
    }

    public void setTongGiaTri(int tongGiaTri) {
        this.tongGiaTri = tongGiaTri;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

       
}
