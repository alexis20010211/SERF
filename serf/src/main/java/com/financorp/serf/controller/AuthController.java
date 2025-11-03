package com.financorp.serf.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financorp.serf.util.JwtUtil;

import lombok.Data;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authManager,
                          UserDetailsService userDetailsService,
                          JwtUtil jwtUtil) {
        this.authManager = authManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    // 🔹 Endpoint público para login
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        // 🔹 Autenticar usuario con Spring Security
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        // 🔹 Cargar usuario
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

        // 🔹 Extraer roles del usuario
        List<String> roles = userDetails.getAuthorities()
                                        .stream()
                                        .map(a -> a.getAuthority())
                                        .collect(Collectors.toList());

        // 🔹 Generar JWT con roles
        final String jwt = jwtUtil.generateToken(userDetails.getUsername(), roles);

        return new AuthResponse(jwt);
    }

    // 🔹 DTO para recibir username/password
    @Data
    public static class AuthRequest {
        private String username;
        private String password;
    }

    // 🔹 DTO para devolver JWT
    @Data
    public static class AuthResponse {
        private final String token;
    }
}
