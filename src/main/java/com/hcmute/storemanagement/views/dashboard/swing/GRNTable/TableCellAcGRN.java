package com.hcmute.storemanagement.views.dashboard.swing.GRNTable;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellAcGRN extends DefaultCellEditor {

    private ModelActionGRN data;

    public TableCellAcGRN() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (ModelActionGRN) o;
        ActionGRN cell = new ActionGRN(data);
        cell.setBackground(new Color(30, 30, 30, 50));
        return cell;
    }

    @Override
    public Object getCellEditorValue() {
        return data;
    }
}
