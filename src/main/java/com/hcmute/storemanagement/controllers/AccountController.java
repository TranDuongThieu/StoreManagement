/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.controllers;

import com.hcmute.storemanagement.service.DBConnection;
import com.hcmute.storemanagement.models.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author thieu
 */
public class AccountController {

    public TaiKhoan getAccountByUsername(String userName) {
        TaiKhoan taiKhoan = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish database connection
            connection = DBConnection.getConnection();

            // Prepare SQL query
            String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);

            // Execute query
            resultSet = preparedStatement.executeQuery();

            // Process result set
            if (resultSet.next()) {
                // Retrieve data from the result set and create TaiKhoan object
                taiKhoan = new TaiKhoan();
                taiKhoan.setTenDangNhap(resultSet.getString("TenDangNhap"));
                taiKhoan.setMatKhau(resultSet.getString("MatKhau"));
                taiKhoan.setQuyenNguoiDung(resultSet.getString("QuyenNguoiDung"));
                // Set other attributes as needed
            }
        } catch (SQLException e) {
            // Handle exception
            System.err.println("error " + e);

        } finally {
            // Close resources
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
                System.err.println("error " + e);
            }
        }

        return taiKhoan;
    }
}
