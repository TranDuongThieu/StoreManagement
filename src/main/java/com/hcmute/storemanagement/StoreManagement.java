/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.hcmute.storemanagement;

import com.hcmute.storemanagement.views.authen.Authen;
import com.hcmute.storemanagement.views.dashboard.mainAdmin.Dashboard;
import com.hcmute.storemanagement.views.staff_dashboard.mainStaff.StaffDashboard;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StoreManagement {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Dashboard().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(StoreManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
