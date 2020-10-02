package com.sparta.panda.uos_manager.common.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "admin_notice", schema = "uos_manager", catalog = "")
public class AdminNotice {
    private Integer adminPostId;
    private Integer adminId;
    private LocalDateTime dateTimePosted;
    private String title;
    private String content;
    private Admin adminByAdminId;

    @Id
    @Column(name = "admin_post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getAdminPostId() {
        return adminPostId;
    }

    public void setAdminPostId(Integer adminPostId) {
        this.adminPostId = adminPostId;
    }

    @Basic
    @Column(name = "admin_id")
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "date_time_posted")
    public LocalDateTime getDateTimePosted() {
        return dateTimePosted;
    }

    public void setDateTimePosted(LocalDateTime dateTimePosted) {
        this.dateTimePosted = dateTimePosted;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminNotice that = (AdminNotice) o;
        return Objects.equals(adminPostId, that.adminPostId) &&
                Objects.equals(adminId, that.adminId) &&
                Objects.equals(dateTimePosted, that.dateTimePosted) &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminPostId, adminId, dateTimePosted, title, content);
    }

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "admin_id", nullable = false, insertable=false, updatable=false)
    public Admin getAdminByAdminId() {
        return adminByAdminId;
    }

    public void setAdminByAdminId(Admin adminByAdminId) {
        this.adminByAdminId = adminByAdminId;
    }
}
