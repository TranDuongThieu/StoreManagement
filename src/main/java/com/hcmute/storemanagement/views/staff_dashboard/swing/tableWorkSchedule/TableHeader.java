package com.hcmute.storemanagement.views.staff_dashboard.swing.tableWorkSchedule;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class TableHeader extends JLabel {

    public TableHeader(String text) {
        super(text);
        setOpaque(true);
        setBackground(new Color(1,169,255));
        setFont(new Font("sansserif", 1, 12));
        //setForeground(new Color(102, 102, 102));
        setForeground(new Color(0, 0, 0));
        setBorder(new EmptyBorder(10, 5, 10  , 5));       
    }
    
   @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(230,230,230));
        g2.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
        super.paintComponent(grphcs);
    } 
}
