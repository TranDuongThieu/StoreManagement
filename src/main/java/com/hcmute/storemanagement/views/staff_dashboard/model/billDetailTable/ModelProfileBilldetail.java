package com.hcmute.storemanagement.views.staff_dashboard.model.billDetailTable;
import javax.swing.Icon;

public class ModelProfileBilldetail {

    public ModelProfileBilldetail(Icon icon, String Id) {
        this.icon = icon;
        this.Id = Id;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    

    public ModelProfileBilldetail() {
    }

    private Icon icon;
    private String Id;
}
