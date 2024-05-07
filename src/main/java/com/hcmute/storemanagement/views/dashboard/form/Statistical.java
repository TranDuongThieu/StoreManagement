/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.form;

import com.hcmute.storemanagement.DAO.StaffDao.AdminDonNhapHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.IAdminDonNhapHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.IStaffDonHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.IStaffSanPhamDao;
import com.hcmute.storemanagement.DAO.StaffDao.StaffDonHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.StaffSanPhamDao;
import com.hcmute.storemanagement.views.dashboard.chart.ModelSanPhamBanChay;
import com.raven.chart.ModelChart;
import java.awt.Color;
import java.time.Year;

/**
 *
 * @author DELL
 */
public class Statistical extends javax.swing.JPanel {

    IStaffDonHangDao staffDonHangDao = new StaffDonHangDao();
    IAdminDonNhapHangDao adminDonNhapHangDao = new AdminDonNhapHangDao();
    IStaffSanPhamDao sanPhamDao = new StaffSanPhamDao();

    public Statistical() {
        initComponents();
        setOpaque(false);
        init();
    }

    private void init() {

        tbRevenue.addLegend("Income", new Color(12, 84, 175), new Color(104, 49, 200));
        tbRevenue.addLegend("Purchase", new Color(186, 37, 37), new Color(241, 100, 120));
        int currentYear = Year.now().getValue();
        for (int month = 1; month <= 12; month++) {
            int totalRevenue = staffDonHangDao.getTotalRevenueByMonthAndYear(month, currentYear);
            int totalPurchase = adminDonNhapHangDao.getTotalAmountByMonthAndYear(month, currentYear);
            if (month == 1) {
                tbRevenue.addData(new ModelChart("January", new double[]{totalRevenue, totalPurchase}));
            }
            if (month == 2) {
                tbRevenue.addData(new ModelChart("February", new double[]{totalRevenue, totalPurchase}));
            }
            if (month == 3) {
                tbRevenue.addData(new ModelChart("March", new double[]{totalRevenue, totalPurchase}));
            }
            if (month == 4) {
                tbRevenue.addData(new ModelChart("April", new double[]{totalRevenue, totalPurchase}));
            }
            if (month == 5) {
                tbRevenue.addData(new ModelChart("May", new double[]{totalRevenue, totalPurchase}));
            }
            if (month == 6) {
                tbRevenue.addData(new ModelChart("June", new double[]{totalRevenue, totalPurchase}));
            }
            if (month == 7) {
                tbRevenue.addData(new ModelChart("July", new double[]{totalRevenue, totalPurchase}));
            }
            if (month == 8) {
                tbRevenue.addData(new ModelChart("August", new double[]{totalRevenue, totalPurchase}));
            }
            if (month == 9) {
                tbRevenue.addData(new ModelChart("September", new double[]{totalRevenue, totalPurchase}));
            }
            if (month == 10) {
                tbRevenue.addData(new ModelChart("October", new double[]{totalRevenue, totalPurchase}));
            }
            if (month == 11) {
                tbRevenue.addData(new ModelChart("November", new double[]{totalRevenue, totalPurchase}));
            }
            if (month == 12) {
                tbRevenue.addData(new ModelChart("December", new double[]{totalRevenue, totalPurchase}));
            }
            tbRevenue.start();

        }

        ModelSanPhamBanChay spbc = null;
        int[] totals = new int[12];
        String[] namePr = new String[12];
        for (int i = 0; i < 12; i++) {
            spbc = sanPhamDao.getTotalMaxOfProduct(i + 1, currentYear);
            if (spbc != null) {
                totals[i] = spbc.getQuantity() * spbc.getCost();
                namePr[i] = spbc.getProductName();
            } else {
                totals[i] = 0;
                spbc = new ModelSanPhamBanChay();
                namePr[i]="";
            }
            System.err.println("name:" + spbc.getProductName());
        }
        
        tbSPBC.addLegend("Best-selling product of the month", new Color(12, 84, 175), new Color(0, 108, 247));
        
        tbSPBC.addData(new ModelChart("January ("+namePr[0]+")", new double[]{totals[0]}));
        tbSPBC.addData(new ModelChart("February ("+namePr[1]+")", new double[]{totals[1]}));
        tbSPBC.addData(new ModelChart("March ("+namePr[2]+")", new double[]{totals[2]}));
        tbSPBC.addData(new ModelChart("April ("+namePr[3]+")", new double[]{totals[3]}));
        tbSPBC.addData(new ModelChart("May ("+namePr[4]+")", new double[]{totals[4]}));
        tbSPBC.addData(new ModelChart("June ("+namePr[5]+")", new double[]{totals[5]}));
        tbSPBC.addData(new ModelChart("July ("+namePr[6]+")", new double[]{totals[6]}));
        tbSPBC.addData(new ModelChart("August ("+namePr[7]+")", new double[]{totals[7]}));
        tbSPBC.addData(new ModelChart("September ("+namePr[8]+")", new double[]{totals[8]}));
        tbSPBC.addData(new ModelChart("October ("+namePr[9]+")", new double[]{totals[9]}));
        tbSPBC.addData(new ModelChart("November ("+namePr[10]+")", new double[]{totals[10]}));
        tbSPBC.addData(new ModelChart("December ("+namePr[11]+")", new double[]{totals[11]}));
        tbSPBC.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn1 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        tbRevenue = new com.hcmute.storemanagement.views.dashboard.chart.Chart();
        tbSPBC = new com.hcmute.storemanagement.views.dashboard.chart.LineChart();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1076, 639));

        pn1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn1Layout = new javax.swing.GroupLayout(pn1);
        pn1.setLayout(pn1Layout);
        pn1Layout.setHorizontalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbRevenue, javax.swing.GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
                    .addComponent(tbSPBC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn1Layout.setVerticalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbSPBC, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(tbRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder pn1;
    private com.hcmute.storemanagement.views.dashboard.chart.Chart tbRevenue;
    private com.hcmute.storemanagement.views.dashboard.chart.LineChart tbSPBC;
    // End of variables declaration//GEN-END:variables

}
