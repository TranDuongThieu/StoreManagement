package com.hcmute.storemanagement.views.dashboard.form;

import com.hcmute.storemanagement.controllers.Staff.StaffController;
import com.hcmute.storemanagement.models.NhanVien;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class StaffForm extends javax.swing.JPanel {

    public StaffForm() {
        initComponents();
        initData();
    }

    private void initData() {
        //  Test Data table
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        StaffController staffController = new StaffController();
      
//            model.addRow(new ModelStaff(new ImageIcon(), "Mr Raven", "Male", "raven_programming@gmail.com", status).toDataTable());
        ArrayList<NhanVien> staffList = staffController.getAllStaff();
        for (NhanVien staff : staffList)
            model.addRow(staff.toDataTable());
        
        table1.fixTable(jScrollPane);
//        List<ModelChartPie> list1 = new ArrayList<>();
//        list1.add(new ModelChartPie("Monday", 10, new Color(4, 174, 243)));
//        list1.add(new ModelChartPie("Tuesday", 150, new Color(215, 39, 250)));
//        list1.add(new ModelChartPie("Wednesday", 80, new Color(44, 88, 236)));
//        list1.add(new ModelChartPie("Thursday", 100, new Color(21, 202, 87)));
//        list1.add(new ModelChartPie("Friday", 125, new Color(127, 63, 255)));
//        list1.add(new ModelChartPie("Saturday", 80, new Color(238, 167, 35)));
//        list1.add(new ModelChartPie("Sunday", 200, new Color(245, 79, 99)));
////        chartPie.setModel(list1);
//        //  Test data chart line
//        List<ModelChartLine> list = new ArrayList<>();
//        list.add(new ModelChartLine("Monday", 10));
//        list.add(new ModelChartLine("Tuesday", 150));
//        list.add(new ModelChartLine("Wednesday", 80));
//        list.add(new ModelChartLine("Thursday", 100));
//        list.add(new ModelChartLine("Friday", 125));
//        list.add(new ModelChartLine("Saturday", 80));
//        list.add(new ModelChartLine("Sunday", 200));
//        chartLine1.setModel(list);
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
                "ID", "Họ Và Tên", "Ngày Sinh", "Giới Tính", "CCCD", "Số Điện Thoại", "Email", "Địa Chỉ"
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
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane;
    private com.hcmute.storemanagement.views.dashboard.Table.swing.Table table1;
    // End of variables declaration//GEN-END:variables
}
