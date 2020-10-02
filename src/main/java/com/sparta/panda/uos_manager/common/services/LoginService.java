package com.sparta.panda.uos_manager.common.services;

import com.sparta.panda.uos_manager.common.entities.Login;
import com.sparta.panda.uos_manager.common.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Optional<Login> getLoginByEmail(String email) {
        return loginRepository.findByEmail(email);
    }

}
