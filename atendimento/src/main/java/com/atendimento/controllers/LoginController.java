package com.atendimento.controllers;

import com.atendimento.models.Login;
import com.atendimento.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = "/verificar-credenciais")
    public ResponseEntity<Boolean> verificaCredenciaisLogin(@RequestBody Map<String,String> login) {
        Boolean autenticado = this.loginService.verificaCredenciaisLogin(login);
        if (autenticado) {
             return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
    }

    @PostMapping
    public ResponseEntity<Login> createUser(@RequestBody Login login) {
        return loginService.createUser(login)
                .map(l -> ResponseEntity.status(HttpStatus.CREATED).body(l))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

}
