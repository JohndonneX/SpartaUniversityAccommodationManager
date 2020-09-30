package com.sparta.panda.uos_manager.common.services;

import com.sparta.panda.uos_manager.common.entities.Issue;
import com.sparta.panda.uos_manager.common.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {

    private final IssueRepository issueRepository;

    @Autowired
    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public List<Issue> getAllIssues() {
        return (List<Issue>) issueRepository.findAll();
    }
    public void saveIssue(Issue issue) {
        issueRepository.save(issue);
    }

}
