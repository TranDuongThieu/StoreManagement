/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.DAO.AbstractDao.AbstractDao;
import com.hcmute.storemanagement.models.DonHang;
import com.hcmute.storemanagement.service.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class StaffDonHangDao extends AbstractDao<DonHang> implements IStaffDonHangDao {

    public StaffDonHangDao() {
        super(DonHang.class);
    }

    public String addBill(double total, String idStaff) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet generatedKeys = null;
        String generatedId = null;

        try {
            // Lấy kết nối từ DBConnection (hàm getConnection)
            connection = DBConnection.getConnection();

            // Tạo định dạng ngày tháng cho ngày đặt hàng
            Date currentDate = new Date();
            java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());

            // Chuẩn bị câu lệnh SQL để chèn hóa đơn vào cơ sở dữ liệu và lấy mã hóa đơn được tạo
            String insertQuery = "INSERT INTO DONHANG (NgayDatHang, TongGiaTri, MaNhanVien) VALUES (?, ?, ?)";
            pstmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

            // Thiết lập các tham số cho câu lệnh chèn
            pstmt.setDate(1, sqlDate);
            pstmt.setDouble(2, total);
            pstmt.setString(3, idStaff);

            // Thực thi câu lệnh chèn
            pstmt.executeUpdate();

            // Lấy mã hóa đơn được tạo
            generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getString(1); // Đọc mã hóa đơn dưới dạng String
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng tài nguyên
            try {
                if (generatedKeys != null) {
                    generatedKeys.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return generatedId;
    }

    public String getLastInsertedBillId() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        String lastInsertedBillId = null;

        try {
            connection = DBConnection.getConnection();
            String query = "SELECT TOP 1 MaDonHang FROM DONHANG ORDER BY MaDonHang DESC";
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                lastInsertedBillId = resultSet.getString("MaDonHang");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng tài nguyên
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lastInsertedBillId;
    }

    public DonHang findBillById(String billId) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        DonHang donHang = null;

        try {
            connection = DBConnection.getConnection();
            String query = "SELECT * FROM DONHANG WHERE MaDonHang = ?";
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, billId);
            resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                // Lấy thông tin liên quan đến đơn hàng từ kết quả truy vấn
                String maDonHang = resultSet.getString("MaDonHang");
                Date ngayDatHang = resultSet.getDate("NgayDatHang");
                int tongGiaTri = resultSet.getInt("TongGiaTri");
                String maKhachHang = resultSet.getString("MaKhachHang");
                String maNhanVien = resultSet.getString("MaNhanVien");

                // Khởi tạo đối tượng DonHang với thông tin tìm được
                donHang = new DonHang(maDonHang, ngayDatHang, tongGiaTri, maKhachHang, maNhanVien);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng tài nguyên
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return donHang;
    }
}
