package com.hcmute.storemanagement.views.authen.component;

import com.hcmute.storemanagement.DAO.StaffDao.StaffTaiKhoanDao;
import com.hcmute.storemanagement.DAO.StaffDao.StaffNhanVienDao;
import com.hcmute.storemanagement.models.NhanVien;
import com.hcmute.storemanagement.models.TaiKhoan;
import com.hcmute.storemanagement.service.StaffNhanVienService;
import com.hcmute.storemanagement.service.StaffTaiKhoanService;
import com.hcmute.storemanagement.views.authen.Authen;
import com.hcmute.storemanagement.views.authen.swing.Button;
import com.hcmute.storemanagement.views.authen.swing.MyPasswordField;
import com.hcmute.storemanagement.views.authen.swing.MyTextField;
import com.hcmute.storemanagement.views.dashboard.mainAdmin.Dashboard;
import com.hcmute.storemanagement.views.staff_dashboard.mainStaff.StaffDashboard;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    private Authen authenForm;

    public PanelLoginAndRegister(Authen authenForm) {
        initComponents();
        initRegister();
        this.authenForm = authenForm;
        initLogin();
        login.setVisible(false);
        register.setVisible(true);
    }

    private void initRegister() {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]10[]push"));
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        register.add(label);

        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\com\\hcmute\\storemanagement\\ultis\\icon\\user.png"));
        txtUser.setHint("Username");
        register.add(txtUser, "w 60%");

        MyTextField txtTenNhanVien = new MyTextField();
        txtTenNhanVien.setPrefixIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\com\\hcmute\\storemanagement\\ultis\\icon\\user.png"));
        txtTenNhanVien.setHint("Fullname");
        register.add(txtTenNhanVien, "w 60%");

        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\com\\hcmute\\storemanagement\\ultis\\icon\\pass.png"));
        txtPass.setHint("Password");
        register.add(txtPass, "w 60%");

        MyPasswordField txtConfirmPass = new MyPasswordField();
        txtConfirmPass.setPrefixIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\com\\hcmute\\storemanagement\\ultis\\icon\\pass.png"));
        txtConfirmPass.setHint("Confirm Password");
        register.add(txtConfirmPass, "w 60%");

        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN UP");
        register.add(cmd, "w 40%, h 40");

        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register(txtUser, txtTenNhanVien, txtPass, txtConfirmPass);
            }
        });
    }

    public void register(MyTextField txtUser, MyTextField txtTenNhanVien, MyPasswordField txtPass, MyPasswordField txtConfirmPass) {

    }

    private void initLogin() {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        login.add(label);
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\com\\hcmute\\storemanagement\\ultis\\icon\\user.png"));
        txtEmail.setHint("Username");
        login.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\com\\hcmute\\storemanagement\\ultis\\icon\\pass.png"));
        txtPass.setHint("Password");
        login.add(txtPass, "w 60%");
        JButton cmdForget = new JButton("Forgot your password ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setBorderPainted(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    login(txtEmail.getText().toString(), txtPass.getText().toString());
                } catch (SQLException ex) {
                    Logger.getLogger(PanelLoginAndRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        cmd.setText("SIGN IN");
        login.add(cmd, "w 40%, h 40");
    }

    public class GlobalVariables {
        public static String userId; // Biến toàn cục lưu trữ ID của người dùng
        public static String fullName;
    }

    public void login(String username, String password) throws SQLException {
        StaffTaiKhoanService staffTaiKhoanService = new StaffTaiKhoanService();
        TaiKhoan account = staffTaiKhoanService.getAccountByUsername(username);
        // ID & NAME STAFF
        StaffNhanVienService staffCtr = new StaffNhanVienService();
        NhanVien idNhanVien = staffCtr.getUserByUserName(username);
        String id = idNhanVien.getMaNhanVien();
        String name = idNhanVien.getTenNhanVien();
        if (account != null) {
            if (account.getMatKhau().equals(password)) {
                System.out.println("Login successful.");
                if (account.getQuyenNguoiDung().equals("admin")) {
                    new Dashboard().setVisible(true);
                    GlobalVariables.userId = id;
                    GlobalVariables.fullName = name;                    
                    authenForm.closeForm();
                } else if (account.getQuyenNguoiDung().equals("staff")) {
                    new StaffDashboard().setVisible(true);
                    GlobalVariables.userId = id;
                    GlobalVariables.fullName = name;                 
                    authenForm.closeForm();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Wrong password. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Account does not exist.", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
