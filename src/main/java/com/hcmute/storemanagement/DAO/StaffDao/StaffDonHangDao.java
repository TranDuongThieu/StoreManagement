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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffDonHangDao extends AbstractDao<DonHang> implements IStaffDonHangDao {

    public StaffDonHangDao() {
        super(DonHang.class);
    }

    public boolean deleteBill(String billId) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            // Lấy kết nối từ DBConnection (hàm getConnection)
            connection = DBConnection.getConnection();

            // Chuẩn bị câu lệnh SQL để xóa hóa đơn từ cơ sở dữ liệu
            String deleteQuery = "DELETE FROM DONHANG WHERE MaDonHang = ?";
            pstmt = connection.prepareStatement(deleteQuery);

            // Thiết lập tham số cho câu lệnh xóa
            pstmt.setString(1, billId);

            // Thực thi câu lệnh xóa
            int rowsAffected = pstmt.executeUpdate();

            // Kiểm tra số dòng bị ảnh hưởng để xác định xem xóa thành công hay không
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            // Đóng tài nguyên
            try {
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

    public void updateTotal(String billId, double newTotal) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = DBConnection.getConnection();

            String updateQuery = "UPDATE DONHANG SET TongGiaTri = ? WHERE MaDonHang = ?";
            pstmt = connection.prepareStatement(updateQuery);
            pstmt.setDouble(1, newTotal);
            pstmt.setString(2, billId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Tổng tiền đã được cập nhật thành công cho đơn hàng có mã: " + billId);
            } else {
                System.out.println("Không tìm thấy đơn hàng có mã: " + billId);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng tài nguyên
            try {
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
                donHang = new DonHang(maDonHang, maKhachHang, maNhanVien, ngayDatHang, tongGiaTri);
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

    public void updateCustomer(String billId, String newCustomerId) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = DBConnection.getConnection();
            String query = "UPDATE DONHANG SET MaKhachHang = ? WHERE MaDonHang = ?";
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, newCustomerId);
            pstmt.setString(2, billId);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Thông tin khách hàng đã được cập nhật thành công cho đơn hàng có mã: " + billId);
            } else {
                System.out.println("Không tìm thấy đơn hàng có mã: " + billId);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng tài nguyên
            try {
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
    }

    public List<DonHang> getBillFromCusId(String cusId) {
        List<DonHang> donHangList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM DONHANG WHERE MaKhachHang = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cusId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                DonHang donHang = new DonHang();
                // Populate DonHang object from ResultSet
                donHang.setMaDonHang(resultSet.getString("MaDonHang"));
                donHang.setNgayDatHang(resultSet.getDate("NgayDatHang"));
                donHang.setTongGiaTri(resultSet.getInt("TongGiaTri"));
                donHang.setMaKhachHang(resultSet.getString("MaKhachHang"));
                donHang.setMaNhanVien(resultSet.getString("MaNhanVien"));

                donHangList.add(donHang);
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

        return donHangList;
    }

    public List<DonHang> getBillFromStaff(String cusId) {
        List<DonHang> donHangList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM DONHANG WHERE MaNhanVien = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cusId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                DonHang donHang = new DonHang();
                // Populate DonHang object from ResultSet
                donHang.setMaDonHang(resultSet.getString("MaDonHang"));
                donHang.setNgayDatHang(resultSet.getDate("NgayDatHang"));
                donHang.setTongGiaTri(resultSet.getInt("TongGiaTri"));
                donHang.setMaKhachHang(resultSet.getString("MaKhachHang"));
                donHang.setMaNhanVien(resultSet.getString("MaNhanVien"));

                donHangList.add(donHang);
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

        return donHangList;
    }

    public List<DonHang> selectAllOrders() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<DonHang> orders = new ArrayList<>();

        try {
            // Get connection from DBConnection class (getConnection method)
            connection = DBConnection.getConnection();

            // Create SQL query to retrieve all orders
            String selectQuery = "SELECT * FROM DONHANG";
            pstmt = connection.prepareStatement(selectQuery);

            // Execute the query
            resultSet = pstmt.executeQuery();

            // Iterate through the results and create a list of orders
            while (resultSet.next()) {
                // Retrieve information for each order from the result set
                String orderId = resultSet.getString("MaDonHang");
                Date orderDate = resultSet.getDate("NgayDatHang");
                int totalPrice = resultSet.getInt("TongGiaTri");
                String customerId = resultSet.getString("MaKhachHang");
                String staffId = resultSet.getString("MaNhanVien");

                // Create an Order object from the retrieved information
                DonHang order = new DonHang(orderId, customerId, staffId, orderDate, totalPrice);

                // Add the order to the list
                orders.add(order);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close resources
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

        return orders;
    }

    public int getTotalRevenueByMonthAndYear(int month, int year) {
        int totalRevenue = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT SUM(TongGiaTri) AS TotalRevenue FROM DONHANG WHERE YEAR(NgayDatHang) = ? AND MONTH(NgayDatHang) = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, year);
            preparedStatement.setInt(2, month);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                totalRevenue = resultSet.getInt("TotalRevenue");
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

        return totalRevenue;
    }
}
