/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.views.staff_dashboard.model;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;
import com.hcmute.storemanagement.views.staff_dashboard.model.billDetailTable.EventActionBilldetail;
import com.hcmute.storemanagement.views.staff_dashboard.model.billDetailTable.ModelActionBillDetail;
import com.hcmute.storemanagement.views.staff_dashboard.model.billDetailTable.ModelProfileBilldetail;
import com.hcmute.storemanagement.views.staff_dashboard.swing.workScheduleTable.EventAction;
import com.hcmute.storemanagement.views.staff_dashboard.swing.workScheduleTable.ModelAction;
import com.hcmute.storemanagement.views.staff_dashboard.swing.workScheduleTable.ModelProfile;
import java.text.DecimalFormat;
import javax.swing.Icon;
import static org.jfree.data.Range.shift;
import static org.joda.time.format.ISODateTimeFormat.date;

public class ModelBill {

    private Icon image;

    private String nameProduct;

    private String idOrder;

    private String idProduct;

    private String quantity;
    
    private int Warehouse;

    private int cost;
    
    private int sumCost;
    

    public ModelBill() {
    }

    public ModelBill(Icon image, String nameProduct, String idOrder, String idProduct, String quantity, int Warehouse, int cost, int sumCost) {
        this.image = image;
        this.nameProduct = nameProduct;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.Warehouse = Warehouse;
        this.cost = cost;
        this.sumCost = sumCost;
    }

    public int getWarehouse() {
        return Warehouse;
    }

    public void setWarehouse(int Warehouse) {
        this.Warehouse = Warehouse;
    }

    

    public int getSumCost() {
        return sumCost;
    }

    public void setSumCost(int sumCost) {
        this.sumCost = sumCost;
    }

  

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Object[] toRowTable(EventActionBilldetail event) {
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        return new Object[]{new ModelProfileBilldetail(image, nameProduct), idOrder, idProduct, quantity, Warehouse, cost,sumCost, new ModelActionBillDetail(this, event)};
    }

}
