package com.sparta.panda.uos_manager.resident.services;

import com.sparta.panda.uos_manager.common.entities.Resident;
import com.sparta.panda.uos_manager.common.entities.ResidentNotice;
import com.sparta.panda.uos_manager.common.repositories.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResidentService {

    private final ResidentRepository residentRepository;

    @Autowired
    public ResidentService(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }


    public Resident getResidentById(int id) {
        Optional<Resident> resident = residentRepository.findById(id);
        if (resident.isPresent()) {
            return resident.get();
        } else {
            return null;
        }
    }


}
