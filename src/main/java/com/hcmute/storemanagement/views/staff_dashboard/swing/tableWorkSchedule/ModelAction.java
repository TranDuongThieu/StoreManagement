package com.hcmute.storemanagement.views.staff_dashboard.swing.tableWorkSchedule;

import com.hcmute.storemanagement.views.staff_dashboard.model.ModelWorkSchedule;


public class ModelAction {

    public ModelWorkSchedule getWorkSchedule() {
        return student;
    }

    public void setWorkSchedule(ModelWorkSchedule student) {
        this.student = student;
    }

    public EventAction getEvent() {
        return event;
    }

    public void setEvent(EventAction event) {
        this.event = event;
    }

    public ModelAction(ModelWorkSchedule student, EventAction event) {
        this.student = student;
        this.event = event;
    }

    public ModelAction() {
    }

    private ModelWorkSchedule student;
    private EventAction event;
}
