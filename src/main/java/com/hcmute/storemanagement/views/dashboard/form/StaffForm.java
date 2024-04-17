package com.hcmute.storemanagement.views.dashboard.form;

import com.hcmute.storemanagement.DAO.StaffDao.StaffNhanVienDao;
import com.hcmute.storemanagement.models.NhanVien;
import com.hcmute.storemanagement.service.StaffNhanVienService;
import com.hcmute.storemanagement.views.authen.component.PanelLoginAndRegister;
import com.hcmute.storemanagement.views.dashboard.model.modelUser;
import com.hcmute.storemanagement.views.dashboard.popup.popupAddAccount;
import com.hcmute.storemanagement.views.dashboard.popup.popupAddStaff;
import com.hcmute.storemanagement.views.dashboard.swing.TableUser.EventActionUser;
import com.hcmute.storemanagement.views.dashboard.swing.TableUser.ModelProfileUser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StaffForm extends javax.swing.JPanel {

    StaffNhanVienService staffNhanVienService = new StaffNhanVienService();
    private Object variNameObj = null;
    private Object variPhoneObj = null;
    private Object variEmailObj = null;
    private Object variGenderObj = null;
    private Object variDayOfBirthObj = null;
    private Object variAddressObj = null;
    private Object variCccdObj = null;

    public StaffForm() throws SQLException {
        initComponents();
        initData();
    }

    private void initData() throws SQLException {
        EventActionUser eventAction = new EventActionUser() {
            @Override
            public void delete(modelUser student, ActionEvent e) {
                System.err.println(",delete");
                // Lấy vị trí hàng được chọn
                int row = tbStaff.getSelectedRow();
                // Lấy giá trị từ hàng và cột tương ứng, lấy được đối tượng object
                // lấy id
                ModelProfileUser profileUser = (ModelProfileUser) tbStaff.getValueAt(row, 0);
                String id = profileUser.getId();
                // lấy gt còn lại
                Object nameObj = tbStaff.getValueAt(row, 1);
                Object phoneObj = tbStaff.getValueAt(row, 2);
                Object emailObj = tbStaff.getValueAt(row, 3);
                Object genderObj = tbStaff.getValueAt(row, 4);
                Object dayOfBirthObj = tbStaff.getValueAt(row, 5);
                Object addressObj = tbStaff.getValueAt(row, 6);
                Object cccdObj = tbStaff.getValueAt(row, 7);
                System.err.println("nameObj" + cccdObj);
                // chuyen object sang string 
                String phone = phoneObj != null ? phoneObj.toString() : "";
                String gender = genderObj != null ? genderObj.toString() : "";
                String cccd = cccdObj != null ? cccdObj.toString() : "";
                // Chuyen Object Dateofbieth sang Date
                Date ngay = null;
                if (dayOfBirthObj != null) {
                    if (dayOfBirthObj instanceof Date) {
                        ngay = (Date) dayOfBirthObj;
                    } else if (dayOfBirthObj instanceof String) {
                        try {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            ngay = dateFormat.parse((String) dayOfBirthObj);
                        } catch (ParseException ex) {
                            Logger.getLogger(StaffForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                // check nulll xem người dùng có xóa đi cái gì ko

                if (tbStaff.isEditing()) {
                    tbStaff.getCellEditor().stopCellEditing();
                }
                boolean checkDelete = staffNhanVienService.deleteStaffByUserId(id);
                if (checkDelete == true) {
                    JOptionPane.showMessageDialog(StaffForm.this, "Xóa nhân viên thành công");
                    try {
                        initData();
                    } catch (SQLException ex) {
                        Logger.getLogger(StaffForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(StaffForm.this, "Xóa nhân viên không thành công");
                    // truyền dữ liệu cũ vào bảng
                    setValueOf(row);
                    // Đổi màu hàng tương ứng
                    tbStaff.addRowSelectionInterval(row, row);
                    tbStaff.setSelectionBackground(Color.RED);
                }

            }

            @Override
            public void update(modelUser student, ActionEvent e) {
                System.err.println(",update");
                // Lấy vị trí hàng được chọn
                int row = tbStaff.getSelectedRow();
                // Lấy giá trị từ hàng và cột tương ứng, lấy được đối tượng object
                // lấy giá trị ID
                ModelProfileUser profileUser = (ModelProfileUser) tbStaff.getValueAt(row, 0);
                String id = profileUser.getId();
                // lấy các giá trị còn lại
                Object nameObj = tbStaff.getValueAt(row, 1);
                Object phoneObj = tbStaff.getValueAt(row, 2);
                Object emailObj = tbStaff.getValueAt(row, 3);
                Object genderObj = tbStaff.getValueAt(row, 4);
                Object dayOfBirthObj = tbStaff.getValueAt(row, 5);
                Object addressObj = tbStaff.getValueAt(row, 6);
                Object cccdObj = tbStaff.getValueAt(row, 7);
                System.err.println("nameObj" + cccdObj);
                // chuyen object sang string 
                String name = nameObj != null ? nameObj.toString() : "";
                String phone = phoneObj != null ? phoneObj.toString() : "";
                String email = emailObj != null ? emailObj.toString() : "";
                String gender = genderObj != null ? genderObj.toString() : "";
                String address = addressObj != null ? addressObj.toString() : "";
                String cccd = cccdObj != null ? cccdObj.toString() : "";
                // Chuyen Object Dateofbieth sang Date
                Date ngay = null;
                if (dayOfBirthObj != null) {
                    if (dayOfBirthObj instanceof Date) {
                        ngay = (Date) dayOfBirthObj;
                    } else if (dayOfBirthObj instanceof String) {
                        try {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            ngay = dateFormat.parse((String) dayOfBirthObj);
                        } catch (ParseException ex) {
                            Logger.getLogger(StaffForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                // check nulll xem người dùng có xóa đi cái gì ko
                if (nameObj == null || phoneObj == null || emailObj == null || genderObj == null || dayOfBirthObj == null || addressObj == null || cccdObj == null || cccdObj.equals("")) {
                    JOptionPane.showMessageDialog(StaffForm.this, "Vui lòng không để dữ liệu trống");
                    setValueOf(row);
                } else {
                    boolean check = checkAll(phone, gender, ngay, cccd, row);
                    if (check == true) {
                        Boolean checkUpdate = staffNhanVienService.updateStaff(id, name, address, email, phone, cccd, ngay);
                        if (checkUpdate == true) {
                            JOptionPane.showMessageDialog(StaffForm.this, "Cập nhật nhân viên thành công");
                        } else {
                            JOptionPane.showMessageDialog(StaffForm.this, "Cập nhật nhân viên không thành công");
                            // truyền dữ liệu cũ vào bảng
                            setValueOf(row);
                        }
                    }
                }
            }

        };
        // Add dữ liệu vào bảng
        DefaultTableModel model = (DefaultTableModel) tbStaff.getModel();
        model.setRowCount(0);
        StaffNhanVienDao staffController = new StaffNhanVienDao();
        ArrayList<NhanVien> staffList = staffController.getAllStaff();
        for (NhanVien staff : staffList) {
            ImageIcon icon = new ImageIcon("C:\\imagepj\\image\\user.png");
            model.addRow(new modelUser(icon, staff.getMaNhanVien(), staff.getTenNhanVien(), staff.getSoDienThoai(), staff.getEmail(), staff.getGioiTinh(), staff.getNgaySinh(), staff.getDiaChi(), staff.getCCCD()).toRowTable(eventAction));
        }
    }

    private void setValueOf(int row) {
        // set lại giá trị cũ về bảng
        tbStaff.setValueAt(variNameObj, row, 1);
        tbStaff.setValueAt(variPhoneObj, row, 2);
        tbStaff.setValueAt(variEmailObj, row, 3);
        tbStaff.setValueAt(variGenderObj, row, 4);
        tbStaff.setValueAt(variDayOfBirthObj, row, 5);
        tbStaff.setValueAt(variAddressObj, row, 6);
        tbStaff.setValueAt(variCccdObj, row, 7);
//        variNameObj = null;
//        variPhoneObj = null;
//        variEmailObj = null;
//        variGenderObj = null;
//        variDayOfBirthObj = null;
//        variDayOfBirthObj = null;
//        variCccdObj = null;

    }

    private boolean checkAll(String phone, String gender, Date dayOfBirth, String cccd, int row) {

        // check cccd
        try {
            long cccdConvert = Long.parseLong(cccd);
            if (cccd.length() != 12) {
                int dialogResult = JOptionPane.showConfirmDialog(this, "Căn cước của bạn đã sai. Bạn muốn hoàn lại dữ liệu ban đầu không?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    // Gọi phương thức để hoàn lại dữ liệu ban đầu ở đây
                    setValueOf(row);
                }
//                JOptionPane.showMessageDialog(this, "Căn cước của bạn phải đủ 12 kí tự số");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Căn cước của bạn chỉ được nhập kí tự số");
            return false;
        }

        // check phone
        try {
            long phoneConvert = Long.parseLong(phone);
            if (phone.length() != 10) {
                JOptionPane.showMessageDialog(this, "Số điện thoại của bạn phải đủ 10 kí tự số");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số điện thoại của bạn chỉ được nhập giá trị số");
            return false;
        }
        // check gender 
        // check ngay sinh
        // Tính toán ngày 18 tuổi tính đến từ ngày hiện tại
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -18);
        java.util.Date eighteenYearsAgo = calendar.getTime();
        if (dayOfBirth != null && dayOfBirth.after(eighteenYearsAgo)) {
            JOptionPane.showMessageDialog(this, "Bạn chưa đủ 18 tuổi");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStaff = new com.hcmute.storemanagement.views.dashboard.swing.TableUser.TableUser();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 119, 253));
        jLabel1.setText("List Staff");

        tbStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone", "Email", "Gender", "Day of birth", "Address", "CCCD", "Action"
            }
        ));
        tbStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickGetData(evt);
            }
        });
        jScrollPane1.setViewportView(tbStaff);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\imagepj\\icon\\add.png")); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickOpenPopupStaff(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clickGetData(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickGetData
        int row = tbStaff.rowAtPoint(evt.getPoint());
        int column = tbStaff.columnAtPoint(evt.getPoint());
        Object nameObj = tbStaff.getValueAt(row, 1);
        Object phoneObj = tbStaff.getValueAt(row, 2);
        Object emailObj = tbStaff.getValueAt(row, 3);
        Object genderObj = tbStaff.getValueAt(row, 4);
        Object dayOfBirthObj = tbStaff.getValueAt(row, 5);
        Object addressObj = tbStaff.getValueAt(row, 6);
        Object cccdObj = tbStaff.getValueAt(row, 7);
        variNameObj = nameObj;
        variPhoneObj = phoneObj;
        variEmailObj = emailObj;
        variGenderObj = genderObj;
        variDayOfBirthObj = dayOfBirthObj;
        variAddressObj = addressObj;
        variCccdObj = cccdObj;
    }//GEN-LAST:event_clickGetData

    private void clickOpenPopupStaff(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickOpenPopupStaff
        openPopup();
    }//GEN-LAST:event_clickOpenPopupStaff

    private static void openPopup() {
        // Tạo cửa sổ popup và hiển thị
        JFrame popupFrame = new JFrame();
        popupFrame.setTitle(null); // Đặt tiêu đề là null
        popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đóng cửa sổ popup khi đóng
        popupAddAccount popupForm = new popupAddAccount();
        popupFrame.add(popupForm);
        popupFrame.pack();
        popupFrame.setLocationRelativeTo(null); // Căn giữa cửa sổ
        popupFrame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.hcmute.storemanagement.views.dashboard.swing.TableUser.TableUser tbStaff;
    // End of variables declaration//GEN-END:variables
}
