package com.hcmute.storemanagement.views.staff_dashboard.mainStaff;

import com.hcmute.storemanagement.views.authen.Authen;
import com.hcmute.storemanagement.views.dashboard.event.EventMenuSelected;
import com.hcmute.storemanagement.views.dashboard.popup.popupAddStaff;
import com.hcmute.storemanagement.views.staff_dashboard.form.FormHome;
import com.hcmute.storemanagement.views.staff_dashboard.model.ModelItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import org.jdesktop.animation.timing.Animator;

public class StaffDashboard extends javax.swing.JFrame {

    private FormHome home;
    private Animator animator;
    private Point animatePoint;
    private ModelItem itemSelected;
    private DashBoardProductForm staffDashboardProduct;
    private StaffDashBoardPhoneForm staffDashboardPhone;

    public StaffDashboard() throws SQLException {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        staffDashboardProduct = new DashBoardProductForm();
        staffDashboardPhone = new StaffDashBoardPhoneForm();
        menu_staff1.initMoving(StaffDashboard.this);
        menu_staff1.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 1){
                    setForm(staffDashboardProduct);
                }
                if (index == 2){
                    setForm(new StaffDashBoardPhoneForm());
                }
                if (index == 12){
                        setForm(new StaffProfile());
                   
                }
                if (index == 13){
                    try {
                        setForm(new StaffDashboardWorkSchedule());
                    } catch (SQLException ex) {
                        Logger.getLogger(StaffDashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if (index == 15) {
                    dispose();
                    new Authen().setVisible(true);
                }
            }
        });
    }
   
     private void setForm(JComponent com) {
        mainPanelStaff.removeAll();
        mainPanelStaff.add(com);
        mainPanelStaff.repaint();
        mainPanelStaff.revalidate();
    }

    private Point getLocationOf(Component com) {
        Point p = home.getPanelItemLocation();
        int x = p.x;
        int y = p.y;
        int itemX = com.getX();
        int itemY = com.getY();
        int left = 10;
        int top = 35;
        return new Point(x + itemX + left, y + itemY + top);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        mainPanelStaff = new javax.swing.JPanel();
        menu_staff1 = new com.hcmute.storemanagement.views.staff_dashboard.component.Menu_staff();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(237, 236, 236));
        panelBorder1.setPreferredSize(new java.awt.Dimension(1280, 657));

        mainPanelStaff.setBackground(new java.awt.Color(237, 236, 236));
        mainPanelStaff.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu_staff1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanelStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 1077, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu_staff1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanelStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 1253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StaffDashboard().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanelStaff;
    private com.hcmute.storemanagement.views.staff_dashboard.component.Menu_staff menu_staff1;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
