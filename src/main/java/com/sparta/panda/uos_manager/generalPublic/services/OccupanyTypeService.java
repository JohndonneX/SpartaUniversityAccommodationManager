package com.sparta.panda.uos_manager.generalPublic.services;

import com.sparta.panda.uos_manager.common.entities.OccupancyType;
import com.sparta.panda.uos_manager.common.repositories.OccupancyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccupanyTypeService {
    private final OccupancyTypeRepository occupancyTypeRepository;

    @Autowired
    public OccupanyTypeService(OccupancyTypeRepository occupancyTypeRepository) {
        this.occupancyTypeRepository = occupancyTypeRepository;
    }

    public List<OccupancyType> getRoomTypes(){
        return (List<OccupancyType>) occupancyTypeRepository.findAll();
    }
}
