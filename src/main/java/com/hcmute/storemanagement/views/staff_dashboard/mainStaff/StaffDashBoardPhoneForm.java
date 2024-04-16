/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.staff_dashboard.mainStaff;

import com.hcmute.storemanagement.views.staff_dashboard.event.EventItem;
import com.hcmute.storemanagement.views.staff_dashboard.form.FormHome;
import com.hcmute.storemanagement.views.staff_dashboard.model.ModelItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.ImageIcon;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

/**
 *
 * @author DELL
 */
public class StaffDashBoardPhoneForm extends javax.swing.JPanel {

    private FormHome formHome;
    private Animator animator;
    private Point animatePoint;
    private ModelItem itemSelected;

    public StaffDashBoardPhoneForm() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        init();
        //  Animator start form animatePoint to TagetPoint
        animator = PropertySetter.createAnimator(500, mainPanel1, "imageLocation", animatePoint, mainPanel1.getTargetLocation());
        animator.addTarget(new PropertySetter(mainPanel1, "imageSize", new Dimension(180, 120), mainPanel1.getTargetSize()));
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void end() {
                mainPanel1.setImageOld(null);
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
    }

    private void init() {
        formHome = new FormHome();
        mainPanel1.setLayout(new BorderLayout());
        mainPanel1.add(formHome);
        testData();
    }

    private void testData() {
        formHome.setEvent(new EventItem() {
            @Override
            public void itemClick(Component com, ModelItem item) {
                if (itemSelected != null) {
                    mainPanel1.setImageOld(itemSelected.getImage());
                }
                if (itemSelected != item) {
                    if (!animator.isRunning()) {
                        itemSelected = item;
                        animatePoint = getLocationOf(com);
                        mainPanel1.setImage(item.getImage());
                        mainPanel1.setImageLocation(animatePoint);
                        mainPanel1.setImageSize(new Dimension(180, 120));
                        mainPanel1.repaint();
                        formHome.setSelected(com);
             //           formHome.showItem(item);
                        animator.start();
                    }
                }
            }
        });

        int ID = 1;
        for (int i = 0; i <= 5; i++) {

        //formHome.addItem(new ModelItem("1", "Iphone 15", "This product is excluded from all promotional discounts and offers.", "12 tháng", 160, new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\com\\hcmute\\storemanagement\\ultis\\image\\Iphone15.png"), 100, 1000));
        }
    }

    private Point getLocationOf(Component com) {
        Point p = formHome.getPanelItemLocation();
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

        background1 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Background();
        mainPanel1 = new com.hcmute.storemanagement.views.staff_dashboard.swing.MainPanel();

        setPreferredSize(new java.awt.Dimension(1050, 683));

        background1.setPreferredSize(new java.awt.Dimension(1050, 683));

        mainPanel1.setPreferredSize(new java.awt.Dimension(1093, 683));

        javax.swing.GroupLayout mainPanel1Layout = new javax.swing.GroupLayout(mainPanel1);
        mainPanel1.setLayout(mainPanel1Layout);
        mainPanel1Layout.setHorizontalGroup(
            mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1093, Short.MAX_VALUE)
        );
        mainPanel1Layout.setVerticalGroup(
            mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addComponent(mainPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, 1093, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Background background1;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.MainPanel mainPanel1;
    // End of variables declaration//GEN-END:variables
}
