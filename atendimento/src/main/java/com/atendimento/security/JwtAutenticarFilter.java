//package com.atendimento.security;
//
//import com.atendimento.models.Login;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import data.DetalheLoginData;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//
//public class JwtAutenticarFilter extends UsernamePasswordAuthenticationFilter {
//
//
//    public static final long TOKEN_EXPIRACAO = 360000000;
//
//    public static final String TOKEN_SENHA = "d259b3b3-1310-4bab-a849-91a95907e6c7";
//
//
//    private final AuthenticationManager authenticationManager;
//
//    public JwtAutenticarFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        try {
//            Login login = new ObjectMapper().readValue(request.getInputStream(),Login.class);
//            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                    login.getEmail(),
//                    login.getSenha(),
//                    new ArrayList<>()
//            ));
//        } catch (IOException e) {
//            throw new RuntimeException("falha ao autenticar usuario",e);
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain, Authentication authResult)
//                                                                            throws IOException, ServletException {
//        DetalheLoginData loginData =  (DetalheLoginData) authResult.getPrincipal();
//        String token = JWT.create()
//                .withSubject(loginData.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis()+ TOKEN_EXPIRACAO))
//                .sign(Algorithm.HMAC512(TOKEN_SENHA));
//
//        response.getWriter().write(token);
//        response.getWriter().flush();
//    }
//}
