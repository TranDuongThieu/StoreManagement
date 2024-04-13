/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.DAO.AbstractDao.AbstractDao;
import com.hcmute.storemanagement.models.NgayLamViec;
import com.hcmute.storemanagement.models.NhanVien;
import com.hcmute.storemanagement.service.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class StaffNgayLamViecDao extends AbstractDao<NgayLamViec> implements IStaffNgayLamViecDao {

    public StaffNgayLamViecDao() {
        super(NgayLamViec.class);
    }

//    public boolean insertNgayLamViec(Date Ngay) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        try {
//            connection = DBConnection.getConnection();
//            String query = "INSERT INTO NGAYLAMVIEC (NgayLamViec) VALUES (?)";
//            preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setDate(1, new java.sql.Date(Ngay.getTime()));
//            preparedStatement.executeUpdate();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }

    public void checkAndInsertNgayLamViec(Date Ngay) {
        Connection connection = null;
        PreparedStatement selectStatement = null;
        PreparedStatement insertStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            String selectQuery = "SELECT * FROM NGAYLAMVIEC WHERE NgayLamViec = ?";
            selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setDate(1, new java.sql.Date(Ngay.getTime()));
            resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
            } else {
                // Ngày chưa tồn tại trong bảng, thêm mới
                String insertQuery = "INSERT INTO NGAYLAMVIEC (NgayLamViec) VALUES (?)";
                insertStatement = connection.prepareStatement(insertQuery);
                insertStatement.setDate(1, new java.sql.Date(Ngay.getTime()));
                insertStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (selectStatement != null) {
                    selectStatement.close();
                }
                if (insertStatement != null) {
                    insertStatement.close();
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
