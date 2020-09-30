package com.sparta.panda.uos_manager.admin.services;

import com.sparta.panda.uos_manager.common.entities.Resident;
import com.sparta.panda.uos_manager.common.repositories.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
