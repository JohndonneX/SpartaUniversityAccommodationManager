package com.sparta.panda.uos_manager.generalPublic.services;

import com.sparta.panda.uos_manager.common.entities.Enquiry;
import com.sparta.panda.uos_manager.common.repositories.EnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnquiryService {
    private final EnquiryRepository enquiryRepository;

    @Autowired
    public EnquiryService(EnquiryRepository enquiryRepository) {
        this.enquiryRepository = enquiryRepository;
    }

    public void saveEnquiry(Enquiry enquiry) {
        enquiryRepository.save(enquiry);
    }

}
