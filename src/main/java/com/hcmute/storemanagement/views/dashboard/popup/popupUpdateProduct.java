/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.popup;

import com.hcmute.storemanagement.DAO.StaffDao.IStaffSanPhamDao;
import com.hcmute.storemanagement.DAO.StaffDao.StaffSanPhamDao;
import com.hcmute.storemanagement.models.SanPham;
import static com.microsoft.sqlserver.jdbc.StringUtils.isNumeric;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class popupUpdateProduct extends javax.swing.JPanel {

    private SanPham sanPham;
    IStaffSanPhamDao sanPhamDao = new StaffSanPhamDao();

    public popupUpdateProduct(SanPham sanPham) {
        initComponents();
        this.sanPham = sanPham;
        showData();
    }

    private void showData() {
        ImageIcon icon = new ImageIcon(sanPham.getHinhAnh()); // Đường dẫn của hình ảnh
        lbIconImage.setIcon(icon);
        txtCost.setText(String.valueOf(sanPham.getGia()));
        txtDes.setText(sanPham.getMoTa());
        txtGuarantee.setText(sanPham.getThoiHanBaoHanh());
        txtName.setText(sanPham.getTenSanPham());
        txtSold.setText(String.valueOf(sanPham.getSoLuongDaBan()));
        txtWarehouse.setText(String.valueOf(sanPham.getSoLuongTrongKho()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        panelBorder1 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        panelBorder2 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        txtName = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        jLabel2 = new javax.swing.JLabel();
        panelBorder3 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        txtDes = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        jLabel3 = new javax.swing.JLabel();
        panelBorder4 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jLabel4 = new javax.swing.JLabel();
        txtGuarantee = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        panelBorder5 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jLabel5 = new javax.swing.JLabel();
        txtSold = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        panelBorder6 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        txtWarehouse = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        jLabel6 = new javax.swing.JLabel();
        panelBorder7 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jLabel7 = new javax.swing.JLabel();
        txtCost = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        btnUpdate = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();
        lbIconImage = new javax.swing.JLabel();
        btnChangeImage = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 119, 253));
        jLabel8.setText("Update Product");

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setForeground(new java.awt.Color(51, 51, 51));
        panelBorder1.setAutoscrolls(true);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setForeground(new java.awt.Color(51, 51, 51));

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Name");

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder3.setForeground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Description");

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        panelBorder4.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder4.setForeground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Guarantee");

        javax.swing.GroupLayout panelBorder4Layout = new javax.swing.GroupLayout(panelBorder4);
        panelBorder4.setLayout(panelBorder4Layout);
        panelBorder4Layout.setHorizontalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder4Layout.createSequentialGroup()
                        .addComponent(txtGuarantee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelBorder4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelBorder4Layout.setVerticalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder4Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtGuarantee, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelBorder5.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder5.setForeground(new java.awt.Color(51, 51, 51));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Sold");

        javax.swing.GroupLayout panelBorder5Layout = new javax.swing.GroupLayout(panelBorder5);
        panelBorder5.setLayout(panelBorder5Layout);
        panelBorder5Layout.setHorizontalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder5Layout.createSequentialGroup()
                        .addComponent(txtSold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelBorder5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelBorder5Layout.setVerticalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtSold, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelBorder6.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder6.setForeground(new java.awt.Color(51, 51, 51));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Warehouse");

        javax.swing.GroupLayout panelBorder6Layout = new javax.swing.GroupLayout(panelBorder6);
        panelBorder6.setLayout(panelBorder6Layout);
        panelBorder6Layout.setHorizontalGroup(
            panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder6Layout.createSequentialGroup()
                        .addComponent(txtWarehouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelBorder6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelBorder6Layout.setVerticalGroup(
            panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder6Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        panelBorder7.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder7.setForeground(new java.awt.Color(51, 51, 51));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Cost");

        javax.swing.GroupLayout panelBorder7Layout = new javax.swing.GroupLayout(panelBorder7);
        panelBorder7.setLayout(panelBorder7Layout);
        panelBorder7Layout.setHorizontalGroup(
            panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder7Layout.createSequentialGroup()
                        .addComponent(txtCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelBorder7Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelBorder7Layout.setVerticalGroup(
            panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder7Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnUpdate.setBackground(new java.awt.Color(84, 151, 252));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lbIconImage.setBackground(new java.awt.Color(204, 255, 255));
        lbIconImage.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\product.png")); // NOI18N

        btnChangeImage.setForeground(new java.awt.Color(51, 51, 51));
        btnChangeImage.setText("Change image");
        btnChangeImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIconImage, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnChangeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(75, 75, 75))
                    .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIconImage, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChangeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Icon icon = lbIconImage.getIcon();
        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        icon.paintIcon(null, g2d, 0, 0);
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
        SanPham product = new SanPham();

//        if (txtCost.getText().equals("") || txtDes.getText().equals("") || txtGuarantee.getText().equals("") || txtName.getText().equals("") || txtSold.getText().equals("") || txtWarehouse.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
//            return;
//        } else {
//
//            if (Integer.parseInt(txtSold.getText()) > 0 && Integer.parseInt(txtWarehouse.getText()) > 0 && Integer.parseInt(txtCost.getText()) > 0) {
//                // Đặt mảng byte vào thuộc tính HinhAnh của đối tượng sanPham
//                try {
//                    product.setMaSanPham(sanPham.getMaSanPham());
//                    product.setHinhAnh(imageData);
//                    product.setGia(Integer.parseInt(txtCost.getText()));
//                    product.setMoTa(txtDes.getText());
//                    product.setThoiHanBaoHanh(txtGuarantee.getText());
//                    product.setTenSanPham(txtName.getText());
//                    product.setSoLuongDaBan(Integer.parseInt(txtSold.getText()));
//                    product.setSoLuongTrongKho(Integer.parseInt(txtWarehouse.getText()));
//
//                    sanPhamDao.updateSanPham(product);
//                    JOptionPane.showMessageDialog(this, "Cập nhật thành công");
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số dương vào các ô (Số sản phẩm bán ra, kho hàng, giá tiền)");
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "Vui lòng nhập số dương vào các ô (Số sản phẩm bán ra, kho hàng, giá tiền)");
//            }
        if (txtCost.getText().equals("") || txtDes.getText().equals("") || txtGuarantee.getText().equals("") || txtName.getText().equals("") || txtSold.getText().equals("") || txtWarehouse.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
            return;
        } else {
            String soldText = txtSold.getText();
            String warehouseText = txtWarehouse.getText();
            String costText = txtCost.getText();
            if (isNumeric(soldText) && isNumeric(warehouseText) && isNumeric(costText)) {
                int sold = Integer.parseInt(soldText);
                int warehouse = Integer.parseInt(warehouseText);
                int cost = Integer.parseInt(costText);

                if (sold > 0 && warehouse > 0 && cost > 0) {
                    // Thực hiện các hành động khi tất cả số nguyên đều lớn hơn 0
                    try {
                        product.setMaSanPham(sanPham.getMaSanPham());
                        product.setHinhAnh(imageData);
                        product.setGia(Integer.parseInt(txtCost.getText()));
                        product.setMoTa(txtDes.getText());
                        product.setThoiHanBaoHanh(txtGuarantee.getText());
                        product.setTenSanPham(txtName.getText());
                        product.setSoLuongDaBan(Integer.parseInt(txtSold.getText()));
                        product.setSoLuongTrongKho(Integer.parseInt(txtWarehouse.getText()));

                        sanPhamDao.updateSanPham(product);
                        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập số dương vào các ô (Số sản phẩm bán ra, kho hàng, giá tiền)");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số dương vào các ô (Số sản phẩm bán ra, kho hàng, giá tiền)");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số dương vào các ô (Số sản phẩm bán ra, kho hàng, giá tiền)");
            }

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnChangeImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeImageActionPerformed

        JFileChooser fileChooser = new JFileChooser(); // Tạo một hộp thoại chọn tệp
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); // Thiết lập thư mục mặc định là thư mục người dùng
        int result = fileChooser.showOpenDialog(this); // Hiển thị hộp thoại chọn tệp và đợi cho người dùng chọn một tệp

        if (result == JFileChooser.APPROVE_OPTION) { // Nếu người dùng đã chọn một tệp
            File selectedFile = fileChooser.getSelectedFile(); // Lấy ra tệp đã chọn

            // Tạo một ImageIcon từ tệp đã chọn
            ImageIcon originalIcon = new ImageIcon(selectedFile.getAbsolutePath());

            // Chỉnh kích thước của hình ảnh
            Image scaledImage = originalIcon.getImage().getScaledInstance(119, 119, Image.SCALE_SMOOTH);

            // Tạo một ImageIcon mới với kích thước đã điều chỉnh
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // Đặt hình ảnh làm biểu tượng cho nhãn
            lbIconImage.setIcon(scaledIcon);
        }

    }//GEN-LAST:event_btnChangeImageActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 btnChangeImage;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbIconImage;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder1;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder2;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder3;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder4;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder5;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder6;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder7;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtCost;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtDes;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtGuarantee;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtName;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtSold;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtWarehouse;
    // End of variables declaration//GEN-END:variables

}
