/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.form;

import com.hcmute.storemanagement.DAO.StaffDao.IStaffDonHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.IStaffKhachHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.StaffDonHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.StaffKhachHangDao;
import com.hcmute.storemanagement.models.DonHang;
import com.hcmute.storemanagement.models.KhachHang;
import com.hcmute.storemanagement.service.FormatPrice;
import com.hcmute.storemanagement.views.dashboard.popup.BillDetail;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GDNForm extends javax.swing.JPanel {

    IStaffDonHangDao ordersv = new StaffDonHangDao();
    IStaffKhachHangDao CusDao = new StaffKhachHangDao();
    FormatPrice format = new FormatPrice();

    public GDNForm() {
        initComponents();
        initDate();
    }

    private void initDate() {
        List<DonHang> listOrders = ordersv.selectAllOrders();
        DefaultTableModel model = (DefaultTableModel) tbGDN.getModel();
        model.setRowCount(0);

        for (DonHang order : listOrders) {
            //SanPham sp = spDao.getSanPhamById(chitiet.getMaSanPham());
            Object[] row = new Object[5];
            row[0] = order.getMaDonHang(); // Product ID
            row[1] = order.getMaKhachHang(); // Product Name
            row[2] = order.getMaNhanVien(); // Price
            row[3] = order.getNgayDatHang(); // Quantity
            row[4] = format.format(order.getTongGiaTri());
            model.addRow(row);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbGDN = new com.hcmute.storemanagement.views.dashboard.swing.ProductTable.ProductTable();
        jLabel2 = new javax.swing.JLabel();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 119, 253));
        jLabel1.setText("Good Delivered Note");

        tbGDN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orders ID", "Customers ID", "Staffs ID", "Date", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbGDN);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\eye.png")); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickShowGRNDetail(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clickShowGRNDetail(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickShowGRNDetail
        int rowIndex = tbGDN.getSelectedRow();
        if (rowIndex != -1) {
            Object IDGRN = tbGDN.getValueAt(rowIndex, 0);
            String IdGRN = IDGRN != null ? IDGRN.toString() : "";
            System.err.println("IDHRN: " + IdGRN);

            Object IDCus = tbGDN.getValueAt(rowIndex, 1);
            String Idcus = IDCus != null ? IDCus.toString() : "";

            DonHang donhang = ordersv.findBillById(IdGRN);
            KhachHang khachHang = CusDao.getKhachHangByID(Idcus);
            openPopup(donhang, khachHang);

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 hàng trong bảng");
        }
    }//GEN-LAST:event_clickShowGRNDetail

    private static void openPopup(DonHang selectedDonHang, KhachHang khachHang) {
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder1;
    private com.hcmute.storemanagement.views.dashboard.swing.ProductTable.ProductTable tbGDN;
    // End of variables declaration//GEN-END:variables
}
