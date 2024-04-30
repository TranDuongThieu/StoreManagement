/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.DAO.StaffDao.AdminNhaCungCapDao;
import com.hcmute.storemanagement.DAO.StaffDao.IAdminNhaCungCapDao;
import com.hcmute.storemanagement.models.NhaCungCap;
import java.util.List;

/**
 *
 * @author DELL
 */
public class AdminNhaCungCapService implements IAdminNhaCungCapService {

    IAdminNhaCungCapDao adnccDao = new AdminNhaCungCapDao();

    @Override
    public List<NhaCungCap> getAllNhaCungCap() {
        return adnccDao.getAllNhaCungCap();
    }

}
