/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.popup;

import com.hcmute.storemanagement.DAO.StaffDao.StaffTaiKhoanDao;
import com.hcmute.storemanagement.views.dashboard.form.StaffForm;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class popupAddAccount extends javax.swing.JPanel {

    StaffTaiKhoanDao staffTaiKhoanDao = new StaffTaiKhoanDao();
    static JFrame parentFrame;
    private JFrame popupFrame;

    public popupAddAccount(JFrame parentFrame) {
        initComponents();
        String username = getUsername();
        txtUsername.setText(username);
        txtUsername.setEditable(false);
        this.parentFrame = parentFrame;
    }

    public String getUsername() {
        String username = staffTaiKhoanDao.getLatestAccountUsername();
        if (username == null) username = "TKNV001";
        if (username.matches("TKNV\\d+")) {
            int number = Integer.parseInt(username.substring(4)); // Bỏ đi "TKNV" và lấy số phía sau
            number++;
            String newNumber = String.format("%03d", number); // Định dạng lại số thành chuỗi có 3 chữ số, bắt đầu từ "001"
            username = "TKNV" + newNumber;
        }
        return username;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        panelBorder1 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        txtPass = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        jLabel1 = new javax.swing.JLabel();
        panelBorder2 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        txtCfPass = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        jLabel2 = new javax.swing.JLabel();
        panelBorder4 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jLabel4 = new javax.swing.JLabel();
        cbbRole = new javax.swing.JComboBox<>();
        btnAddStaff = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();
        panelBorder3 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        txtUsername = new com.hcmute.storemanagement.views.dashboard.swing.TextInput();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 119, 253));
        jLabel8.setText("Add Account");

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setForeground(new java.awt.Color(51, 51, 51));
        panelBorder1.setAutoscrolls(true);

        txtPass.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Password");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setForeground(new java.awt.Color(51, 51, 51));

        txtCfPass.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Confirm Password");

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(txtCfPass, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtCfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        panelBorder4.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder4.setForeground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Role");

        cbbRole.setBackground(new java.awt.Color(248, 248, 248));
        cbbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "staff" }));

        javax.swing.GroupLayout panelBorder4Layout = new javax.swing.GroupLayout(panelBorder4);
        panelBorder4.setLayout(panelBorder4Layout);
        panelBorder4Layout.setHorizontalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBorder4Layout.createSequentialGroup()
                        .addComponent(cbbRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelBorder4Layout.setVerticalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder4Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnAddStaff.setBackground(new java.awt.Color(84, 151, 252));
        btnAddStaff.setForeground(new java.awt.Color(255, 255, 255));
        btnAddStaff.setText("Continue");
        btnAddStaff.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStaffActionPerformed(evt);
            }
        });

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder3.setForeground(new java.awt.Color(51, 51, 51));
        panelBorder3.setAutoscrolls(true);

        txtUsername.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Username");

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaffActionPerformed

        String role = (String) cbbRole.getSelectedItem();
        String pass = txtPass.getText();
        String cfPass = txtCfPass.getText();
        if (pass.trim().length() > 6) {
            if (pass.equals(cfPass)) {
                openPopupAddStaff(role, pass);
            } else {
                JOptionPane.showMessageDialog(this, "Mật khẩu xác nhận không chính xác");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Độ dài mật khẩu lớn hơn 6 kí tự");
        }

    }//GEN-LAST:event_btnAddStaffActionPerformed

//    private static void openPopup(String role, String pass) {
//        JFrame popupFrame = new JFrame();
//        popupFrame.setTitle(null); // Đặt tiêu đề là null
//        popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đóng cửa sổ popup khi đóng
//        popupAddStaff popupForm = new popupAddStaff(role, pass); // Truyền role và pass vào
//        popupFrame.add(popupForm);
//        popupFrame.pack();
//        popupFrame.setLocationRelativeTo(null); // Căn giữa cửa sổ
//        popupFrame.setVisible(true);
//        parentFrame.setVisible(false);
//
//    }

    private void openPopupAddStaff(String role, String pass) {
        // tạo GRN mới 

        popupFrame = new JFrame();
        popupFrame.setTitle(null); // Đặt tiêu đề là null
        popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ngăn cửa sổ tự đóng khi nhấn "X"
        popupFrame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {
                
                parentFrame.dispose();
            }
        });
        popupAddStaff addAccount = new popupAddStaff(role, pass,popupFrame);
        popupFrame.add(addAccount);
        popupFrame.pack();
        popupFrame.setLocationRelativeTo(null);
        popupFrame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 btnAddStaff;
    private javax.swing.JComboBox<String> cbbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder1;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder2;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder3;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder4;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtCfPass;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtPass;
    private com.hcmute.storemanagement.views.dashboard.swing.TextInput txtUsername;
    // End of variables declaration//GEN-END:variables
}
