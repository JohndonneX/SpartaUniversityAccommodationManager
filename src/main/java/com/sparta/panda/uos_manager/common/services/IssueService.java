package com.sparta.panda.uos_manager.common.services;

import com.sparta.panda.uos_manager.common.entities.Issue;
import com.sparta.panda.uos_manager.common.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Optional<Issue> getIssueById(Integer id) {
        return issueRepository.findById(id);
    }

    public void markIssueAsCompletedById(Integer id) {
        Issue issue = issueRepository.findById(id).get();
        issue.setDateTimeResolved(LocalDateTime.now());
        issue.setStatus("Completed");
        issueRepository.save(issue);
    }

}
