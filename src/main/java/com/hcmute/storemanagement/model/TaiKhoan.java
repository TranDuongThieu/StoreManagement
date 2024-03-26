/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.model;

/**
 *
 * @author DELL
 */
public class TaiKhoan {
    private String tenDangNhap;
    private String matKhau;
    private String quyenNguoiDung;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenDangNhap, String matKhau, String quyenNguoiDung) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.quyenNguoiDung = quyenNguoiDung;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getQuyenNguoiDung() {
        return quyenNguoiDung;
    }

    public void setQuyenNguoiDung(String quyenNguoiDung) {
        this.quyenNguoiDung = quyenNguoiDung;
    }
    
    
}
