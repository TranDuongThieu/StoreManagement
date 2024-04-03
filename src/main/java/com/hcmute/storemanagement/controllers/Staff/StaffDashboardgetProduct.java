/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.controllers.Staff;

import com.hcmute.storemanagement.models.SanPham;
import com.hcmute.storemanagement.service.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDashboardgetProduct {


    public List<SanPham> getAllSanPham() {
        List<SanPham> sanPhams = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM SANPHAM";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(resultSet.getString("MaSanPham"));
                sanPham.setTenSanPham(resultSet.getString("TenSanPham"));
                sanPham.setMoTa(resultSet.getString("MoTa"));
                sanPham.setThoiHanBaoHanh(resultSet.getString("ThoiHanBaoHanh"));

                // Lấy dữ liệu VARBINARY từ cột HinhAnh
                byte[] imageData = resultSet.getBytes("HinhAnh");
                // Thiết lập dữ liệu VARBINARY vào thuộc tính HinhAnh của đối tượng SanPham
                sanPham.setHinhAnh(imageData);

                sanPham.setSoLuongDaBan(resultSet.getInt("SoLuongDaBan"));
                sanPham.setSoLuongTrongKho(resultSet.getInt("SoLuongTrongKho"));
                sanPham.setGia(resultSet.getInt("Gia"));
                sanPham.setMaDanhMuc(resultSet.getString("MaDanhMuc"));
                sanPhams.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            // Handle exceptions
        }

        return sanPhams;

    }

}
