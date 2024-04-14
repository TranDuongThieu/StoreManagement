/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.staff_dashboard.mainStaff;

import com.hcmute.storemanagement.models.LichLamViec;
import com.hcmute.storemanagement.service.StaffLNgayLamViecService;
import com.hcmute.storemanagement.service.StaffLichLamViecService;
import com.hcmute.storemanagement.views.authen.component.PanelLoginAndRegister;
import com.hcmute.storemanagement.views.staff_dashboard.model.ModelWorkSchedule;
import com.hcmute.storemanagement.views.staff_dashboard.swing.tableWorkSchedule.EventAction;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StaffDashboardWorkSchedule extends javax.swing.JPanel {

    private String idUser = PanelLoginAndRegister.GlobalVariables.userId;

    public StaffDashboardWorkSchedule() throws SQLException {
        initComponents();
        tbPayment.fixTable(jScrollPane1);
        initTablePaymentData();

    }

    private void deleterowLichLamViec(String userId, Date ngay, int maCa) throws SQLException {
        StaffLichLamViecService staffLichLamViecService = new StaffLichLamViecService();
        staffLichLamViecService.delete1rowLichLamViec(userId, ngay, maCa);
        System.out.println(userId + " " + ngay + " " + maCa);
        // Xóa hàng trong mô hình dữ liệu
        DefaultTableModel model = (DefaultTableModel) tbPayment.getModel();

        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            Object objUserID = model.getValueAt(i, 0);
            Object objNgay = model.getValueAt(i, 1);
            Object objCa = model.getValueAt(i, 2);

            System.out.println(objUserID.toString() + " " + objNgay.toString() + " " + objCa.toString());
            // Kiểm tra xem hàng có thông tin tương ứng với việc xóa hay không
            if (objNgay.equals(ngay) && objCa.equals(maCa)) {
                model.removeRow(i);
                JOptionPane.showMessageDialog(this, "Đã xóa ca làm");
//                System.out.println( model.getRowCount());
                break;
            }
        }

    }

    private void initTablePaymentData() throws SQLException {

        EventAction eventAction = new EventAction() {
            @Override
            public void delete(ModelWorkSchedule student, ActionEvent e) {
                System.out.println("call.delete()");
                // Lấy vị trí hàng được chọn
                int row = tbPayment.getSelectedRow();
                // Lấy giá trị từ hàng và cột tương ứng, lấy được đối tượng object
                Object userID = tbPayment.getValueAt(row, 0);
                Object ngayObj = tbPayment.getValueAt(row, 1);
                Object caObj = tbPayment.getValueAt(row, 2);
                // Chuyển đổi Object ngay thành kiểu Date
                Date ngay = null;
                if (ngayObj != null) {
                    if (ngayObj instanceof Date) {
                        ngay = (Date) ngayObj;
                    } else if (ngayObj instanceof String) {
                        try {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            ngay = dateFormat.parse((String) ngayObj);
                        } catch (ParseException ex) {
                            Logger.getLogger(StaffDashboardWorkSchedule.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                int ca = 0;
                if (caObj != null) {
                    if (caObj instanceof Integer) {
                        ca = (int) caObj;
                    } else if (caObj instanceof String) {
                        ca = Integer.parseInt((String) caObj);

                    }
                }
                try {
                    if (tbPayment.isEditing()){
                        tbPayment.getCellEditor().stopCellEditing();
                    }
                    deleterowLichLamViec(idUser, ngay, ca);
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDashboardWorkSchedule.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void update(ModelWorkSchedule student, ActionEvent e) {
                System.out.println(".update()");
            }
        };
        DefaultTableModel model = (DefaultTableModel) tbPayment.getModel();
        model.setRowCount(0);
        StaffLichLamViecService staffWSch = new StaffLichLamViecService();
        ArrayList<LichLamViec> lichLamViecs = (ArrayList<LichLamViec>) staffWSch.getWorkScheduleWithID(PanelLoginAndRegister.GlobalVariables.userId);
        ImageIcon icon = new ImageIcon("C:\\imagepj\\image\\user.png");
        for (LichLamViec lich : lichLamViecs) {
            model.addRow(new ModelWorkSchedule(icon, PanelLoginAndRegister.GlobalVariables.fullName, lich.getNgayLamViec(), lich.getMaCa()).toRowTable(eventAction));
        }
//        model.setRowCount(model.getRowCount() + 1);

    }

    public void showTable() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelBorder1 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPayment = new com.hcmute.storemanagement.views.staff_dashboard.swing.tableWorkSchedule.Table();
        jLabel2 = new javax.swing.JLabel();
        btnAdd = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();
        cbShift1 = new com.hcmute.storemanagement.views.staff_dashboard.swing.CheckBoxCustom();
        cbShift2 = new com.hcmute.storemanagement.views.staff_dashboard.swing.CheckBoxCustom();
        cbShift3 = new com.hcmute.storemanagement.views.staff_dashboard.swing.CheckBoxCustom();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDate = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1039, 657));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Register");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setOpaque(true);

        tbPayment.setBackground(new java.awt.Color(204, 204, 204));
        tbPayment.setForeground(new java.awt.Color(0, 0, 0));
        tbPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date", "Shift", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPayment.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(tbPayment);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Work Schedule");

        btnAdd.setBackground(new java.awt.Color(137, 207, 243));
        btnAdd.setForeground(new java.awt.Color(51, 51, 51));
        btnAdd.setText("Add");
        btnAdd.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        cbShift1.setForeground(new java.awt.Color(0, 0, 0));
        cbShift1.setText("ONE 8.00 - 11.30 Am");
        cbShift1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbShift2.setForeground(new java.awt.Color(0, 0, 0));
        cbShift2.setText("TWO 13:00 - 18:00 Pm");
        cbShift2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbShift3.setForeground(new java.awt.Color(0, 0, 0));
        cbShift3.setText("THREE 19:00 - 23.00 Pm");
        cbShift3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Date");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Shift");

        txtDate.setBackground(new java.awt.Color(255, 255, 255));
        txtDate.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cbShift1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbShift2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbShift3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbShift2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbShift3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbShift1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public List<Integer> checkLichTrung(List<Integer> listShif, Date ngay) {
        StaffLichLamViecService staffWSch = new StaffLichLamViecService();
        ArrayList<LichLamViec> lichLamViecs = (ArrayList<LichLamViec>) staffWSch.getWorkScheduleWithID(PanelLoginAndRegister.GlobalVariables.userId);
        List<Integer> caTrung = new ArrayList<>();

        for (LichLamViec lichLamViec : lichLamViecs) {
            if (lichLamViec.getNgayLamViec().equals(ngay) && listShif.contains(lichLamViec.getMaCa())) {
                // Ngày và ca làm việc trùng khớp
                caTrung.add(lichLamViec.getMaCa());
            }
        }
        return caTrung;
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        int demCaDuocChon = 0;
        Date currentDate = new Date();
        Date dateValue = txtDate.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String userId = PanelLoginAndRegister.GlobalVariables.userId;
        // check null
        if (dateValue != null && dateValue.before(currentDate)) {
            JOptionPane.showMessageDialog(this, "Đăng ký không thành công. Vui lòng chọn ngày sau ngày hiện tại!");
        } else if (dateValue == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày!!!");
        } else if (!cbShift1.isSelected() && !cbShift2.isSelected() && !cbShift3.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ca làm!!");
        } else {

            // Convert string qua date để lưu xuống SQL
            String formattedDate = sdf.format(dateValue);
            java.util.Date date = null;
            try {
                date = sdf.parse(formattedDate);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày phù hợp!!!");
            }
            // List lưu danh sách mã ca đưuọc chọn trên giao diện
            List<Integer> listShif = new ArrayList<>();
            if (cbShift1.isSelected()) {
                listShif.add(1);
                demCaDuocChon++;
            }
            if (cbShift2.isSelected()) {
                listShif.add(2);
                demCaDuocChon++;
            }
            if (cbShift3.isSelected()) {
                listShif.add(3);
                demCaDuocChon++;
            }

            // checktrung
            List<Integer> checkTrung = checkLichTrung(listShif, date);
            if (checkTrung == null || checkTrung.isEmpty()) {
                StaffLNgayLamViecService staffLNgayLamViecService = new StaffLNgayLamViecService();
                // Thêm ngày được chọn vào bảng nếu chưa có
                staffLNgayLamViecService.checkAndInsertNgayLamViec(date);
                // add dữ liệu vào lịch làm việc
                StaffLichLamViecService lichlamviec = new StaffLichLamViecService();
                int isInsertLich = lichlamviec.insertLichLamViec(userId, date, listShif);
                if (isInsertLich > 0) {
                    JOptionPane.showMessageDialog(this, "<html><div style='text-align: center;'>Trong " + demCaDuocChon + " ca được chọn <br/> Bạn đã thêm thành công " + isInsertLich + " ca làm việc</div></html>");
                    cbShift1.setSelected(false);
                    cbShift2.setSelected(false);
                    cbShift3.setSelected(false);
                    txtDate.setDate(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm lịch không thành công");
                }
                // Đổ dữ liệu vào lại trong bảng
                try {
                    initTablePaymentData();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDashboardWorkSchedule.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bạn đã đăng ký trùng ca " + checkTrung + " vào ngày " + formattedDate);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 btnAdd;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.CheckBoxCustom cbShift1;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.CheckBoxCustom cbShift2;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.CheckBoxCustom cbShift3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder1;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.tableWorkSchedule.Table tbPayment;
    private com.toedter.calendar.JDateChooser txtDate;
    // End of variables declaration//GEN-END:variables
}
