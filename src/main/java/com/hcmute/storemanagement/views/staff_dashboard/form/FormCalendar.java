/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.staff_dashboard.form;

import com.hcmute.storemanagement.views.staff_dashboard.model.ToDay;
import com.hcmute.storemanagement.views.staff_dashboard.swing.Cell;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.SwingUtilities;

public class FormCalendar extends javax.swing.JPanel {

    private int month;
    private int year;

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

    public FormCalendar(int month, int year) {
        this.month = month;
        this.year = year;
        initComponents();
        init();
    }

    private void init() {
        lbMon.asTitle();
        lbTus.asTitle();
        lbWed.asTitle();
        lbThu.asTitle();
        lbFri.asTitle();
        lbSat.asTitle();
        lbSun.asTitle();
        setDate();
    }

    private void setDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);  //  month jan as 0 so start from 0
        calendar.set(Calendar.DATE, 1);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;  //  get day of week -1 to index
        calendar.add(Calendar.DATE, -startDay);
        ToDay toDay = getToDay();
        for (Component com : getComponents()) {
            Cell cell = (Cell) com;
            if (!cell.isTitle()) {
                cell.setText(calendar.get(Calendar.DATE) + "");
                cell.setDate(calendar.getTime());
                cell.currentMonth(calendar.get(Calendar.MONTH) == month - 1);
                if (toDay.isToDay(new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)))) {
                    cell.setAsToDay();
                }
                calendar.add(Calendar.DATE, 1); //  up 1 day
            }
        }
    }

    private ToDay getToDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSun = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        lbMon = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        lbTus = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        lbWed = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        lbThu = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        lbFri = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        lbSat = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell8 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell9 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell10 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell11 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell12 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell13 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell14 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell15 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell16 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell17 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell18 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell19 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell20 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell21 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell22 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell23 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell24 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell25 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell26 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell27 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell28 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell29 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell30 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell31 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell32 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell33 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell34 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell35 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell36 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell37 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell38 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell39 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell40 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell41 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell42 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell43 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell44 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell45 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell46 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell47 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell48 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();
        cell49 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Cell();

        setBackground(new java.awt.Color(153, 153, 153));
        setOpaque(false);
        setLayout(new java.awt.GridLayout(7, 7));

        lbSun.setForeground(new java.awt.Color(255, 51, 51));
        lbSun.setText("Sun");
        lbSun.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbSun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbSunActionPerformed(evt);
            }
        });
        add(lbSun);

        lbMon.setForeground(new java.awt.Color(0, 0, 0));
        lbMon.setText("Mon");
        lbMon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        add(lbMon);

        lbTus.setForeground(new java.awt.Color(0, 0, 0));
        lbTus.setText("Tus");
        lbTus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        add(lbTus);

        lbWed.setForeground(new java.awt.Color(0, 0, 0));
        lbWed.setText("Wed");
        lbWed.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        add(lbWed);

        lbThu.setForeground(new java.awt.Color(0, 0, 0));
        lbThu.setText("Thu");
        lbThu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        add(lbThu);

        lbFri.setForeground(new java.awt.Color(0, 0, 0));
        lbFri.setText("Fri");
        lbFri.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        add(lbFri);

        lbSat.setForeground(new java.awt.Color(0, 0, 0));
        lbSat.setText("Sat");
        lbSat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        add(lbSat);

        cell8.setForeground(new java.awt.Color(0, 0, 0));
        cell8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell8);

        cell9.setForeground(new java.awt.Color(0, 0, 0));
        cell9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell9);

        cell10.setForeground(new java.awt.Color(0, 0, 0));
        cell10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell10);

        cell11.setForeground(new java.awt.Color(0, 0, 0));
        cell11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell11);

        cell12.setForeground(new java.awt.Color(0, 0, 0));
        cell12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell12);

        cell13.setForeground(new java.awt.Color(0, 0, 0));
        cell13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell13);

        cell14.setForeground(new java.awt.Color(0, 0, 0));
        cell14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell14);

        cell15.setForeground(new java.awt.Color(0, 0, 0));
        cell15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell15);

        cell16.setForeground(new java.awt.Color(0, 0, 0));
        cell16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell16);

        cell17.setForeground(new java.awt.Color(0, 0, 0));
        cell17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell17);

        cell18.setForeground(new java.awt.Color(0, 0, 0));
        cell18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell18);

        cell19.setForeground(new java.awt.Color(0, 0, 0));
        cell19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell19);

        cell20.setForeground(new java.awt.Color(0, 0, 0));
        cell20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell20);

        cell21.setForeground(new java.awt.Color(0, 0, 0));
        cell21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell21);

        cell22.setForeground(new java.awt.Color(0, 0, 0));
        cell22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell22);

        cell23.setForeground(new java.awt.Color(0, 0, 0));
        cell23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell23);

        cell24.setForeground(new java.awt.Color(0, 0, 0));
        cell24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell24);

        cell25.setForeground(new java.awt.Color(0, 0, 0));
        cell25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell25);

        cell26.setForeground(new java.awt.Color(0, 0, 0));
        cell26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell26);

        cell27.setForeground(new java.awt.Color(0, 0, 0));
        cell27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell27);

        cell28.setForeground(new java.awt.Color(0, 0, 0));
        cell28.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell28);

        cell29.setForeground(new java.awt.Color(0, 0, 0));
        cell29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell29);

        cell30.setForeground(new java.awt.Color(0, 0, 0));
        cell30.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell30);

        cell31.setForeground(new java.awt.Color(0, 0, 0));
        cell31.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell31);

        cell32.setForeground(new java.awt.Color(0, 0, 0));
        cell32.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell32);

        cell33.setForeground(new java.awt.Color(0, 0, 0));
        cell33.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell33);

        cell34.setForeground(new java.awt.Color(0, 0, 0));
        cell34.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell34);

        cell35.setForeground(new java.awt.Color(0, 0, 0));
        cell35.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell35);

        cell36.setForeground(new java.awt.Color(0, 0, 0));
        cell36.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell36);

        cell37.setForeground(new java.awt.Color(0, 0, 0));
        cell37.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell37);

        cell38.setForeground(new java.awt.Color(0, 0, 0));
        cell38.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell38);

        cell39.setForeground(new java.awt.Color(0, 0, 0));
        cell39.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell39);

        cell40.setForeground(new java.awt.Color(0, 0, 0));
        cell40.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell40);

        cell41.setForeground(new java.awt.Color(0, 0, 0));
        cell41.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell41);

        cell42.setForeground(new java.awt.Color(0, 0, 0));
        cell42.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell42);

        cell43.setForeground(new java.awt.Color(0, 0, 0));
        cell43.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell43);

        cell44.setForeground(new java.awt.Color(0, 0, 0));
        cell44.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell44);

        cell45.setForeground(new java.awt.Color(0, 0, 0));
        cell45.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell45);

        cell46.setForeground(new java.awt.Color(0, 0, 0));
        cell46.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell46);

        cell47.setForeground(new java.awt.Color(0, 0, 0));
        cell47.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell47);

        cell48.setForeground(new java.awt.Color(0, 0, 0));
        cell48.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell48);

        cell49.setForeground(new java.awt.Color(0, 0, 0));
        cell49.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cell49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDateClick(evt);
            }
        });
        add(cell49);
    }// </editor-fold>//GEN-END:initComponents

    private void lbSunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbSunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbSunActionPerformed

    private void getDateClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getDateClick

    }//GEN-LAST:event_getDateClick


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell10;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell11;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell12;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell13;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell14;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell15;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell16;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell17;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell18;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell19;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell20;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell21;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell22;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell23;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell24;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell25;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell26;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell27;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell28;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell29;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell30;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell31;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell32;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell33;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell34;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell35;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell36;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell37;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell38;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell39;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell40;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell41;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell42;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell43;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell44;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell45;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell46;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell47;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell48;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell49;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell8;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell cell9;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell lbFri;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell lbMon;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell lbSat;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell lbSun;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell lbThu;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell lbTus;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Cell lbWed;
    // End of variables declaration//GEN-END:variables
}
