/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.DAO.StaffDao.StaffNhanVienDao;
import com.hcmute.storemanagement.models.NhanVien;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class StaffNhanVienService implements IStaffNhanVienService {

    StaffNhanVienDao staffNhanVienDao = new StaffNhanVienDao();

    @Override
    public ArrayList<NhanVien> getAllStaff() {
        return staffNhanVienDao.getAllStaff();
    }

    @Override
    public NhanVien getUserIdByUserName(String userName) {
        return staffNhanVienDao.getUserIdByUserName(userName);
    }

    @Override
    public NhanVien getStaffById(String userID) {
        return staffNhanVienDao.getStaffById(userID);
    }

    @Override
    public boolean updateStaff(String id, String ten, String diaChi, String email, String phone, String cccd, Date ngaySinh) {
        return staffNhanVienDao.updateStaff(id, ten, diaChi, email, phone, cccd, ngaySinh);
    }

    @Override
    public boolean deleteStaffByUserId(String userId) {
        return staffNhanVienDao.deleteStaffByUserId(userId);
    }

}
