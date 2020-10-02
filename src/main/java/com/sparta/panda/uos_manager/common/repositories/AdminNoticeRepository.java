package com.sparta.panda.uos_manager.common.repositories;

import com.sparta.panda.uos_manager.common.entities.AdminNotice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminNoticeRepository extends CrudRepository<AdminNotice, Integer> {

    @Override
    <S extends AdminNotice> S save(S s);

    List<AdminNotice> findByOrderByDateTimePostedDesc();
}
