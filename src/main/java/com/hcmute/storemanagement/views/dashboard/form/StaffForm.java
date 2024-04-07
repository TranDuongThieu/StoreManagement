package com.hcmute.storemanagement.views.dashboard.form;

import com.hcmute.storemanagement.controllers.Staff.StaffController;
import com.hcmute.storemanagement.models.NhanVien;
import com.hcmute.storemanagement.views.dashboard.Table.Cell.TableActionCellRender;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class StaffForm extends javax.swing.JPanel {

    public StaffForm() {
        initComponents();
        table1.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRender());

        initData();
    }

    private void initData() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        StaffController staffController = new StaffController();

        ArrayList<NhanVien> staffList = staffController.getAllStaff();
        for (NhanVien staff : staffList) {
            Object[] rowData = staff.toDataTable(); // Lấy dữ liệu từ đối tượng NhanVien

            // Kiểm tra nếu dữ liệu không đủ cho số lượng cột, thêm giá trị null vào cột cuối cùng
            if (rowData.length < model.getColumnCount()) {
                Object[] newRowData = new Object[model.getColumnCount()];
                System.arraycopy(rowData, 0, newRowData, 0, rowData.length);
                rowData = newRowData;
            }

            model.addRow(rowData); // Thêm hàng vào mô hình
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        table1 = new com.hcmute.storemanagement.views.dashboard.Table.swing.Table();

        setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(66, 66, 66));
        jLabel1.setText("List Staff");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Full Name", "Date of birth", "Gender", "CCCD", "Phone", "Email", "Address", "Action"
            }
        ));
        jScrollPane.setViewportView(table1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 1014, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane;
    private com.hcmute.storemanagement.views.dashboard.Table.swing.Table table1;
    // End of variables declaration//GEN-END:variables
}
