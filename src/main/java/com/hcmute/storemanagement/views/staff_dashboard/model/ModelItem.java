package com.hcmute.storemanagement.views.staff_dashboard.model;

import javax.swing.Icon;

public class ModelItem {

  
    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGuarantee() {
        return Guarantee;
    }

    public void setGuarantee(String Guarantee) {
        this.Guarantee = Guarantee;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(int warehouse) {
        this.warehouse = warehouse;
    }

    
    
    
    public ModelItem(String itemID, String itemName, String description, String Guarantee, double price, Icon image, int sold, int warehouse) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.description = description;
        this.Guarantee = Guarantee;
        this.price = price;
        this.image = image;
        this.sold = sold;
        this.warehouse = warehouse;
    }

    

    public ModelItem() {
    }

    private String itemID;
    private String itemName;
    private String description;
    private String Guarantee;
    private double price;
    private Icon image;
    private int sold;
    private int warehouse;
}
