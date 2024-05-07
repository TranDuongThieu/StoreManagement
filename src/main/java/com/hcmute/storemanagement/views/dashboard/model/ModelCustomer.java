/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.model;

import com.hcmute.storemanagement.service.FormatPrice;
import com.hcmute.storemanagement.views.dashboard.swing.TableUser.EventActionUser;
import com.hcmute.storemanagement.views.dashboard.swing.TableUser.ModelActionUser;
import com.hcmute.storemanagement.views.dashboard.swing.TableUser.ModelProfileUser;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.Icon;

/**
 *
 * @author DELL
 */
public class ModelCustomer {

    private String idCustomer;
    private String name;
    private String phone;
    private int point;
    private int numberOfBill;
    private int totalCost;
    private Icon icon;

    public ModelCustomer() {
    }

    public ModelCustomer(Icon icon, String idCustomer, String name, String phone, int point, int numberOfBill, int totalCost) {
        this.icon = icon;
        this.idCustomer = idCustomer;
        this.name = name;
        this.phone = phone;
        this.point = point;
        this.numberOfBill = numberOfBill;
        this.totalCost = totalCost;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Object[] toRowTable() {
            FormatPrice format = new FormatPrice();

        return new Object[]{new ModelProfileUser(icon, idCustomer), name, phone, point, numberOfBill, format.format(totalCost)};
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getNumberOfBill() {
        return numberOfBill;
    }

    public void setNumberOfBill(int numberOfBill) {
        this.numberOfBill = numberOfBill;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
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
}
