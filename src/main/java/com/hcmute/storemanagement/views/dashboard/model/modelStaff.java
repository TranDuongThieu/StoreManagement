/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.views.dashboard.model;

import com.hcmute.storemanagement.views.dashboard.swing.TableUser.EventActionUser;
import com.hcmute.storemanagement.views.dashboard.swing.TableUser.ModelActionUser;
import com.hcmute.storemanagement.views.dashboard.swing.TableUser.ModelProfileUser;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.Icon;

public class modelStaff {

    private Icon icon;
    private String IdUser;
    private String tenUser;
    private String soDienThoai;
    private String email;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String CCCD;
    private String userName;
    private String password;

    public modelStaff() {
    }

    public modelStaff(Icon icon, String IdUser, String tenUser, String soDienThoai, String email, String gioiTinh, Date ngaySinh, String diaChi, String CCCD, String userName, String password) {
        this.icon = icon;
        this.IdUser = IdUser;
        this.tenUser = tenUser;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.CCCD = CCCD;
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String IdUser) {
        this.IdUser = IdUser;
    }

    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }

    
    

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTenNhanVien() {
        return tenUser;
    }

    public void setTenNhanVien(String tenUser) {
        this.tenUser = tenUser;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object[] toRowTable(EventActionUser event) {
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        return new Object[]{new ModelProfileUser(icon, IdUser),tenUser, soDienThoai, email, gioiTinh, ngaySinh, diaChi, CCCD, userName, password, new ModelActionUser(this, event)};
    }

}
