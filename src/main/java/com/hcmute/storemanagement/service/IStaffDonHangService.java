/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.models.DonHang;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IStaffDonHangService {

    String addBill(double total, String idStaff);

    String getLastInsertedBillId();

    DonHang findBillById(String billId);

    List<DonHang> getBillFromCusId(String cusId);

    List<DonHang> getBillFromStaff(String cusId);

    void updateCustomer(String billId, String newCustomerId);

    void updateTotal(String billId, double newTotal);

    boolean deleteBill(String billId);
}
