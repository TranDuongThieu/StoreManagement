/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.DAO.StaffDao.AdminChiTietDonNhapHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.IAdminChiTietDonNhapHangDao;
import com.hcmute.storemanagement.models.ChiTietDonNhapHang;
import java.util.List;

/**
 *
 * @author DELL
 */
public class AdminChiTietDonNhapHangService implements IAdminChiTietDonNhapHangService {

    IAdminChiTietDonNhapHangDao GRNDetail = new AdminChiTietDonNhapHangDao();

    @Override
    public List<ChiTietDonNhapHang> getGRNDetailgByGRNId(String maDonNhapHang) {
        return GRNDetail.getGRNDetailgByGRNId(maDonNhapHang);
    }

    @Override
    public boolean updateSoluong(String maDonNhapHang, String maSanPham, int soLuongMoi) {
        return GRNDetail.updateSoluong(maDonNhapHang, maSanPham, soLuongMoi);
    }

    @Override
    public boolean deleteGRNDetail(String maDonNhapHang, String maSanPham) {
        return GRNDetail.deleteGRNDetail(maDonNhapHang, maSanPham);
    }

}
