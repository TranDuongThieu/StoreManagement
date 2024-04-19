package com.hcmute.storemanagement.views.staff_dashboard.model.billDetailTable;

import com.hcmute.storemanagement.views.staff_dashboard.model.ModelBill;

public class ModelActionBillDetail {

    public ModelBill getWorkSchedule() {
        return student;
    }

    public void setWorkSchedule(ModelBill student) {
        this.student = student;
    }

    public EventActionBilldetail getEvent() {
        return event;
    }

    public void setEvent(EventActionBilldetail event) {
        this.event = event;
    }

    public ModelActionBillDetail(ModelBill student, EventActionBilldetail event) {
        this.student = student;
        this.event = event;
    }

    public ModelActionBillDetail() {
    }

    private ModelBill student;
    private EventActionBilldetail event;
}
