/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.models.DonHang;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public interface IStaffDonHangDao {

    String addBill(double total, String idStaff);

    String getLastInsertedBillId();

    DonHang findBillById(String billId);
}
