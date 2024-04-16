package com.hcmute.storemanagement.views.dashboard.swing.TableUser;

import com.hcmute.storemanagement.views.staff_dashboard.swing.ModernScrollBarUI;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustomUser extends JScrollBar {

    public ScrollBarCustomUser() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(3, 5));
        setForeground(new Color(255, 255, 255, 80));
        setUnitIncrement(20);
        setOpaque(false);
    }
}
