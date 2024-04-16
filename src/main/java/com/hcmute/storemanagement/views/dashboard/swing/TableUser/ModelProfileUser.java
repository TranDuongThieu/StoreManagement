package com.hcmute.storemanagement.views.dashboard.swing.TableUser;
import javax.swing.Icon;

public class ModelProfileUser {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelProfileUser(Icon icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public ModelProfileUser() {
    }

    private Icon icon;
    private String name;
}
