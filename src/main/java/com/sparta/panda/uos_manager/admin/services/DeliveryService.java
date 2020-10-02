package com.sparta.panda.uos_manager.admin.services;

import com.sparta.panda.uos_manager.common.entities.Delivery;
import com.sparta.panda.uos_manager.common.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public List<Delivery> getAllDeliveries() {
        return (List<Delivery>) deliveryRepository.findAll();
    }

    public Optional<Delivery> getDeliveryById(Integer id) {
        return deliveryRepository.findById(id);
    }

    public void updateDeliveryStatusById(Integer id) {
        Delivery delivery = deliveryRepository.findById(id).get();
        delivery.setStatus("Delivered");
        deliveryRepository.save(delivery);
    }

    public List<Delivery> getPendingDeliveries() {
        return (List<Delivery>) deliveryRepository.findAllByStatus("Awaiting Collection");
    }

}
