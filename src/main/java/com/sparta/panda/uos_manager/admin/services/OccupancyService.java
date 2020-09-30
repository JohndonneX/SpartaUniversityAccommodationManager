package com.sparta.panda.uos_manager.admin.services;

import com.sparta.panda.uos_manager.common.entities.Occupancy;
import com.sparta.panda.uos_manager.common.repositories.OccupancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccupancyService {

    private final OccupancyRepository occupancyRepository;

    @Autowired
    public OccupancyService(OccupancyRepository occupancyRepository) {
        this.occupancyRepository = occupancyRepository;
    }

    public List<Occupancy> getAllOccupancies() {
        return (List<Occupancy>) occupancyRepository.findAll();
    }

}
