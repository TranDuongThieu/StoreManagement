/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.models.SanPham;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IStaffSanPhamDao {

    List<SanPham> getAllSanPham();

    List<SanPham> getAllPhone();

    List<SanPham> getAllLapTop();

    List<SanPham> getAllTablet();

    List<SanPham> getAllAccessory();

    SanPham getSanPhamById(String id);

    int getSoLuongTrongKhoByMaSanPham(String maSanPham);
    
    void updateSoLuongTrongKho(String maSanPham, int soLuongMoi);
}
