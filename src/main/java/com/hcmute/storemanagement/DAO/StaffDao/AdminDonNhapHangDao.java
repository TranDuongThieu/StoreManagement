/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.models.DonNhapHang;
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
public class AdminDonNhapHangDao implements IAdminDonNhapHangDao {

    public DonNhapHang getById(String id) {
        DonNhapHang donNhapHang = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM DONNHAPHANG WHERE MaDonNhapHang = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Retrieve data from the result set and create a DonNhapHang object
                donNhapHang = new DonNhapHang();
                donNhapHang.setMaDonNhapHang(resultSet.getString("MaDonNhapHang"));
                donNhapHang.setNgayNhapHang(resultSet.getDate("NgayNhapHang"));
                donNhapHang.setTongGiaTri(resultSet.getInt("TongGiaTri"));
                donNhapHang.setMaNhaCungCap(resultSet.getString("MaNhaCungCap"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        } finally {
            // Close resources in the reverse order of their creation
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
                // Handle exceptions
            }
        }

        return donNhapHang;
    }

    public int getTotalAmountByMonthAndYear(int month, int year) {
        int totalAmount = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT SUM(TongGiaTri) AS TotalAmount FROM DONNHAPHANG WHERE YEAR(NgayNhapHang) = ? AND MONTH(NgayNhapHang) = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, year);
            preparedStatement.setInt(2, month);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                totalAmount = resultSet.getInt("TotalAmount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ
        } finally {
            // Đóng tài nguyên (Connection, PreparedStatement, ResultSet)
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
                // Xử lý ngoại lệ
            }
        }

        return totalAmount;
    }

    public List<DonNhapHang> getAllDonNhapHang() {
        List<DonNhapHang> donNhapHangList = new ArrayList<DonNhapHang>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM DONNHAPHANG";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Retrieve data from the result set and create a DonNhapHang object
                DonNhapHang donNhapHang = new DonNhapHang();
                donNhapHang.setMaDonNhapHang(resultSet.getString("MaDonNhapHang"));
                donNhapHang.setNgayNhapHang(resultSet.getDate("NgayNhapHang"));
                donNhapHang.setTongGiaTri(resultSet.getInt("TongGiaTri"));
                donNhapHang.setMaNhaCungCap(resultSet.getString("MaNhaCungCap"));
                donNhapHangList.add(donNhapHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        } finally {
            // Close resources in the reverse order of their creation
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
                // Handle exceptions
            }
        }

        return donNhapHangList;
    }

    public void insertDonNhapHang(DonNhapHang donNhapHang) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnection.getConnection();
            // Đặt 'MaDonNhapHang' thành null để cơ sở dữ liệu tự sinh
            String sql = "INSERT INTO DONNHAPHANG (NgayNhapHang, TongGiaTri, MaNhaCungCap) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Set values from the DonNhapHang object
            preparedStatement.setDate(1, new java.sql.Date(donNhapHang.getNgayNhapHang().getTime()));
            preparedStatement.setInt(2, donNhapHang.getTongGiaTri());
            preparedStatement.setString(3, donNhapHang.getMaNhaCungCap());

            // Execute the statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        } finally {
            // Close resources in the reverse order of their creation
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle exceptions
            }
        }
    }

    public String getMaDonNhapHangCuoiCung() {
        List<DonNhapHang> donNhapHangList = getAllDonNhapHang();

        // Kiểm tra nếu danh sách không rỗng
        if (!donNhapHangList.isEmpty()) {
            // Lấy phần tử cuối cùng trong danh sách
            DonNhapHang lastDonNhapHang = donNhapHangList.get(donNhapHangList.size() - 1);
            return lastDonNhapHang.getMaDonNhapHang();
        }

        return null; // Hoặc giá trị mặc định phù hợp
    }

    public int getTotalValueByMaDonNhapHang(String maDonNhapHang) {
        int totalValue = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT TongGiaTri FROM DONNHAPHANG WHERE MaDonNhapHang = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maDonNhapHang);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                totalValue = resultSet.getInt("TongGiaTri");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý các ngoại lệ
        } finally {
            // Đóng tài nguyên theo thứ tự ngược với việc tạo ra chúng
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
                // Xử lý các ngoại lệ
            }
        }

        return totalValue;
    }

    public boolean updateTotalValueById(String maDonNhapHang, int newTotalValue) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "UPDATE DONNHAPHANG SET TongGiaTri = ? WHERE MaDonNhapHang = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, newTotalValue);
            preparedStatement.setString(2, maDonNhapHang);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý các ngoại lệ
        } finally {
            // Đóng tài nguyên theo thứ tự ngược với việc tạo ra chúng
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Xử lý các ngoại lệ
            }
        }

        return false;
    }

    public void deleteDonNhapHang(String maDonNhapHang) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "DELETE FROM DONNHAPHANG WHERE MaDonNhapHang = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Set parameter for MaDonNhapHang
            preparedStatement.setString(1, maDonNhapHang);

            // Execute the statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        } finally {
            // Close resources in the reverse order of their creation
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle exceptions
            }
        }
    }
}
