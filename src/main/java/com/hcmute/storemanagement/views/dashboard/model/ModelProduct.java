/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.model;

import com.hcmute.storemanagement.views.dashboard.swing.ProductTable.EventActionProduct;
import com.hcmute.storemanagement.views.dashboard.swing.ProductTable.ModelActionProduct;
import com.hcmute.storemanagement.views.dashboard.swing.ProductTable.ModelProfileProduct;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.Icon;

/**
 *
 * @author DELL
 */
public class ModelProduct {

    private Icon icon;
    private String maSanPham;
    private String tenSanPham;
    private String moTa;
    private String thoiHanBaoHanh;
    private int soLuongDaBan;
    private int soLuongTrongKho;
    private int gia;

    public ModelProduct() {
    }

    public ModelProduct(Icon icon, String maSanPham, String tenSanPham, String moTa, String thoiHanBaoHanh, int soLuongDaBan, int soLuongTrongKho, int gia) {
        this.icon = icon;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.thoiHanBaoHanh = thoiHanBaoHanh;
        this.soLuongDaBan = soLuongDaBan;
        this.soLuongTrongKho = soLuongTrongKho;
        this.gia = gia;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
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
    
       
  
    
    public Object[] toRowTable(EventActionProduct event) {
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        return new Object[]{new ModelProfileProduct(icon, maSanPham), tenSanPham, moTa, thoiHanBaoHanh,soLuongDaBan,soLuongTrongKho,gia, new ModelActionProduct(this, event)};
    }
    
}
