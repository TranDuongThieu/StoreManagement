/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.DAO.StaffDao.IStaffTaiKhoanDao;
import com.hcmute.storemanagement.DAO.AbstractDao.AbstractDao;
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
public class StaffTaiKhoanDao extends AbstractDao<TaiKhoan> implements IStaffTaiKhoanDao {

    public StaffTaiKhoanDao() {
        super(TaiKhoan.class);
    }

    @Override
    public String getTableName() {
        return "TAIKHOAN";
    }

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

    // Phương thức thêm tài khoản mới
    public boolean createAccount(String password, String role) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean success = false;

        try {
            // Thiết lập kết nối với cơ sở dữ liệu
            connection = DBConnection.getConnection();

            // Chuẩn bị truy vấn SQL
            String sql = "INSERT INTO TaiKhoan (MatKhau, QuyenNguoiDung) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, role);

            // Thực thi truy vấn
            int rowsAffected = preparedStatement.executeUpdate();

            // Kiểm tra xem có tài khoản nào được thêm thành công hay không
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            System.err.println("Lỗi: " + e.getMessage());
        } finally {
            // Đóng tất cả tài nguyên
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }

        return success;
    }

    // Phương thức lấy tên tài khoản mới nhất
    public String getLatestAccountUsername() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String latestUsername = null;

        try {
            // Thiết lập kết nối với cơ sở dữ liệu
            connection = DBConnection.getConnection();

            // Chuẩn bị truy vấn SQL để lấy tên tài khoản mới nhất
            String sql = "SELECT TOP 1 TenDangNhap FROM TaiKhoan ORDER BY TenDangNhap DESC";
            preparedStatement = connection.prepareStatement(sql);

            // Thực thi truy vấn
            resultSet = preparedStatement.executeQuery();

            // Kiểm tra xem kết quả có dòng nào hay không
            if (resultSet.next()) {
                // Lấy tên tài khoản mới nhất từ kết quả
                latestUsername = resultSet.getString("TenDangNhap");
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            System.err.println("Lỗi: " + e.getMessage());
        } finally {
            // Đóng tất cả tài nguyên
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
                System.err.println("Lỗi: " + e.getMessage());
            }
        }

        return latestUsername;
    }

    public boolean deleteAccount(String userName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // Lấy kết nối từ DBConnection (hàm getConnection)
            connection = DBConnection.getConnection();

            // Chuẩn bị câu lệnh SQL để xóa tài khoản từ cơ sở dữ liệu
            String deleteQuery = "DELETE FROM TaiKhoan WHERE TenDangNhap = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);

            // Thiết lập tham số cho câu lệnh xóa
            preparedStatement.setString(1, userName);

            // Thực thi câu lệnh xóa
            int rowsAffected = preparedStatement.executeUpdate();

            // Kiểm tra số dòng bị ảnh hưởng để xác định xem xóa thành công hay không
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            // Đóng tài nguyên
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
