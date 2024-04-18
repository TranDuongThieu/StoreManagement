package com.hcmute.storemanagement.views.dashboard.swing.TableUser;

import com.hcmute.storemanagement.views.dashboard.model.modelStaff;


public class ModelActionUser {

    public modelStaff getWorkSchedule() {
        return user;
    }

    public void setWorkSchedule(modelStaff user) {
        this.user = user;
    }

    public EventActionUser getEvent() {
        return event;
    }

    public void setEvent(EventActionUser event) {
        this.event = event;
    }

    public ModelActionUser(modelStaff user, EventActionUser event) {
        this.user = user;
        this.event = event;
    }

    public ModelActionUser() {
    }

    private modelStaff user;
    private EventActionUser event;
}
