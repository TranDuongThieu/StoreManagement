package com.hcmute.storemanagement.views.dashboard.swing.ProductTable;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellAcProduct extends DefaultCellEditor {

    private ModelActionProduct data;

    public TableCellAcProduct() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (ModelActionProduct) o;
        ActionProduct cell = new ActionProduct(data);
        cell.setBackground(new Color(30, 30, 30, 50));
        return cell;
    }

    @Override
    public Object getCellEditorValue() {
        return data;
    }
}
