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
import java.awt.Color;
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
    StaffLichLamViecService staffWSch = new StaffLichLamViecService();
    Object caLam = null;

    public StaffDashboardWorkSchedule() throws SQLException {
        initComponents();
        tbPayment.fixTable(jScrollPane1);
        initTablePaymentData();

    }

    private void deleterowLichLamViec(String userId, Date ngay, int maCa) throws SQLException {
        staffWSch.delete1rowLichLamViec(userId, ngay, maCa);
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
                findAllShiftWithDate();
                break;
            }
        }

    }

    public boolean updateLichLamViec(String userId, Date ngay, int ca) {
         boolean flagUpdate = staffWSch.update1rowLichLamViec(idUser, ngay, ca);
        if (ca <= 0 || ca > 3) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ca làm phù hợp");
        } else if(flagUpdate == false){
            JOptionPane.showMessageDialog(this, "Cập nhật ca làm việc không thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật ca làm việc thành công");
            return true;
        }
        return false;
    }

    private void initTablePaymentData() throws SQLException {

        EventAction eventAction = new EventAction() {
            @Override
            public void delete(ModelWorkSchedule student, ActionEvent e) {
                // Lấy vị trí hàng được chọn
                int row = tbPayment.getSelectedRow();
                // Lấy giá trị từ hàng và cột tương ứng, lấy được đối tượng object
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
                    if (tbPayment.isEditing()) {
                        tbPayment.getCellEditor().stopCellEditing();
                    }
                    deleterowLichLamViec(idUser, ngay, ca);
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDashboardWorkSchedule.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void update(ModelWorkSchedule student, ActionEvent e) {
                // Lấy vị trí hàng được chọn
                int row = tbPayment.getSelectedRow();
                // Lấy giá trị từ hàng và cột tương ứng, lấy được đối tượng object
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
                if (tbPayment.isEditing()) {
                    tbPayment.getCellEditor().stopCellEditing();
                }
                boolean flagUpdate = updateLichLamViec(idUser, ngay, ca);
                if (flagUpdate == false) {
                    tbPayment.setValueAt(caLam, row, 2);
                    // Đổi màu hàng tương ứng
                    tbPayment.addRowSelectionInterval(row, row); // Chọn hàng để thay đổi màu
                    tbPayment.setSelectionBackground(Color.RED);
                }
            }
        };
        DefaultTableModel model = (DefaultTableModel) tbPayment.getModel();
        model.setRowCount(0);
        ArrayList<LichLamViec> lichLamViecs = (ArrayList<LichLamViec>) staffWSch.getWorkScheduleWithID(PanelLoginAndRegister.GlobalVariables.userId);
        ImageIcon icon = new ImageIcon("C:\\imagepj\\image\\user.png");
        for (LichLamViec lich : lichLamViecs) {
            model.addRow(new ModelWorkSchedule(icon, PanelLoginAndRegister.GlobalVariables.fullName, lich.getNgayLamViec(), lich.getMaCa()).toRowTable(eventAction));
        }
//        model.setRowCount(model.getRowCount() + 1);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbSlotShift1 = new javax.swing.JLabel();
        lbSlotShift2 = new javax.swing.JLabel();
        lbSlotShift3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(227, 226, 226));
        setPreferredSize(new java.awt.Dimension(1039, 657));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Register");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tbPayment.setBackground(new java.awt.Color(204, 204, 204));
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
        tbPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickGetCell(evt);
            }
        });
        jScrollPane1.setViewportView(tbPayment);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
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
        jLabel3.setText("Date:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Shift:");

        txtDate.setBackground(new java.awt.Color(255, 255, 255));
        txtDate.setForeground(new java.awt.Color(51, 51, 51));
        txtDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtDatePropertyChange(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Slot:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Shift 1:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Shift 2:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Shift 3:");

        lbSlotShift1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSlotShift1.setForeground(new java.awt.Color(0, 0, 0));
        lbSlotShift1.setText("0");

        lbSlotShift2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSlotShift2.setForeground(new java.awt.Color(0, 0, 0));
        lbSlotShift2.setText("0");

        lbSlotShift3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSlotShift3.setForeground(new java.awt.Color(0, 0, 0));
        lbSlotShift3.setText("0");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(59, 59, 59)
                        .addComponent(jLabel4)
                        .addGap(34, 34, 34)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbShift3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbShift2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(cbShift1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addComponent(jLabel5)))
                        .addGap(38, 38, 38)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(lbSlotShift2))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(lbSlotShift1))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(lbSlotShift3)))))
                .addContainerGap(251, Short.MAX_VALUE))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lbSlotShift1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(cbShift1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbShift2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(lbSlotShift2)))
                        .addGap(12, 12, 12)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbShift3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(lbSlotShift3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public List<Integer> checkLichTrung(List<Integer> listShif, Date ngay) {
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
        // lấy giá trị ca đã được đăng ký 
        int soLuongCa1 = Integer.parseInt(lbSlotShift1.getText());
        int soLuongCa2 = Integer.parseInt(lbSlotShift2.getText());
        int soLuongCa3 = Integer.parseInt(lbSlotShift3.getText());

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
            // kiểm tra ca đó đủ số lựng chưa 
            int soCaDuocChon = checkSoLuong(soLuongCa1, soLuongCa2, soLuongCa3, listShif, demCaDuocChon);
            // checktrung
            List<Integer> checkTrung = checkLichTrung(listShif, date);

            // int checkSoLuongdki = staffWSch.demSoCaTheoNgay(date, listShif);
            if (checkTrung == null || checkTrung.isEmpty()) {
                StaffLNgayLamViecService staffLNgayLamViecService = new StaffLNgayLamViecService();
                // Thêm ngày được chọn vào bảng nếu chưa có
                staffLNgayLamViecService.checkAndInsertNgayLamViec(date);
                // add dữ liệu vào lịch làm việc
                StaffLichLamViecService lichlamviec = new StaffLichLamViecService();
                int isInsertLich = lichlamviec.insertLichLamViec(userId, date, listShif);
                if (isInsertLich > 0) {
                    JOptionPane.showMessageDialog(this, "<html><div style='text-align: center;'>Trong " + soCaDuocChon + " ca được chọn <br/> Bạn đã thêm thành công " + isInsertLich + " ca làm việc</div></html>");
                    clearData();
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

    private void txtDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtDatePropertyChange
        clearPartData();
        findAllShiftWithDate();

     }//GEN-LAST:event_txtDatePropertyChange

    private void clickGetCell(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickGetCell
        int row = tbPayment.rowAtPoint(evt.getPoint());
        int column = tbPayment.columnAtPoint(evt.getPoint());
        Object value = tbPayment.getValueAt(row, column);
        caLam = value;
    }//GEN-LAST:event_clickGetCell

    private void clearPartData() {
        cbShift1.setSelected(false);
        cbShift2.setSelected(false);
        cbShift3.setSelected(false);
        lbSlotShift1.setText("0");
        lbSlotShift2.setText("0");
        lbSlotShift3.setText("0");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 btnAdd;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.CheckBoxCustom cbShift1;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.CheckBoxCustom cbShift2;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.CheckBoxCustom cbShift3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSlotShift1;
    private javax.swing.JLabel lbSlotShift2;
    private javax.swing.JLabel lbSlotShift3;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder1;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.tableWorkSchedule.Table tbPayment;
    private com.toedter.calendar.JDateChooser txtDate;
    // End of variables declaration//GEN-END:variables

    private List<Integer> checkSoLuongdki(Date date) {
        List<Integer> check = staffWSch.demSoCaTheoNgay(date);
        return check;
    }

    private void clearData() {
        cbShift1.setSelected(false);
        cbShift2.setSelected(false);
        cbShift3.setSelected(false);
        txtDate.setDate(null);
        lbSlotShift1.setText("0");
        lbSlotShift2.setText("0");
        lbSlotShift3.setText("0");
    }

    private int checkSoLuong(int soLuongCa1, int soLuongCa2, int soLuongCa3, List<Integer> listShif, int demCaDuocChon) {
        if (cbShift1.isSelected() && soLuongCa1 < 5) {
            listShif.add(1);
            demCaDuocChon++;
        }
        if (cbShift2.isSelected() && soLuongCa2 < 5) {
            listShif.add(2);
            demCaDuocChon++;
        }
        if (cbShift3.isSelected() && soLuongCa3 < 5) {
            listShif.add(3);
            demCaDuocChon++;
        }
        if (cbShift1.isSelected() && soLuongCa1 >= 5) {
            JOptionPane.showMessageDialog(this, "Ca " + 1 + " đã đủ số lượng");
        } else if (cbShift2.isSelected() && soLuongCa2 >= 5) {
            JOptionPane.showMessageDialog(this, "Ca " + 2 + " đã đủ số lượng");
        } else if (cbShift3.isSelected() && soLuongCa3 >= 5) {
            JOptionPane.showMessageDialog(this, "Ca " + 3 + " đã đủ số lượng");
        } else if ((cbShift1.isSelected() && soLuongCa1 >= 5) && (cbShift2.isSelected() && soLuongCa2 >= 5)) {
            JOptionPane.showMessageDialog(this, "Ca 1 và 2 đã đủ số lượng");
        } else if (cbShift1.isSelected() && soLuongCa1 >= 5 && cbShift3.isSelected() && soLuongCa3 >= 5) {
            JOptionPane.showMessageDialog(this, "Ca 1 và 3 đã đủ số lượng");
        } else if (cbShift2.isSelected() && soLuongCa2 >= 5 && cbShift3.isSelected() && soLuongCa3 >= 5) {
            JOptionPane.showMessageDialog(this, "Ca 2 và 3 đã đủ số lượng");
        } else if (cbShift1.isSelected() && soLuongCa1 >= 5 && cbShift2.isSelected() && soLuongCa2 >= 5 && cbShift3.isSelected() && soLuongCa3 >= 5) {
            JOptionPane.showMessageDialog(this, "Ca 1, 2 và 3 đã đủ số lượng");
        }
        return demCaDuocChon;
    }

    private void findAllShiftWithDate() {
        // check so luong da dăng ky
        Date dateValue = txtDate.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        if (dateValue != null) {
            // check null
            String formattedDate = sdf.format(dateValue);
            try {
                date = sdf.parse(formattedDate);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày phù hợp!!!");
            }
            List<Integer> checDki = checkSoLuongdki(date);
            for (int i = 0; i < checDki.size(); i++) {
                Integer value = checDki.get(i);
                if (i == 0 && value > 0) {
                    lbSlotShift1.setText(String.valueOf(value));
                }
                if (i == 1 && value > 0) {
                    lbSlotShift2.setText(String.valueOf(value));
                }
                if (i == 2 && value > 0) {
                    lbSlotShift3.setText(String.valueOf(value));
                }
            }
        } else {
            System.err.println("Ngay chưa chọn");
        }
    }

}
