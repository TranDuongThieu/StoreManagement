package com.hcmute.storemanagement.views.dashboard.swing;

import com.hcmute.storemanagement.views.dashboard.swing.*;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TextInput extends JTextField {

    public TextInput() {
        // Tạo viền đen độ dày 15 pixel
        LineBorder border = new LineBorder(Color.BLACK, 1, true);
        // Tạo viền bo góc
        LineBorder cornerBorder = new LineBorder(Color.BLACK, 0, true); // 0 để không có viền đen, chỉ bo góc

        // Kết hợp cả hai viền thành một
        CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(border, cornerBorder);
        setBorder(compoundBorder);

        setSelectionColor(new Color(220, 204, 182));
    }
    private final String hint = "";

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
            g.drawString(hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }
    }
}
