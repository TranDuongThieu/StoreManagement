package com.hcmute.storemanagement.views.dashboard.swing.TableUser;
import javax.swing.Icon;

public class ModelProfileUser {

    public ModelProfileUser(Icon icon, String Id) {
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

    

    public ModelProfileUser() {
    }

    private Icon icon;
    private String Id;
}
