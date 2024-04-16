package com.hcmute.storemanagement.views.dashboard.form;

import com.hcmute.storemanagement.DAO.StaffDao.StaffNhanVienDao;
import com.hcmute.storemanagement.models.NhanVien;
import com.hcmute.storemanagement.views.dashboard.model.modelUser;
import com.hcmute.storemanagement.views.dashboard.swing.TableUser.EventActionUser;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class StaffForm extends javax.swing.JPanel {

    public StaffForm() throws SQLException {
        initComponents();
        //table1.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRender());

        initData();
    }

    private void initData() throws SQLException {
        EventActionUser eventAction = new EventActionUser() {
            @Override
            public void delete(modelUser student, ActionEvent e) {
                
            }

            @Override
            public void update(modelUser student, ActionEvent e) {
                
            }
        };
        // Add dữ liệu vào bảng
        DefaultTableModel model = (DefaultTableModel) tableUser1.getModel();
        StaffNhanVienDao staffController = new StaffNhanVienDao();
        ArrayList<NhanVien> staffList = staffController.getAllStaff();
        for (NhanVien staff : staffList) {
//            Object[] rowData = staff.toDataTable(); // Lấy dữ liệu từ đối tượng NhanVien
//            // Kiểm tra nếu dữ liệu không đủ cho số lượng cột, thêm giá trị null vào cột cuối cùng
//            if (rowData.length < model.getColumnCount()) {
//                Object[] newRowData = new Object[model.getColumnCount()];
//                System.arraycopy(rowData, 0, newRowData, 0, rowData.length);
//                rowData = newRowData;
//            }
            ImageIcon icon = new ImageIcon("C:\\imagepj\\image\\user.png");
            model.addRow(new modelUser(icon, staff.getTenNhanVien(), staff.getSoDienThoai(), staff.getEmail(), staff.getGioiTinh(), staff.getNgaySinh(), staff.getDiaChi(), staff.getCCCD()).toRowTable(eventAction));
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUser1 = new com.hcmute.storemanagement.views.dashboard.swing.TableUser.TableUser();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 119, 253));
        jLabel1.setText("List Staff");

        tableUser1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Phone", "Email", "Gender", "Day of birth", "Address", "CCCD", "Action"
            }
        ));
        jScrollPane1.setViewportView(tableUser1);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\add.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.hcmute.storemanagement.views.dashboard.swing.TableUser.TableUser tableUser1;
    // End of variables declaration//GEN-END:variables
}
