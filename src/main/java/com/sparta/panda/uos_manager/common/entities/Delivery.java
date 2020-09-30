package com.sparta.panda.uos_manager.common.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Delivery {
    private Integer deliveryId;
    private Integer residentId;
    private LocalDateTime dateTimeOfArrival;
    private String deliveryDescription;
    private String status;
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

        Delivery delivery = (Delivery) o;

        if (deliveryId != null ? !deliveryId.equals(delivery.deliveryId) : delivery.deliveryId != null) return false;
        if (residentId != null ? !residentId.equals(delivery.residentId) : delivery.residentId != null) return false;
        if (dateTimeOfArrival != null ? !dateTimeOfArrival.equals(delivery.dateTimeOfArrival) : delivery.dateTimeOfArrival != null)
            return false;
        if (deliveryDescription != null ? !deliveryDescription.equals(delivery.deliveryDescription) : delivery.deliveryDescription != null)
            return false;
        if (status != null ? !status.equals(delivery.status) : delivery.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deliveryId != null ? deliveryId.hashCode() : 0;
        result = 31 * result + (residentId != null ? residentId.hashCode() : 0);
        result = 31 * result + (dateTimeOfArrival != null ? dateTimeOfArrival.hashCode() : 0);
        result = 31 * result + (deliveryDescription != null ? deliveryDescription.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
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
