package com.hcmute.storemanagement.views.dashboard.swing.TableUser;

import com.hcmute.storemanagement.views.dashboard.model.modelStaff;
import java.awt.event.ActionEvent;


public interface EventActionUser {

    public void delete(modelStaff student, ActionEvent e);

    public void update(modelStaff student,  ActionEvent e);

}