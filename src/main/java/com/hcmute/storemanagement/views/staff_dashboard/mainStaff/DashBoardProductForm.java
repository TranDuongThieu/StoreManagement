/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hcmute.storemanagement.views.staff_dashboard.mainStaff;

import com.hcmute.storemanagement.models.SanPham;
import com.hcmute.storemanagement.models.ThongTinSanPham;
import com.hcmute.storemanagement.service.StaffSanPhamService;
import com.hcmute.storemanagement.service.StaffThongTinSanPhamService;
import com.hcmute.storemanagement.views.staff_dashboard.event.EventItem;
import com.hcmute.storemanagement.views.staff_dashboard.form.HomeForm;
import com.hcmute.storemanagement.views.staff_dashboard.model.ModelItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

public class DashBoardProductForm extends javax.swing.JPanel {

    private HomeForm home;
    private Animator animator;
    private Point animatePoint;
    private ModelItem itemSelected;
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public DashBoardProductForm(int index) throws SQLException {
        this.index = index;
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        init();
        //  Animator start form animatePoint to TagetPoint
        animator = PropertySetter.createAnimator(500, mainPanel1, "imageLocation", animatePoint, mainPanel1.getTargetLocation());
        animator.addTarget(new PropertySetter(mainPanel1, "imageSize", new Dimension(180, 120), mainPanel1.getTargetSize()));
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void end() {
                mainPanel1.setImageOld(null);
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
    }

    private void init() throws SQLException {
        home = new HomeForm();
        mainPanel1.setLayout(new BorderLayout());
        mainPanel1.add(home);
        if (index == 1) {
            List<SanPham> sanPham = allProduct();
            testData(sanPham);
        } else if(index ==2){
            List<SanPham> sanPham = allPhone();
            testData(sanPham);
        } else if(index ==3){
            List<SanPham> sanPham = allLapTop();
            testData(sanPham);
        }  else if(index ==4){
            List<SanPham> sanPham = allTablet();
            testData(sanPham);
        } else if(index ==5){
            List<SanPham> sanPham = allAccessory();
            testData(sanPham);
        } 

    }

    public List<SanPham> allProduct() throws SQLException {
        StaffSanPhamService getAllProduct = new StaffSanPhamService();
        List<SanPham> sanPham = getAllProduct.getAllSanPham();
        return sanPham;
    }
    
    public List<SanPham> allPhone() throws SQLException {
        StaffSanPhamService getAllPhone = new StaffSanPhamService();
        List<SanPham> sanPham = getAllPhone.getAllPhone();
        return sanPham;
    }
    
    public List<SanPham> allLapTop() throws SQLException {
        StaffSanPhamService getAllLap = new StaffSanPhamService();
        List<SanPham> sanPham = getAllLap.getAllLapTop();
        return sanPham;
    }
    
    public List<SanPham> allTablet() throws SQLException {
        StaffSanPhamService getAllTablet = new StaffSanPhamService();
        List<SanPham> sanPham = getAllTablet.getAllTablet();
        return sanPham;
    }
    
    public List<SanPham> allAccessory() throws SQLException {
        StaffSanPhamService getAllAccessory = new StaffSanPhamService();
        List<SanPham> sanPham = getAllAccessory.getAllAccessory();
        return sanPham;
    }

    private void testData(List<SanPham> sanPham) {
        home.setEvent(new EventItem() {
            @Override
            public void itemClick(Component com, ModelItem item) {
                if (item != null) {
                    // Lấy mã
                    String maSanPham = item.getItemID();
                    StaffThongTinSanPhamService gettAllThongSo = null;
                    gettAllThongSo = new StaffThongTinSanPhamService();
                    List<ThongTinSanPham> ttSanPham = gettAllThongSo.getAllThongSo(maSanPham);

                    // Tiếp tục với các hành động khác nếu cần
                    if (itemSelected != null) {
                        mainPanel1.setImageOld(itemSelected.getImage());
                    }
                    if (itemSelected != item) {
                        if (!animator.isRunning()) {
                            itemSelected = item;
                            animatePoint = getLocationOf(com);
                            mainPanel1.setImage(item.getImage());
                            mainPanel1.setImageLocation(animatePoint);
                            mainPanel1.setImageSize(new Dimension(180, 120));
                            mainPanel1.repaint();
                            home.setSelected(com);
                            home.showItem(item, ttSanPham);
                            animator.start();
                        }
                    }
                }
            }
        });
            for (SanPham sp : sanPham) {
                home.addItem(new ModelItem(sp.getMaSanPham(), sp.getTenSanPham(), sp.getMoTa(), sp.getThoiHanBaoHanh(), sp.getGia(), new ImageIcon(sp.getHinhAnh()), sp.getSoLuongDaBan(), sp.getSoLuongTrongKho()));
            }
    }

    private Point getLocationOf(Component com) {
        Point p = home.getPanelItemLocation();
        int x = p.x;
        int y = p.y;
        int itemX = com.getX();
        int itemY = com.getY();
        int left = 10;
        int top = 35;
        return new Point(x + itemX + left, y + itemY + top);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.hcmute.storemanagement.views.staff_dashboard.swing.Background();
        mainPanel1 = new com.hcmute.storemanagement.views.staff_dashboard.swing.MainPanel();

        javax.swing.GroupLayout mainPanel1Layout = new javax.swing.GroupLayout(mainPanel1);
        mainPanel1.setLayout(mainPanel1Layout);
        mainPanel1Layout.setHorizontalGroup(
            mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1093, Short.MAX_VALUE)
        );
        mainPanel1Layout.setVerticalGroup(
            mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addComponent(mainPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hcmute.storemanagement.views.staff_dashboard.swing.Background background1;
    private com.hcmute.storemanagement.views.staff_dashboard.swing.MainPanel mainPanel1;
    // End of variables declaration//GEN-END:variables
}
