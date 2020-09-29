package com.sparta.panda.uos_manager.common.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Login {
    private Integer loginId;
    private String email;
    private String password;
    private Integer residentId;
    private Integer adminId;
    private Resident residentByResidentId;
    private Admin adminByAdminId;

    @Id
    @Column(name = "login_id")
    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "resident_id")
    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    @Basic
    @Column(name = "admin_id")
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return Objects.equals(loginId, login.loginId) &&
                Objects.equals(email, login.email) &&
                Objects.equals(password, login.password) &&
                Objects.equals(residentId, login.residentId) &&
                Objects.equals(adminId, login.adminId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginId, email, password, residentId, adminId);
    }

    @ManyToOne
    @JoinColumn(name = "resident_id", referencedColumnName = "resident_id", insertable=false, updatable=false)
    public Resident getResidentByResidentId() {
        return residentByResidentId;
    }

    public void setResidentByResidentId(Resident residentByResidentId) {
        this.residentByResidentId = residentByResidentId;
    }

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "admin_id", insertable=false, updatable=false)
    public Admin getAdminByAdminId() {
        return adminByAdminId;
    }

    public void setAdminByAdminId(Admin adminByAdminId) {
        this.adminByAdminId = adminByAdminId;
    }
}
