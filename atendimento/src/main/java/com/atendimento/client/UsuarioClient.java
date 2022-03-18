package com.atendimento.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class UsuarioClient {

    @Value("${usuario-service}")
    private String usuarioApiUrl;


    private RestTemplate restTemplate;


    public boolean autenticarTokenUsuario(String token) {
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        try {
            ResponseEntity<Boolean> response = restTemplate.exchange(usuarioApiUrl, HttpMethod.GET,requestEntity,Boolean.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            return false;
        }
    }
}
