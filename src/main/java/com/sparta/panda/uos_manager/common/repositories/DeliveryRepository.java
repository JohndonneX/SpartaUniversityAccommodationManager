package com.sparta.panda.uos_manager.common.repositories;

import com.sparta.panda.uos_manager.common.entities.Delivery;
import org.springframework.data.repository.CrudRepository;


public interface DeliveryRepository extends CrudRepository<Delivery, Integer> {

    @Override
    <S extends Delivery> S save(S s);

}
