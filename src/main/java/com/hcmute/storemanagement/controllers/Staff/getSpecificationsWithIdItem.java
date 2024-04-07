/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.controllers.Staff;

import com.hcmute.storemanagement.models.ThongSoSanPham;
import com.hcmute.storemanagement.models.ThongTinSanPham;
import com.hcmute.storemanagement.service.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class getSpecificationsWithIdItem {

    public List<ThongTinSanPham> getAllThongSo(String IdSp) {
        List<ThongTinSanPham> ttsanPhams = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM V_THONGTINSANPHAM WHERE MaSanPham = ?";
            preparedStatement = connection.prepareStatement(sql);
            // Thiết lập giá trị cho tham số MaSanPham
            preparedStatement.setString(1, IdSp);
            // Thực thi câu truy vấn SQL
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ThongTinSanPham ttsanPham = new ThongTinSanPham();
//                sanPham.setMaSanPham(resultSet.getString("MaSanPham"));
//                sanPham.setTenSanPham(resultSet.getString("TenSanPham"));
//                sanPham.setMoTa(resultSet.getString("MoTa"));
//                sanPham.setThoiHanBaoHanh(resultSet.getString("ThoiHanBaoHanh"));
//
//                // Lấy dữ liệu VARBINARY từ cột HinhAnh
//                byte[] imageData = resultSet.getBytes("HinhAnh");
//                // Thiết lập dữ liệu VARBINARY vào thuộc tính HinhAnh của đối tượng SanPham
//                sanPham.setHinhAnh(imageData);
//
//                sanPham.setSoLuongDaBan(resultSet.getInt("SoLuongDaBan"));
//                sanPham.setSoLuongTrongKho(resultSet.getInt("SoLuongTrongKho"));
//                sanPham.setGia(resultSet.getInt("Gia"));
//                sanPham.setMaDanhMuc(resultSet.getString("MaDanhMuc"));
                ttsanPham.setTenLoaiThongSo(resultSet.getString("TenLoaiThongSo"));
                ttsanPham.setGiaTriThongSo(resultSet.getString("GiaTriThongSo"));
                ttsanPhams.add(ttsanPham);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            // Handle exceptions
        }

        return ttsanPhams;

    }
}
