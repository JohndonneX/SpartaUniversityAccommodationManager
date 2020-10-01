package com.sparta.panda.uos_manager.admin.services;

import com.sparta.panda.uos_manager.common.entities.AdminNotice;
import com.sparta.panda.uos_manager.common.repositories.AdminNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminNoticeService {

    private final AdminNoticeRepository adminNoticeRepository;

    @Autowired
    public AdminNoticeService(AdminNoticeRepository adminNoticeRepository) {
        this.adminNoticeRepository = adminNoticeRepository;
    }

    public List<AdminNotice> getAllNotices() {
        return (List<AdminNotice>) adminNoticeRepository.findAll();
    }

}
