/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.models.NhaCungCap;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IAdminNhaCungCapDao {
    NhaCungCap getById(String id);
    List<NhaCungCap> getAllNhaCungCap();
}
