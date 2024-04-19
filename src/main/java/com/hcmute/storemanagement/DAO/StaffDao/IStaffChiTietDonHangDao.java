/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.models.ChiTietDonHang;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IStaffChiTietDonHangDao {

    boolean createChiTietDonHang(String maDonHang, String maSanPham, int soLuong);

    int checkChiTietDonHang(String maDonHang, String maSanPham);

    boolean updateSoLuong(String maDonHang, String maSanPham, int soLuongMoi);

}
