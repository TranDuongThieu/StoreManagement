/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.staff_dashboard.mainStaff;

import com.hcmute.storemanagement.models.ChiTietDonHang;
import com.hcmute.storemanagement.models.DonHang;
import com.hcmute.storemanagement.models.KhachHang;
import com.hcmute.storemanagement.models.SanPham;
import com.hcmute.storemanagement.service.AdminChiTietDonHangService;
import com.hcmute.storemanagement.service.IAdminChiTietDonHangService;
import com.hcmute.storemanagement.service.IStaffChiTietDonHangService;
import com.hcmute.storemanagement.service.IStaffDonHangService;
import com.hcmute.storemanagement.service.IStaffKhachHangService;
import com.hcmute.storemanagement.service.IStaffSanPhamService;
import com.hcmute.storemanagement.service.StaffChiTietDonHangService;
import com.hcmute.storemanagement.service.StaffDonHangService;
import com.hcmute.storemanagement.service.StaffKhachHangService;
import com.hcmute.storemanagement.service.StaffSanPhamService;
import com.hcmute.storemanagement.views.authen.component.PanelLoginAndRegister;
import com.hcmute.storemanagement.views.staff_dashboard.form.HomeForm;
import com.hcmute.storemanagement.views.staff_dashboard.model.ModelBill;
import com.hcmute.storemanagement.views.staff_dashboard.model.billDetailTable.EventActionBilldetail;
import com.itextpdf.text.BaseColor;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.time.LocalDate;

public class BillForm extends javax.swing.JPanel {

    int quanttOld = 0;

    IStaffDonHangService staffDonHangService = new StaffDonHangService();
    IStaffKhachHangService staffKhachHangService = new StaffKhachHangService();
    IAdminChiTietDonHangService adBillDetail = new AdminChiTietDonHangService();
    IStaffSanPhamService stProduct = new StaffSanPhamService();
    IStaffChiTietDonHangService staffBilldetail = new StaffChiTietDonHangService();

    public BillForm() throws SQLException {
        initComponents();
        txtScoresCustomer.setEditable(false);
        ShowBill();
        initBilldetailTable();
    }

