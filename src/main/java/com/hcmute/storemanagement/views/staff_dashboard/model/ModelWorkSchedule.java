package com.hcmute.storemanagement.views.staff_dashboard.model;


import com.hcmute.storemanagement.views.staff_dashboard.swing.tableWorkSchedule.EventAction;
import com.hcmute.storemanagement.views.staff_dashboard.swing.tableWorkSchedule.ModelAction;
import com.hcmute.storemanagement.views.staff_dashboard.swing.tableWorkSchedule.ModelProfile;
import java.text.DecimalFormat;
import javax.swing.Icon;

public class ModelWorkSchedule {

    public ModelWorkSchedule(Icon icon, String name, String date, int shift) {
        this.icon = icon;
        this.name = name;
        this.date = date;
        this.shift = shift;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

   
 
    
    public ModelWorkSchedule() {
    }

    private Icon icon;
    private String name;
    private String date;
    private int shift;

    public Object[] toRowTable(EventAction event) {
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        return new Object[]{new ModelProfile(icon, name), date, shift, new ModelAction(this, event)};
    }
}
