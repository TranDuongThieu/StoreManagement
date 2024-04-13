/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.DAO.StaffDao.StaffLichLamViecDao;
import com.hcmute.storemanagement.models.LichLamViec;
import java.util.Date;
import java.util.List;


public class StaffLichLamViecService implements IStaffLichLamViecService{
    StaffLichLamViecDao stLichLamViecDao = new StaffLichLamViecDao();
    public List<LichLamViec> getWorkScheduleWithID(String UserID){
        return stLichLamViecDao.getWorkScheduleWithID(UserID);
    }

    @Override
    public boolean insertLichLamViec(String UserID, Date Ngay, List<Integer> listShift) {
        return stLichLamViecDao.insertLichLamViec(UserID, Ngay, listShift);
    }
    
}
