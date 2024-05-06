/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.form;

import com.hcmute.storemanagement.models.DonNhapHang;
import com.hcmute.storemanagement.service.AdminDonNhapHangService;
import com.hcmute.storemanagement.service.IAdminDonNhapHangService;
import com.hcmute.storemanagement.views.dashboard.popup.popUpAddGRN;
import com.hcmute.storemanagement.views.dashboard.popup.popupGRNDetail;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class GRNForm extends javax.swing.JPanel {

    IAdminDonNhapHangService donNhapHang = new AdminDonNhapHangService();
    private JFrame popupFrame;

    public GRNForm() {
        initComponents();
        initData();
    }

    private void initData() {
        List<DonNhapHang> listDonNhapHang = donNhapHang.getAllDonNhapHang();
        DefaultTableModel model = (DefaultTableModel) tbGRN.getModel();
        model.setRowCount(0);

        for (DonNhapHang donNhap : listDonNhapHang) {
            Object[] row = new Object[4];
            row[0] = donNhap.getMaDonNhapHang(); // Product ID
            row[1] = donNhap.getNgayNhapHang(); // Product Name
            row[2] = donNhap.getTongGiaTri(); // Price
            row[3] = donNhap.getMaNhaCungCap(); // Quantity

            model.addRow(row);
        }
    }

    private void openPopup(String IdGRN, Date date) {
        JFrame popupFrame = new JFrame();
        popupFrame.setTitle(null); // Đặt tiêu đề là null
        popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đóng cửa sổ popup khi đóng
        popupFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                initData();
            }
        });
        popupGRNDetail billInfo = new popupGRNDetail(IdGRN, date);
        popupFrame.add(billInfo);
        popupFrame.pack();
        popupFrame.setLocationRelativeTo(null); // Căn giữa cửa sổ
        popupFrame.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.hcmute.storemanagement.views.dashboard.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbGRN = new com.hcmute.storemanagement.views.dashboard.swing.GRNTable.GRNTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        tbGRN.setBackground(new java.awt.Color(204, 204, 204));
        tbGRN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN ID", "Date", "Total", "Supplier ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbGRN);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 119, 253));
        jLabel1.setText("Good Receive Note");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\eye.png")); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickShowGRNDetail(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\add.png")); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickAddGRN(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1076, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clickShowGRNDetail(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickShowGRNDetail
        int rowIndex = tbGRN.getSelectedRow();
        if (rowIndex != -1) {
            Object IDGRN = tbGRN.getValueAt(rowIndex, 0);
            String IdGRN = IDGRN != null ? IDGRN.toString() : "";
            System.err.println("IDHRN: " + IdGRN);

            Object Date = tbGRN.getValueAt(rowIndex, 1);
            String dateString = Date != null ? Date.toString() : "";
            Date date = null;

            if (!dateString.isEmpty()) {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    date = dateFormat.parse(dateString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if (rowIndex != -1) {
                openPopup(IdGRN, date);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 hàng trong bảng");
        }
    }//GEN-LAST:event_clickShowGRNDetail

    private void clickAddGRN(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickAddGRN
        openPUAddGRN();
    }//GEN-LAST:event_clickAddGRN

    private void openPUAddGRN() {
        // tạo GRN mới 
        popupFrame = new JFrame();
        popupFrame.setTitle(null); // Đặt tiêu đề là null
        popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ngăn cửa sổ tự đóng khi nhấn "X"
        popupFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(popupFrame, "Bạn chưa hoàn thành đơn nhập hàng, bạn có chắc chắn muốn thoát không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    popupFrame.dispose();
                    donNhapHang.deleteDonNhapHang(String.valueOf(popUpAddGRN.GRNID));

                }
//                if (!popUpAddGRN.GRNID.equals("")) {
//                    donNhapHang.deleteDonNhapHang(String.valueOf(popUpAddGRN.GRNID));
//                }
            }

            @Override
            public void windowClosed(WindowEvent e) {
                initData();
            }
        });

        popUpAddGRN billInfo = new popUpAddGRN(popupFrame);
        popupFrame.add(billInfo);
        popupFrame.pack();
        popupFrame.setLocationRelativeTo(null);
        popupFrame.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.hcmute.storemanagement.views.dashboard.swing.PanelBorder panelBorder1;
    private com.hcmute.storemanagement.views.dashboard.swing.GRNTable.GRNTable tbGRN;
    // End of variables declaration//GEN-END:variables

}
