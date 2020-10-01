package com.sparta.panda.uos_manager.common.services;

import com.sparta.panda.uos_manager.common.entities.Resident;
import com.sparta.panda.uos_manager.common.repositories.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidentService {

    private ResidentRepository residentRepository;

    @Autowired
    public ResidentService(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    public List<Resident> getAllResidents() {
        return (List<Resident>) residentRepository.findAll();
    }

    public void addNewResident(Resident resident) {
        residentRepository.save(resident);
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
