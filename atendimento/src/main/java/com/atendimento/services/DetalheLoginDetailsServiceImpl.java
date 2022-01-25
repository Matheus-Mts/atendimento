//package com.atendimento.services;
//
//import com.atendimento.data.DataLoginDetalhe;
//import com.atendimento.models.Login;
//import com.atendimento.repository.LoginRepository;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@Service
//public class DetalheLoginDetailsServiceImpl implements UserDetailsService {
//
//    private final LoginRepository loginRepository;
//
//    public DetalheLoginDetailsServiceImpl(LoginRepository loginRepository) {
//        this.loginRepository = loginRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Login> loginOptional = Optional.ofNullable(loginRepository.findByEmail(username));
//        if (loginOptional.isPresent()) {
//            return new DataLoginDetalhe(loginOptional);
//        }    else {
//            throw new UsernameNotFoundException("Usuario não encontrado: " + username);
//        }
//    }
//}
//
