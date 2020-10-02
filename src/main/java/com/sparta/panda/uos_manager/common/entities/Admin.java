package com.sparta.panda.uos_manager.common.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Admin {
    private Integer adminId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private String profileImage;
    private String role;
    private Collection<AdminNotice> adminNoticesByAdminId;
    private Collection<Login> loginsByAdminId;

    @Id
    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    @Column(name = "contact_no")
    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Basic
    @Column(name = "profile_image")
    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(adminId, admin.adminId) &&
                Objects.equals(firstName, admin.firstName) &&
                Objects.equals(lastName, admin.lastName) &&
                Objects.equals(email, admin.email) &&
                Objects.equals(contactNo, admin.contactNo) &&
                Objects.equals(profileImage, admin.profileImage) &&
                Objects.equals(role, admin.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, firstName, lastName, email, contactNo, profileImage, role);
    }

    @OneToMany(mappedBy = "adminByAdminId")
    public Collection<AdminNotice> getAdminNoticesByAdminId() {
        return adminNoticesByAdminId;
    }

    public void setAdminNoticesByAdminId(Collection<AdminNotice> adminNoticesByAdminId) {
        this.adminNoticesByAdminId = adminNoticesByAdminId;
    }

    @OneToMany(mappedBy = "adminByAdminId")
    public Collection<Login> getLoginsByAdminId() {
        return loginsByAdminId;
    }

    public void setLoginsByAdminId(Collection<Login> loginsByAdminId) {
        this.loginsByAdminId = loginsByAdminId;
    }
}
