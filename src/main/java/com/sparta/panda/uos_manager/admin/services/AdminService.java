package com.sparta.panda.uos_manager.admin.services;

import com.sparta.panda.uos_manager.common.entities.Admin;
import com.sparta.panda.uos_manager.common.entities.Resident;
import com.sparta.panda.uos_manager.common.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmin(){
        return (List<Admin>) adminRepository.findAll();

    public Admin getAdminById(int id) {
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isPresent()) {
            return admin.get();
        } else {
            return null;
        }
    }

}
