package com.hcmute.storemanagement.views.AdminDashboard.swing;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Icon;

public class TableCell_Image extends javax.swing.JPanel {

    public TableCell_Image(Icon icon) {
        initComponents();
        setOpaque(false);
//        pic.setIcon(icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(250, 250, 250));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 6, getWidth(), getHeight() - 12);
        super.paintComponent(g);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
