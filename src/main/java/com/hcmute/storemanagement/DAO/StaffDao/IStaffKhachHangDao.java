/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.models.DonHang;
import com.hcmute.storemanagement.models.KhachHang;
import com.hcmute.storemanagement.models.SanPham;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IStaffKhachHangDao {

    List<KhachHang> getAll();

    KhachHang getKhachHangByID(String maKhachHang);

    KhachHang getKhachHangByPhoneNumber(String soDienThoai);

    boolean addKhachHang(String tenKhachHang, String soDienThoai, int diemThanhVien);

}