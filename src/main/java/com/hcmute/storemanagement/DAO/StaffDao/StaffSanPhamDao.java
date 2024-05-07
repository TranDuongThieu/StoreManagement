/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.DAO.StaffDao;

import com.hcmute.storemanagement.DAO.AbstractDao.AbstractDao;
import com.hcmute.storemanagement.models.SanPham;
import com.hcmute.storemanagement.service.DBConnection;
import com.hcmute.storemanagement.views.dashboard.chart.ModelSanPhamBanChay;
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

    public void updateSoLuongTrongKho(String maSanPham, int soLuongMoi) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "UPDATE SANPHAM SET SoLuongTrongKho = ? WHERE MaSanPham = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Thiết lập tham số cho câu lệnh SQL
            preparedStatement.setInt(1, soLuongMoi);
            preparedStatement.setString(2, maSanPham);

            // Thực thi câu lệnh SQL
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Số lượng trong kho của sản phẩm có mã " + maSanPham + " đã được cập nhật thành " + soLuongMoi);
            } else {
                System.out.println("Không tìm thấy sản phẩm có mã " + maSanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và tài nguyên
            // Xử lý ngoại lệ nếu cần
        }
    }

    public void updateSoLuongDaBan(String maSanPham, int soLuongMoi) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "UPDATE SANPHAM SET SoLuongDaBan = ? WHERE MaSanPham = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Thiết lập tham số cho câu lệnh SQL
            preparedStatement.setInt(1, soLuongMoi);
            preparedStatement.setString(2, maSanPham);

            // Thực thi câu lệnh SQL
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Số lượng trong kho của sản phẩm có mã " + maSanPham + " đã được cập nhật thành " + soLuongMoi);
            } else {
                System.out.println("Không tìm thấy sản phẩm có mã " + maSanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và tài nguyên
            // Xử lý ngoại lệ nếu cần
        }
    }

    public boolean deleteSanPhamById(String maSanPham) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean success = false;

        try {
            connection = DBConnection.getConnection();
            String sql = "DELETE FROM SANPHAM WHERE MaSanPham = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maSanPham);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                success = true;
                System.out.println("Sản phẩm đã được xóa thành công!");
            } else {
                System.out.println("Không tìm thấy sản phẩm với ID: " + maSanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng các tài nguyên
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

    public void updateSanPham(SanPham sanPham) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Lấy kết nối đến cơ sở dữ liệu
            connection = DBConnection.getConnection();

            // Tạo truy vấn SQL UPDATE
            String sql = "UPDATE SANPHAM SET TenSanPham=?, MoTa=?, ThoiHanBaoHanh=?, HinhAnh=?, SoLuongDaBan=?, SoLuongTrongKho=?, Gia=? WHERE MaSanPham=?";

            // Tạo đối tượng PreparedStatement với truy vấn SQL đã tạo
            preparedStatement = connection.prepareStatement(sql);

            // Thiết lập các tham số cho truy vấn
            preparedStatement.setString(1, sanPham.getTenSanPham());
            preparedStatement.setString(2, sanPham.getMoTa());
            preparedStatement.setString(3, sanPham.getThoiHanBaoHanh());
            preparedStatement.setBytes(4, sanPham.getHinhAnh());
            preparedStatement.setInt(5, sanPham.getSoLuongDaBan());
            preparedStatement.setInt(6, sanPham.getSoLuongTrongKho());
            preparedStatement.setInt(7, sanPham.getGia());
            preparedStatement.setString(8, sanPham.getMaSanPham());

            // Thực thi truy vấn UPDATE
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Sản phẩm đã được cập nhật thành công!");
            } else {
                System.out.println("Không có sản phẩm nào được cập nhật.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng các tài nguyên
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

    public boolean insertProduct(SanPham sanPham) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "INSERT INTO SANPHAM (MaDanhMuc, TenSanPham, MoTa, ThoiHanBaoHanh, HinhAnh, SoLuongDaBan, SoLuongTrongKho, Gia) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sanPham.getMaDanhMuc());
            preparedStatement.setString(2, sanPham.getTenSanPham());
            preparedStatement.setString(3, sanPham.getMoTa());
            preparedStatement.setString(4, sanPham.getThoiHanBaoHanh());
            preparedStatement.setBytes(5, sanPham.getHinhAnh());
            preparedStatement.setInt(6, sanPham.getSoLuongDaBan());
            preparedStatement.setInt(7, sanPham.getSoLuongTrongKho());
            preparedStatement.setInt(8, sanPham.getGia());

            // Thực thi truy vấn
            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Product inserted successfully.");

            // Trả về true nếu có ít nhất một dòng được chèn thành công
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Trả về false nếu có lỗi xảy ra
            return false;
        } finally {
            // Đóng các tài nguyên
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

    public ModelSanPhamBanChay getTotalMaxOfProduct(int month, int year) {
        ModelSanPhamBanChay result = null;
        try {
            // Kết nối tới cơ sở dữ liệu SQL Server
            Connection conn = DBConnection.getConnection();
            // Chuẩn bị truy vấn SQL
            String query = "SELECT * FROM dbo.func_TimSanPhamBanChayTrongThang(?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, Integer.toString(month));
            statement.setString(2, Integer.toString(year));
            // Thực thi truy vấn
            ResultSet resultSet = statement.executeQuery();
            // Xử lý kết quả truy vấn
            if (resultSet.next()) {
                String maSanPham = resultSet.getString("MaSanPham");
                String tenSanPham = resultSet.getString("TenSanPham");
                int gia = resultSet.getInt("Gia");
                int tongLuotBan = resultSet.getInt("TongLuotBan");

                // Tạo đối tượng ModelSanPhamBanChay từ kết quả truy vấn
                result = new ModelSanPhamBanChay(maSanPham, tenSanPham, gia, tongLuotBan);
            }

            // Đóng kết nối và giải phóng tài nguyên
            conn.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
