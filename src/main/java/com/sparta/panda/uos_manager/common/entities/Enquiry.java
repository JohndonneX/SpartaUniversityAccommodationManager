package com.sparta.panda.uos_manager.common.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Enquiry {
    @Id
    private Integer enquiryId;
    private LocalDateTime dateTimePosted;
    private String email;
    private String contactNo;
    private String content;
    private String status;

    @Id
    @Column(name = "enquiry_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(Integer enquiryId) {
        this.enquiryId = enquiryId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enquiry enquiry = (Enquiry) o;
        return Objects.equals(enquiryId, enquiry.enquiryId) &&
                Objects.equals(dateTimePosted, enquiry.dateTimePosted) &&
                Objects.equals(email, enquiry.email) &&
                Objects.equals(contactNo, enquiry.contactNo) &&
                Objects.equals(content, enquiry.content) &&
                Objects.equals(status, enquiry.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enquiryId, dateTimePosted, email, contactNo, content, status);
    }
}
