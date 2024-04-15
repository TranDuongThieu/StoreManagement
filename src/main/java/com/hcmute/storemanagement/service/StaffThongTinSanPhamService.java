/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.DAO.StaffDao.StaffThongTinSanPhamDao;
import com.hcmute.storemanagement.models.ThongTinSanPham;
import java.util.List;


public class StaffThongTinSanPhamService implements IStaffThongTinSanPhamService {

    StaffThongTinSanPhamDao staffThongTinSanPhamDao = new StaffThongTinSanPhamDao();

    @Override
    public List<ThongTinSanPham> getAllThongSo(String IdSp) {
        return staffThongTinSanPhamDao.getAllThongSo(IdSp);
    }

}
