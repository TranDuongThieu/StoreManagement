/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.staff_dashboard.mainStaff;

import com.hcmute.storemanagement.DAO.StaffDao.IStaffDonHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.IStaffKhachHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.StaffDonHangDao;
import com.hcmute.storemanagement.models.DonHang;
import com.hcmute.storemanagement.models.KhachHang;
import com.hcmute.storemanagement.service.IStaffKhachHangService;
import com.hcmute.storemanagement.service.StaffKhachHangService;
import com.hcmute.storemanagement.views.authen.component.PanelLoginAndRegister;
import com.hcmute.storemanagement.views.dashboard.popup.BillDetail;
import com.hcmute.storemanagement.views.dashboard.popup.popupAddAccount;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TransactionForm extends javax.swing.JPanel {

    IStaffDonHangDao bill = new StaffDonHangDao();
    List<DonHang> donhangs;
    private static KhachHang khachHang;
    IStaffKhachHangService staffKhachHang = new StaffKhachHangService();

    public TransactionForm() {
        initComponents();
        initDataTable();
    }

    private void initDataTable() {
        System.err.println("ádasdasd");
        DefaultTableModel model = (DefaultTableModel) tbAllBill.getModel();
        //     model.setRowCount(0); // Xóa tất cả các hàng trong model
        donhangs = bill.getBillFromStaff(String.valueOf(PanelLoginAndRegister.GlobalVariables.userId));
        System.err.println("Don: " + donhangs.toString());
        for (DonHang don : donhangs) {
            System.err.println("don hang: " + don.getMaDonHang());
            Vector<Object> rowData = new Vector<>();
            rowData.add(don.getMaDonHang());
            rowData.add(don.getMaKhachHang());
            rowData.add(don.getMaNhanVien());
            rowData.add(don.getNgayDatHang());
            rowData.add(formatTotalCost(don.getTongGiaTri()));
            // Thêm hàng vào model
            model.addRow(rowData);
        }
    }

    private String formatTotalCost(int totalCost) {
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        return df.format(totalCost);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAllBill = new com.hcmute.storemanagement.views.staff_dashboard.model.billDetailTable.BillDetailTable();
        jLabel1 = new javax.swing.JLabel();
        iconBillDetail = new javax.swing.JLabel();
        detailBtn = new com.hcmute.storemanagement.views.authen.swing.Button();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        tbAllBill.setBackground(new java.awt.Color(204, 204, 204));
        tbAllBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Customer ID", "Staff ID", "Date", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAllBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickGetDataRow(evt);
            }
        });
        jScrollPane1.setViewportView(tbAllBill);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 119, 253));
        jLabel1.setText("List Bill");

        iconBillDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickIconShowBilldetail(evt);
            }
        });

        detailBtn.setBackground(new java.awt.Color(102, 255, 51));
        detailBtn.setForeground(new java.awt.Color(255, 255, 255));
        detailBtn.setText("Detail Bill");
        detailBtn.setActionCommand("WatchBill");
        detailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(detailBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(14, 14, 14)
                                .addComponent(iconBillDetail)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(iconBillDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(49, 49, 49))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
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
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clickGetDataRow(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickGetDataRow


    }//GEN-LAST:event_clickGetDataRow

    private void clickIconShowBilldetail(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickIconShowBilldetail
        int rowIndex = tbAllBill.getSelectedRow();
        Object IDcustomer = tbAllBill.getValueAt(rowIndex, 1);
        String idcust = IDcustomer != null ? IDcustomer.toString() : "";
        // tìm khách hàng bằng mã khách hàng
        khachHang = staffKhachHang.getKhachHangByID(idcust);
        System.err.println("khach hang: " + khachHang.getTenKhachHang());
        if (rowIndex != -1) {
            openPopup(donhangs.get(rowIndex));
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row.");
        }
    }//GEN-LAST:event_clickIconShowBilldetail

    private void detailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailBtnActionPerformed
        int rowIndex = tbAllBill.getSelectedRow();
        Object IDcustomer = tbAllBill.getValueAt(rowIndex, 1);
        String idcust = IDcustomer != null ? IDcustomer.toString() : "";
        // tìm khách hàng bằng mã khách hàng
        khachHang = staffKhachHang.getKhachHangByID(idcust);
        System.err.println("khach hang: " + khachHang.getTenKhachHang());
        if (rowIndex != -1) {
            openPopup(donhangs.get(rowIndex));
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row.");
        }
    }//GEN-LAST:event_detailBtnActionPerformed

    private static void openPopup(DonHang selectedDonHang) {
        JFrame popupFrame = new JFrame();
        popupFrame.setTitle(null); // Đặt tiêu đề là null
        popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đóng cửa sổ popup khi đóng
        BillDetail billInfo = new BillDetail(selectedDonHang, khachHang);
        popupFrame.add(billInfo);
        popupFrame.pack();
        popupFrame.setLocationRelativeTo(null); // Căn giữa cửa sổ
        popupFrame.setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.authen.swing.Button detailBtn;
    private javax.swing.JLabel iconBillDetail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder1;
    private com.hcmute.storemanagement.views.staff_dashboard.model.billDetailTable.BillDetailTable tbAllBill;
    // End of variables declaration//GEN-END:variables
}
