package com.hcmute.storemanagement.views.staff_dashboard.model.billDetailTable;


public class ProfileBilldetail extends javax.swing.JPanel {
    
    public ProfileBilldetail(ModelProfileBilldetail data) {
        setOpaque(true);
        initComponents();
        pic.setIcon(data.getIcon());
        lbName.setText(data.getId());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbName = new javax.swing.JLabel();
        pic = new com.hcmute.storemanagement.views.staff_dashboard.swing.workScheduleTable.ImageAvatar();

        lbName.setForeground(new java.awt.Color(102, 102, 102));
        lbName.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbName;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.workScheduleTable.ImageAvatar pic;
    // End of variables declaration//GEN-END:variables
}
