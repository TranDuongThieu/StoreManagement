/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.models;

/**
 *
 * @author DELL
 */
public class ChiTietDonNhapHang {
    private String maDonNhapHang;
    private String maSanPham;
    private int soLuong;

    public ChiTietDonNhapHang() {
    }

    public ChiTietDonNhapHang(String maDonNhapHang, String maSanPham, int soLuong) {
        this.maDonNhapHang = maDonNhapHang;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
    }

    public String getMaDonNhapHang() {
        return maDonNhapHang;
    }

    public void setMaDonNhapHang(String maDonNhapHang) {
        this.maDonNhapHang = maDonNhapHang;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
}
