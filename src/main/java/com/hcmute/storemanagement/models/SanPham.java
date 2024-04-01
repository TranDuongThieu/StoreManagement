/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.models;

/**
 *
 * @author DELL
 */
public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private String moTa;
    private String thoiHanBaoHanh;
    private byte[] hinhAnh;
    private int soLuongDaBan;
    private int soLuongTrongKho;
    private String maDanhMuc;
    private int gia;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanPham, String moTa, String thoiHanBaoHanh, byte[] hinhAnh, int soLuongDaBan, int soLuongTrongKho, String maDanhMuc, int gia) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.thoiHanBaoHanh = thoiHanBaoHanh;
        this.hinhAnh = hinhAnh;
        this.soLuongDaBan = soLuongDaBan;
        this.soLuongTrongKho = soLuongTrongKho;
        this.maDanhMuc = maDanhMuc;
        this.gia = gia;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getThoiHanBaoHanh() {
        return thoiHanBaoHanh;
    }

    public void setThoiHanBaoHanh(String thoiHanBaoHanh) {
        this.thoiHanBaoHanh = thoiHanBaoHanh;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getSoLuongDaBan() {
        return soLuongDaBan;
    }

    public void setSoLuongDaBan(int soLuongDaBan) {
        this.soLuongDaBan = soLuongDaBan;
    }

    public int getSoLuongTrongKho() {
        return soLuongTrongKho;
    }

    public void setSoLuongTrongKho(int soLuongTrongKho) {
        this.soLuongTrongKho = soLuongTrongKho;
    }

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    
}
