/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.models.LichLamViec;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IStaffLichLamViecService {

    List<LichLamViec> getWorkScheduleWithID(String UserID);

    int insertLichLamViec(String UserID, Date Ngay, List<Integer> listShift);

    void delete1rowLichLamViec(String UserID, Date Ngay, int MaCa);

    List<Integer> demSoCaTheoNgay(Date Ngay);

    boolean update1rowLichLamViec(String UserID, Date Ngay, int MaCa);
}
