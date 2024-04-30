/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.models.DonNhapHang;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IAdminDonNhapHangService {

    List<DonNhapHang> getAllDonNhapHang();

    int getTotalValueByMaDonNhapHang(String maDonNhapHang);

    boolean updateTotalValueById(String maDonNhapHang, int newTotalValue);

    String getMaDonNhapHangCuoiCung();
}