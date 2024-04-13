package com.hcmute.storemanagement.views.staff_dashboard.swing.tableWorkSchedule;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class Table extends JTable {

    public Table() {
        setOpaque(false);
        getTableHeader().setBackground(new Color(255, 255, 255));
        setBackground(new Color(0, 0, 0, 0));
        setShowHorizontalLines(true);
        setGridColor(new Color(30, 30, 30, 50));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                if (i1 == 4) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int i, int i1) {
                if (o instanceof ModelProfile) {
                    System.out.println(".profile()");
                    ModelProfile data = (ModelProfile) o;
                    Profile cell = new Profile(data);
                    if (selected) {
                        //cell.setBackground(new Color(239, 244, 255));
                        cell.setBackground(new Color(134,206,243));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    return cell;
                } 
                else if (o instanceof ModelAction) {
                    System.out.println(".action()");
                    ModelAction data = (ModelAction) o;
                    Action cell = new Action(data);

                    if (selected) {
                        cell.setBackground(new Color(134,206,243));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    return cell;
                }
                else {
                    System.out.println("Else");
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, i, i1);
                    setBorder(noFocusBorder);
//                    com.setForeground(new Color(102, 102, 102, 102));
//                    JLabel label = new JLabel(o + "");
//                    label.setForeground(new Color(102, 102, 102));
                    if (selected) {
                        com.setBackground(new Color(134,206,243));
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
        if (col == 3) {
            return new TableCellAction();
        } else {
            return super.getCellEditor(row, col);
        }
    }

    public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addRow(row);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setOpaque(false);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }
    
}