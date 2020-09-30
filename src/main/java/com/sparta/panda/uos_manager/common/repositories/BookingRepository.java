package com.sparta.panda.uos_manager.common.repositories;

import com.sparta.panda.uos_manager.common.entities.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
}
