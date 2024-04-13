/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.models.NhanVien;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface IStaffNhanVienService {
    ArrayList<NhanVien> getAllStaff();
    NhanVien getUserIdByUserName(String userName);
}
