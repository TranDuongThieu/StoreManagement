package com.hcmute.storemanagement.views.dashboard.form;

import com.hcmute.storemanagement.views.AdminDashboard.chart.ModelChartLine;
import com.hcmute.storemanagement.views.AdminDashboard.chart.ModelChartPie;
import com.raven.model.ModelStaff;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class StaffForm extends javax.swing.JPanel {

    public StaffForm() {
        initComponents();
        initData();
    }

    private void initData() {
        //  Test Data table
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            String status;
            int ran = r.nextInt(3);
            if (ran == 0) {
                status = "Pending";
            } else if (ran == 1) {
                status = "Approved";
            } else {
                status = "Cancel";
            }
            model.addRow(new ModelStaff(new ImageIcon(), "Mr Raven", "Male", "raven_programming@gmail.com", status).toDataTable());
        }
        table1.fixTable(jScrollPane);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        table1 = new com.hcmute.storemanagement.views.AdminDashboard.swing.Table();

        setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(66, 66, 66));
        jLabel1.setText("List Staff");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Profile", "Name", "Gender", "Email", "Status"
            }
        ));
        jScrollPane.setViewportView(table1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane;
    private com.hcmute.storemanagement.views.AdminDashboard.swing.Table table1;
    // End of variables declaration//GEN-END:variables
}
