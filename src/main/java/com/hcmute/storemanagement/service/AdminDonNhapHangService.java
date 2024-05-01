/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.DAO.StaffDao.AdminDonNhapHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.IAdminDonNhapHangDao;
import com.hcmute.storemanagement.models.DonNhapHang;
import java.util.List;

/**
 *
 * @author DELL
 */
public class AdminDonNhapHangService implements IAdminDonNhapHangService {

    IAdminDonNhapHangDao DonNhapHang = new AdminDonNhapHangDao();

    @Override
    public List<DonNhapHang> getAllDonNhapHang() {
        return DonNhapHang.getAllDonNhapHang();
    }

    @Override
    public int getTotalValueByMaDonNhapHang(String maDonNhapHang) {
        return DonNhapHang.getTotalValueByMaDonNhapHang(maDonNhapHang);
    }

    @Override
    public boolean updateTotalValueById(String maDonNhapHang, int newTotalValue) {
        return DonNhapHang.updateTotalValueById(maDonNhapHang, newTotalValue);
    }

    @Override
    public String getMaDonNhapHangCuoiCung() {
        return DonNhapHang.getMaDonNhapHangCuoiCung();
    }

    @Override
    public void insertDonNhapHang(DonNhapHang donNhapHang) {
        DonNhapHang.insertDonNhapHang(donNhapHang);
    }

    @Override
    public void deleteDonNhapHang(String maDonNhapHang) {
        DonNhapHang.deleteDonNhapHang(maDonNhapHang);
    }
}
