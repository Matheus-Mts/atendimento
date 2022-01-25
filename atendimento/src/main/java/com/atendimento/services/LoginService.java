package com.atendimento.services;

import com.atendimento.models.Login;
import com.atendimento.repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {

    private LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Boolean verificaCredenciaisLogin(Map<String,String> login) {
        Optional<Login> possivelLogin = Optional.ofNullable(loginRepository.findByEmail(login.getOrDefault("email","")));
        if (possivelLogin.isPresent()) {
            return true;
        }else {
            return false;
        }
    }

    public Optional<Login> createUser(Login login) {
        return Optional.ofNullable(loginRepository.save(login));
    }
}
