package com.hcmute.storemanagement.views.staff_dashboard.component;

import com.hcmute.storemanagement.views.staff_dashboard.model.ModelItem;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;

public class Item extends javax.swing.JPanel {
    
    public ModelItem getData() {
        return data;
    }
    
    public boolean isSelected() {
        return selected;
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }
    
    private boolean selected;
    
    public Item() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    private ModelItem data;
    
    
    
    public void setData(ModelItem data) {
        this.data = data;
        pic.setImage(data.getImage());
        lbItemName.setText(data.getItemName());
        lbDescription.setText(data.getDescription());
//        lbDescription.setVisible(false);
        lbGuaranteeOut.setText(data.getGuarantee());
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        lbPrice.setText(df.format(data.getPrice()));
        lbSoldOut.setText(String.valueOf(data.getSold()));
        lbWarehouseOut.setText(String.valueOf(data.getWarehouse()));
    }
    
    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242, 242, 242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        if (selected) {
            g2.setColor(new Color(94, 156, 255));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        g2.dispose();
        super.paint(grphcs);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbItemName = new javax.swing.JLabel();
        lbDescription = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();
        pic = new com.hcmute.storemanagement.views.staff_dashboard.swing.PictureBox();
        lbGuaranteeOut = new javax.swing.JLabel();
        lbWarehouseOut = new javax.swing.JLabel();
        lbSoldOut = new javax.swing.JLabel();
        lbWarehouse1 = new javax.swing.JLabel();
        lbSold = new javax.swing.JLabel();
        lbGuarantee = new javax.swing.JLabel();

        lbItemName.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbItemName.setForeground(new java.awt.Color(76, 76, 76));
        lbItemName.setText("Item Name");

        lbDescription.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbDescription.setForeground(new java.awt.Color(178, 178, 178));
        lbDescription.setText("Description");

        lbPrice.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(76, 76, 76));
        lbPrice.setText("$0.00");

        lbGuaranteeOut.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbGuaranteeOut.setForeground(new java.awt.Color(76, 76, 76));
        lbGuaranteeOut.setText("Guarantee");

        lbWarehouseOut.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        lbWarehouseOut.setForeground(new java.awt.Color(76, 76, 76));
        lbWarehouseOut.setText("Warehouse:");

        lbSoldOut.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        lbSoldOut.setForeground(new java.awt.Color(76, 76, 76));
        lbSoldOut.setText("Sold");

        lbWarehouse1.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        lbWarehouse1.setForeground(new java.awt.Color(76, 76, 76));
        lbWarehouse1.setText("Warehouse:");

        lbSold.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        lbSold.setForeground(new java.awt.Color(76, 76, 76));
        lbSold.setText("Sold:");

        lbGuarantee.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbGuarantee.setForeground(new java.awt.Color(76, 76, 76));
        lbGuarantee.setText("Guarantee:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbSold)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbSoldOut)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbPrice))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbWarehouse1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbWarehouseOut, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbGuarantee, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(lbGuaranteeOut, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbItemName)
                .addGap(4, 4, 4)
                .addComponent(lbDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGuaranteeOut)
                    .addComponent(lbGuarantee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbWarehouse1)
                    .addComponent(lbWarehouseOut))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lbPrice))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSold)
                            .addComponent(lbSoldOut))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbGuarantee;
    private javax.swing.JLabel lbGuaranteeOut;
    private javax.swing.JLabel lbItemName;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JLabel lbSold;
    private javax.swing.JLabel lbSoldOut;
    private javax.swing.JLabel lbWarehouse1;
    private javax.swing.JLabel lbWarehouseOut;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.PictureBox pic;
    // End of variables declaration//GEN-END:variables
}
