package com.sparta.panda.uos_manager.common.entities;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "recreational_room_type", schema = "uos_manager", catalog = "")
public class RecreationalRoomType {
    private Integer recreationalRoomTypeId;
    private String title;
    private String description;
    private Collection<Booking> bookingsByRecreationalRoomTypeId;

    @Id
    @Column(name = "recreational_room_type_id")
    public Integer getRecreationalRoomTypeId() {
        return recreationalRoomTypeId;
    }

    public void setRecreationalRoomTypeId(Integer recreationalRoomTypeId) {
        this.recreationalRoomTypeId = recreationalRoomTypeId;
    }

    @Basic
    @Column
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecreationalRoomType that = (RecreationalRoomType) o;
        return Objects.equals(recreationalRoomTypeId, that.recreationalRoomTypeId) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recreationalRoomTypeId, description);
    }

    @OneToMany(mappedBy = "recreationalRoomTypeByRecreationalRoomTypeId")
    public Collection<Booking> getBookingsByRecreationalRoomTypeId() {
        return bookingsByRecreationalRoomTypeId;
    }

    public void setBookingsByRecreationalRoomTypeId(Collection<Booking> bookingsByRecreationalRoomTypeId) {
        this.bookingsByRecreationalRoomTypeId = bookingsByRecreationalRoomTypeId;
    }
}
