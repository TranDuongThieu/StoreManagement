/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard;

import com.hcmute.storemanagement.views.AdminDashboard.form.StaffForm;
import com.hcmute.storemanagement.views.authen.Authen;
import com.hcmute.storemanagement.views.dashboard.event.EventMenuSelected;
import com.hcmute.storemanagement.views.dashboard.form.Form_1;
import com.hcmute.storemanagement.views.dashboard.form.Form_2;
import com.hcmute.storemanagement.views.dashboard.form.Form_3;
import com.hcmute.storemanagement.views.dashboard.form.Statistical;
import com.hcmute.storemanagement.views.staff_dashboard.mainStaff.DashBoardProductForm;
import java.awt.Color;
import javax.swing.JComponent;

/**
 *
 * @author thieu
 */
public class Dashboard extends javax.swing.JFrame {

    private Form_1 form1;
    private Form_2 form2;
    private Form_3 form3;
    private StaffDashBoardProduct staffDashboard;
    private StaffForm staffForm;

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
//        setBackground(new Color(0, 0, 0, 0));
        menu1.initMoving(Dashboard.this);
        form1 = new Form_1();
        form2 = new Form_2();
        form3 = new Form_3();
        staffForm = new StaffForm();
        staffDashboard = new StaffDashBoardProduct();
        menu1.initMoving(Dashboard.this);
        menu1.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                System.out.println(index);
                if(index == 0){
                    setForm(new Statistical());
                }
                if (index == 8) {
                    setForm(new DashBoardProductForm());
                } else if (index == 2) {
                    setForm(form2);
                } 
                else if (index == 4){
                    setForm(staffForm);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE))
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private com.hcmute.storemanagement.views.dashboard.component.Menu menu1;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder2;
    // End of variables declaration//GEN-END:variables
}
