/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.controllers;

import com.hcmute.storemanagement.models.NhanVien;
import com.hcmute.storemanagement.service.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thieu
 */
public class StaffController {
     public ArrayList<NhanVien> getAllStaff() {
        ArrayList<NhanVien> staffList = new ArrayList<NhanVien>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish database connection
            connection = DBConnection.getConnection();

            // Prepare SQL query
            String sql = "SELECT * FROM NhanVien";

            // Prepare statement
            preparedStatement = connection.prepareStatement(sql);

            // Execute query
            resultSet = preparedStatement.executeQuery();

            // Process result set
            while (resultSet.next()) {
                // Retrieve data from the result set and create NhanVien objects
                NhanVien nhanVien = new NhanVien(
                        resultSet.getString("MaNhanVien"),
                        resultSet.getString("TenNhanVien"),
                        resultSet.getDate("NgaySinh"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getString("CCCD"),
                        resultSet.getString("DiaChi"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("Email"),
                        resultSet.getString("TenDangNhap")
                );
                // Add the NhanVien object to the staff list
                staffList.add(nhanVien);
            }
        } catch (SQLException e) {
            // Handle exception
            System.err.println("Error: " + e.getMessage());
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
                System.err.println("Error: " + e.getMessage());
            }
        }

        return staffList;
    }
}
