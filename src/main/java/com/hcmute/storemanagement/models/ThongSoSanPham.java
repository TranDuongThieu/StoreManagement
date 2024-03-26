/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.models;

/**
 *
 * @author DELL
 */
public class ThongSoSanPham {
    private String maSanPham;
    private String maThongSo;

    public ThongSoSanPham() {
    }

    public ThongSoSanPham(String maSanPham, String maThongSo) {
        this.maSanPham = maSanPham;
        this.maThongSo = maThongSo;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getMaThongSo() {
        return maThongSo;
    }

    public void setMaThongSo(String maThongSo) {
        this.maThongSo = maThongSo;
    }
    
}
