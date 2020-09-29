package com.sparta.panda.uos_manager.common.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Occupancy {
    private Integer roomId;
    private Integer roomTypeId;
    private Integer currentOccupants;
    private Integer floorNo;
    private OccupancyType occupancyTypeByRoomTypeId;
    private Collection<Resident> residentsByRoomId;

    @Id
    @Column(name = "room_id")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "room_type_id")
    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    @Basic
    @Column(name = "current_occupants")
    public Integer getCurrentOccupants() {
        return currentOccupants;
    }

    public void setCurrentOccupants(Integer currentOccupants) {
        this.currentOccupants = currentOccupants;
    }

    @Basic
    @Column(name = "floor_no")
    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Occupancy occupancy = (Occupancy) o;
        return Objects.equals(roomId, occupancy.roomId) &&
                Objects.equals(roomTypeId, occupancy.roomTypeId) &&
                Objects.equals(currentOccupants, occupancy.currentOccupants) &&
                Objects.equals(floorNo, occupancy.floorNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, roomTypeId, currentOccupants, floorNo);
    }

    @ManyToOne
    @JoinColumn(name = "room_type_id", referencedColumnName = "room_type_id", nullable = false, insertable=false, updatable=false)
    public OccupancyType getOccupancyTypeByRoomTypeId() {
        return occupancyTypeByRoomTypeId;
    }

    public void setOccupancyTypeByRoomTypeId(OccupancyType occupancyTypeByRoomTypeId) {
        this.occupancyTypeByRoomTypeId = occupancyTypeByRoomTypeId;
    }

    @OneToMany(mappedBy = "occupancyByRoomId")
    public Collection<Resident> getResidentsByRoomId() {
        return residentsByRoomId;
    }

    public void setResidentsByRoomId(Collection<Resident> residentsByRoomId) {
        this.residentsByRoomId = residentsByRoomId;
    }
}
