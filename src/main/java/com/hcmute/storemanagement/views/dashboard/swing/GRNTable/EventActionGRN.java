package com.hcmute.storemanagement.views.dashboard.swing.GRNTable;

import com.hcmute.storemanagement.views.dashboard.model.ModelProduct;
import com.hcmute.storemanagement.views.dashboard.model.ModelGRN;
import com.hcmute.storemanagement.views.staff_dashboard.model.ModelBill;
import java.awt.event.ActionEvent;


public interface EventActionGRN {

    public void delete(ModelGRN student, ActionEvent e);

    public void update(ModelGRN student,  ActionEvent e);

}
