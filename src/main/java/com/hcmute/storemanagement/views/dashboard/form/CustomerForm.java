/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.form;

import com.hcmute.storemanagement.DAO.StaffDao.IStaffDonHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.StaffKhachHangDao;
import com.hcmute.storemanagement.models.DonHang;
import com.hcmute.storemanagement.models.KhachHang;
import com.hcmute.storemanagement.views.dashboard.model.ModelCustomer;
import com.hcmute.storemanagement.views.dashboard.popup.BillInfo;
import com.hcmute.storemanagement.views.dashboard.popup.popupAddStaff;
import com.raven.chart.ModelChart;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.hcmute.storemanagement.DAO.StaffDao.IStaffKhachHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.StaffDonHangDao;

/**
 *
 * @author DELL
 */
public class CustomerForm extends javax.swing.JPanel {
    List<KhachHang> listKH;
    public CustomerForm() {
        initComponents();
        setOpaque(false);
        init();
    }

    private void init() {
        DefaultTableModel model = (DefaultTableModel) tableCustomer1.getModel();
        model.setRowCount(0);
        IStaffKhachHangDao cusDao = new StaffKhachHangDao();
        IStaffDonHangDao billDao = new StaffDonHangDao();
        listKH = cusDao.getAll();
        for (KhachHang kh : listKH) {
            ModelCustomer modelCus = new ModelCustomer();
            modelCus.setIdCustomer(kh.getMaKhachHang());
            modelCus.setName(kh.getTenKhachHang());
            modelCus.setPhone(kh.getSoDienThoai());
            modelCus.setPoint(kh.getDiemThanhVien());
            List<DonHang> listDonHang = billDao.getBillFromCusId(kh.getMaKhachHang());
            modelCus.setNumberOfBill(listDonHang.size());
            int totalCost = 0;
            for (DonHang dh : listDonHang) {
                totalCost+=dh.getTongGiaTri();
            }
            modelCus.setTotalCost(totalCost);
            ImageIcon icon = new ImageIcon("C:\\imagepj\\image\\user.png");
            modelCus.setIcon(icon);
            model.addRow(modelCus.toRowTable());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer1 = new com.hcmute.storemanagement.views.dashboard.swing.TableCustomer.TableCustomer();
        jLabel1 = new javax.swing.JLabel();
        button1 = new com.hcmute.storemanagement.views.authen.swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1076, 639));

        tableCustomer1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone", "Point", "Number Of Bills", "Total Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableCustomer1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 119, 253));
        jLabel1.setText("Customer List");

        button1.setBackground(new java.awt.Color(30, 119, 253));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Watch Bill");
        button1.setActionCommand("WatchBill");
        button1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        int rowIndex = tableCustomer1.getSelectedRow();
    
    // Ensure a row is selected
    if (rowIndex != -1) {
        // Use the selected KhachHang object as needed
        openPopup(listKH.get(rowIndex));
        
        
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row.");
    }
        
    }//GEN-LAST:event_button1ActionPerformed

     private static void openPopup(KhachHang selectedKhachHang) {
        JFrame popupFrame = new JFrame();
        popupFrame.setTitle(null); // Đặt tiêu đề là null
        popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đóng cửa sổ popup khi đóng
        BillInfo billInfo = new BillInfo(selectedKhachHang); // Truyền role và pass vào
        popupFrame.add(billInfo);
        popupFrame.pack();
        popupFrame.setLocationRelativeTo(null); // Căn giữa cửa sổ
        popupFrame.setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.authen.swing.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.hcmute.storemanagement.views.dashboard.swing.TableCustomer.TableCustomer tableCustomer1;
    // End of variables declaration//GEN-END:variables

}
