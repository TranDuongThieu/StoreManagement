/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.models.KhachHang;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IStaffKhachHangService {

    List<KhachHang> getAll();

    KhachHang getKhachHangByID(String maKhachHang);

    KhachHang getKhachHangByPhoneNumber(String soDienThoai);

boolean addKhachHang(String tenKhachHang, String soDienThoai);
    void updateScore(String customerId, int newScore);

}
