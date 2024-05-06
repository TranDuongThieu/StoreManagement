/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.models.TaiKhoan;

/**
 *
 * @author DELL
 */
public interface IStaffTaiKhoanService {

    TaiKhoan getAccountByUsername(String userName);

    boolean createAccount(String password, String role);

    String getLatestAccountUsername();

    boolean deleteAccount(String userName);
}
