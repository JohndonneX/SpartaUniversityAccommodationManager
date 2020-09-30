package com.sparta.panda.uos_manager.admin.services;

import com.sparta.panda.uos_manager.common.entities.Booking;
import com.sparta.panda.uos_manager.common.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAlBookings() {
        return (List<Booking>) bookingRepository.findAll();
    }

}
