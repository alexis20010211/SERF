package com.financorp.serf.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financorp.serf.repository.UserRepository;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 🔹 GET público: cualquiera puede listar usuarios
    @GetMapping("/api/users")
    public List<Map<String, Object>> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(u -> Map.of(
                        "id", u.getId(),
                        "username", u.getUsername(),
                        "roles", u.getRoles().stream()
                                        .map(r -> r.getName())
                                        .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }
}
