package com.hcmute.storemanagement.views.staff_dashboard.event;


import com.hcmute.storemanagement.views.staff_dashboard.model.ModelItem;
import java.awt.Component;

public interface EventItem {

    public void itemClick(Component com, ModelItem item);
}
