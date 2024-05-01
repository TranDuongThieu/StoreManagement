/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.models.ChiTietDonNhapHang;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IAdminChiTietDonNhapHangService {

    List<ChiTietDonNhapHang> getGRNDetailgByGRNId(String maDonNhapHang);

    boolean updateSoluong(String maDonNhapHang, String maSanPham, int soLuongMoi);

    boolean deleteGRNDetail(String maDonNhapHang, String maSanPham);

    boolean insertChiTietDonNhapHang(String maDonNhapHang, String maSanPham, int soLuong);
}
