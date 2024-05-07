/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.service;

import java.text.DecimalFormat;

/**
 *
 * @author thieu
 */
public class FormatPrice {
    public String format(int price) {
        DecimalFormat df = new DecimalFormat("$#,##0");
        return df.format(price);
    }
}
