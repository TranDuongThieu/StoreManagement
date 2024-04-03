/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.models;

/**
 *
 * @author DELL
 */
public class ThongSoKyThuat {
    private String maThongSo;
    private String giaTriThongSo;
    private String maLoaiThongSo;

    public ThongSoKyThuat() {
    }

    public ThongSoKyThuat(String maThongSo, String giaTriThongSo, String maLoaiThongSo) {
        this.maThongSo = maThongSo;
        this.giaTriThongSo = giaTriThongSo;
        this.maLoaiThongSo = maLoaiThongSo;
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

    public String getMaLoaiThongSo() {
        return maLoaiThongSo;
    }

    public void setMaLoaiThongSo(String maLoaiThongSo) {
        this.maLoaiThongSo = maLoaiThongSo;
    }
    
}
