/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.popup;

import com.hcmute.storemanagement.DAO.StaffDao.AdminChiTietDonNhapHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.IAdminChiTietDonNhapHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.IStaffSanPhamDao;
import com.hcmute.storemanagement.DAO.StaffDao.StaffSanPhamDao;
import com.hcmute.storemanagement.models.ChiTietDonNhapHang;
import com.hcmute.storemanagement.models.SanPham;
import com.hcmute.storemanagement.service.AdminDonNhapHangService;
import com.hcmute.storemanagement.service.IAdminDonNhapHangService;
import com.hcmute.storemanagement.views.dashboard.model.ModelGRN;
import com.hcmute.storemanagement.views.dashboard.swing.GRNTable.EventActionGRN;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class popupGRNDetail extends javax.swing.JPanel {

    private String IdGRN;
    private Date date;
    IAdminChiTietDonNhapHangDao GRNDetail = new AdminChiTietDonNhapHangDao();
    IStaffSanPhamDao stProduct = new StaffSanPhamDao();
    IAdminDonNhapHangService GRNservice = new AdminDonNhapHangService();

    private int oldQuantity;

    public popupGRNDetail(String IdGRN, Date date) {
        initComponents();
        this.IdGRN = IdGRN;
        this.date = date;
        lbDate.setText(String.valueOf(date));
        initData();
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
                // lấy quantity 
                Object Quantity = tbGrnDetail.getValueAt(row, 3);
                String quantity = Quantity != null ? Quantity.toString() : "";
                // xóa
                GRNDetail.deleteGRNDetail(IdGRN, prdId);
                JOptionPane.showMessageDialog(popupGRNDetail.this, "Bạn đã xóa thành công");

                SanPham sanPham = stProduct.getSanPhamById(prdId);
                int totalUpDate = GRNservice.getTotalValueByMaDonNhapHang(IdGRN) - (sanPham.getGia() * (Integer.parseInt(quantity)));
                GRNservice.updateTotalValueById(IdGRN, totalUpDate);
                System.err.println("tttalupdate: " + totalUpDate);
                // cập nhật số lượng
                int qttyWarehouse = stProduct.getSoLuongTrongKhoByMaSanPham(prdId);
                int newQuantity = qttyWarehouse - Integer.parseInt(quantity);
                stProduct.updateSoLuongTrongKho(prdId, newQuantity);
                initData();
            }

            @Override
            public void update(ModelGRN student, ActionEvent e) {
                // kiểm tra còn action ko
                if (tbGrnDetail.isEditing()) {
                    tbGrnDetail.getCellEditor().stopCellEditing();
                }
                int row = tbGrnDetail.getSelectedRow();
                // lấy id product
                Object productID = tbGrnDetail.getValueAt(row, 1);
                String prdId = productID != null ? productID.toString() : "";
                // lấy số lượng mới 
                Object Quantity = tbGrnDetail.getValueAt(row, 4);
                String quantitynew = Quantity != null ? Quantity.toString() : "";
                // cập nhật total và total payment
                boolean checkUd = GRNDetail.updateSoluong(IdGRN, prdId, Integer.parseInt(quantitynew));
                // cập nhật lại số lượng trong kho
                int qttyWarehouse = stProduct.getSoLuongTrongKhoByMaSanPham(prdId);
                // cập nhật lại tổng tiền trong GRN 
                SanPham sanPham = stProduct.getSanPhamById(prdId);
                if (checkUd == true) {
                    int quantity = qttyWarehouse - (oldQuantity - Integer.parseInt(quantitynew));
                    stProduct.updateSoLuongTrongKho(prdId, quantity);
                    if (oldQuantity > Integer.parseInt(quantitynew)) {
                        int totalUpDate = GRNservice.getTotalValueByMaDonNhapHang(IdGRN) - (sanPham.getGia() * (oldQuantity - Integer.parseInt(quantitynew)));
                        GRNservice.updateTotalValueById(IdGRN, totalUpDate);
                    } else {
                        int totalUpDate = GRNservice.getTotalValueByMaDonNhapHang(IdGRN) + (sanPham.getGia() * (Integer.parseInt(quantitynew) - oldQuantity));
                        GRNservice.updateTotalValueById(IdGRN, totalUpDate);
                    }
                    JOptionPane.showMessageDialog(popupGRNDetail.this, "Cập nhật số lượng thành công");
                } else {
                    JOptionPane.showMessageDialog(popupGRNDetail.this, "Cập nhật số lượng thất bại");
                }
            }
        };
        DefaultTableModel model = (DefaultTableModel) tbGrnDetail.getModel();
        model.setRowCount(0);
        List<ChiTietDonNhapHang> ctDonNhapHang = (List<ChiTietDonNhapHang>) GRNDetail.getGRNDetailgByGRNId(IdGRN);
        for (ChiTietDonNhapHang ct : ctDonNhapHang) {
            SanPham sanPham = stProduct.getSanPhamById(ct.getMaSanPham());
            byte[] imageData = sanPham.getHinhAnh(); // Lấy dữ liệu hình ảnh từ đối tượng sanPham
            ImageIcon imageIcon = new ImageIcon(imageData);
            model.addRow(new ModelGRN(imageIcon, ct.getMaDonNhapHang(), ct.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getGia(), ct.getSoLuong(), sanPham.getGia() * ct.getSoLuong()).toRowTable(eventAction));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbGrnDetail = new com.hcmute.storemanagement.views.dashboard.swing.GRNTable.GRNTable();
        lbDate = new javax.swing.JLabel();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 119, 253));
        jLabel8.setText("GRN Detail");

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
        tbGrnDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickGetQuantity(evt);
            }
        });
        jScrollPane1.setViewportView(tbGrnDetail);

        lbDate.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbDate.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDate)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbDate))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clickGetQuantity(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickGetQuantity

        int row = tbGrnDetail.getSelectedRow();
        Object Quantity = tbGrnDetail.getValueAt(row, 3);
        String quantity = Quantity != null ? Quantity.toString() : "";
        oldQuantity = Integer.parseInt(quantity);

    }//GEN-LAST:event_clickGetQuantity


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDate;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder1;
    private com.hcmute.storemanagement.views.dashboard.swing.GRNTable.GRNTable tbGrnDetail;
    // End of variables declaration//GEN-END:variables
}
