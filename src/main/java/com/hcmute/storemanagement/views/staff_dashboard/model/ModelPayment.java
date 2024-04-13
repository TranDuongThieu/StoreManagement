package com.hcmute.storemanagement.views.staff_dashboard.model;


import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.Icon;

public class ModelPayment {

    private String maDonHang;
    private Date ngayDatHang;
    private int tongGiaTri;
    private String maKhachHang;
    private double maNhanVien;

    public ModelPayment() {
    }

    public ModelPayment(String maDonHang, Date ngayDatHang, int tongGiaTri, String maKhachHang, double maNhanVien) {
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

    public double getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(double maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    
   
}
