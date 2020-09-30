package com.sparta.panda.uos_manager.resident.services;

import com.sparta.panda.uos_manager.common.entities.ResidentNotice;
import com.sparta.panda.uos_manager.common.repositories.ResidentNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ResidentNoticeBoardService {

    private final ResidentNoticeRepository residentNoticeRepository;

    @Autowired
    public ResidentNoticeBoardService(ResidentNoticeRepository residentNoticeRepository) {
        this.residentNoticeRepository = residentNoticeRepository;
    }

    public void saveResidentNotice(ResidentNotice residentNotice) {
        residentNoticeRepository.save(residentNotice);
    }

    public ResidentNotice getResidentNoticeById(int id) {
        Optional<ResidentNotice> residentNotice = residentNoticeRepository.findById(id);
        if (residentNotice.isPresent()) {
            return residentNotice.get();
        } else {
            return null;
        }
    }

    public List<ResidentNotice> getAllNotices() {
        List<ResidentNotice> allNotices = (List<ResidentNotice>) residentNoticeRepository.findAll();
        return allNotices;
    }

    public List<ResidentNotice> getAllNoticesOrderedByDateTimePostedDesc() {
        return residentNoticeRepository.findByOrderByDateTimePostedDesc();
    }

    public void deleteNotice(int id) {
        residentNoticeRepository.deleteById(id);
    }

}
