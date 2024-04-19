/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.DAO.StaffDao.StaffNhanVienDao;
import com.hcmute.storemanagement.DAO.StaffDao.StaffSanPhamDao;
import com.hcmute.storemanagement.models.SanPham;
import java.util.List;

/**
 *
 * @author DELL
 */
public class StaffSanPhamService implements IStaffSanPhamService {

    StaffSanPhamDao staffSanPhamDao = new StaffSanPhamDao();

    @Override
    public List<SanPham> getAllSanPham() {
        return staffSanPhamDao.getAllSanPham();
    }

    @Override
    public List<SanPham> getAllPhone() {
        return staffSanPhamDao.getAllPhone();
    }

    @Override
    public List<SanPham> getAllLapTop() {
        return staffSanPhamDao.getAllLapTop();
    }

    @Override
    public List<SanPham> getAllTablet() {
        return staffSanPhamDao.getAllTablet();
    }

    @Override
    public List<SanPham> getAllAccessory() {
        return staffSanPhamDao.getAllAccessory();
    }

    @Override
    public SanPham getSanPhamById(String id) {
        return staffSanPhamDao.getSanPhamById(id);
    }

}
