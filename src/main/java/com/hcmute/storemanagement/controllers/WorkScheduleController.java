package com.hcmute.storemanagement.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hcmute.storemanagement.models.GeneralSchedule;
import com.hcmute.storemanagement.service.DBConnection;

public class WorkScheduleController {

    public ArrayList<GeneralSchedule> getScheduleFromDateToDate(String monday, String sunday) {
        ArrayList<GeneralSchedule> schedules = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String query = "SELECT NV.TenNhanVien, LLV.NgayLamViec, LLV.MaCa "
                    + "FROM NHANVIEN NV "
                    + "JOIN LICHLAMVIEC LLV ON NV.MaNhanVien = LLV.MaNhanVien "
                    + "WHERE LLV.NgayLamViec BETWEEN ? AND ?";
            preparedStatement = connection.prepareStatement(query);
            
            // Convert Monday and Sunday strings to Date objects
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date mondayDate = sdf.parse(monday);
            Date sundayDate = sdf.parse(sunday);
            
            // Set the parameters in the prepared statement
            preparedStatement.setDate(1, new java.sql.Date(mondayDate.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(sundayDate.getTime()));
            
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String hoten = resultSet.getString("TenNhanVien");
                Date ngayLamViec = resultSet.getDate("NgayLamViec");
                int maCa = resultSet.getInt("maCa");
                GeneralSchedule schedule = new GeneralSchedule(hoten, ngayLamViec, maCa);
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();// Handle or log the exception as needed
        } catch (Exception e) {
            e.printStackTrace(); // Handle or log the exception as needed
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
                e.printStackTrace();// Handle or log the exception as needed
            }
        }
        return schedules;
    }
}
