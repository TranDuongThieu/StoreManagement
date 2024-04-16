package com.hcmute.storemanagement.views.dashboard.swing.TableUser;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class TableHeaderUser extends JLabel {

    public TableHeaderUser(String text) {
        super(text);
        setOpaque(true);
        setBackground(new Color(250, 250, 250));
        setFont(new java.awt.Font("sansserif", 1, 12));
        setForeground(new Color(102, 102, 102));
        setBorder(new EmptyBorder(10, 5, 10, 5));
    }
    
   @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(204,204,204));
        g2.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
        super.paintComponent(grphcs);
    } 
}
