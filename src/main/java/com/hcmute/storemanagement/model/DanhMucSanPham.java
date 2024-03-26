/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.model;

/**
 *
 * @author DELL
 */
public class DanhMucSanPham {
     private String maDanhMuc;
    private String tenDanhMuc;
    private String maDanhMucCha;

    public DanhMucSanPham() {
    }

    public DanhMucSanPham(String maDanhMuc, String tenDanhMuc, String maDanhMucCha) {
        this.maDanhMuc = maDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.maDanhMucCha = maDanhMucCha;
    }

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getMaDanhMucCha() {
        return maDanhMucCha;
    }

    public void setMaDanhMucCha(String maDanhMucCha) {
        this.maDanhMucCha = maDanhMucCha;
    }
    
    
}
