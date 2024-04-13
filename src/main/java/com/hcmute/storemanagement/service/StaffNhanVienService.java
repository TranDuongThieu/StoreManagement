/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.DAO.StaffDao.StaffNhanVienDao;
import com.hcmute.storemanagement.models.NhanVien;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class StaffNhanVienService implements IStaffNhanVienService{
    StaffNhanVienDao staffNhanVienDao = new StaffNhanVienDao();

    @Override
    public ArrayList<NhanVien> getAllStaff() {
        return staffNhanVienDao.getAllStaff();
    }

    @Override
    public NhanVien getUserIdByUserName(String userName) {
        return staffNhanVienDao.getUserIdByUserName(userName);
    }
    
    
    
}
