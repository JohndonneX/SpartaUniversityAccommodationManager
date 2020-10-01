package com.sparta.panda.uos_manager.common.repositories;

import com.sparta.panda.uos_manager.common.entities.Resident;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ResidentRepository extends CrudRepository<Resident, Integer> {

    Optional<Resident> findByEmail(String email);

}
