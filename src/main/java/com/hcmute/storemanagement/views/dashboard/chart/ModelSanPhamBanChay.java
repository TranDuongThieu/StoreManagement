/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.chart;

/**
 *
 * @author DELL
 */
public class ModelSanPhamBanChay {
    private String ProductID;
    private String ProductName;
    private int cost;
    private int quantity;

    public ModelSanPhamBanChay(String ProductID, String ProductName, int cost, int quantity) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.cost = cost;
        this.quantity = quantity;
    }

    public ModelSanPhamBanChay() {
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
