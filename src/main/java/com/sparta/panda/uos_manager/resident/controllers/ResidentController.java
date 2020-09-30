package com.sparta.panda.uos_manager.resident.controllers;

import com.sparta.panda.uos_manager.common.entities.ResidentNotice;
import com.sparta.panda.uos_manager.common.utilities.CurrentUser;
import com.sparta.panda.uos_manager.resident.services.ResidentNoticeBoardService;
import com.sparta.panda.uos_manager.resident.services.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class ResidentController {

    private ResidentNoticeBoardService residentNoticeBoardService;
    private ResidentService residentService;

    @Autowired
    public ResidentController(ResidentNoticeBoardService residentNoticeBoardService, ResidentService residentService) {
        this.residentNoticeBoardService = residentNoticeBoardService;
        this.residentService = residentService;
    }

    @GetMapping("/residentNoticeBoard")
    public String getResidentNoticeBoard(Model model) {
        model.addAttribute("notices", residentNoticeBoardService.getAllNoticesOrderedByDateTimePostedDesc());
        model.addAttribute("role", CurrentUser.getResident().getRole());
        return "/resident/residentNoticeBoard";
    }

    @GetMapping("/residentNoticeBoardCreatePost")
    public String getResidentNoticeBoardCreatePost(Model model) {
        model.addAttribute("newResidentPost", new ResidentNotice());
        return "/resident/residentNoticeBoardCreatePost";
    }

    @PostMapping("/residentNoticeBoardCreatePost")
    public ModelAndView postResidentNoticeBoardCreatePost(@ModelAttribute ResidentNotice newResidentPost, ModelMap modelMap) {
        newResidentPost.setResidentId(2);
        newResidentPost.setResidentByResidentId(residentService.getResidentById(2));
        newResidentPost.setDateTimePosted(LocalDateTime.now());
        residentNoticeBoardService.saveResidentNotice(newResidentPost);
        modelMap.addAttribute("notices", residentNoticeBoardService.getAllNoticesOrderedByDateTimePostedDesc());
        modelMap.addAttribute("role", CurrentUser.getResident().getRole());

        return new ModelAndView("redirect:http://localhost:8080/residentNoticeBoard", modelMap);
    }

    @PostMapping("/residentNoticeBoardDelete")
    public ModelAndView postResidentNoticeBoardDelete(@RequestParam int postId) {
        residentNoticeBoardService.deleteNotice(postId);
        return new ModelAndView("redirect:http://localhost:8080/residentNoticeBoard");
    }
}
