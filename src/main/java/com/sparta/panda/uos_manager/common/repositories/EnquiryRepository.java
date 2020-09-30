package com.sparta.panda.uos_manager.common.repositories;


import com.sparta.panda.uos_manager.common.entities.Enquiry;
import org.springframework.data.repository.CrudRepository;

public interface EnquiryRepository extends CrudRepository<Enquiry, Integer> {
    @Override
    <S extends Enquiry> S save(S s);
}
