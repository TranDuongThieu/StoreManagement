/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.DAO.AbstractDao.AbstractDao;
import com.hcmute.storemanagement.models.LichLamViec;
import com.hcmute.storemanagement.service.DBConnection;
import com.microsoft.sqlserver.jdbc.StringUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class StaffLichLamViecDao extends AbstractDao<LichLamViec> {

    public StaffLichLamViecDao() {
        super(LichLamViec.class);
    }

    public List<LichLamViec> getWorkScheduleWithID(String UserID) {
        List<LichLamViec> lich1NhanVien = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM LICHLAMVIEC WHERE MaNhanVien = ?";
            preparedStatement = connection.prepareStatement(sql);
            // Thiết lập giá trị cho tham số MaSanPham
            preparedStatement.setString(1, UserID);
            // Thực thi câu truy vấn SQL
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LichLamViec lich = new LichLamViec();

                lich.setMaNhanVien(resultSet.getString("MaNhanVien"));
                lich.setNgayLamViec(resultSet.getDate("NgayLamViec"));
                lich.setMaCa(resultSet.getInt("MaCa"));
                lich1NhanVien.add(lich);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            // Handle exceptions
        }

        return lich1NhanVien;
    }

    public boolean insertLichLamViec(String UserID, Date Ngay, List<Integer> listShift) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    int insertedRecords = 0; // Biến đếm số bản ghi được thêm vào bảng LICHLAMVIEC
    try {
        connection = DBConnection.getConnection();
        String query = "INSERT INTO LICHLAMVIEC (MaNhanVien, NgayLamViec, MaCa) VALUES (?, ?, ?)";
        preparedStatement = connection.prepareStatement(query);

        for (Integer maCa : listShift) {
            preparedStatement.setString(1, UserID);
            preparedStatement.setDate(2, new java.sql.Date(Ngay.getTime()));
            preparedStatement.setInt(3, maCa);
            // Thực thi câu lệnh INSERT cho mỗi giá trị maCa trong danh sách
            int result = preparedStatement.executeUpdate();
            insertedRecords += result;
        }

        // Trả về true nếu có ít nhất một bản ghi được thêm mới
        return insertedRecords > 0;
    } catch (Exception e) {
        e.printStackTrace();
        // Xử lý ngoại lệ nếu có
    } finally {
        // Đóng kết nối và giải phóng tài nguyên
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
    
    // Trả về false nếu không có bản ghi nào được thêm mới
    return false;
}
}