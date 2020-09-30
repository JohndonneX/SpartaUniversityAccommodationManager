package com.sparta.panda.uos_manager.common.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "resident_notice", schema = "uos_manager", catalog = "")
public class ResidentNotice {
    private Integer residentPostId;
    private Integer residentId;
    private LocalDateTime dateTimePosted;
    private String title;
    private String content;
    private Resident residentByResidentId;

    @Id
    @Column(name = "resident_post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getResidentPostId() {
        return residentPostId;
    }

    public void setResidentPostId(Integer residentPostId) {
        this.residentPostId = residentPostId;
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
        ResidentNotice that = (ResidentNotice) o;
        return Objects.equals(residentPostId, that.residentPostId) &&
                Objects.equals(residentId, that.residentId) &&
                Objects.equals(dateTimePosted, that.dateTimePosted) &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(residentPostId, residentId, dateTimePosted, title, content);
    }

    @ManyToOne
    @JoinColumn(name = "resident_id", referencedColumnName = "resident_id", nullable = false, insertable=false, updatable=false)
    public Resident getResidentByResidentId() {
        return residentByResidentId;
    }

    public void setResidentByResidentId(Resident residentByResidentId) {
        this.residentByResidentId = residentByResidentId;
    }
}
