/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.DAO.AbstractDao.AbstractDao;
import com.hcmute.storemanagement.models.SanPham;
import com.hcmute.storemanagement.service.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffSanPhamDao extends AbstractDao<SanPham> implements IStaffSanPhamDao {

    public StaffSanPhamDao() {
        super(SanPham.class);
    }

    public List<SanPham> getAllSanPham() {
        List<SanPham> sanPhams = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM SANPHAM";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(resultSet.getString("MaSanPham"));
                sanPham.setTenSanPham(resultSet.getString("TenSanPham"));
                sanPham.setMoTa(resultSet.getString("MoTa"));
                sanPham.setThoiHanBaoHanh(resultSet.getString("ThoiHanBaoHanh"));

                // Lấy dữ liệu VARBINARY từ cột HinhAnh
                byte[] imageData = resultSet.getBytes("HinhAnh");
                // Thiết lập dữ liệu VARBINARY vào thuộc tính HinhAnh của đối tượng SanPham
                sanPham.setHinhAnh(imageData);

                sanPham.setSoLuongDaBan(resultSet.getInt("SoLuongDaBan"));
                sanPham.setSoLuongTrongKho(resultSet.getInt("SoLuongTrongKho"));
                sanPham.setGia(resultSet.getInt("Gia"));
                sanPham.setMaDanhMuc(resultSet.getString("MaDanhMuc"));
                sanPhams.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            // Handle exceptions
        }

        return sanPhams;

    }

    public List<SanPham> getAllPhone() {
        List<SanPham> sanPhams = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM SANPHAM WHERE MaDanhMuc = 'DMSP001'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(resultSet.getString("MaSanPham"));
                sanPham.setTenSanPham(resultSet.getString("TenSanPham"));
                sanPham.setMoTa(resultSet.getString("MoTa"));
                sanPham.setThoiHanBaoHanh(resultSet.getString("ThoiHanBaoHanh"));

                // Lấy dữ liệu VARBINARY từ cột HinhAnh
                byte[] imageData = resultSet.getBytes("HinhAnh");
                // Thiết lập dữ liệu VARBINARY vào thuộc tính HinhAnh của đối tượng SanPham
                sanPham.setHinhAnh(imageData);

                sanPham.setSoLuongDaBan(resultSet.getInt("SoLuongDaBan"));
                sanPham.setSoLuongTrongKho(resultSet.getInt("SoLuongTrongKho"));
                sanPham.setGia(resultSet.getInt("Gia"));
                sanPham.setMaDanhMuc(resultSet.getString("MaDanhMuc"));
                sanPhams.add(sanPham);
            }
        } catch (SQLException e) {
            // Handle or log the exception
            e.printStackTrace();
        } finally {
            // Close resources in reverse order of their creation
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return sanPhams;
    }

    public List<SanPham> getAllLapTop() {
        List<SanPham> sanPhams = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM SANPHAM WHERE MaDanhMuc = 'DMSP002'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(resultSet.getString("MaSanPham"));
                sanPham.setTenSanPham(resultSet.getString("TenSanPham"));
                sanPham.setMoTa(resultSet.getString("MoTa"));
                sanPham.setThoiHanBaoHanh(resultSet.getString("ThoiHanBaoHanh"));

                // Lấy dữ liệu VARBINARY từ cột HinhAnh
                byte[] imageData = resultSet.getBytes("HinhAnh");
                // Thiết lập dữ liệu VARBINARY vào thuộc tính HinhAnh của đối tượng SanPham
                sanPham.setHinhAnh(imageData);

                sanPham.setSoLuongDaBan(resultSet.getInt("SoLuongDaBan"));
                sanPham.setSoLuongTrongKho(resultSet.getInt("SoLuongTrongKho"));
                sanPham.setGia(resultSet.getInt("Gia"));
                sanPham.setMaDanhMuc(resultSet.getString("MaDanhMuc"));
                sanPhams.add(sanPham);
            }
        } catch (SQLException e) {
            // Handle or log the exception
            e.printStackTrace();
        } finally {
            // Close resources in reverse order of their creation
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return sanPhams;
    }

    public List<SanPham> getAllTablet() {
        List<SanPham> sanPhams = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM SANPHAM WHERE MaDanhMuc = 'DMSP003'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(resultSet.getString("MaSanPham"));
                sanPham.setTenSanPham(resultSet.getString("TenSanPham"));
                sanPham.setMoTa(resultSet.getString("MoTa"));
                sanPham.setThoiHanBaoHanh(resultSet.getString("ThoiHanBaoHanh"));

                // Lấy dữ liệu VARBINARY từ cột HinhAnh
                byte[] imageData = resultSet.getBytes("HinhAnh");
                // Thiết lập dữ liệu VARBINARY vào thuộc tính HinhAnh của đối tượng SanPham
                sanPham.setHinhAnh(imageData);

                sanPham.setSoLuongDaBan(resultSet.getInt("SoLuongDaBan"));
                sanPham.setSoLuongTrongKho(resultSet.getInt("SoLuongTrongKho"));
                sanPham.setGia(resultSet.getInt("Gia"));
                sanPham.setMaDanhMuc(resultSet.getString("MaDanhMuc"));
                sanPhams.add(sanPham);
            }
        } catch (SQLException e) {
            // Handle or log the exception
            e.printStackTrace();
        } finally {
            // Close resources in reverse order of their creation
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return sanPhams;
    }

    public List<SanPham> getAllAccessory() {
        List<SanPham> sanPhams = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM SANPHAM WHERE MaDanhMuc = 'DMSP004'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(resultSet.getString("MaSanPham"));
                sanPham.setTenSanPham(resultSet.getString("TenSanPham"));
                sanPham.setMoTa(resultSet.getString("MoTa"));
                sanPham.setThoiHanBaoHanh(resultSet.getString("ThoiHanBaoHanh"));

                // Lấy dữ liệu VARBINARY từ cột HinhAnh
                byte[] imageData = resultSet.getBytes("HinhAnh");
                // Thiết lập dữ liệu VARBINARY vào thuộc tính HinhAnh của đối tượng SanPham
                sanPham.setHinhAnh(imageData);

                sanPham.setSoLuongDaBan(resultSet.getInt("SoLuongDaBan"));
                sanPham.setSoLuongTrongKho(resultSet.getInt("SoLuongTrongKho"));
                sanPham.setGia(resultSet.getInt("Gia"));
                sanPham.setMaDanhMuc(resultSet.getString("MaDanhMuc"));
                sanPhams.add(sanPham);
            }
        } catch (SQLException e) {
            // Handle or log the exception
            e.printStackTrace();
        } finally {
            // Close resources in reverse order of their creation
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return sanPhams;
    }

    @Override
    public SanPham getSanPhamById(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SanPham sanPham = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM SANPHAM WHERE MaSanPham = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                sanPham = new SanPham();
                sanPham.setMaSanPham(resultSet.getString("MaSanPham"));
                sanPham.setTenSanPham(resultSet.getString("TenSanPham"));
                sanPham.setMoTa(resultSet.getString("MoTa"));
                sanPham.setThoiHanBaoHanh(resultSet.getString("ThoiHanBaoHanh"));

                // Lấy dữ liệu VARBINARY từ cột HinhAnh
                byte[] imageData = resultSet.getBytes("HinhAnh");
                // Thiết lập dữ liệu VARBINARY vào thuộc tính HinhAnh của đối tượng SanPham
                sanPham.setHinhAnh(imageData);

                sanPham.setSoLuongDaBan(resultSet.getInt("SoLuongDaBan"));
                sanPham.setSoLuongTrongKho(resultSet.getInt("SoLuongTrongKho"));
                sanPham.setGia(resultSet.getInt("Gia"));
                sanPham.setMaDanhMuc(resultSet.getString("MaDanhMuc"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            // Handle exceptions
        }
        System.out.println(sanPham.getTenSanPham());
        return sanPham;
    }

    public int getSoLuongTrongKhoByMaSanPham(String maSanPham) {
        int soLuongTrongKho = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT SoLuongTrongKho FROM SANPHAM WHERE MaSanPham=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maSanPham);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                soLuongTrongKho = resultSet.getInt("SoLuongTrongKho");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            // Handle exceptions
        }

        return soLuongTrongKho;
    }

}
