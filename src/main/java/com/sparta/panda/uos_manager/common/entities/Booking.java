package com.sparta.panda.uos_manager.common.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Booking {
    private Integer bookingId;
    private Integer residentId;
    private Integer recreationalRoomTypeId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String status;
    private RecreationalRoomType recreationalRoomTypeByRecreationalRoomTypeId;
    private Resident residentByResidentId;

    @Id
    @Column(name = "booking_id")
    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
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
    @Column(name = "recreational_room_type_id")
    public Integer getRecreationalRoomTypeId() {
        return recreationalRoomTypeId;
    }

    public void setRecreationalRoomTypeId(Integer recreationalRoomTypeId) {
        this.recreationalRoomTypeId = recreationalRoomTypeId;
    }

    @Basic
    @Column(name = "start_date_time")
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    @Basic
    @Column(name = "end_date_time")
    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
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
        Booking booking = (Booking) o;
        return Objects.equals(bookingId, booking.bookingId) &&
                Objects.equals(recreationalRoomTypeId, booking.recreationalRoomTypeId) &&
                Objects.equals(startDateTime, booking.startDateTime) &&
                Objects.equals(endDateTime, booking.endDateTime) &&
                Objects.equals(status, booking.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, recreationalRoomTypeId, startDateTime, endDateTime, status);
    }

    @ManyToOne
    @JoinColumn(name = "recreational_room_type_id", referencedColumnName = "recreational_room_type_id", nullable = false, insertable=false, updatable=false)
    public RecreationalRoomType getRecreationalRoomTypeByRecreationalRoomTypeId() {
        return recreationalRoomTypeByRecreationalRoomTypeId;
    }

    public void setRecreationalRoomTypeByRecreationalRoomTypeId(RecreationalRoomType recreationalRoomTypeByRecreationalRoomTypeId) {
        this.recreationalRoomTypeByRecreationalRoomTypeId = recreationalRoomTypeByRecreationalRoomTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "resident_id", referencedColumnName = "resident_id", nullable = false, insertable = false, updatable = false)
    public Resident getResidentByResidentId() {
        return residentByResidentId;
    }

    public void setResidentByResidentId(Resident residentByResidentId) {
        this.residentByResidentId = residentByResidentId;
    }
}

