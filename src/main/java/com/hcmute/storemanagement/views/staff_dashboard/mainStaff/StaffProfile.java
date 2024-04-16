/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.staff_dashboard.mainStaff;

import com.hcmute.storemanagement.models.NhanVien;
import com.hcmute.storemanagement.service.StaffNhanVienService;
import com.hcmute.storemanagement.views.authen.component.PanelLoginAndRegister;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class StaffProfile extends javax.swing.JPanel {

    StaffNhanVienService staffNhanVienService = new StaffNhanVienService();

    public StaffProfile() {
        initComponents();
        profileStaff();
    }

    private void profileStaff() {
        NhanVien nhanVien = staffNhanVienService.getStaffById(String.valueOf(PanelLoginAndRegister.GlobalVariables.userId));
        lbName.setText(nhanVien.getTenNhanVien());
        lbGender.setText(nhanVien.getGioiTinh());
        lbUserId.setText(String.valueOf(PanelLoginAndRegister.GlobalVariables.userId));

        btnAddress.setText(nhanVien.getDiaChi());
        btnCccd.setText(nhanVien.getCCCD());
        btnDateOfBirth.setText(String.valueOf(nhanVien.getNgaySinh()));
        btnEmail.setText(nhanVien.getEmail());
        btnPhone.setText(nhanVien.getSoDienThoai());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        panelBorder2 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jLabel11 = new javax.swing.JLabel();
        panelBorder9 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jLabel18 = new javax.swing.JLabel();
        panelBorder5 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jLabel13 = new javax.swing.JLabel();
        panelBorder14 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        txtEmail = new com.hcmute.storemanagement.views.staff_dashboard.swing.TextInput();
        panelBorder4 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jLabel12 = new javax.swing.JLabel();
        panelBorder13 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        txtName = new com.hcmute.storemanagement.views.staff_dashboard.swing.TextInput();
        panelBorder7 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jLabel15 = new javax.swing.JLabel();
        panelBorder16 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        txtAddress = new com.hcmute.storemanagement.views.staff_dashboard.swing.TextInput();
        panelBorder8 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jLabel16 = new javax.swing.JLabel();
        panelBorder17 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        txtCccd = new com.hcmute.storemanagement.views.staff_dashboard.swing.TextInput();
        panelBorder6 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jLabel14 = new javax.swing.JLabel();
        panelBorder15 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        txtPhone = new com.hcmute.storemanagement.views.staff_dashboard.swing.TextInput();
        panelBorder10 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jLabel17 = new javax.swing.JLabel();
        panelBorder18 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        txtDateOfBirth = new com.toedter.calendar.JDateChooser();
        panelBorder3 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbUserId = new javax.swing.JLabel();
        btnDateOfBirth = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnEmail = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();
        jLabel8 = new javax.swing.JLabel();
        btnPhone = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();
        btnCccd = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAddress = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();
        jLabel2 = new javax.swing.JLabel();
        panelBorder12 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        panelBorder11 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();

        setPreferredSize(new java.awt.Dimension(1039, 644));

        panelBorder1.setBackground(new java.awt.Color(227, 226, 226));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(30, 119, 253));
        jLabel11.setText("My profile");

        panelBorder9.setBackground(new java.awt.Color(221, 231, 255));

        javax.swing.GroupLayout panelBorder9Layout = new javax.swing.GroupLayout(panelBorder9);
        panelBorder9.setLayout(panelBorder9Layout);
        panelBorder9Layout.setHorizontalGroup(
            panelBorder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBorder9Layout.setVerticalGroup(
            panelBorder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\download.png")); // NOI18N
        jLabel18.setText("jLabel18");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickUpdateProfile(evt);
            }
        });

        panelBorder5.setBackground(new java.awt.Color(221, 231, 255));

        jLabel13.setBackground(new java.awt.Color(22, 22, 22));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Email");

        panelBorder14.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setForeground(new java.awt.Color(51, 51, 51));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout panelBorder14Layout = new javax.swing.GroupLayout(panelBorder14);
        panelBorder14.setLayout(panelBorder14Layout);
        panelBorder14Layout.setHorizontalGroup(
            panelBorder14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder14Layout.setVerticalGroup(
            panelBorder14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelBorder5Layout = new javax.swing.GroupLayout(panelBorder5);
        panelBorder5.setLayout(panelBorder5Layout);
        panelBorder5Layout.setHorizontalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelBorder14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder5Layout.setVerticalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBorder4.setBackground(new java.awt.Color(221, 231, 255));

        jLabel12.setBackground(new java.awt.Color(22, 22, 22));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Name");

        panelBorder13.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        txtName.setBackground(new java.awt.Color(255, 255, 255));
        txtName.setForeground(new java.awt.Color(51, 51, 51));
        txtName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout panelBorder13Layout = new javax.swing.GroupLayout(panelBorder13);
        panelBorder13.setLayout(panelBorder13Layout);
        panelBorder13Layout.setHorizontalGroup(
            panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder13Layout.createSequentialGroup()
                .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder13Layout.setVerticalGroup(
            panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelBorder4Layout = new javax.swing.GroupLayout(panelBorder4);
        panelBorder4.setLayout(panelBorder4Layout);
        panelBorder4Layout.setHorizontalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelBorder13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder4Layout.setVerticalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBorder7.setBackground(new java.awt.Color(221, 231, 255));

        jLabel15.setBackground(new java.awt.Color(22, 22, 22));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Address");

        panelBorder16.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        txtAddress.setBackground(new java.awt.Color(255, 255, 255));
        txtAddress.setForeground(new java.awt.Color(51, 51, 51));
        txtAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout panelBorder16Layout = new javax.swing.GroupLayout(panelBorder16);
        panelBorder16.setLayout(panelBorder16Layout);
        panelBorder16Layout.setHorizontalGroup(
            panelBorder16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder16Layout.setVerticalGroup(
            panelBorder16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelBorder7Layout = new javax.swing.GroupLayout(panelBorder7);
        panelBorder7.setLayout(panelBorder7Layout);
        panelBorder7Layout.setHorizontalGroup(
            panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder7Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelBorder16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder7Layout.setVerticalGroup(
            panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBorder8.setBackground(new java.awt.Color(221, 231, 255));

        jLabel16.setBackground(new java.awt.Color(22, 22, 22));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("CCCD");

        panelBorder17.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        txtCccd.setBackground(new java.awt.Color(255, 255, 255));
        txtCccd.setForeground(new java.awt.Color(51, 51, 51));
        txtCccd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout panelBorder17Layout = new javax.swing.GroupLayout(panelBorder17);
        panelBorder17.setLayout(panelBorder17Layout);
        panelBorder17Layout.setHorizontalGroup(
            panelBorder17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCccd, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder17Layout.setVerticalGroup(
            panelBorder17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtCccd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelBorder8Layout = new javax.swing.GroupLayout(panelBorder8);
        panelBorder8.setLayout(panelBorder8Layout);
        panelBorder8Layout.setHorizontalGroup(
            panelBorder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder8Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelBorder17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder8Layout.setVerticalGroup(
            panelBorder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBorder6.setBackground(new java.awt.Color(221, 231, 255));

        jLabel14.setBackground(new java.awt.Color(22, 22, 22));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Phone");

        panelBorder15.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        txtPhone.setBackground(new java.awt.Color(255, 255, 255));
        txtPhone.setForeground(new java.awt.Color(51, 51, 51));
        txtPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout panelBorder15Layout = new javax.swing.GroupLayout(panelBorder15);
        panelBorder15.setLayout(panelBorder15Layout);
        panelBorder15Layout.setHorizontalGroup(
            panelBorder15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder15Layout.setVerticalGroup(
            panelBorder15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder15Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelBorder6Layout = new javax.swing.GroupLayout(panelBorder6);
        panelBorder6.setLayout(panelBorder6Layout);
        panelBorder6Layout.setHorizontalGroup(
            panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelBorder15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder6Layout.setVerticalGroup(
            panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBorder10.setBackground(new java.awt.Color(221, 231, 255));

        jLabel17.setBackground(new java.awt.Color(22, 22, 22));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Day of birth");

        panelBorder18.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        txtDateOfBirth.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelBorder18Layout = new javax.swing.GroupLayout(panelBorder18);
        panelBorder18.setLayout(panelBorder18Layout);
        panelBorder18Layout.setHorizontalGroup(
            panelBorder18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDateOfBirth, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );
        panelBorder18Layout.setVerticalGroup(
            panelBorder18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDateOfBirth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorder10Layout = new javax.swing.GroupLayout(panelBorder10);
        panelBorder10.setLayout(panelBorder10Layout);
        panelBorder10Layout.setHorizontalGroup(
            panelBorder10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder10Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelBorder18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder10Layout.setVerticalGroup(
            panelBorder10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelBorder8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelBorder6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBorder5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(panelBorder10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelBorder7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelBorder9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder2Layout.createSequentialGroup()
                        .addComponent(panelBorder9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder2Layout.createSequentialGroup()
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelBorder7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelBorder8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBorder6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBorder10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(49, 49, 49))))
        );

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder3.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\userProfile.png")); // NOI18N

        lbName.setBackground(new java.awt.Color(22, 22, 22));
        lbName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(102, 102, 102));
        lbName.setText("Trần Văn B");

        lbGender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbGender.setForeground(new java.awt.Color(153, 153, 153));
        lbGender.setText("Nam");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Hi, Wellcom to back!!");

        lbUserId.setBackground(new java.awt.Color(22, 22, 22));
        lbUserId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbUserId.setForeground(new java.awt.Color(102, 102, 102));
        lbUserId.setText("NV001");

        btnDateOfBirth.setBackground(new java.awt.Color(75, 189, 248));
        btnDateOfBirth.setForeground(new java.awt.Color(255, 255, 255));
        btnDateOfBirth.setText("17/05/2003");
        btnDateOfBirth.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\bell.png")); // NOI18N
        jLabel6.setText("jLabel6");

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\bell.png")); // NOI18N
        jLabel7.setText("jLabel6");

        btnEmail.setBackground(new java.awt.Color(75, 189, 248));
        btnEmail.setForeground(new java.awt.Color(255, 255, 255));
        btnEmail.setText("Waytnt17523@gmail.com");
        btnEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\bell.png")); // NOI18N
        jLabel8.setText("jLabel6");

        btnPhone.setBackground(new java.awt.Color(75, 189, 248));
        btnPhone.setForeground(new java.awt.Color(255, 255, 255));
        btnPhone.setText("0329040846");
        btnPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnCccd.setBackground(new java.awt.Color(75, 189, 248));
        btnCccd.setForeground(new java.awt.Color(255, 255, 255));
        btnCccd.setText("023627728920");
        btnCccd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\bell.png")); // NOI18N
        jLabel9.setText("jLabel6");

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\bell.png")); // NOI18N
        jLabel10.setText("jLabel6");

        btnAddress.setBackground(new java.awt.Color(75, 189, 248));
        btnAddress.setForeground(new java.awt.Color(255, 255, 255));
        btnAddress.setText("Hồ Chí Minh");
        btnAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\nextbutton.png")); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickTransferData(evt);
            }
        });

        panelBorder12.setBackground(new java.awt.Color(237, 236, 236));

        javax.swing.GroupLayout panelBorder12Layout = new javax.swing.GroupLayout(panelBorder12);
        panelBorder12.setLayout(panelBorder12Layout);
        panelBorder12Layout.setHorizontalGroup(
            panelBorder12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );
        panelBorder12Layout.setVerticalGroup(
            panelBorder12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lbUserId))
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelBorder3Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(lbName)
                                        .addComponent(lbGender))))
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCccd, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelBorder12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lbName)
                        .addGap(0, 0, 0)
                        .addComponent(lbGender)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUserId)
                .addGap(27, 27, 27)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCccd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBorder11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelBorder11Layout = new javax.swing.GroupLayout(panelBorder11);
        panelBorder11.setLayout(panelBorder11Layout);
        panelBorder11Layout.setHorizontalGroup(
            panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBorder11Layout.setVerticalGroup(
            panelBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBorder11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clickTransferData(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickTransferData
        NhanVien nhanVien = staffNhanVienService.getStaffById(String.valueOf(PanelLoginAndRegister.GlobalVariables.userId));
        txtAddress.setText(nhanVien.getDiaChi());
        txtCccd.setText(nhanVien.getCCCD());
        txtDateOfBirth.setDate(nhanVien.getNgaySinh());
        txtEmail.setText(nhanVien.getEmail());
        txtName.setText(nhanVien.getTenNhanVien());
        txtPhone.setText(nhanVien.getSoDienThoai());
    }//GEN-LAST:event_clickTransferData

    private void clickUpdateProfile(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickUpdateProfile
        Date dateValue = txtDateOfBirth.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        if (dateValue != null) {
            String formattedDate = sdf.format(dateValue);
            try {
                date = sdf.parse(formattedDate);
            } catch (ParseException ex) {
                Logger.getLogger(StaffProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("Lỗi convert ngày");
        }
        // tính 18 tủi 
        // Tính toán ngày 18 tuổi tính đến từ ngày hiện tại
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -18);
        java.util.Date eighteenYearsAgo = calendar.getTime();
        // check null
        boolean check = checkNull();

        if (check == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
            return;
        } else {
            // check phone, cccd
            // check dãy số cccd và phone
            try {
                long cccd = Long.parseLong(txtCccd.getText());

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Căn cước của bạn chí được nhập giá trị số");
                return;
            }

            try {
                long phone = Long.parseLong(txtPhone.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Số điện thoại của bạn chỉ được nhập giá trị số");
                return;
            }
        }

        // check độ dài và tuổi
        if (txtCccd.getText().length() != 12) {
            JOptionPane.showMessageDialog(this, "Căn cước của bạn phải đủ 12 số");
        } else if (txtPhone.getText().length() != 10) {
            JOptionPane.showMessageDialog(this, "Số điện thoại của bạn phải đủ 10 số");
        } else if (dateValue != null && dateValue.after(eighteenYearsAgo)) {
            JOptionPane.showMessageDialog(this, "Bạn chưa đủ 18 tuổi");
        } else {
            boolean flagUpdate = staffNhanVienService.updateStaff(String.valueOf(PanelLoginAndRegister.GlobalVariables.userId), txtName.getText(), txtAddress.getText(), txtEmail.getText(), txtPhone.getText(), txtCccd.getText(), date);
            if (flagUpdate == true) {
                profileStaff();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            }
        }
    }//GEN-LAST:event_clickUpdateProfile

    private boolean checkNull() {
        if (txtAddress.getText().equals("")
                || txtCccd.getText().equals("")
                || txtDateOfBirth.getDate() == null
                || txtEmail.getText().equals("")
                || txtName.getText().equals("")
                || txtPhone.getText().equals("")) {
            return false;
        }
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 btnAddress;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 btnCccd;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 btnDateOfBirth;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 btnEmail;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 btnPhone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbUserId;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder1;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder10;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder11;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder12;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder13;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder14;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder15;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder16;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder17;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder18;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder2;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder3;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder4;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder5;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder6;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder7;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder8;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder9;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.TextInput txtAddress;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.TextInput txtCccd;
    private com.toedter.calendar.JDateChooser txtDateOfBirth;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.TextInput txtEmail;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.TextInput txtName;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.TextInput txtPhone;
    // End of variables declaration//GEN-END:variables
}
