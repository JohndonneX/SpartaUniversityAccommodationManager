package com.sparta.panda.uos_manager.common.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "occupancy_type", schema = "uos_manager", catalog = "")
public class OccupancyType {
    private Integer roomTypeId;
    private Integer noOfBedrooms;
    private String details;
    private String typeDescription;
    private Collection<Occupancy> occupanciesByRoomTypeId;

    @Id
    @Column(name = "room_type_id")
    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    @Basic
    @Column(name = "no_of_bedrooms")
    public Integer getNoOfBedrooms() {
        return noOfBedrooms;
    }

    public void setNoOfBedrooms(Integer noOfBedrooms) {
        this.noOfBedrooms = noOfBedrooms;
    }

    @Basic
    @Column
    public String getDetails() { return details; }

    public void setDetails(String details) {
        this.details = details;
    }

    @Basic
    @Column(name = "type_description")
    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OccupancyType that = (OccupancyType) o;
        return Objects.equals(roomTypeId, that.roomTypeId) &&
                Objects.equals(noOfBedrooms, that.noOfBedrooms) &&
                Objects.equals(typeDescription, that.typeDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomTypeId, noOfBedrooms, typeDescription);
    }

    @OneToMany(mappedBy = "occupancyTypeByRoomTypeId")
    public Collection<Occupancy> getOccupanciesByRoomTypeId() {
        return occupanciesByRoomTypeId;
    }

    public void setOccupanciesByRoomTypeId(Collection<Occupancy> occupanciesByRoomTypeId) {
        this.occupanciesByRoomTypeId = occupanciesByRoomTypeId;
    }
}
