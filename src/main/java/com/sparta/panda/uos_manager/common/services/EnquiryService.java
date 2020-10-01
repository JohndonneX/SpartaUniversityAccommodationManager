package com.sparta.panda.uos_manager.common.services;

import com.sparta.panda.uos_manager.common.entities.Enquiry;
import com.sparta.panda.uos_manager.common.repositories.EnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Enquiry> getAllEnquiries() {
        return (List<Enquiry>) enquiryRepository.findAll();
    }

    public void approveEnquiryById(Integer id) {
        Enquiry enquiry = enquiryRepository.findById(id).get();

        enquiry.setStatus("Done");
        enquiryRepository.save(enquiry);
    }

    public void rejectEnquiryById(Integer id) {
        Enquiry enquiry = enquiryRepository.findById(id).get();

        enquiry.setStatus("Rejected");
        enquiryRepository.save(enquiry);
    }

}
