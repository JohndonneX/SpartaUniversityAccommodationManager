package com.sparta.panda.uos_manager.admin.services;

import com.sparta.panda.uos_manager.common.entities.Occupancy;
import com.sparta.panda.uos_manager.common.repositories.OccupancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Occupancy> getOccupancyById(Integer id) {
        return occupancyRepository.findById(id);
    }

    public void updateOccupancy(Occupancy occupancy) {
        occupancy.setCurrentOccupants(occupancy.getCurrentOccupants() + 1);
        occupancyRepository.save(occupancy);
    }
}
