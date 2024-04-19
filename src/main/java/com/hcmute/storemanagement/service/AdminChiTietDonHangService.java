/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.DAO.StaffDao.AdminChiTietDonHangDao;
import com.hcmute.storemanagement.models.ChiTietDonHang;
import java.util.List;

/**
 *
 * @author DELL
 */
public class AdminChiTietDonHangService implements IAdminChiTietDonHangService {

    AdminChiTietDonHangDao adBilldetail = new AdminChiTietDonHangDao();

    @Override
    public List<ChiTietDonHang> getChiTietDonHangById(String maDonHang) {
        return adBilldetail.getChiTietDonHangById(maDonHang);
    }

    @Override
    public boolean deleteChiTietDonHang(String maDonHang, String maSanPham) {
        return adBilldetail.deleteChiTietDonHang(maDonHang, maSanPham);
    }

}
