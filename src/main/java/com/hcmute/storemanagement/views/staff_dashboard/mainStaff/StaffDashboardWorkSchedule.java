/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.staff_dashboard.mainStaff;

import com.hcmute.storemanagement.views.staff_dashboard.model.ModelWorkSchedule;
import com.hcmute.storemanagement.views.staff_dashboard.swing.tableWorkSchedule.EventAction;
import javax.swing.ImageIcon;

public class StaffDashboardWorkSchedule extends javax.swing.JPanel {

    public StaffDashboardWorkSchedule() {
        initComponents();
        tbPayment.fixTable(jScrollPane1);
        initTablePaymentData();
    }

    private void initTablePaymentData() {

        EventAction eventAction = new EventAction() {
            @Override
            public void delete(ModelWorkSchedule student) {
                //showMessage("Delete Student : " + student.getName());
                System.out.println(".delete()");
            }

            @Override
            public void update(ModelWorkSchedule student) {
                //showMessage("Update Student : " + student.getName());
                System.out.println(".update()");
            }
        };
        String imagePath = "C:\\imagepj\\image\\user.png";
        ImageIcon icon = new ImageIcon(imagePath);
        tbPayment.addRow(new ModelWorkSchedule(icon, "Jonh", "Male",1 ).toRowTable(eventAction));
        tbPayment.addRow(new ModelWorkSchedule(icon, "Jonh", "Male",1 ).toRowTable(eventAction));
        tbPayment.addRow(new ModelWorkSchedule(icon, "Jonh", "Male",1 ).toRowTable(eventAction));
        tbPayment.addRow(new ModelWorkSchedule(icon, "Jonh", "Male",1 ).toRowTable(eventAction));
        tbPayment.addRow(new ModelWorkSchedule(icon, "Jonh", "Male",1 ).toRowTable(eventAction));
        tbPayment.addRow(new ModelWorkSchedule(icon, "Jonh", "Male",1 ).toRowTable(eventAction));
        tbPayment.addRow(new ModelWorkSchedule(icon, "Jonh", "Male",1 ).toRowTable(eventAction));
        tbPayment.addRow(new ModelWorkSchedule(icon, "Jonh", "Male",1 ).toRowTable(eventAction));
        tbPayment.addRow(new ModelWorkSchedule(icon, "Jonh", "Male",1 ).toRowTable(eventAction));        
        tbPayment.addRow(new ModelWorkSchedule(icon, "Jonh", "Male",1 ).toRowTable(eventAction));

                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calendarCustom1 = new com.hcmute.storemanagement.views.staff_dashboard.form.CalendarCustom();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPayment = new com.hcmute.storemanagement.views.staff_dashboard.swing.tableWorkSchedule.Table();
        workSchedule1 = new com.hcmute.storemanagement.views.staff_dashboard.component.workSchedule();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1039, 657));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Work Schedule");

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
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPayment.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(tbPayment);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(calendarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(workSchedule1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(calendarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(workSchedule1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.staff_dashboard.form.CalendarCustom calendarCustom1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.tableWorkSchedule.Table tbPayment;
    private com.hcmute.storemanagement.views.staff_dashboard.component.workSchedule workSchedule1;
    // End of variables declaration//GEN-END:variables
}
