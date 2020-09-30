package com.sparta.panda.uos_manager.resident.controllers;
import com.sparta.panda.uos_manager.common.entities.Issue;
import com.sparta.panda.uos_manager.resident.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class ResidentController {
    private final IssueService issueService;

    @Autowired
    public ResidentController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/reportIssue")
    public String reportIssueForm(Model model) {
        model.addAttribute("issue", new Issue());
        return "/resident/issueRequestForm";
    }

    @PostMapping("/submitIssueForm")
    public String contactUsSubmit(@ModelAttribute Issue issue){
        issue.setStatus("Pending");
        issue.setDateTimePosted(LocalDateTime.now());
        issueService.saveIssue(issue);

        return "/resident/issueSubmitSuccess";
    }
}
