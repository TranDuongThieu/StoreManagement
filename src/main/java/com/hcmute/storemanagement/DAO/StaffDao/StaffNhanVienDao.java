/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.DAO.AbstractDao.AbstractDao;
import com.hcmute.storemanagement.models.NhanVien;
import com.hcmute.storemanagement.service.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class StaffNhanVienDao extends AbstractDao<NhanVien> implements IStaffNhanVienDao {

    public StaffNhanVienDao() {
        super(NhanVien.class);
    }

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

    public NhanVien getUserIdByUserName(String userName) {
        NhanVien nhanVien = new NhanVien();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM NHANVIEN WHERE TenDangNhap = ?";
            preparedStatement = connection.prepareStatement(sql);
            // Thiết lập giá trị cho tham số userName
            preparedStatement.setString(1, userName);
            // Thực thi câu truy vấn SQL
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                nhanVien.setMaNhanVien(resultSet.getString("MaNhanVien"));
                nhanVien.setTenNhanVien(resultSet.getString("TenNhanVien"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            // Handle exceptions
        }
        return nhanVien;
    }

    public NhanVien getStaffById(String userID) {
        NhanVien nhanVien = new NhanVien();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM NHANVIEN WHERE MaNhanVien = ?";
            preparedStatement = connection.prepareStatement(sql);
            // Thiết lập giá trị cho tham số userID
            preparedStatement.setString(1, userID);
            // Thực thi câu truy vấn SQL
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                nhanVien.setMaNhanVien(resultSet.getString("MaNhanVien"));
                nhanVien.setTenNhanVien(resultSet.getString("TenNhanVien"));
                nhanVien.setNgaySinh(resultSet.getDate("NgaySinh"));
                nhanVien.setGioiTinh(resultSet.getString("GioiTinh"));
                nhanVien.setCCCD(resultSet.getString("CCCD"));
                nhanVien.setDiaChi(resultSet.getString("DiaChi"));
                nhanVien.setSoDienThoai(resultSet.getString("SoDienThoai"));
                nhanVien.setEmail(resultSet.getString("Email"));
                nhanVien.setTenDangNhap(resultSet.getString("TenDangNhap"));
            } else {
                // Nếu không tìm thấy nhân viên với userID tương ứng
                // xử lý tại đây, ví dụ: nhanVien = null hoặc throw exception
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng các tài nguyên kết nối và câu truy vấn
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
        return nhanVien;
    }

   public void updateStaff(String id, String ten, String diaChi, String email, String phone, String cccd, Date ngaySinh) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
        connection = DBConnection.getConnection();
        String sql = "UPDATE NHANVIEN SET TenNhanVien = ?, DiaChi = ?, Email = ?, SoDienThoai = ?, CCCD = ?, NgaySinh = ? WHERE MaNhanVien = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, ten);
        preparedStatement.setString(2, diaChi);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, phone);
        preparedStatement.setString(5, cccd);
        preparedStatement.setTimestamp(6, new Timestamp(ngaySinh.getTime()));
        preparedStatement.setString(7, id);
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Đóng các tài nguyên kết nối và câu truy vấn
        try {
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
}

}
