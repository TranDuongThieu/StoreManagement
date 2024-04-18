/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.model;

import java.util.Date;
import javax.swing.Icon;

/**
 *
 * @author DELL
 */
public class ModelCustomer {

    private Icon icon;
    private String idCustomer;
    private String name;
    private String phone;
    private Date dayOfBirth;

    public ModelCustomer() {
    }

    public ModelCustomer(Icon icon, String idCustomer, String name, String phone, Date dayOfBirth) {
        this.icon = icon;
        this.idCustomer = idCustomer;
        this.name = name;
        this.phone = phone;
        this.dayOfBirth = dayOfBirth;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    
}
