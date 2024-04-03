/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.views.staff_dashboard.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.LineBorder;

/**
 *
 * @author DELL
 */
public class RoundedLineBorder extends LineBorder{
    
   private int radius;

    public RoundedLineBorder(Color color, int thickness, int radius) {
        super(color, thickness);
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics g2 = g.create();
        if (g2 != null) {
            g2.setColor(lineColor);
            for (int i = 0; i < thickness; i++) {
                g2.drawRoundRect(x + i, y + i, width - i * 2 - 1, height - i * 2 - 1, radius, radius);
            }
            g2.dispose();
        }
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }
    
    
}
