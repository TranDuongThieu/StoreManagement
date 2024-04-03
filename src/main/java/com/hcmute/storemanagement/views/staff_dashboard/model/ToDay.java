/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.views.staff_dashboard.model;


public class ToDay {

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ToDay(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public ToDay() {
    }

    private int day;
    private int month;
    private int year;

    public boolean isToDay(ToDay date) {
        return day == date.getDay() && month == date.getMonth() && year == date.getYear();
    }
}