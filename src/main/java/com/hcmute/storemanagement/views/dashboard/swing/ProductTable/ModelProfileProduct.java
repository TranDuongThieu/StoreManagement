package com.hcmute.storemanagement.views.dashboard.swing.ProductTable;
import javax.swing.Icon;

public class ModelProfileProduct {

    public ModelProfileProduct(Icon icon, String Id) {
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

    

    public ModelProfileProduct() {
    }

    private Icon icon;
    private String Id;
}
