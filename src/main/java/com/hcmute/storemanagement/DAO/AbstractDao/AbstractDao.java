/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.DAO.AbstractDao;

import com.hcmute.storemanagement.service.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T> {

    private Class<T> entityClass;
    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public AbstractDao(Class<T> cls) {
        this.entityClass = cls;
    }

    public void insert(T entity) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String tableName = getTableName(); // Lấy tên bảng từ phương thức getTableName()
        String sql = "INSERT INTO " + tableName + " (column1, column2, ...) VALUES (?, ?, ...)";
        PreparedStatement statement = connection.prepareStatement(sql);

        // Thiết lập các giá trị tham số trong câu truy vấn
        // Ví dụ: statement.setString(1, entity.getColumn1());
        //       statement.setString(2, entity.getColumn2());
        //       ...
        statement.executeUpdate();
    }

    public void update(T entity) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String tableName = getTableName(); // Lấy tên bảng từ phương thức getTableName()
        String sql = "UPDATE " + tableName + " SET column1 = ?, column2 = ?, ... WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        // Thiết lập các giá trị tham số trong câu truy vấn
        // Ví dụ: statement.setString(1, entity.getColumn1());
        //       statement.setString(2, entity.getColumn2());
        //       statement.setObject(3, entity.getId());
        statement.executeUpdate();
    }

    public void delete(Object id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String tableName = getTableName(); // Lấy tên bảng từ phương thức getTableName()
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, id);
        statement.executeUpdate();
    }

    public T findById(Object id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String tableName = getTableName(); // Lấy tên bảng từ phương thức getTableName()
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            // Lấy các giá trị từ resultSet và tạo đối tượng T tương ứng
            // Ví dụ: T entity = new T();
            //       entity.setColumn1(resultSet.getString("column1"));
            //       entity.setColumn2(resultSet.getString("column2"));
            //       ...
            //       return entity;
        }
        return null; // Trả về null nếu không tìm thấy
    }

    public List<T> findAll() throws SQLException {
        Connection connection = DBConnection.getConnection();
        List<T> entities = new ArrayList<>();
        String tableName = getTableName(); // Lấy tên bảng từ phương thức getTableName()
        String sql = "SELECT * FROM " + tableName;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            // Lấy các giá trị từ resultSet và tạo đối tượng T tương ứng
            // Ví dụ: T entity = new T();
            //       entity.setColumn1(resultSet.getString("column1"));
            //       entity.setColumn2(resultSet.getString("column2"));
            //       ...
            //       entities.add(entity);
        }
        return entities;
    }
}
