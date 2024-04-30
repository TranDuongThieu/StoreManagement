/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.models.NhaCungCap;
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
public class AdminNhaCungCapDao implements IAdminNhaCungCapDao {

    public List<NhaCungCap> getAllNhaCungCap() {
        List<NhaCungCap> nhaCungCaps = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM NHACUNGCAP";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                NhaCungCap nhaCungCap = new NhaCungCap();
                nhaCungCap.setMaNhaCungCap(resultSet.getString("MaNhaCungCap"));
                nhaCungCap.setTenNhaCungCap(resultSet.getString("TenNhaCungCap"));
                nhaCungCap.setDiaChi(resultSet.getString("DiaChi"));
                nhaCungCap.setSoDienThoai(resultSet.getString("SoDienThoai"));

                nhaCungCaps.add(nhaCungCap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối, PreparedStatement và ResultSet
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
            }
        }

        return nhaCungCaps;
    }
}
