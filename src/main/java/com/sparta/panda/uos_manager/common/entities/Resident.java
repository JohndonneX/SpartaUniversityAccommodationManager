package com.sparta.panda.uos_manager.common.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Resident {
    private Integer residentId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private Integer roomId;
    private String role;
    private Collection<Delivery> deliveriesByResidentId;
    private Collection<Login> loginsByResidentId;
    private Occupancy occupancyByRoomId;
    private Collection<ResidentNotice> residentNoticesByResidentId;

    @Id
    @Column(name = "resident_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
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
    @Column(name = "room_id")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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
        Resident resident = (Resident) o;
        return Objects.equals(residentId, resident.residentId) &&
                Objects.equals(firstName, resident.firstName) &&
                Objects.equals(lastName, resident.lastName) &&
                Objects.equals(email, resident.email) &&
                Objects.equals(contactNo, resident.contactNo) &&
                Objects.equals(roomId, resident.roomId) &&
                Objects.equals(role, resident.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(residentId, firstName, lastName, email, contactNo, roomId, role);
    }

    @OneToMany(mappedBy = "residentByResidentId")
    public Collection<Delivery> getDeliveriesByResidentId() {
        return deliveriesByResidentId;
    }

    public void setDeliveriesByResidentId(Collection<Delivery> deliveriesByResidentId) {
        this.deliveriesByResidentId = deliveriesByResidentId;
    }

    @OneToMany(mappedBy = "residentByResidentId")
    public Collection<Login> getLoginsByResidentId() {
        return loginsByResidentId;
    }

    public void setLoginsByResidentId(Collection<Login> loginsByResidentId) {
        this.loginsByResidentId = loginsByResidentId;
    }

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "room_id", insertable=false, updatable=false)
    public Occupancy getOccupancyByRoomId() {
        return occupancyByRoomId;
    }

    public void setOccupancyByRoomId(Occupancy occupancyByRoomId) {
        this.occupancyByRoomId = occupancyByRoomId;
    }

    @OneToMany(mappedBy = "residentByResidentId")
    public Collection<ResidentNotice> getResidentNoticesByResidentId() {
        return residentNoticesByResidentId;
    }

    public void setResidentNoticesByResidentId(Collection<ResidentNotice> residentNoticesByResidentId) {
        this.residentNoticesByResidentId = residentNoticesByResidentId;
    }
}
