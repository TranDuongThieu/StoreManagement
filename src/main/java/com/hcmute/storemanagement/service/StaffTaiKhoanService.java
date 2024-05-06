/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.DAO.StaffDao.StaffTaiKhoanDao;
import com.hcmute.storemanagement.models.TaiKhoan;

/**
 *
 * @author DELL
 */
public class StaffTaiKhoanService implements IStaffTaiKhoanService {

    StaffTaiKhoanDao staffTaiKhoanDao = new StaffTaiKhoanDao();

    @Override
    public TaiKhoan getAccountByUsername(String userName) {
        return staffTaiKhoanDao.getAccountByUsername(userName);
    }

    @Override
    public boolean createAccount(String password, String role) {
        return staffTaiKhoanDao.createAccount(password, role);
    }

    @Override
    public String getLatestAccountUsername() {
        return staffTaiKhoanDao.getLatestAccountUsername();
    }

    @Override
    public boolean deleteAccount(String userName) {
        return staffTaiKhoanDao.deleteAccount(userName);
    }

}
