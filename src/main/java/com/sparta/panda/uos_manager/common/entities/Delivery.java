package com.sparta.panda.uos_manager.common.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Delivery {
    private Integer deliveryId;
    private Integer residentId;
    private LocalDateTime dateTimeOfArrival;
    private String deliveryDescription;
    private Resident residentByResidentId;

    @Id
    @Column(name = "delivery_id")
    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
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
    @Column(name = "date_time_of_arrival")
    public LocalDateTime getDateTimeOfArrival() {
        return dateTimeOfArrival;
    }

    public void setDateTimeOfArrival(LocalDateTime dateTimeOfArrival) {
        this.dateTimeOfArrival = dateTimeOfArrival;
    }

    @Basic
    @Column(name = "delivery_description")
    public String getDeliveryDescription() {
        return deliveryDescription;
    }

    public void setDeliveryDescription(String deliveryDescription) {
        this.deliveryDescription = deliveryDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(deliveryId, delivery.deliveryId) &&
                Objects.equals(residentId, delivery.residentId) &&
                Objects.equals(dateTimeOfArrival, delivery.dateTimeOfArrival) &&
                Objects.equals(deliveryDescription, delivery.deliveryDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryId, residentId, dateTimeOfArrival, deliveryDescription);
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
