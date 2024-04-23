package com.hcmute.storemanagement.views.dashboard.swing.ProductTable;

import com.hcmute.storemanagement.views.dashboard.model.ModelProduct;

public class ModelActionProduct {

    public ModelProduct getWorkSchedule() {
        return student;
    }

    public void setWorkSchedule(ModelProduct student) {
        this.student = student;
    }

    public EventActionProduct getEvent() {
        return event;
    }

    public void setEvent(EventActionProduct event) {
        this.event = event;
    }

    public ModelActionProduct(ModelProduct student, EventActionProduct event) {
        this.student = student;
        this.event = event;
    }

    public ModelActionProduct() {
    }

    private ModelProduct student;
    private EventActionProduct event;
}