    private void initBilldetailTable() throws SQLException {

        EventActionBilldetail eventAction = new EventActionBilldetail() {
            @Override
            public void delete(ModelBill student, ActionEvent e) {
                // kiểm tra còn action ko
                if (tbBilldetail.isEditing()) {
                    tbBilldetail.getCellEditor().stopCellEditing();
                }
                System.err.println("delete");
                // Lấy vị trí hàng được chọn
                int row = tbBilldetail.getSelectedRow();
                // Lấy giá trị từ hàng và cột tương ứng, lấy được đối tượng object
                Object orderID = tbBilldetail.getValueAt(row, 1);
                Object ProductID = tbBilldetail.getValueAt(row, 2);
                Object Cost = tbBilldetail.getValueAt(row, 5);
                String orderid = orderID != null ? orderID.toString() : "";
                String productid = ProductID != null ? ProductID.toString() : "";
                int cost = Cost != null ? Integer.parseInt(Cost.toString()) : 0;

                adBillDetail.deleteChiTietDonHang(orderid, productid);
                JOptionPane.showMessageDialog(BillForm.this, "Xóa thành công");
                HomeForm.globalBillId.totalGlb = HomeForm.globalBillId.totalGlb - cost;
                lbTotal.setText(String.valueOf(HomeForm.globalBillId.totalGlb));
                lbTotalPayment.setText(String.valueOf(HomeForm.globalBillId.totalGlb));

                try {
                    initBilldetailTable();
                } catch (SQLException ex) {
                    Logger.getLogger(BillForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                // cập nhật total và total payment

            }

            @Override
            public void update(ModelBill student, ActionEvent e) {
                int row = tbBilldetail.getSelectedRow();
                Object orderID = tbBilldetail.getValueAt(row, 1);
                Object ProductID = tbBilldetail.getValueAt(row, 2);
                Object Quantity = tbBilldetail.getValueAt(row, 3);
                Object Cost = tbBilldetail.getValueAt(row, 5);
                String orderid = orderID != null ? orderID.toString() : "";
                String productid = ProductID != null ? ProductID.toString() : "";
                int quantity = Quantity != null ? Integer.parseInt(Quantity.toString()) : 0;
                int cost = Cost != null ? Integer.parseInt(Cost.toString()) : 0;
                // kt số lượng trong kho 
                int qtWhouse = stProduct.getSoLuongTrongKhoByMaSanPham(productid);
                if (quantity > qtWhouse) {
                    JOptionPane.showMessageDialog(BillForm.this, "Số lượng trong kho không đủ");
                    try {
                        initBilldetailTable();
                    } catch (SQLException ex) {
                        Logger.getLogger(BillForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    //HomeForm.globalBillId.totalGlb = 1;
                    // Cập nhật totlal payment và total 
                    // tính lại số mới nhập
                    int newQuantity = quantity - quanttOld;

                    HomeForm.globalBillId.totalGlb = HomeForm.globalBillId.totalGlb + cost * newQuantity;
                    lbTotal.setText(String.valueOf(HomeForm.globalBillId.totalGlb));
                    lbTotalPayment.setText(String.valueOf(HomeForm.globalBillId.totalGlb));
                    lbDiscount.setText("");
                    // up date số lượng
                    staffBilldetail.updateSoLuong(orderid, productid, quantity);
                    JOptionPane.showMessageDialog(BillForm.this, "Cập nhật số lượng thành công");
                    try {
                        initBilldetailTable();
                    } catch (SQLException ex) {
                        Logger.getLogger(BillForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        initBilldetailTable();
                    } catch (SQLException ex) {
                        Logger.getLogger(BillForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        };
        DefaultTableModel model = (DefaultTableModel) tbBilldetail.getModel();
        model.setRowCount(0);
        List<ChiTietDonHang> chitietdonhang = (List<ChiTietDonHang>) adBillDetail.getChiTietDonHangById(HomeForm.globalBillId.BillId);
        for (ChiTietDonHang ct : chitietdonhang) {
            SanPham sanPham = stProduct.getSanPhamById(ct.getMaSanPham());
            byte[] imageData = sanPham.getHinhAnh(); // Lấy dữ liệu hình ảnh từ đối tượng sanPham
            ImageIcon imageIcon = new ImageIcon(imageData);
            model.addRow(new ModelBill(imageIcon, sanPham.getTenSanPham(), ct.getMaDonHang(), sanPham.getMaSanPham(), String.valueOf(ct.getSoLuong()), sanPham.getSoLuongTrongKho(), sanPham.getGia(), sanPham.getGia() * ct.getSoLuong()).toRowTable(eventAction));
        }
    }

    private void ShowBill() {
        DonHang dh = staffDonHangService.findBillById(String.valueOf(HomeForm.globalBillId.BillId));
        if (dh != null) {
            lbDate.setText(String.valueOf(dh.getNgayDatHang()));
            lbTotal.setText(String.valueOf(HomeForm.globalBillId.totalGlb) + "$");
            lbIdStaff.setText(String.valueOf(PanelLoginAndRegister.GlobalVariables.userId));
            lbIdOrder.setText(String.valueOf(HomeForm.globalBillId.BillId));
            lbDiscount.setText("0%");
            lbTotalPayment.setText(String.valueOf(HomeForm.globalBillId.totalGlb) + "$");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBilldetail = new com.hcmute.storemanagement.views.staff_dashboard.model.billDetailTable.BillDetailTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnExFile = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();
        lbIdOrder = new javax.swing.JLabel();
        lbIdCustomer = new javax.swing.JLabel();
        lbIdStaff = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        lbDiscount = new javax.swing.JLabel();
        lbTotalPayment = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new com.hcmute.storemanagement.views.dashboard.swing.SearchText();
        iconSearch = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnAddCustomer = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();
        btnAddDiscount = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();
        txtNameCustomer = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        txtPhoneCustomer = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        jLabel21 = new javax.swing.JLabel();
        txtScoresCustomer = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        txtDiscountCustomer = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        jLabel22 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        tbBilldetail.setBackground(new java.awt.Color(204, 204, 204));
        tbBilldetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Order ID", "Product ID", "Quantity", "Warehouse", "Cost", "Total", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbBilldetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickCellTable(evt);
            }
        });
        jScrollPane1.setViewportView(tbBilldetail);
        if (tbBilldetail.getColumnModel().getColumnCount() > 0) {
            tbBilldetail.getColumnModel().getColumn(0).setMinWidth(150);
            tbBilldetail.getColumnModel().getColumn(0).setPreferredWidth(210);
            tbBilldetail.getColumnModel().getColumn(0).setMaxWidth(210);
        }

        jPanel1.setBackground(new java.awt.Color(233, 233, 233));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ID Order:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("ID Customer:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("ID Staff:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Date:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Discount:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Total:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 119, 253));
        jLabel5.setText("Bill");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Total Payment");

        btnExFile.setBackground(new java.awt.Color(84, 151, 252));
        btnExFile.setForeground(new java.awt.Color(255, 255, 255));
        btnExFile.setText(" Export file");
        btnExFile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExFileActionPerformed(evt);
            }
        });

        lbIdOrder.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbIdOrder.setForeground(new java.awt.Color(51, 51, 51));

        lbIdCustomer.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbIdCustomer.setForeground(new java.awt.Color(51, 51, 51));

        lbIdStaff.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbIdStaff.setForeground(new java.awt.Color(51, 51, 51));

        lbDate.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbDate.setForeground(new java.awt.Color(51, 51, 51));

        lbTotal.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(51, 51, 51));

        lbDiscount.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbDiscount.setForeground(new java.awt.Color(51, 51, 51));

        lbTotalPayment.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbTotalPayment.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIdOrder)
                    .addComponent(lbIdCustomer)
                    .addComponent(lbIdStaff)
                    .addComponent(lbDate)
                    .addComponent(lbTotal)
                    .addComponent(lbDiscount)
                    .addComponent(lbTotalPayment)
                    .addComponent(btnExFile, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbIdOrder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbIdCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbIdStaff))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbDiscount))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbTotalPayment))
                .addGap(18, 18, 18)
                .addComponent(btnExFile, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 119, 253));
        jLabel8.setText("Detail");

        jPanel2.setBackground(new java.awt.Color(233, 233, 233));

        txtSearch.setBackground(new java.awt.Color(233, 233, 233));
        txtSearch.setForeground(new java.awt.Color(51, 51, 51));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterSearch(evt);
            }
        });

        iconSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconSearch.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\search.png")); // NOI18N
        iconSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickSearch(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(iconSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Name");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Phone");

        btnAddCustomer.setBackground(new java.awt.Color(84, 151, 252));
        btnAddCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCustomer.setText("Add Customer");
        btnAddCustomer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        btnAddDiscount.setBackground(new java.awt.Color(84, 151, 252));
        btnAddDiscount.setForeground(new java.awt.Color(255, 255, 255));
        btnAddDiscount.setText("Add Discount");
        btnAddDiscount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDiscountActionPerformed(evt);
            }
        });

        txtNameCustomer.setBackground(new java.awt.Color(233, 233, 233));

        txtPhoneCustomer.setBackground(new java.awt.Color(233, 233, 233));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Scores");

        txtScoresCustomer.setBackground(new java.awt.Color(233, 233, 233));

        txtDiscountCustomer.setBackground(new java.awt.Color(233, 233, 233));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Discount");

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\reload.png")); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickReload(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel20)
                                                    .addComponent(jLabel21)
                                                    .addComponent(jLabel22))
                                                .addGap(137, 137, 137))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addComponent(btnAddDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel19)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPhoneCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNameCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtScoresCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiscountCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)))))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNameCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(16, 16, 16)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhoneCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtScoresCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiscountCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAddDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
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

    private void enterSearch(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterSearch
        String txtSearch = this.txtSearch.getText();

        // tìm khách hàng bằng mã id hoặc sdt 
        IStaffKhachHangService staffCus = new StaffKhachHangService();
        KhachHang khByID = staffCus.getKhachHangByID(txtSearch);
        KhachHang khByPhone = staffCus.getKhachHangByPhoneNumber(txtSearch);
        if (khByID != null) {
            showCusWithId(khByID);
        } else if (khByPhone != null) {
            showCusWithId(khByPhone);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm được khách hàng phù hợp!");
        }
    }//GEN-LAST:event_enterSearch

    private void btnAddDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDiscountActionPerformed
        if (txtDiscountCustomer.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa đủ điểm để được giảm giá!");
        } else {
            lbDiscount.setText(txtDiscountCustomer.getText());
            String amountString = lbTotal.getText();
            String cleanAmountString = amountString.substring(0, amountString.length() - 1);
            int total = Integer.parseInt(cleanAmountString);
            String discString = txtDiscountCustomer.getText();
            String cleanLastString = amountString.substring(0, discString.length() - 1);
            int discount = Integer.parseInt(cleanLastString);
            lbTotalPayment.setText(String.valueOf(total - total * discount / 100));
        }
    }//GEN-LAST:event_btnAddDiscountActionPerformed

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        // insert customer 
        if (txtNameCustomer.getText().equals("") || txtPhoneCustomer.getText().equals("") || txtScoresCustomer.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tên, số điện thoại và điểm!");
        } else {
            boolean checkAdd = staffKhachHangService.addKhachHang(txtNameCustomer.getText(), txtPhoneCustomer.getText(), Integer.parseInt(txtScoresCustomer.getText()));
            if (checkAdd == true) {
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công \n Bạn có thể tra cứu thông tin khách hàng này");
            } else {
                JOptionPane.showMessageDialog(this, "Khách hàng này đã tồn tại!");
            }
        }
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void clickSearch(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickSearch
        String txtSearch = this.txtSearch.getText();

        // tìm khách hàng bằng mã id hoặc sdt 
        IStaffKhachHangService staffCus = new StaffKhachHangService();
        KhachHang khByID = staffCus.getKhachHangByID(txtSearch);
        KhachHang khByPhone = staffCus.getKhachHangByPhoneNumber(txtSearch);
        if (khByID != null) {
            showCusWithId(khByID);
        } else if (khByPhone != null) {
            showCusWithId(khByPhone);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm được khách hàng phù hợp!");
        }    }//GEN-LAST:event_clickSearch

    private void btnExFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExFileActionPerformed
        // in hóa đơn 
        generateAndSaveBill();
        // cập nhật số lượng sản phẩm còn trong kho
        List<ChiTietDonHang> chitietdonhang = (List<ChiTietDonHang>) adBillDetail.getChiTietDonHangById(HomeForm.globalBillId.BillId);
        for (ChiTietDonHang ct : chitietdonhang) {
            SanPham sanPham = stProduct.getSanPhamById(ct.getMaSanPham());
            int warehouse = sanPham.getSoLuongTrongKho() - Integer.valueOf(ct.getSoLuong());
            stProduct.updateSoLuongTrongKho(sanPham.getMaSanPham(), warehouse);
        }

        // gán biến global về 0
        HomeForm.globalBillId.BillId = null;
        HomeForm.globalBillId.productId = null;
        HomeForm.globalBillId.totalGlb = 0;
        try {
            initBilldetailTable();
        } catch (SQLException ex) {
            Logger.getLogger(BillForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        nullBill();
    }//GEN-LAST:event_btnExFileActionPerformed

    private void nullBill() {
        lbDate.setText("");
        lbDiscount.setText("");
        lbIdCustomer.setText("");
        lbIdOrder.setText("");
        lbIdStaff.setText("");
        lbTotal.setText("");
        lbTotalPayment.setText("");
    }
//    private void generateAndSaveBill() {
//        String filename = "bill1.pdf";
//        String content = "Hóa đơn\n\nTên sản phẩm: ABC\nGiá: $100\nSố lượng: 2\nTổng cộng: $200";
//        // Tạo tài liệu PDF và thêm nội dung
//        Document document = new Document();
//        try {
//            PdfWriter.getInstance(document, new FileOutputStream(filename));
//            document.open();
//            document.add(new Paragraph(content));
//            document.close();
//            System.out.println("Hóa đơn được tạo thành công và lưu vào máy tính!");
//        } catch (DocumentException | FileNotFoundException ex) {
//            ex.printStackTrace();
//        }
//    }

    private void generateAndSaveBill() {
        // Lấy ngày hiện tại
        LocalDate currentDate = LocalDate.now();
        String date = String.valueOf(currentDate);
        String FILE_NAME = "Bill" + date + ".pdf";
        // Tạo tài liệu PDF với kích thước A7 và lề 50 đơn vị cho mỗi cạnh
        Document document = new Document(PageSize.A6, 30, 30, 30, 30);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(FILE_NAME));
            document.open();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD, BaseColor.BLACK);
            Font contentFont = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL, BaseColor.BLACK);

            Paragraph title = new Paragraph("Bill", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("\n")); // Add empty line

            // Add content
            String[] contentLines = {
                "ID order:               " + String.valueOf(lbIdOrder.getText()),
                "ID customer:            " + String.valueOf(lbIdCustomer.getText()),
                "ID Staff:                " + String.valueOf(lbIdStaff.getText()),
                "Date:                     " + String.valueOf(lbDate.getText()),
                "Total:                     " + String.valueOf(lbTotal.getText()),
                "Discount:               " + String.valueOf(lbDiscount.getText()),
                "Total payment:       " + String.valueOf(lbTotalPayment.getText())
            };

            for (String line : contentLines) {
                Paragraph content = new Paragraph(line, contentFont);
                document.add(content);
            }

            document.close();
            System.out.println("Hóa đơn được tạo thành công và lưu vào máy tính!");
            JOptionPane.showMessageDialog(this, "Xuất hóa đơn thành công");
        } catch (DocumentException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void clickReload(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickReload
        txtDiscountCustomer.setText("");
        txtNameCustomer.setText("");
        txtPhoneCustomer.setText("");
        txtScoresCustomer.setText("");
        String amountString = lbTotal.getText();
        String cleanAmountString = amountString.substring(0, amountString.length() - 1);
        int total = Integer.parseInt(cleanAmountString);
        lbTotalPayment.setText(String.valueOf(total));
        lbDiscount.setText("");
        lbIdStaff.setText("");
    }//GEN-LAST:event_clickReload

    private void clickCellTable(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickCellTable
        // TODO add your handling code here:
        int row = tbBilldetail.rowAtPoint(evt.getPoint());
        int column = tbBilldetail.columnAtPoint(evt.getPoint());

        Object value = tbBilldetail.getValueAt(row, column);
        quanttOld = value != null ? Integer.parseInt(value.toString()) : 0;

        System.err.println("quantity: " + quanttOld);
    }//GEN-LAST:event_clickCellTable

    private void showCusWithId(KhachHang khachHang) {
        txtNameCustomer.setText(khachHang.getTenKhachHang());
        //txtNameCustomer.setEditable(false);
        txtPhoneCustomer.setText(khachHang.getSoDienThoai());
        //txtPhoneCustomer.setEditable(false);
        txtScoresCustomer.setText(String.valueOf(khachHang.getDiemThanhVien()));
        lbIdCustomer.setText(khachHang.getMaKhachHang());
        //txtScoresCustomer.setEditable(false);
        if (khachHang.getDiemThanhVien() > 500) {
            txtDiscountCustomer.setText("5%");
        } else if (khachHang.getDiemThanhVien() > 1000) {
            txtDiscountCustomer.setText("10%");
            txtDiscountCustomer.setEditable(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 btnAddCustomer;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 btnAddDiscount;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 btnExFile;
    private javax.swing.JLabel iconSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbDiscount;
    private javax.swing.JLabel lbIdCustomer;
    private javax.swing.JLabel lbIdOrder;
    private javax.swing.JLabel lbIdStaff;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbTotalPayment;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder1;
    private com.hcmute.storemanagement.views.staff_dashboard.model.billDetailTable.BillDetailTable tbBilldetail;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtDiscountCustomer;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtNameCustomer;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtPhoneCustomer;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtScoresCustomer;
    private com.hcmute.storemanagement.views.dashboard.swing.SearchText txtSearch;
    // End of variables declaration//GEN-END:variables
}
