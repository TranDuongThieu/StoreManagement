/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.DAO.StaffDao.StaffChiTietDonHangDao;

/**
 *
 * @author DELL
 */
public class StaffChiTietDonHangService implements IStaffChiTietDonHangService {

    StaffChiTietDonHangDao staffccch = new StaffChiTietDonHangDao();

    @Override
    public boolean createChiTietDonHang(String maDonHang, String maSanPham, int soLuong) {
        return staffccch.createChiTietDonHang(maDonHang, maSanPham, soLuong);
    }

    @Override
    public int checkChiTietDonHang(String maDonHang, String maSanPham) {
        return staffccch.checkChiTietDonHang(maDonHang, maSanPham);
    }

    @Override
    public boolean updateSoLuong(String maDonHang, String maSanPham, int soLuongMoi) {
        return staffccch.updateSoLuong(maDonHang, maSanPham, soLuongMoi);
    }

}
