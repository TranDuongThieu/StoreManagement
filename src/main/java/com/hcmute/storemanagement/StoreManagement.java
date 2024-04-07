/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.hcmute.storemanagement;

import com.hcmute.storemanagement.views.authen.Authen;
import com.hcmute.storemanagement.views.dashboard.mainAdmin.Dashboard;
import com.hcmute.storemanagement.views.staff_dashboard.mainStaff.StaffDashboard;


public class StoreManagement {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffDashboard().setVisible(true);
            }
        });
    }
}
