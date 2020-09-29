package com.sparta.panda.uos_manager.common.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Issue {
    private Integer issueId;
    private LocalDateTime dateTimePosted;
    private String title;
    private String content;
    private String status;
    private LocalDateTime dateTimeResolved;

    @Id
    @Column(name = "issue_id")
    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
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

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "date_time_resolved")
    public LocalDateTime getDateTimeResolved() {
        return dateTimeResolved;
    }

    public void setDateTimeResolved(LocalDateTime dateTimeResolved) {
        this.dateTimeResolved = dateTimeResolved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return Objects.equals(issueId, issue.issueId) &&
                Objects.equals(dateTimePosted, issue.dateTimePosted) &&
                Objects.equals(title, issue.title) &&
                Objects.equals(content, issue.content) &&
                Objects.equals(status, issue.status) &&
                Objects.equals(dateTimeResolved, issue.dateTimeResolved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issueId, dateTimePosted, title, content, status, dateTimeResolved);
    }
}
