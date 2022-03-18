package com.atendimento.config;

import com.atendimento.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestFilter extends OncePerRequestFilter {

    @Autowired
    UsuarioClient usuarioClient;

    public RequestFilter(UsuarioClient usuarioClient) {
        this.usuarioClient = usuarioClient;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {


        if (request.getMethod().equals(HttpMethod.GET) && request.getRequestURI().intern().equals("/atendimentos/atendimentos/")) {
            if (usuarioClient.autenticarTokenUsuario(request.getHeader("Authorization"))) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is not valid.");
            }
        }else {
            chain.doFilter(request, response);
        }
    }
}
