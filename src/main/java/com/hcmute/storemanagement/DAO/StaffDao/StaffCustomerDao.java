/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.DAO.AbstractDao.AbstractDao;
import com.hcmute.storemanagement.models.DonHang;
import com.hcmute.storemanagement.models.KhachHang;
import com.hcmute.storemanagement.models.SanPham;
import com.hcmute.storemanagement.service.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffCustomerDao extends AbstractDao<KhachHang> implements IStaffCustomerDao{

    public StaffCustomerDao(){
        super(KhachHang.class);
    }


    public List<KhachHang> getAll() {
        List<KhachHang> khachHangList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM KHACHHANG";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                KhachHang khachHang = new KhachHang();
                // Populate KhachHang object from ResultSet
                khachHang.setMaKhachHang(resultSet.getString("MaKhachHang"));
                khachHang.setTenKhachHang(resultSet.getString("TenKhachHang"));
                khachHang.setSoDienThoai(resultSet.getString("SoDienThoai"));
                khachHang.setDiemThanhVien(resultSet.getInt("DiemThanhVien"));
                
                khachHangList.add(khachHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        } finally {
            // Close resources (Connection, PreparedStatement, ResultSet)
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle exception
            }
        }

        return khachHangList;
    }

  public List<DonHang> getBillFromCusId(String cusId) {
        List<DonHang> donHangList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM DONHANG WHERE MaKhachHang = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cusId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                DonHang donHang = new DonHang();
                // Populate DonHang object from ResultSet
                donHang.setMaDonHang(resultSet.getString("MaDonHang"));
                donHang.setNgayDatHang(resultSet.getDate("NgayDatHang"));
                donHang.setTongGiaTri(resultSet.getInt("TongGiaTri"));
                donHang.setMaKhachHang(resultSet.getString("MaKhachHang"));
                donHang.setMaNhanVien(resultSet.getString("MaNhanVien"));

                donHangList.add(donHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        } finally {
            // Close resources (Connection, PreparedStatement, ResultSet)
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle exception
            }
        }

        return donHangList;
    }
}
