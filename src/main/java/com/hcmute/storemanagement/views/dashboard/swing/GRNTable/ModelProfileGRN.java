package com.hcmute.storemanagement.views.dashboard.swing.GRNTable;
import javax.swing.Icon;

public class ModelProfileGRN {

    public ModelProfileGRN(Icon icon, String Id) {
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

    

    public ModelProfileGRN() {
    }

    private Icon icon;
    private String Id;
}
