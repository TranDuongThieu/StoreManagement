/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import java.util.Date;

/**
 *
 * @author DELL
 */
public interface IStaffNgayLamViecDao {
    //boolean insertNgayLamViec(Date Ngay);
    void checkAndInsertNgayLamViec(Date Ngay);
}