package com.hcmute.storemanagement.views.dashboard.swing.TableUser;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionUser extends javax.swing.JPanel {

    public ActionUser(ModelActionUser data) {
        setOpaque(true);
        initComponents();
        cmdEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent  ae) {
                data.getEvent().update(data.getWorkSchedule(), ae);
            }
        });
        cmdDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent  ae) {
                data.getEvent().delete(data.getWorkSchedule(),ae);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.setColor(new Color(30, 30, 30, 50));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdEdit = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();
        cmdDelete = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();

        setBackground(new Color(0,0,0,0)
        );

        cmdEdit.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\editTbUser.png")); // NOI18N

        cmdDelete.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\deleteTbUser.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 cmdDelete;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 cmdEdit;
    // End of variables declaration//GEN-END:variables
}
