package com.hcmute.storemanagement.views.staff_dashboard.swing.tableWorkSchedule;

import com.hcmute.storemanagement.views.staff_dashboard.model.ModelWorkSchedule;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public interface EventAction {

    public void delete(ModelWorkSchedule student, ActionEvent e);

    public void update(ModelWorkSchedule student,  ActionEvent e);

}
