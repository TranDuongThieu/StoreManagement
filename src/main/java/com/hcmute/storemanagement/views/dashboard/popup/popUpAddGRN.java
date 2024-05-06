/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.popup;

import com.hcmute.storemanagement.DAO.StaffDao.AdminChiTietDonNhapHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.IAdminChiTietDonNhapHangDao;
import com.hcmute.storemanagement.models.ChiTietDonNhapHang;
import com.hcmute.storemanagement.models.DonNhapHang;
import com.hcmute.storemanagement.models.NhaCungCap;
import com.hcmute.storemanagement.models.SanPham;
import com.hcmute.storemanagement.service.AdminDonNhapHangService;
import com.hcmute.storemanagement.service.AdminNhaCungCapService;
import com.hcmute.storemanagement.service.GeneratePDF;
import com.hcmute.storemanagement.service.IAdminDonNhapHangService;
import com.hcmute.storemanagement.service.IAdminNhaCungCapService;
import com.hcmute.storemanagement.service.IStaffSanPhamService;
import com.hcmute.storemanagement.service.StaffSanPhamService;
import com.hcmute.storemanagement.views.dashboard.form.GRNForm;
import com.hcmute.storemanagement.views.dashboard.model.ModelGRN;
import com.hcmute.storemanagement.views.dashboard.swing.GRNTable.EventActionGRN;
import com.hcmute.storemanagement.views.dashboard.swing.GRNTable.ModelProfileGRN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class popUpAddGRN extends javax.swing.JPanel {

    IStaffSanPhamService productsv = new StaffSanPhamService();
    IAdminNhaCungCapService nccSv = new AdminNhaCungCapService();
    IAdminDonNhapHangService GRNsv = new AdminDonNhapHangService();
    IAdminChiTietDonNhapHangDao GRNDetail = new AdminChiTietDonNhapHangDao();

    List<SanPham> sanPhams = productsv.getAllSanPham();
    List<NhaCungCap> nccs = nccSv.getAllNhaCungCap();
    private JFrame popupJframe;
    private String ProductId = sanPhams.get(0).getMaSanPham();
    private String SupplierId = nccs.get(0).getMaNhaCungCap();
    private int total = 0;
    public static String GRNID = "";

    public popUpAddGRN(JFrame popupJframe) {
        this.popupJframe = popupJframe;
        initComponents();
        showDataCbbPrName();
        showDataCbbSpName();
        // lấy ngày hiện tại
        Date currentDate = new Date();
        // Đặt ngày hiện tại cho JDateChooser
        txtDate.setDate(currentDate);
        // set madon moi
        txtGRNID.setText(getGRNID());
        txtGRNID.setEditable(false);
        //initData();
        txtCost.setText(String.valueOf(sanPhams.get(0).getGia()));
    }

    private void initData() {

        EventActionGRN eventAction = new EventActionGRN() {
            @Override
            public void delete(ModelGRN student, ActionEvent e) {
                // kiểm tra còn action ko
                if (tbGrnDetail.isEditing()) {
                    tbGrnDetail.getCellEditor().stopCellEditing();
                }
                int row = tbGrnDetail.getSelectedRow();
                // lấy id product
                Object productID = tbGrnDetail.getValueAt(row, 1);
                String prdId = productID != null ? productID.toString() : "";
                // xóa
                GRNDetail.deleteGRNDetail(txtGRNID.getText(), prdId);
                JOptionPane.showMessageDialog(popUpAddGRN.this, "Bạn đã xóa thành công");
                initData();
            }

            @Override
            public void update(ModelGRN student, ActionEvent e) {
                // kiểm tra còn action ko
                if (tbGrnDetail.isEditing()) {
                    tbGrnDetail.getCellEditor().stopCellEditing();
                }
                int row = tbGrnDetail.getSelectedRow();
                ModelProfileGRN profileUser = (ModelProfileGRN) tbGrnDetail.getValueAt(row, 0);
                String idGRN = profileUser.getId();
                // lấy id product
                Object productID = tbGrnDetail.getValueAt(row, 1);
                String prdId = productID != null ? productID.toString() : "";
                // lấy số lượng mới 
                Object Quantity = tbGrnDetail.getValueAt(row, 4);
                String quantitynew = Quantity != null ? Quantity.toString() : "";
                GRNDetail.updateSoluong(idGRN, prdId, Integer.parseInt(quantitynew));
                JOptionPane.showMessageDialog(popUpAddGRN.this, "Cập nhật thành công");
                initData();
                txtTotal.setText(String.valueOf(total()));
            }
        };
        DefaultTableModel model = (DefaultTableModel) tbGrnDetail.getModel();
        model.setRowCount(0);
        List<ChiTietDonNhapHang> ctDonNhapHang = (List<ChiTietDonNhapHang>) GRNDetail.getGRNDetailgByGRNId(String.valueOf(txtGRNID.getText()));
        for (ChiTietDonNhapHang ct : ctDonNhapHang) {
            SanPham sanPham = productsv.getSanPhamById(ct.getMaSanPham());
            byte[] imageData = sanPham.getHinhAnh(); // Lấy dữ liệu hình ảnh từ đối tượng sanPham
            ImageIcon imageIcon = new ImageIcon(imageData);
            model.addRow(new ModelGRN(imageIcon, ct.getMaDonNhapHang(), ct.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getGia(), ct.getSoLuong(), sanPham.getGia() * ct.getSoLuong()).toRowTable(eventAction));
        }
    }

    public String getGRNID() {
        String GRNID = GRNsv.getMaDonNhapHangCuoiCung();

        if (GRNID.matches("DNH\\d+")) {
            int number = Integer.parseInt(GRNID.substring(3)); // Bỏ đi "TKNV" và lấy số phía sau
            number++;
            String newNumber = String.format("%03d", number); // Định dạng lại số thành chuỗi có 3 chữ số, bắt đầu từ "001"
            GRNID = "DNH" + newNumber;
        }
        return GRNID;
    }

    private void showDataCbbPrName() {
        // Tạo một DefaultComboBoxModel
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        // Tạo một Map để ánh xạ tên sản phẩm với ID
        Map<String, String> productMap = new HashMap<>();

        // Thêm tên sản phẩm vào model và ánh xạ với ID
        for (SanPham sanPham : sanPhams) {
            String productName = sanPham.getTenSanPham();
            String productId = sanPham.getMaSanPham();
            String displayText = productId + " - " + productName;
            comboBoxModel.addElement(displayText);
            productMap.put(displayText, productId);
        }

        // Gán model cho JComboBox
        cbbProductName.setModel(comboBoxModel);

        // Đăng ký ActionListener để xử lý sự kiện khi người dùng chọn tên sản phẩm
        cbbProductName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedProduct = (String) cbbProductName.getSelectedItem();
                String[] parts = selectedProduct.split(" - ");
                String selectedProductId = parts[0];
                ProductId = selectedProductId;
                System.out.println("Selected Product ID: " + selectedProductId);

                SanPham sanPham = productsv.getSanPhamById(ProductId);
                txtCost.setText(String.valueOf(sanPham.getGia()));
                txtCost.setEditable(false);
            }
        });
    }

    private void showDataCbbSpName() {
        // Tạo một DefaultComboBoxModel
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        // Thêm tên nhà cung cấp vào model
        for (NhaCungCap nhacungcap : nccs) {
            String supplierName = nhacungcap.getTenNhaCungCap();
            String supplierId = nhacungcap.getMaNhaCungCap();
            String displayText = supplierId + " - " + supplierName;
            comboBoxModel.addElement(displayText);
        }

        // Gán model cho JComboBox
        CbbSupplierName.setModel(comboBoxModel);

        // Đăng ký ActionListener để xử lý sự kiện khi người dùng chọn nhà cung cấp
        CbbSupplierName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSupplier = (String) CbbSupplierName.getSelectedItem();
                String[] parts = selectedSupplier.split(" - ");
                String selectedSupplierId = parts[0];
                SupplierId = selectedSupplierId;
                System.out.println("Selected Supplier ID: " + selectedSupplierId);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        panelBorder1 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbGrnDetail = new com.hcmute.storemanagement.views.dashboard.swing.GRNTable.GRNTable();
        jLabel9 = new javax.swing.JLabel();
        button11 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();
        txtGRNID = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        jLabel5 = new javax.swing.JLabel();
        CbbSupplierName = new javax.swing.JComboBox<>();
        txtDate = new com.toedter.calendar.JDateChooser();
        cbbProductName = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCost = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        txtQuantity = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        jLabel11 = new javax.swing.JLabel();
        button12 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();
        button13 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 119, 253));
        jLabel8.setText("GRN Detail");

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        tbGrnDetail.setBackground(new java.awt.Color(204, 204, 204));
        tbGrnDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN ID", "Product ID", "Product Name", "Cost", "Quantity", "Total", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbGrnDetail);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 119, 253));
        jLabel9.setText("Add good received note");

        button11.setBackground(new java.awt.Color(30, 119, 253));
        button11.setForeground(new java.awt.Color(255, 255, 255));
        button11.setText("Finish");
        button11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button11ActionPerformed(evt);
            }
        });

        txtGRNID.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("GRN ID ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Date ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Total ($)");

        txtTotal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Supplier Name");

        CbbSupplierName.setBackground(new java.awt.Color(255, 255, 255));
        CbbSupplierName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDate.setBackground(new java.awt.Color(255, 255, 255));

        cbbProductName.setBackground(new java.awt.Color(255, 255, 255));
        cbbProductName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Product Name");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Quantity");

        txtCost.setBackground(new java.awt.Color(255, 255, 255));

        txtQuantity.setBackground(new java.awt.Color(255, 255, 255));
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateQuantity(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Cost ($)");

        button12.setBackground(new java.awt.Color(30, 119, 253));
        button12.setForeground(new java.awt.Color(255, 255, 255));
        button12.setText("Add GRN detail");
        button12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickAddGRNDetail(evt);
            }
        });

        button13.setBackground(new java.awt.Color(255, 0, 51));
        button13.setForeground(new java.awt.Color(255, 255, 255));
        button13.setText("Delete GRN");
        button13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button13clickAddGRNDetail(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(42, 42, 42)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CbbSupplierName, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(txtGRNID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(button13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(cbbProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addComponent(txtGRNID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGap(10, 10, 10)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(CbbSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateQuantity(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateQuantity

//        txtTotal.setText(String.valueOf(Integer.parseInt(txtCost.getText()) * Integer.valueOf(txtQuantity.getText())));

    }//GEN-LAST:event_updateQuantity

    private void clickAddGRNDetail(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickAddGRNDetail
        GRNID = txtGRNID.getText();
        Date date = txtDate.getDate();
        DonNhapHang donnhaphang = new DonNhapHang();
        donnhaphang.setMaNhaCungCap(SupplierId);
        donnhaphang.setNgayNhapHang(date);
        donnhaphang.setTongGiaTri(0);
        // tao 1 donnhaphang

        String quantityText = txtQuantity.getText();
        try {
            int quantity = Integer.parseInt(quantityText);

            if (txtGRNID.getText().equals(GRNsv.getMaDonNhapHangCuoiCung())) {
                if (txtQuantity.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng");
                } else {
                    boolean checkInsert = GRNDetail.insertChiTietDonNhapHang(String.valueOf(txtGRNID.getText()), ProductId, Integer.parseInt(txtQuantity.getText()));
                    if (checkInsert == true) {
                        total = total();
                        txtTotal.setText(String.valueOf(total));
                        initData();

                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm không thành công, vui lòng chỉnh sửa trong bảng");
                    }
                }
            } else {
                GRNsv.insertDonNhapHang(donnhaphang);

                if (txtQuantity.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng");
                } else {
                    boolean checkInsert = GRNDetail.insertChiTietDonNhapHang(String.valueOf(txtGRNID.getText()), ProductId, Integer.parseInt(txtQuantity.getText()));
                    if (checkInsert == true) {

                        total = total();
                        txtTotal.setText(String.valueOf(total));
                        initData();

                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm không thành công, vui lòng chỉnh sửa trong bảng");
                    }
                }
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Giá trị không hợp lệ. Vui lòng nhập một số nguyên.");
        }

        // add vào GRN detail 

    }//GEN-LAST:event_clickAddGRNDetail

    private int total() {
        int total = 0;
        List<ChiTietDonNhapHang> listGRNdetail = GRNDetail.getGRNDetailgByGRNId(txtGRNID.getText());

        for (ChiTietDonNhapHang ct : listGRNdetail) {
            SanPham sanPham = productsv.getSanPhamById(ct.getMaSanPham());
            total = total + sanPham.getGia() * ct.getSoLuong();
        }
        return total;
    }

    private void button13clickAddGRNDetail(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button13clickAddGRNDetail
        txtTotal.setText("");
        txtQuantity.setText("");
        GRNsv.deleteDonNhapHang(txtGRNID.getText());
        initData();
    }//GEN-LAST:event_button13clickAddGRNDetail

    private void button11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button11ActionPerformed
        if (txtGRNID.getText().equals(GRNsv.getMaDonNhapHangCuoiCung())) {
            // cập nhật total 
            GRNsv.updateTotalValueById(txtGRNID.getText(), total());
            // kiểm tra T F 
            GeneratePDF gen = new GeneratePDF();
            gen.generateGRN(txtGRNID.getText());
            int result = JOptionPane.showConfirmDialog(this, "Thêm đơn nhập hàng thành công, bạn có chắc chắn muốn thoát?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                popupJframe.dispose();
                GRNID = "";
            }
        } else {
            int result = JOptionPane.showConfirmDialog(this, "Chưa thêm đơn hàng, bạn có chắc chắn muốn thoát?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                popupJframe.dispose();
            }
        }
    }//GEN-LAST:event_button11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbbSupplierName;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 button11;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 button12;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 button13;
    private javax.swing.JComboBox<String> cbbProductName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder1;
    private com.hcmute.storemanagement.views.dashboard.swing.GRNTable.GRNTable tbGrnDetail;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtCost;
    private com.toedter.calendar.JDateChooser txtDate;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtGRNID;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtQuantity;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtTotal;
    // End of variables declaration//GEN-END:variables
}
