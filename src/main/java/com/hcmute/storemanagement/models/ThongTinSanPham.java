/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.models;

/**
 *
 * @author DELL
 */
public class ThongTinSanPham {
    private String maSanPham;
    private String tenSanPham;
    private String moTa;
    private String thoiHanBaoHanh;
    private byte[] hinhAnh;
    private int soLuongDaBan;
    private int soLuongTrongKho;
    private int gia;
    private String maDanhMuc;
    private String tenDanhMuc;
    private String maLoaiThongSo;
    private String tenLoaiThongSo;
    private String maThongSo;
    private String giaTriThongSo;

    public ThongTinSanPham() {
    }

    public ThongTinSanPham(String maSanPham, String tenSanPham, String moTa, String thoiHanBaoHanh, byte[] hinhAnh, int soLuongDaBan, int soLuongTrongKho, int gia, String maDanhMuc, String tenDanhMuc, String maLoaiThongSo, String tenLoaiThongSo, String maThongSo, String giaTriThongSo) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.thoiHanBaoHanh = thoiHanBaoHanh;
        this.hinhAnh = hinhAnh;
        this.soLuongDaBan = soLuongDaBan;
        this.soLuongTrongKho = soLuongTrongKho;
        this.gia = gia;
        this.maDanhMuc = maDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.maLoaiThongSo = maLoaiThongSo;
        this.tenLoaiThongSo = tenLoaiThongSo;
        this.maThongSo = maThongSo;
        this.giaTriThongSo = giaTriThongSo;
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

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
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

    public String getMaLoaiThongSo() {
        return maLoaiThongSo;
    }

    public void setMaLoaiThongSo(String maLoaiThongSo) {
        this.maLoaiThongSo = maLoaiThongSo;
    }

    public String getTenLoaiThongSo() {
        return tenLoaiThongSo;
    }

    public void setTenLoaiThongSo(String tenLoaiThongSo) {
        this.tenLoaiThongSo = tenLoaiThongSo;
    }

    public String getMaThongSo() {
        return maThongSo;
    }

    public void setMaThongSo(String maThongSo) {
        this.maThongSo = maThongSo;
    }

    public String getGiaTriThongSo() {
        return giaTriThongSo;
    }

    public void setGiaTriThongSo(String giaTriThongSo) {
        this.giaTriThongSo = giaTriThongSo;
    }
    
    
}
