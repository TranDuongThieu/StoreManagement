/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.DAO.StaffDao.StaffNgayLamViecDao;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class StaffLNgayLamViecService implements IStaffLNgayLamViecService {

    StaffNgayLamViecDao staffNgayLamViecDao = new StaffNgayLamViecDao();
//    @Override
//    public boolean insertNgayLamViec(Date Ngay) {
//        return staffNgayLamViecDao.insertNgayLamViec(Ngay);
//    }

    @Override
    public void checkAndInsertNgayLamViec(Date Ngay) {
        staffNgayLamViecDao.checkAndInsertNgayLamViec(Ngay);
    }

}
