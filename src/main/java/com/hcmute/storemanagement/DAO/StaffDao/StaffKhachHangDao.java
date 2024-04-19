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

public class StaffKhachHangDao extends AbstractDao<KhachHang> implements IStaffKhachHangDao {

    public StaffKhachHangDao() {
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
                // Handle exception
            }
        }

        return khachHangList;
    }

    public KhachHang getKhachHangByID(String maKhachHang) {
        KhachHang khachHang = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM KHACHHANG WHERE MaKhachHang = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maKhachHang);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                khachHang = new KhachHang();
                // Populate KhachHang object from ResultSet
                khachHang.setMaKhachHang(resultSet.getString("MaKhachHang"));
                khachHang.setTenKhachHang(resultSet.getString("TenKhachHang"));
                khachHang.setSoDienThoai(resultSet.getString("SoDienThoai"));
                khachHang.setDiemThanhVien(resultSet.getInt("DiemThanhVien"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        } finally {
            // Close resources (Connection, PreparedStatement, ResultSet)
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
                // Handle exception
            }
        }

        return khachHang;
    }

    public KhachHang getKhachHangByPhoneNumber(String soDienThoai) {
        KhachHang khachHang = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM KHACHHANG WHERE SoDienThoai = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, soDienThoai);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                khachHang = new KhachHang();
                // Populate KhachHang object from ResultSet
                khachHang.setMaKhachHang(resultSet.getString("MaKhachHang"));
                khachHang.setTenKhachHang(resultSet.getString("TenKhachHang"));
                khachHang.setSoDienThoai(resultSet.getString("SoDienThoai"));
                khachHang.setDiemThanhVien(resultSet.getInt("DiemThanhVien"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        } finally {
            // Close resources (Connection, PreparedStatement, ResultSet)
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
                // Handle exception
            }
        }

        return khachHang;
    }

    public boolean addKhachHang(String tenKhachHang, String soDienThoai, int diemThanhVien) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean success = false;

        try {
            connection = DBConnection.getConnection();
            String sql = "INSERT INTO KHACHHANG (TenKhachHang, SoDienThoai, DiemThanhVien) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tenKhachHang);
            preparedStatement.setString(2, soDienThoai);
            preparedStatement.setInt(3, diemThanhVien);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        } finally {
            // Close resources (Connection, PreparedStatement)
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle exception
            }
        }

        return success;
    }

}