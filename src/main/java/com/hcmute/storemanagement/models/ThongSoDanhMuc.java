/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.model;

/**
 *
 * @author DELL
 */
public class ThongSoDanhMuc {
    private String maLoaiThongSo;
    private String maDanhMuc;

    public ThongSoDanhMuc() {
    }

    public ThongSoDanhMuc(String maLoaiThongSo, String maDanhMuc) {
        this.maLoaiThongSo = maLoaiThongSo;
        this.maDanhMuc = maDanhMuc;
    }

    public String getMaLoaiThongSo() {
        return maLoaiThongSo;
    }

    public void setMaLoaiThongSo(String maLoaiThongSo) {
        this.maLoaiThongSo = maLoaiThongSo;
    }

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }
    
}
