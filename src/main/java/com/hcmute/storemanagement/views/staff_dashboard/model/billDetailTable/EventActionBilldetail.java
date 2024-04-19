package com.hcmute.storemanagement.views.staff_dashboard.model.billDetailTable;

import com.hcmute.storemanagement.views.staff_dashboard.model.ModelBill;
import java.awt.event.ActionEvent;


public interface EventActionBilldetail {

    public void delete(ModelBill student, ActionEvent e);

    public void update(ModelBill student,  ActionEvent e);

}
