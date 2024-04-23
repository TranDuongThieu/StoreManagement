package com.hcmute.storemanagement.views.dashboard.swing.ProductTable;

import com.hcmute.storemanagement.views.dashboard.model.ModelProduct;
import com.hcmute.storemanagement.views.staff_dashboard.model.ModelBill;
import java.awt.event.ActionEvent;


public interface EventActionProduct {

    public void delete(ModelProduct student, ActionEvent e);

    public void update(ModelProduct student,  ActionEvent e);

}
