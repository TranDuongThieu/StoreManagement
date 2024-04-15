/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.models.NhanVien;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public interface IStaffNhanVienService {
    ArrayList<NhanVien> getAllStaff();
    NhanVien getUserIdByUserName(String userName);
    NhanVien getStaffById(String userID);
        void updateStaff (String id, String ten, String diaChi, String email, String phone, String cccd, Date ngaySinh);

}
