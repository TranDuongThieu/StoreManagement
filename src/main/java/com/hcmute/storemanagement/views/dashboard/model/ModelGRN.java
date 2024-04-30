/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.model;

import com.hcmute.storemanagement.views.dashboard.swing.GRNTable.EventActionGRN;
import com.hcmute.storemanagement.views.dashboard.swing.GRNTable.ModelActionGRN;
import com.hcmute.storemanagement.views.dashboard.swing.GRNTable.ModelProfileGRN;
import com.hcmute.storemanagement.views.dashboard.swing.ProductTable.EventActionProduct;
import java.text.DecimalFormat;
import javax.swing.Icon;

/**
 *
 * @author DELL
 */
public class ModelGRN {
    private Icon icon;
    private String GRNId;
    private String ProductId;
    private String ProductName;
    private int Quantity;    

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getGRNId() {
        return GRNId;
    }

    public void setGRNId(String GRNId) {
        this.GRNId = GRNId;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String ProductId) {
        this.ProductId = ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public ModelGRN(Icon icon, String GRNId, String ProductId, String ProductName, int Quantity) {
        this.icon = icon;
        this.GRNId = GRNId;
        this.ProductId = ProductId;
        this.ProductName = ProductName;
        this.Quantity = Quantity;
    }

    public ModelGRN() {
    }
    
     public Object[] toRowTable(EventActionGRN event) {
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        return new Object[]{new ModelProfileGRN(icon, GRNId), ProductId, ProductName, Quantity, new ModelActionGRN(this, event)};
    }

    
}
