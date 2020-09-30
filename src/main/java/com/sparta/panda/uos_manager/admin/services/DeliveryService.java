package com.sparta.panda.uos_manager.admin.services;

import com.sparta.panda.uos_manager.common.entities.Delivery;
import com.sparta.panda.uos_manager.common.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
