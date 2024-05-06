/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.form;

import com.hcmute.storemanagement.DAO.StaffDao.IStaffSanPhamDao;
import com.hcmute.storemanagement.DAO.StaffDao.StaffSanPhamDao;
import com.hcmute.storemanagement.models.SanPham;
import com.hcmute.storemanagement.views.dashboard.model.ModelProduct;
import com.hcmute.storemanagement.views.dashboard.popup.popupAddProduct;
import com.hcmute.storemanagement.views.dashboard.popup.popupUpdateProduct;
import com.hcmute.storemanagement.views.dashboard.swing.ProductTable.EventActionProduct;
import com.hcmute.storemanagement.views.dashboard.swing.ProductTable.ModelProfileProduct;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class ProductForm extends javax.swing.JPanel {

    IStaffSanPhamDao sanPhamDao = new StaffSanPhamDao();
    SanPham sanpham;

    public ProductForm() {
        initComponents();
        initData();
    }

    private void initData() {

        EventActionProduct eventAction = new EventActionProduct() {
            @Override
            public void delete(ModelProduct student, ActionEvent e) {
                 if (tbProduct.isEditing()) {
                    tbProduct.getCellEditor().stopCellEditing();
                }
                int row = tbProduct.getSelectedRow();
                // lấy id
                ModelProfileProduct profileprd = (ModelProfileProduct) tbProduct.getValueAt(row, 0);
                String id = profileprd.getId();
                sanPhamDao.deleteSanPhamById(id);
                JOptionPane.showMessageDialog(ProductForm.this, "Xóa thành công sản phẩm");
                initData();
            }

            @Override
            public void update(ModelProduct student, ActionEvent e) {
                if (tbProduct.isEditing()) {
                    tbProduct.getCellEditor().stopCellEditing();
                }
                // Lấy index của hàng được chọn
                int rowIndex = tbProduct.getSelectedRow();

                // Kiểm tra xem có hàng được chọn không
                if (rowIndex != -1) {
                    // Lấy thông tin của sản phẩm từ bảng
                    ModelProfileProduct profileprd = (ModelProfileProduct) tbProduct.getValueAt(rowIndex, 0);
                    String id = profileprd.getId();
                    String tenSanPham = (String) tbProduct.getValueAt(rowIndex, 1);
                    String Description = (String) tbProduct.getValueAt(rowIndex, 2);
                    String guarantee = (String) tbProduct.getValueAt(rowIndex, 3);
                    Integer sold = (Integer) tbProduct.getValueAt(rowIndex, 4); // Lấy giá trị Integer từ bảng
                    Integer warehouse = (Integer) tbProduct.getValueAt(rowIndex, 5); // Lấy giá trị Integer từ bảng
                    Integer cost = (Integer) tbProduct.getValueAt(rowIndex, 6); // Lấy giá trị Integer từ bảng

                    Icon icon = profileprd.getIcon(); // Lấy đối tượng Icon từ profileprd

                    int labelWidth = 119;
                    int labelHeight = 119;

// Lấy kích thước của hình ảnh
                    int iconWidth = icon.getIconWidth();
                    int iconHeight = icon.getIconHeight();

// Tính toán tỉ lệ phóng to hoặc thu nhỏ hình ảnh
                    double widthScale = (double) labelWidth / iconWidth;
                    double heightScale = (double) labelHeight / iconHeight;
                    double scale = Math.min(widthScale, heightScale);

// Tính toán kích thước mới của hình ảnh
                    int newWidth = (int) (iconWidth * scale);
                    int newHeight = (int) (iconHeight * scale);

// Tạo một BufferedImage mới với kích thước mới
                    BufferedImage bufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g2d = bufferedImage.createGraphics();

// Vẽ hình ảnh đã được điều chỉnh lên BufferedImage
                    g2d.drawImage(((ImageIcon) icon).getImage(), 0, 0, newWidth, newHeight, null);
                    g2d.dispose();

// Sử dụng ByteArrayOutputStream để ghi dữ liệu hình ảnh từ BufferedImage
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    try {
                        ImageIO.write(bufferedImage, "png", outputStream); // Ghi dữ liệu hình ảnh dưới dạng PNG vào ByteArrayOutputStream
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

// Trích xuất mảng byte từ ByteArrayOutputStream
                    byte[] imageData = outputStream.toByteArray();

                    // Khởi tạo đối tượng SanPham với thông tin từ bảng
                    SanPham sanPham = new SanPham();
                    sanPham.setHinhAnh(imageData);
                    sanPham.setMaSanPham(id);
                    sanPham.setTenSanPham(tenSanPham);
                    sanPham.setMoTa(Description);
                    sanPham.setThoiHanBaoHanh(guarantee);
                    sanPham.setSoLuongDaBan(sold);
                    sanPham.setSoLuongTrongKho(warehouse);
                    sanPham.setGia(cost);
                    // Đặt các thông tin khác của sản phẩm
                    // Mở cửa sổ popup để cập nhật sản phẩm
                    openPopupUpdate(sanPham);
                } else {
                    // Hiển thị thông báo nếu không có hàng nào được chọn
                    JOptionPane.showMessageDialog(ProductForm.this, "Please select a row.");
                }
            }

        };
        // Add dữ liệu vào bảng
        DefaultTableModel model = (DefaultTableModel) tbProduct.getModel();
        model.setRowCount(0);
        List<SanPham> productList = sanPhamDao.getAllSanPham();
        System.err.println("asdasd: " + productList);
        for (SanPham product : productList) {
            byte[] imageData = product.getHinhAnh(); // Lấy dữ liệu hình ảnh từ đối tượng sanPham
            ImageIcon imageIcon = new ImageIcon(imageData);
            model.addRow(new ModelProduct(imageIcon, product.getMaSanPham(), product.getTenSanPham(), product.getMoTa(), product.getThoiHanBaoHanh(), product.getSoLuongDaBan(), product.getSoLuongTrongKho(), product.getGia()).toRowTable(eventAction));
        }
    }

    private void openPopupUpdate(SanPham selectedSanPham) {
        JFrame popupFrame = new JFrame();
        popupFrame.setTitle(null); // Đặt tiêu đề là null
        popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đóng cửa sổ popup khi đóng

        // Tạo một WindowListener cho cửa sổ popup
        popupFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                initData();
            }
        });
        popupUpdateProduct billInfo = new popupUpdateProduct(selectedSanPham,popupFrame);
        popupFrame.add(billInfo);
        popupFrame.pack();
        popupFrame.setLocationRelativeTo(null); // Căn giữa cửa sổ
        popupFrame.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduct = new com.hcmute.storemanagement.views.dashboard.swing.ProductTable.ProductTable();
        jLabel1 = new javax.swing.JLabel();
        iconAddProduct = new javax.swing.JLabel();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        tbProduct.setBackground(new java.awt.Color(204, 204, 204));
        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Description", "Guarantee", "Sold", "Warehouse", "Cost", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbProduct);
        if (tbProduct.getColumnModel().getColumnCount() > 0) {
            tbProduct.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 119, 253));
        jLabel1.setText("Product");

        iconAddProduct.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\add.png")); // NOI18N
        iconAddProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickOPPopupAddPd(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(iconAddProduct)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iconAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clickOPPopupAddPd(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickOPPopupAddPd
        // TODO add your handling code here:
        openPopupAdd();
    }//GEN-LAST:event_clickOPPopupAddPd

    private void openPopupAdd( ) {
        JFrame popupFrame = new JFrame();
        popupFrame.setTitle(null); // Đặt tiêu đề là null
        popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đóng cửa sổ popup khi đóng
        // Tạo một WindowListener cho cửa sổ popup
        popupFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Gọi phương thức để cập nhật bảng sản phẩm trên trang sản phẩm sau khi cửa sổ popup đã đóng lại
                initData();
            }
        });
        popupAddProduct  addproduct = new popupAddProduct(popupFrame);
        popupFrame.add(addproduct);
        popupFrame.pack();
        popupFrame.setLocationRelativeTo(null); // Căn giữa cửa sổ
        popupFrame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconAddProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder1;
    private com.hcmute.storemanagement.views.dashboard.swing.ProductTable.ProductTable tbProduct;
    // End of variables declaration//GEN-END:variables
}
