package com.hcmute.storemanagement.views.dashboard.swing.GRNTable;

import com.hcmute.storemanagement.views.dashboard.model.ModelProduct;
import com.hcmute.storemanagement.views.dashboard.model.ModelGRN;

public class ModelActionGRN {

    public ModelGRN getWorkSchedule() {
        return student;
    }

    public void setWorkSchedule(ModelGRN student) {
        this.student = student;
    }

    public EventActionGRN getEvent() {
        return event;
    }

    public void setEvent(EventActionGRN event) {
        this.event = event;
    }

    public ModelActionGRN(ModelGRN student, EventActionGRN event) {
        this.student = student;
        this.event = event;
    }

    public ModelActionGRN() {
    }

    private ModelGRN student;
    private EventActionGRN event;
}
