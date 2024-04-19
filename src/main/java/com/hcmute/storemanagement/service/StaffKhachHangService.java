/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.DAO.StaffDao.StaffKhachHangDao;
import com.hcmute.storemanagement.models.KhachHang;
import java.util.List;

/**
 *
 * @author DELL
 */
public class StaffKhachHangService implements IStaffKhachHangService {

    StaffKhachHangDao stKhachHang = new StaffKhachHangDao();

    @Override
    public List<KhachHang> getAll() {
        return stKhachHang.getAll();
    }

    @Override
    public KhachHang getKhachHangByID(String maKhachHang) {
        return stKhachHang.getKhachHangByID(maKhachHang);
    }

    @Override
    public KhachHang getKhachHangByPhoneNumber(String soDienThoai) {
        return stKhachHang.getKhachHangByPhoneNumber(soDienThoai);
    }

    @Override
    public boolean addKhachHang(String tenKhachHang, String soDienThoai, int diemThanhVien) {
        return stKhachHang.addKhachHang(tenKhachHang, soDienThoai, diemThanhVien);
    }

}
