/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.DAO.AbstractDao.AbstractDao;
import com.hcmute.storemanagement.models.ChiTietDonHang;
import com.hcmute.storemanagement.service.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class StaffChiTietDonHangDao extends AbstractDao<ChiTietDonHang> implements IStaffChiTietDonHangDao {

    public StaffChiTietDonHangDao() {
        super(ChiTietDonHang.class);
    }

    public boolean createChiTietDonHang(String maDonHang, String maSanPham, int soLuong) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            // Kết nối cơ sở dữ liệu
            connection = DBConnection.getConnection();
            String insertQuery = "INSERT INTO CHITIETDONHANG (MaDonHang, MaSanPham, SoLuong) VALUES (?, ?, ?)";
            pstmt = connection.prepareStatement(insertQuery);

            // Thiết lập các tham số cho câu lệnh chèn
            pstmt.setString(1, maDonHang);
            pstmt.setString(2, maSanPham);
            pstmt.setInt(3, soLuong);

            // Thực thi câu lệnh chèn
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

    public int checkChiTietDonHang(String maDonHang, String maSanPham) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int quantity = 0;

        try {
            // Kết nối cơ sở dữ liệu
            connection = DBConnection.getConnection();
            String selectQuery = "SELECT SoLuong FROM CHITIETDONHANG WHERE MaDonHang = ? AND MaSanPham = ?";
            pstmt = connection.prepareStatement(selectQuery);

            // Thiết lập các tham số cho câu lệnh truy vấn
            pstmt.setString(1, maDonHang);
            pstmt.setString(2, maSanPham);

            // Thực thi câu lệnh truy vấn
            rs = pstmt.executeQuery();

            // Kiểm tra xem có kết quả trả về hay không
            if (rs.next()) {
                quantity = rs.getInt("SoLuong");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng tài nguyên
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
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

        return quantity;
    }

    public boolean updateSoLuong(String maDonHang, String maSanPham, int soLuongMoi) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            // Kết nối cơ sở dữ liệu
            connection = DBConnection.getConnection();
            String updateQuery = "UPDATE CHITIETDONHANG SET SoLuong = ? WHERE MaDonHang = ? AND MaSanPham = ?";
            pstmt = connection.prepareStatement(updateQuery);

            // Thiết lập các tham số cho câu lệnh truy vấn
            pstmt.setInt(1, soLuongMoi);
            pstmt.setString(2, maDonHang);
            pstmt.setString(3, maSanPham);

            // Thực thi câu lệnh truy vấn
            int rowsAffected = pstmt.executeUpdate();

            // Kiểm tra xem có dòng bị ảnh hưởng hay không
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
    
    // tổng tiền 

}
