/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.models.DonNhapHang;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IAdminDonNhapHangDao {

    List<DonNhapHang> getAllDonNhapHang();
    DonNhapHang getById(String id);
    int getTotalValueByMaDonNhapHang(String maDonNhapHang);

    boolean updateTotalValueById(String maDonNhapHang, int newTotalValue);

    String getMaDonNhapHangCuoiCung();

    void insertDonNhapHang(DonNhapHang donNhapHang);

    void deleteDonNhapHang(String maDonNhapHang);
}
