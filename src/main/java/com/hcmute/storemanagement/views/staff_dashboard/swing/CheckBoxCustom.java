/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.views.staff_dashboard.swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JCheckBox;

public class CheckBoxCustom extends JCheckBox {
    
    private final int border = 5; // Đổi giá trị bo góc thành 5

    public CheckBoxCustom() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(false);
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int ly = (getHeight() - 16) / 2;
        if (isSelected()) {
            if (isEnabled()) {
                g2.setColor(getBackground());
            } else {
                g2.setColor(Color.GREEN);
            }
            g2.fillRoundRect(1, ly, 16, 16, border, border);
            //  Draw Check icon
            int px[] = {4, 8, 14, 12, 8, 6};
            int py[] = {ly + 8, ly + 14, ly + 5, ly + 3, ly + 10, ly + 6};
            g2.setColor(new Color(0x0A6923));
            g2.fillPolygon(px, py, px.length);
        } else {
            g2.setColor(Color.GRAY);
            g2.fillRoundRect(1, ly, 16, 16, border, border);
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(2, ly + 1, 14, 14, border, border);
        }
        g2.dispose();
    }
    
}