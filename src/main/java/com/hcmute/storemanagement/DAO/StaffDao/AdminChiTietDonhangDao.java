/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.models.ChiTietDonHang;
import com.hcmute.storemanagement.service.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thieu
 */
public class AdminChiTietDonhangDao implements IAdminChiTietDonHang {

    public List<ChiTietDonHang> getChiTietDonHangById(String maDonHang) {
        List<ChiTietDonHang> chiTietDonHangList = new ArrayList<ChiTietDonHang>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM CHITIETDONHANG WHERE MaDonHang = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maDonHang);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Retrieve data from the result set and create a ChiTietDonHang object
                ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
                chiTietDonHang.setMaDonHang(resultSet.getString("MaDonHang"));
                chiTietDonHang.setMaSanPham(resultSet.getString("MaSanPham"));
                chiTietDonHang.setSoLuong(resultSet.getInt("SoLuong"));
                chiTietDonHangList.add(chiTietDonHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        } finally {
            // Close resources in the reverse order of their creation
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle exceptions
            }
        }

        return chiTietDonHangList;

    }
}
