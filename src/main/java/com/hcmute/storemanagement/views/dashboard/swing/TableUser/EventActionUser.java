package com.hcmute.storemanagement.views.dashboard.swing.TableUser;

import com.hcmute.storemanagement.views.dashboard.model.modelUser;
import java.awt.event.ActionEvent;


public interface EventActionUser {

    public void delete(modelUser student, ActionEvent e);

    public void update(modelUser student,  ActionEvent e);

}
