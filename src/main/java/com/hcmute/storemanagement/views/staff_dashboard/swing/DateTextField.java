/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.views.staff_dashboard.swing;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class DateTextField extends JTextField {

    public DateTextField() {
        setBorder(new LineBorder(Color.BLACK, 1, true)); // Viền đen mỏng với bo góc là 5
        setSelectionColor(new Color(220, 204, 182));
    }
    
    private final String hint = "dd-MM-yyyy"; // Thay hint thành "dd-MM-yyyy"
    private final int margin = 6; // Đặt margin là 6
    
 
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (getText().length() == 0) {
            int h = getHeight();
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            int c0 = getBackground().getRGB();
            int c1 = getForeground().getRGB();
            int m = 0xfefefefe;
            int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
            g.setColor(new Color(c2, true));
            g.drawString(hint, ins.left + margin, h / 2 + fm.getAscent() / 2 - 2); // Thêm margin vào left
        }
    }
    
     @Override
    public Insets getInsets() {
        Insets ins = super.getInsets();
        return new Insets(ins.top, ins.left + margin, ins.bottom, ins.right);
    }
    
}
