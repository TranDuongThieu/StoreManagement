/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.component;

import com.hcmute.storemanagement.views.dashboard.event.EventMenuSelected;
import com.hcmute.storemanagement.views.dashboard.model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author thieu
 */
public class Menu extends javax.swing.JPanel {

    private EventMenuSelected event;

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }

    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }

    private void init() {
        jLabel3.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\com\\hcmute\\storemanagement\\ultis\\icon\\logo.png"));
        listMenu1.addItem(new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("customer", "Customer", Model_Menu.MenuType.MENU));

        listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));

        listMenu1.addItem(new Model_Menu("", "Employee", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("3", "Staff", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("4", "Shift", Model_Menu.MenuType.MENU));

        listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));

        listMenu1.addItem(new Model_Menu("", "Product", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("5", "Product", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("5", "GRN", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("5", "GDN", Model_Menu.MenuType.MENU));

        listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("10", "Logout", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));

        panelMoving4.setSize(WIDTH, 0);
    }

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        panelMoving4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        panelMoving4.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listMenu1 = new com.hcmute.storemanagement.views.dashboard.swing.ListMenu<>();
        panelMoving4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        listMenu1.setBackground(new Color(0,0,0,0));

        panelMoving4.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setText("CuaHangDienTu");

        javax.swing.GroupLayout panelMoving4Layout = new javax.swing.GroupLayout(panelMoving4);
        panelMoving4.setLayout(panelMoving4Layout);
        panelMoving4Layout.setHorizontalGroup(
            panelMoving4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMoving4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMoving4Layout.setVerticalGroup(
            panelMoving4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMoving4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelMoving4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelMoving4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private com.hcmute.storemanagement.views.dashboard.swing.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelMoving4;
    // End of variables declaration//GEN-END:variables
}
