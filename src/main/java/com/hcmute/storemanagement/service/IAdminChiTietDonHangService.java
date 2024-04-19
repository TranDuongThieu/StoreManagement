/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.models.ChiTietDonHang;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IAdminChiTietDonHangService {

    List<ChiTietDonHang> getChiTietDonHangById(String maDonHang);

    boolean deleteChiTietDonHang(String maDonHang, String maSanPham);
}
