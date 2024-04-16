/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.swing.TableUser;

import com.hcmute.storemanagement.views.dashboard.model.modelUser;
import com.hcmute.storemanagement.views.staff_dashboard.model.ModelWorkSchedule;
import com.hcmute.storemanagement.views.staff_dashboard.swing.tableWorkSchedule.EventAction;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class ad extends javax.swing.JPanel {

   
    public ad() {
        initComponents();
        initTable();
    }

    private void initTable() {
        EventActionUser eventAction = new EventActionUser() {  
            @Override
            public void delete(modelUser student, ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void update(modelUser student, ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        ImageIcon icon = new ImageIcon("C:\\imagepj\\image\\user.png");
        String dateString = "2003-5-17";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        tableUser1.addRow(new modelUser(icon, "Thuong", date, "nam", "0101010101", "Ho chi minh", "0101010101", "h@gmail.com").toRowTable(eventAction));
//        tableUser1.addRow(new modelUser(icon, "Thuong", date, "nam", "0101010101", "Ho chi minh", "0101010101", "h@gmail.com").toRowTable(eventAction));
//        tableUser1.addRow(new modelUser(icon, "Thuong", date, "nam", "0101010101", "Ho chi minh", "0101010101", "h@gmail.com").toRowTable(eventAction));
//        tableUser1.addRow(new modelUser(icon, "Thuong", date, "nam", "0101010101", "Ho chi minh", "0101010101", "h@gmail.com").toRowTable(eventAction));
//        tableUser1.addRow(new modelUser(icon, "Thuong", date, "nam", "0101010101", "Ho chi minh", "0101010101", "h@gmail.com").toRowTable(eventAction));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableUser1 = new com.hcmute.storemanagement.views.dashboard.swing.TableUser.TableUser();

        tableUser1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableUser1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private com.hcmute.storemanagement.views.dashboard.swing.TableUser.TableUser tableUser1;
    // End of variables declaration//GEN-END:variables
}
