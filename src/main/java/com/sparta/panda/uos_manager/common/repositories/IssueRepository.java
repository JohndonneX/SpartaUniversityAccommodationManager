package com.sparta.panda.uos_manager.common.repositories;

import com.sparta.panda.uos_manager.common.entities.Issue;
import org.springframework.data.repository.CrudRepository;

public interface IssueRepository extends CrudRepository<Issue, Integer> {

    @Override
    <S extends Issue> S save(S s);
}
