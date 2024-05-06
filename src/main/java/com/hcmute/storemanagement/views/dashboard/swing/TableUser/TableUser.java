package com.hcmute.storemanagement.views.dashboard.swing.TableUser;

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

public class TableUser extends JTable {

    private BufferedImage imageShadow;

    public TableUser() {
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
                if (o instanceof ModelProfileUser) {
                    ModelProfileUser data = (ModelProfileUser) o;
                    ProfileUser cell = new ProfileUser(data);
                    if (selected) {
                        //cell.setBackground(new Color(239, 244, 255));
                        cell.setBackground(new Color(134, 206, 243));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    return cell;
                } else if (o instanceof ModelActionUser) {
                    ModelActionUser data = (ModelActionUser) o;
                    ActionUser cell = new ActionUser(data);

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

//    @Override
//    public Component prepareRenderer(TableCellRenderer tcr, int i, int i1) {
//        if (i1 == 0) {
//           
//            ModelProfileUser profile = (ModelProfileUser) getValueAt(i, 0);
//            Icon icon = profile.getIcon();
//            TableCell_Image cell = new TableCell_Image(icon);
//            return cell;
//        } else if (i1 == 4) {
//            TableCell_Status cell = new TableCell_Status(getValueAt(i, 4).toString());
//            return cell;
//        } else {
//            String values = "";
//            if (getValueAt(i, i1) != null) {
//                values = getValueAt(i, i1).toString();
//            }
//            TableCell cell = new TableCell(values);
//            return cell;
//        }
//    }

//    @Override
//    protected void paintComponent(Graphics grphcs) {
//        super.paintComponent(grphcs);
//        Graphics2D g2 = (Graphics2D) grphcs;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        int space = 12;
//        int margin = space / 2;
//        for (int i = 0; i < getRowCount(); i++) {
//            int row = i;
//            Rectangle r = getCellRect(row, 0, true);
//            if (isRowSelected(i)) {
//                g2.setColor(new Color(17, 164, 232));
//                g2.drawRect(margin, r.getLocation().y + margin, getWidth() - margin * 2, rowHeight - space);
//            }
//            g2.drawImage(imageShadow, 0, r.getLocation().y, null);
//            g2.setColor(new Color(255, 109, 109));
//            g2.fillRect(margin, r.getLocation().y + margin, 3, rowHeight - space);
//        }
//        g2.dispose();
//    }

    @Override
    public TableCellEditor getCellEditor(int row, int col) {
        if (col == 10) {
            return new TableCellActionUser();
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
