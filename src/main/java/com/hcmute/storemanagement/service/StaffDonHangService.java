/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.DAO.StaffDao.StaffDonHangDao;
import com.hcmute.storemanagement.models.DonHang;
import java.util.List;

/**
 *
 * @author DELL
 */
public class StaffDonHangService implements IStaffDonHangService {

    StaffDonHangDao staffDonHangDao = new StaffDonHangDao();

    @Override
    public String addBill(double total, String idStaff) {
        return staffDonHangDao.addBill(total, idStaff);
    }

    @Override
    public String getLastInsertedBillId() {
        return staffDonHangDao.getLastInsertedBillId();
    }

    @Override
    public DonHang findBillById(String billId) {
        return staffDonHangDao.findBillById(billId);
    }

    @Override
    public List<DonHang> getBillFromCusId(String cusId) {
        return getBillFromCusId(cusId);
    }
}
