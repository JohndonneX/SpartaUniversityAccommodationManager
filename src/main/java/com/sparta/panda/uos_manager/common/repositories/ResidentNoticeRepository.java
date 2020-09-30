package com.sparta.panda.uos_manager.common.repositories;

import com.sparta.panda.uos_manager.common.entities.ResidentNotice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResidentNoticeRepository extends CrudRepository<ResidentNotice, Integer> {

    @Override
    <S extends ResidentNotice> S save(S s);

    List<ResidentNotice> findByOrderByDateTimePostedDesc();

}
