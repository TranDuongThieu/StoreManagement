package com.hcmute.storemanagement.views.staff_dashboard.form;

import com.hcmute.storemanagement.models.ThongTinSanPham;
import com.hcmute.storemanagement.views.staff_dashboard.component.Item;
import com.hcmute.storemanagement.views.staff_dashboard.event.EventItem;
import com.hcmute.storemanagement.views.staff_dashboard.model.ModelItem;
import com.hcmute.storemanagement.views.staff_dashboard.swing.ScrollBar;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class FormHome extends javax.swing.JPanel {

    public static String valueID = "";

    public void setEvent(EventItem event) {
        this.event = event;
    }

    private EventItem event;

    public FormHome() {
        initComponents();
        scroll.setVerticalScrollBar(new ScrollBar());
    }

    public void addItem(ModelItem data) {
        Item item = new Item();
        item.setData(data);
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    event.itemClick(item, data);
                }
            }
        });
        panelItem.add(item);
        panelItem.repaint();
        panelItem.revalidate();
    }

    public void setSelected(Component item) {
        for (Component com : panelItem.getComponents()) {
            Item i = (Item) com;
            if (i.isSelected()) {
                i.setSelected(false);
            }
        }
        ((Item) item).setSelected(true);
    }

    public void showItem(ModelItem data, List<ThongTinSanPham> ttSanPham) {

        // biến lấy IDSP
        valueID = data.getItemID();

        String s = "";
        lbItemName.setText(data.getItemName());
        txtDescription.setText(data.getDescription());
        lbGuarantee.setText(data.getGuarantee());
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        lbPrice.setText(df.format(data.getPrice()));
        lbSold.setText(String.valueOf( data.getSold()));
        lbWarehouse.setText(String.valueOf(data.getWarehouse()));
        int count = 4;
        lb4.setText("");
        lb5.setText("");
        lb6.setText("");
        lb7.setText("");
        lb8.setText("");
        txtQuantity.setText("0");
        for (ThongTinSanPham thongTin : ttSanPham) {
            s = s + thongTin.getTenLoaiThongSo() + ": " + thongTin.getGiaTriThongSo();
            if (count == 4) {
                lb4.setText(s);
            }
            if (count == 5) {
                lb5.setText(s);
            }
            if (count == 6) {
                lb6.setText(s);
            }
            if (count == 7) {
                lb7.setText(s);
            }
            if (count == 8) {
                lb8.setText(s);
            }
            count++;
            s = "";
        }
    }

    public Point getPanelItemLocation() {
        Point p = scroll.getLocation();
        return new Point(p.x, p.y - scroll.getViewport().getViewPosition().y);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        panelItem = new com.hcmute.storemanagement.views.staff_dashboard.swing.PanelItem();
        jPanel1 = new javax.swing.JPanel();
        lbItemName = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();
        lbBrand = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtDescription = new javax.swing.JTextPane();
        lbWarehouse = new javax.swing.JLabel();
        lbGuarantee = new javax.swing.JLabel();
        lbSold = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        button12 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Button1();
        jPanel2 = new javax.swing.JPanel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        lb8 = new javax.swing.JLabel();
        lb7 = new javax.swing.JLabel();
        lbSum = new javax.swing.JLabel();
        lbSubstraction = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();

        setOpaque(false);

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setViewportView(panelItem);

        jPanel1.setOpaque(false);

        lbItemName.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbItemName.setForeground(new java.awt.Color(76, 76, 76));
        lbItemName.setText("Item Name");

        lbPrice.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(76, 76, 76));
        lbPrice.setText("$0.00");

        lbBrand.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbBrand.setForeground(new java.awt.Color(76, 76, 76));
        lbBrand.setText("Brand");

        txtDescription.setBorder(null);
        txtDescription.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(178, 178, 178));
        txtDescription.setFocusable(false);

        lbWarehouse.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        lbWarehouse.setForeground(new java.awt.Color(76, 76, 76));

        lbGuarantee.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbGuarantee.setForeground(new java.awt.Color(76, 76, 76));

        lbSold.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        lbSold.setForeground(new java.awt.Color(76, 76, 76));

        lb1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lb1.setForeground(new java.awt.Color(76, 76, 76));
        lb1.setText("Guarantee:");

        lb2.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        lb2.setForeground(new java.awt.Color(76, 76, 76));
        lb2.setText("Warehouse:");

        lb3.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        lb3.setForeground(new java.awt.Color(76, 76, 76));
        lb3.setText("Sold: ");

        button12.setBackground(new java.awt.Color(210, 245, 253));
        button12.setForeground(new java.awt.Color(0, 0, 0));
        button12.setText("Add Bill");
        button12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 94));

        lb4.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        lb4.setForeground(new java.awt.Color(51, 51, 51));

        lb5.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        lb5.setForeground(new java.awt.Color(76, 76, 76));

        lb6.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        lb6.setForeground(new java.awt.Color(76, 76, 76));

        lb8.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        lb8.setForeground(new java.awt.Color(76, 76, 76));

        lb7.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        lb7.setForeground(new java.awt.Color(76, 76, 76));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(lb6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lb8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lb4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(lb8)
                .addContainerGap())
        );

        lbSum.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lbSum.setForeground(new java.awt.Color(0, 0, 0));
        lbSum.setText("-");
        lbSum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbClickSubtraction(evt);
            }
        });

        lbSubstraction.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbSubstraction.setForeground(new java.awt.Color(0, 0, 0));
        lbSubstraction.setText("+");
        lbSubstraction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbClickSum(evt);
            }
        });

        txtQuantity.setBackground(new java.awt.Color(255, 255, 255));
        txtQuantity.setForeground(new java.awt.Color(0, 0, 0));
        txtQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQuantity.setText("0");
        txtQuantity.setOpaque(true);
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lb2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(102, 102, 102))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lb3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbSold, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbSum, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(lbSubstraction, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbGuarantee, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(74, 74, 74)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbBrand, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbPrice, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbItemName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbItemName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbBrand)
                .addGap(10, 10, 10)
                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSubstraction)
                    .addComponent(lbSum)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGuarantee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbWarehouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scroll)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbClickSum(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbClickSum
        if (valueID.equals("")) {
            JOptionPane.showMessageDialog(null, "Bạn cần chọn sản phẩm!!!",
                    "Đặt hàng sản phẩm", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String labelText = txtQuantity.getText();
            System.out.println(labelText);
            if (labelText == null) {
                txtQuantity.setText("0");
            } else {
                int quantity = Integer.parseInt(labelText);
                quantity += 1;
                txtQuantity.setText(String.valueOf(quantity));
            }
        }
    }//GEN-LAST:event_lbClickSum

    private void lbClickSubtraction(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbClickSubtraction
        if (valueID.equals("")) {
            JOptionPane.showMessageDialog(null, "Bạn cần chọn sản phẩm!!!",
                    "Đặt hàng sản phẩm", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String labelText = txtQuantity.getText();
            if (labelText == null) {
                txtQuantity.setText("0");
            } else {
                int quantity = Integer.parseInt(labelText);
                if (quantity > 0) {
                    quantity -= 1;
                } else {
                    JOptionPane.showMessageDialog(null, "Số lượng cần lớn hơn 0!!!",
                            "Đặt hàng sản phẩm", JOptionPane.INFORMATION_MESSAGE);
                }
                txtQuantity.setText(String.valueOf(quantity));
            }
        }
    }//GEN-LAST:event_lbClickSubtraction

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        try {
            String labelText = txtQuantity.getText();
            int quantity = Integer.parseInt(labelText);
        } catch (NumberFormatException e) {
            txtQuantity.setText("0");
        }   
    }//GEN-LAST:event_txtQuantityActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Button1 button12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    private javax.swing.JLabel lbBrand;
    private javax.swing.JLabel lbGuarantee;
    private javax.swing.JLabel lbItemName;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JLabel lbSold;
    private javax.swing.JLabel lbSubstraction;
    private javax.swing.JLabel lbSum;
    private javax.swing.JLabel lbWarehouse;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.PanelItem panelItem;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextPane txtDescription;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
