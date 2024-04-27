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
 * @author DELL
 */
public class AdminChiTietDonHangDao implements IAdminChiTietDonHang{
    
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

    public boolean deleteChiTietDonHang(String maDonHang, String maSanPham) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            // Kết nối cơ sở dữ liệu
            connection = DBConnection.getConnection();
            String deleteQuery = "DELETE FROM CHITIETDONHANG WHERE MaDonHang = ? AND MaSanPham = ?";
            pstmt = connection.prepareStatement(deleteQuery);

            // Thiết lập các tham số cho câu lệnh xóa
            pstmt.setString(1, maDonHang);
            pstmt.setString(2, maSanPham);

            // Thực thi câu lệnh xóa
            int rowsAffected = pstmt.executeUpdate();

            // Kiểm tra xem có dòng nào bị ảnh hưởng hay không
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng tài nguyên
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return success;
    }
}
