/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.mainAdmin;

import com.hcmute.storemanagement.views.authen.Authen;
import com.hcmute.storemanagement.views.dashboard.event.EventMenuSelected;
import com.hcmute.storemanagement.views.dashboard.form.CustomerForm;
import com.hcmute.storemanagement.views.dashboard.form.GRNForm;
import com.hcmute.storemanagement.views.dashboard.form.GeneralScheduleForm;
import com.hcmute.storemanagement.views.dashboard.form.ProductForm;

import com.hcmute.storemanagement.views.dashboard.form.StaffForm;
import com.hcmute.storemanagement.views.dashboard.form.Statistical;
import com.hcmute.storemanagement.views.dashboard.popup.popupAddStaff;
import com.hcmute.storemanagement.views.staff_dashboard.mainStaff.DashBoardProductForm;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 *
 * @author thieu
 */
public class Dashboard extends javax.swing.JFrame {


    private DashBoardProductForm staffDashboardProduct;
    private StaffForm staffForm;
    private GeneralScheduleForm generalScheduleForm;
    private CustomerForm customerForm;

    /**
     * Creates new form Dashboard
     */
    public Dashboard() throws SQLException {
        initComponents();
//        setBackground(new Color(0, 0, 0, 0));
        menu1.initMoving(Dashboard.this);
     
        staffForm = new StaffForm();
        generalScheduleForm = new GeneralScheduleForm();
        customerForm = new CustomerForm();
        menu1.initMoving(Dashboard.this);
        menu1.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                System.out.println(index);
                if(index == 0){
                    setForm(new Statistical());
                }
                if (index == 8) {
                        setForm(new ProductForm());
                    
                } else if (index == 1) {
                    setForm(customerForm);
                } 
                else if (index == 4){
                    setForm(staffForm);
                }
                else if (index == 5) {
                    setForm(generalScheduleForm);
                }
                else if (index == 9) {
                    setForm(new GRNForm());
                }
                else if (index == 12) {
                    dispose();
                    new Authen().setVisible(true);
                }
            }
        });
        setForm(new Statistical());
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        mainPanel = new javax.swing.JPanel();
        menu1 = new com.hcmute.storemanagement.views.dashboard.component.Menu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Dashboard().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private com.hcmute.storemanagement.views.dashboard.component.Menu menu1;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder2;
    // End of variables declaration//GEN-END:variables
}
