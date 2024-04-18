/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.DAO.AbstractDao.AbstractDao;
import com.hcmute.storemanagement.models.LichLamViec;
import com.hcmute.storemanagement.service.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffLichLamViecDao extends AbstractDao<LichLamViec> implements IStaffLichLamViecDao{

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

    public int insertLichLamViec(String UserID, Date Ngay, List<Integer> listShift) {
        int soLuongCaThem = 0;
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
                soLuongCaThem++;
            }
            return soLuongCaThem;
        } catch (Exception e) {
            e.printStackTrace();
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
                e.printStackTrace();
            }
        }

        // Trả về false nếu không có bản ghi nào được thêm mới
        return soLuongCaThem;
    }

    public void delete1rowLichLamViec(String UserID, Date Ngay, int MaCa) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            String query = "DELETE FROM LICHLAMVIEC WHERE MaNhanVien = ? AND NgayLamViec = ? AND MaCa = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, UserID);
            preparedStatement.setDate(2, new java.sql.Date(Ngay.getTime()));
            preparedStatement.setInt(3, MaCa);
            // Thực thi và trả về số lượng hàng bị ảnh hưởng 
            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Xóa thành công!");
            } else {
                System.out.println("Không tìm thấy bản ghi để xóa!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    public boolean update1rowLichLamViec(String UserID, Date Ngay, int MaCa) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean success = false;

        try {
            connection = DBConnection.getConnection();
            String query = "UPDATE LICHLAMVIEC SET MaCa = ? WHERE MaNhanVien = ? AND NgayLamViec = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, MaCa);
            preparedStatement.setString(2, UserID);
            preparedStatement.setDate(3, new java.sql.Date(Ngay.getTime()));
            // Execute the update query
            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Cập nhật thành công!");
                success = true;
            } else {
                System.out.println("Không tìm thấy bản ghi để cập nhật!");
                success = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

        return success;
    }

    public int demSoCaTheoNgay(String UserID, Date Ngay, int MaCa) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            String query = "DELETE FROM LICHLAMVIEC WHERE MaNhanVien = ? AND NgayLamViec = ? AND MaCa = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, UserID);
            preparedStatement.setDate(2, new java.sql.Date(Ngay.getTime()));
            preparedStatement.setInt(3, MaCa);
            // Thực thi và trả về số lượng hàng bị ảnh hưởng 
            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Xóa thành công!");
            } else {
                System.out.println("Không tìm thấy bản ghi để xóa!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return 5;
    }

    public List<Integer> demSoCaTheoNgay(Date Ngay) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> countList = new ArrayList<>();
        try {
            connection = DBConnection.getConnection();
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT MaCa, COUNT(*) AS Total FROM LICHLAMVIEC WHERE NgayLamViec = ? AND MaCa IN (1, 2, 3) GROUP BY MaCa");

            preparedStatement = connection.prepareStatement(queryBuilder.toString());
            preparedStatement.setDate(1, new java.sql.Date(Ngay.getTime()));
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int maCa = resultSet.getInt("MaCa");
                int count = resultSet.getInt("Total");
                countList.add(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                e.printStackTrace();
            }
        }
        return countList;
    }
}
