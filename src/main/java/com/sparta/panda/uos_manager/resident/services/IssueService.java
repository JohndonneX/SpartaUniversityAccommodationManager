package com.sparta.panda.uos_manager.resident.services;

import com.sparta.panda.uos_manager.common.entities.Issue;
import com.sparta.panda.uos_manager.common.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueService {
    private final IssueRepository issueRepository;

    @Autowired
    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public void saveIssue(Issue issue) {
        issueRepository.save(issue);
    }
}
