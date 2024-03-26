/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.models;

/**
 *
 * @author DELL
 */
public class LoaiThongSoSanPham {
    private String maLoaiThongSo;
    private String tenLoaiThongSo;

    public LoaiThongSoSanPham() {
    }

    public LoaiThongSoSanPham(String maLoaiThongSo, String tenLoaiThongSo) {
        this.maLoaiThongSo = maLoaiThongSo;
        this.tenLoaiThongSo = tenLoaiThongSo;
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

}
