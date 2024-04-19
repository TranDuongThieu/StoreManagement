package com.hcmute.storemanagement.views.staff_dashboard.model.billDetailTable;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellAcBilldetail extends DefaultCellEditor {

    private ModelActionBillDetail data;

    public TableCellAcBilldetail() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (ModelActionBillDetail) o;
        ActionBilldetail cell = new ActionBilldetail(data);
        cell.setBackground(new Color(30, 30, 30, 50));
        return cell;
    }

    @Override
    public Object getCellEditorValue() {
        return data;
    }
}
