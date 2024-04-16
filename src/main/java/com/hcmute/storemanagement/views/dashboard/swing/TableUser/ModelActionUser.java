package com.hcmute.storemanagement.views.dashboard.swing.TableUser;

import com.hcmute.storemanagement.views.dashboard.model.modelUser;


public class ModelActionUser {

    public modelUser getWorkSchedule() {
        return student;
    }

    public void setWorkSchedule(modelUser student) {
        this.student = student;
    }

    public EventActionUser getEvent() {
        return event;
    }

    public void setEvent(EventActionUser event) {
        this.event = event;
    }

    public ModelActionUser(modelUser student, EventActionUser event) {
        this.student = student;
        this.event = event;
    }

    public ModelActionUser() {
    }

    private modelUser student;
    private EventActionUser event;
}
