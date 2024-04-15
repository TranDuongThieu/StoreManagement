/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.DAO.StaffDao.StaffLichLamViecDao;
import com.hcmute.storemanagement.models.LichLamViec;
import java.util.Date;
import java.util.List;

public class StaffLichLamViecService implements IStaffLichLamViecService {
    
    StaffLichLamViecDao stLichLamViecDao = new StaffLichLamViecDao();
    
    public List<LichLamViec> getWorkScheduleWithID(String UserID) {
        return stLichLamViecDao.getWorkScheduleWithID(UserID);
    }
    
    @Override
    public int insertLichLamViec(String UserID, Date Ngay, List<Integer> listShift) {
        return stLichLamViecDao.insertLichLamViec(UserID, Ngay, listShift);
    }
    
    @Override
    public void delete1rowLichLamViec(String UserID, Date Ngay, int MaCa) {
        stLichLamViecDao.delete1rowLichLamViec(UserID, Ngay, MaCa);
    }
    
    @Override
    public List<Integer> demSoCaTheoNgay(Date Ngay) {
        return stLichLamViecDao.demSoCaTheoNgay(Ngay);
    }
    
    @Override
    public void update1rowLichLamViec(String UserID, Date Ngay, int MaCa) {
        stLichLamViecDao.update1rowLichLamViec(UserID, Ngay, MaCa);
    }
    
}
