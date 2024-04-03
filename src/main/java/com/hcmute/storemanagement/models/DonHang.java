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
public class DonHang {
     private String maDonHang;
    private Date ngayDatHang;
    private int tongGiaTri;
    private String maKhachHang;
    private String maNhanVien;

    public DonHang() {
    }

    public DonHang(String maDonHang, Date ngayDatHang, int tongGiaTri, String maKhachHang, String maNhanVien) {
        this.maDonHang = maDonHang;
        this.ngayDatHang = ngayDatHang;
        this.tongGiaTri = tongGiaTri;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public int getTongGiaTri() {
        return tongGiaTri;
    }

    public void setTongGiaTri(int tongGiaTri) {
        this.tongGiaTri = tongGiaTri;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    
}
