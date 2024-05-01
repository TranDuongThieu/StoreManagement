/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.form;

import com.hcmute.storemanagement.controllers.WorkScheduleController;
import com.hcmute.storemanagement.models.GeneralSchedule;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GeneralScheduleForm extends javax.swing.JPanel {

    ArrayList<GeneralSchedule> listSchedule;

    class MultiLineTableCellRenderer extends JTextArea implements TableCellRenderer {

        public MultiLineTableCellRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    public GeneralScheduleForm() {
        System.out.println("reload");
        initComponents();
        tbWorkSchedule.setRowHeight(120);
        tbWorkSchedule.setDefaultRenderer(Object.class, new MultiLineTableCellRenderer());
        txtDate.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    // Get the selected date from the JDateChooser
                    Date selectedDate = txtDate.getDate();
                    if (selectedDate != null) {
                        // Use SimpleDateFormat to format the date
                        handleDateSelection(selectedDate);
                    }
                }
            }
        });
        // Set current date in txtDate
        Date currentDate = new Date();
        txtDate.setDate(currentDate);
    }

    private ArrayList<String> getDatesFromMondayToSunday(Date monday) {
        ArrayList<String> dates = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(monday);

        // Add Monday to the list
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dates.add(sdf.format(cal.getTime()));

        // Add the rest of the days until Sunday
        for (int i = 0; i < 6; i++) {
            cal.add(Calendar.DATE, 1);
            dates.add(sdf.format(cal.getTime()));
        }
        return dates;
    }

    private void handleDateSelection(Date selectedDate) {
        // Create a Calendar instance and set it to the selected date
        Calendar cal = Calendar.getInstance();
        cal.setTime(selectedDate);

        // Set the first day of the week to Monday
        cal.setFirstDayOfWeek(Calendar.MONDAY);

        // Get the week of year
        int weekOfYear = cal.get(Calendar.WEEK_OF_YEAR);

        // Set the calendar to the first day of the week (Monday)
        cal.set(Calendar.WEEK_OF_YEAR, weekOfYear);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date monday = cal.getTime();

        // Set the calendar to the last day of the week (Sunday)
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date sunday = cal.getTime();

        // Format the dates
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedMonday = sdf.format(monday);
        String formattedSunday = sdf.format(sunday);

        // Update the labels with Monday and Sunday dates
        lbDateFrom.setText(formattedMonday);
        lbDateTo.setText(formattedSunday);

        ArrayList<String> weekDates = getDatesFromMondayToSunday(monday);
        WorkScheduleController scheduleController = new WorkScheduleController();
        listSchedule = scheduleController.getScheduleFromDateToDate(formattedMonday, formattedSunday);
        for (GeneralSchedule sc : listSchedule) {
            String formatday = sdf.format(sc.getNgayLamViec());
            System.out.println(sc.getHoten() + " " + sc.getMaCa() + " " + formatday);
        }
        ArrayList<String> ca1 = new ArrayList<String>();
        ArrayList<String> ca2 = new ArrayList<String>();
        ArrayList<String> ca3 = new ArrayList<String>();
        ca1.add("Ca 1");
        ca2.add("Ca 2");
        ca3.add("Ca 3");
        for (int i = 1; i < 8; i++) {
            ca1.add("");
            ca2.add("");
            ca3.add("");
        }
        for (int i = 0; i < weekDates.size(); i++) {
            for (GeneralSchedule sc : listSchedule) {
                if (sdf.format(sc.getNgayLamViec()).equals(weekDates.get(i))) {
                    if (sc.getMaCa() == 1) {
                        ca1.set(i + 1, ca1.get(i + 1) + sc.getHoten() + " , " + "\n");
                    }
                    if (sc.getMaCa() == 2) {
                        ca2.set(i + 1, ca2.get(i + 1) + sc.getHoten() + " , " + "\n");

                    }
                    if (sc.getMaCa() == 3) {
                        ca3.set(i + 1, ca3.get(i + 1) + sc.getHoten() + " , " + "\n");

                    }
                }
            }
        }

        DefaultTableModel model = (DefaultTableModel) tbWorkSchedule.getModel();
        model.setRowCount(0);
        String[][] rowData = new String[3][];
        rowData[0] = ca1.toArray(new String[0]);
        rowData[1] = ca2.toArray(new String[0]);
        rowData[2] = ca3.toArray(new String[0]);

        for (String[] row : rowData) {
            model.addRow(row);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbWorkSchedule = new com.hcmute.storemanagement.views.dashboard.swing.Table();
        txtDate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbDateFrom = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbDateTo = new javax.swing.JLabel();
        button1 = new com.hcmute.storemanagement.views.authen.swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1103, 633));

        tbWorkSchedule.setBackground(new java.awt.Color(204, 204, 204));
        tbWorkSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy", "Chủ Nhật"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbWorkSchedule);

        txtDate.setBackground(new java.awt.Color(255, 255, 255));
        txtDate.setForeground(new java.awt.Color(51, 51, 51));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 119, 253));
        jLabel2.setText("Work Schedule");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 119, 253));
        jLabel3.setText("Date");

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("From : ");

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("To :");

        button1.setBackground(new java.awt.Color(30, 119, 253));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Export");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(lbDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(465, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(962, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(lbDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        try {
            // Create a new Excel workbook
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Schedule");

            // Add a row at the top to display the days of the week
            Row headerRow = sheet.createRow(0);
            String[] daysOfWeek = {"", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
            for (int i = 0; i < daysOfWeek.length; i++) {
                headerRow.createCell(i).setCellValue(daysOfWeek[i]);
            }

            // Iterate over the table and add data to the Excel sheet
            for (int row = 0; row < table1.getRowCount(); row++) {
                Row excelRow = sheet.createRow(row + 1); // Shift row index by 1 to accommodate header row
                for (int column = 0; column < table1.getColumnCount(); column++) {
                    Object value = table1.getValueAt(row, column);
                    if (value != null) {
                        excelRow.createCell(column).setCellValue(value.toString());
                    }
                }
            }

            String directoryPath = "schedule/";
            String fileName = "schedule_" + lbDateFrom.getText() + "-" + lbDateTo.getText() + ".xlsx";
            // Create directory if it doesn't exist
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Construct the full file path
            String filePath = directoryPath + fileName;

            // Write the workbook to the generated file name
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }

            // Close the workbook
            workbook.close();

            JOptionPane.showMessageDialog(this, "Excel file exported successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to export Excel file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.authen.swing.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDateFrom;
    private javax.swing.JLabel lbDateTo;
    private com.hcmute.storemanagement.views.dashboard.swing.Table tbWorkSchedule;
    private com.toedter.calendar.JDateChooser txtDate;
    // End of variables declaration//GEN-END:variables
}
