/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.models.ChiTietDonNhapHang;
import com.hcmute.storemanagement.service.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminChiTietDonNhapHangDao implements IAdminChiTietDonNhapHangDao {

    public List<ChiTietDonNhapHang> getGRNDetailgByGRNId(String maDonNhapHang) {
        List<ChiTietDonNhapHang> chiTietDonNhapHangList = new ArrayList<ChiTietDonNhapHang>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM CHITIETDONNHAPHANG WHERE MaDonNhapHang = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maDonNhapHang);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Retrieve data from the result set and create a ChiTietDonNhapHang object
                ChiTietDonNhapHang chiTietDonNhapHang = new ChiTietDonNhapHang();
                chiTietDonNhapHang.setMaDonNhapHang(resultSet.getString("MaDonNhapHang"));
                chiTietDonNhapHang.setMaSanPham(resultSet.getString("MaSanPham"));
                chiTietDonNhapHang.setSoLuong(resultSet.getInt("SoLuong"));
                chiTietDonNhapHangList.add(chiTietDonNhapHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

        return chiTietDonNhapHangList;
    }

    public boolean insertChiTietDonNhapHang(String maDonNhapHang, String maSanPham, int soLuong) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean success = false;

        try {
            connection = DBConnection.getConnection();
            String sql = "INSERT INTO CHITIETDONNHAPHANG (MaDonNhapHang, MaSanPham, SoLuong) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Set values
            preparedStatement.setString(1, maDonNhapHang);
            preparedStatement.setString(2, maSanPham);
            preparedStatement.setInt(3, soLuong);

            // Execute the statement
            int rowsAffected = preparedStatement.executeUpdate();
            // If rowsAffected is greater than 0, it means the insert was successful
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        } finally {
            // Close resources in the reverse order of their creation
            try {
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
        return success;
    }

    public boolean updateSoluong(String maDonNhapHang, String maSanPham, int soLuongMoi) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "UPDATE CHITIETDONNHAPHANG SET SoLuong = ? WHERE MaDonNhapHang = ? AND MaSanPham = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, soLuongMoi);
            preparedStatement.setString(2, maDonNhapHang);
            preparedStatement.setString(3, maSanPham);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        } finally {
            // Close resources in the reverse order of their creation
            try {
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

        return false;
    }

    public boolean deleteGRNDetail(String maDonNhapHang, String maSanPham) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "DELETE FROM CHITIETDONNHAPHANG WHERE MaDonNhapHang = ? AND MaSanPham = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maDonNhapHang);
            preparedStatement.setString(2, maSanPham);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý các ngoại lệ
        } finally {
            // Đóng tài nguyên theo thứ tự ngược với việc tạo ra chúng
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Xử lý các ngoại lệ
            }
        }

        return false;
    }

}
