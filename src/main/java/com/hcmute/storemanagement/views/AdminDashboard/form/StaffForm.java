package com.hcmute.storemanagement.views.AdminDashboard.form;

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
        List<ModelChartPie> list1 = new ArrayList<>();
        list1.add(new ModelChartPie("Monday", 10, new Color(4, 174, 243)));
        list1.add(new ModelChartPie("Tuesday", 150, new Color(215, 39, 250)));
        list1.add(new ModelChartPie("Wednesday", 80, new Color(44, 88, 236)));
        list1.add(new ModelChartPie("Thursday", 100, new Color(21, 202, 87)));
        list1.add(new ModelChartPie("Friday", 125, new Color(127, 63, 255)));
        list1.add(new ModelChartPie("Saturday", 80, new Color(238, 167, 35)));
        list1.add(new ModelChartPie("Sunday", 200, new Color(245, 79, 99)));
        chartPie.setModel(list1);
        //  Test data chart line
        List<ModelChartLine> list = new ArrayList<>();
        list.add(new ModelChartLine("Monday", 10));
        list.add(new ModelChartLine("Tuesday", 150));
        list.add(new ModelChartLine("Wednesday", 80));
        list.add(new ModelChartLine("Thursday", 100));
        list.add(new ModelChartLine("Friday", 125));
        list.add(new ModelChartLine("Saturday", 80));
        list.add(new ModelChartLine("Sunday", 200));
        chartLine1.setModel(list);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        chartLine1 = new com.hcmute.storemanagement.views.AdminDashboard.chart.ChartLine();
        chartPie = new com.hcmute.storemanagement.views.AdminDashboard.chart.ChartPie();
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chartLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(chartPie, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chartLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chartPie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.AdminDashboard.chart.ChartLine chartLine1;
    private com.hcmute.storemanagement.views.AdminDashboard.chart.ChartPie chartPie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane;
    private com.hcmute.storemanagement.views.AdminDashboard.swing.Table table1;
    // End of variables declaration//GEN-END:variables
}
