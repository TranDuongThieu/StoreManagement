package com.hcmute.storemanagement.views.staff_dashboard.model.billDetailTable;

import com.hcmute.storemanagement.views.dashboard.swing.TableUser.*;
import com.hcmute.storemanagement.views.dashboard.Table.swing.shadow.ShadowRenderer;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class BillDetailTable extends JTable {

    private BufferedImage imageShadow;

    public BillDetailTable() {
        setRowHeight(50);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeaderUser h = new TableHeaderUser(o + "");
                if (i1 == 0 || i1 == 4) {
                    h.setHorizontalAlignment(JLabel.CENTER);
                }
                return h;
            }
        });
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent ce) {
                createShadow();
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int i, int i1) {
                if (o instanceof ModelProfileBilldetail) {
                    ModelProfileBilldetail data = (ModelProfileBilldetail) o;
                    ProfileBilldetail cell = new ProfileBilldetail(data);
                    if (selected) {
                        cell.setBackground(new Color(134, 206, 243));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    return cell;
                } else if (o instanceof ModelActionBillDetail) {
                    ModelActionBillDetail data = (ModelActionBillDetail) o;
                    ActionBilldetail cell = new ActionBilldetail(data);
                    if (selected) {
                        cell.setBackground(new Color(134, 206, 243));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    return cell;
                } else {
                    System.out.println("Else");
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, i, i1);
                    setBorder(noFocusBorder);
                    if (selected) {
                        com.setBackground(new Color(134, 206, 243));
                    } else {
                        com.setBackground(Color.WHITE);
                    }
                    return com;
                }
            }
        });
    }

    @Override
    public TableCellEditor getCellEditor(int row, int col) {
        if (col == 5) {
            return new TableCellAcBilldetail();
        } else {
            return super.getCellEditor(row, col);
        }
    }

    private void createShadow() {
        int width = getWidth();
        int height = rowHeight;
        int space = 12;
        int margin = space / 2;
        imageShadow = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imageShadow.createGraphics();
        g2.fillRect(0, 0, width - margin, height - margin);
        g2.drawImage(new ShadowRenderer(6, 0.3f, new Color(160, 160, 160)).createShadow(imageShadow), -4, -4, null);
        g2.fillRect(margin, margin, width - space, height - space);
        g2.setComposite(AlphaComposite.Clear);
        g2.fillRect(margin, margin, width - space, height - space);
        g2.dispose();
    }

    public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addRow(row);
    }

    public void removeRow(int row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.removeRow(row);
        // Remove corresponding action cell data
        // You need to implement this part based on your specific data structure
        // For example:
        // actionCellModel.remove(row);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        scroll.setVerticalScrollBar(new ScrollBarCustomUser());
        JPanel p = new JPanel();
        p.setOpaque(false);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }

}
