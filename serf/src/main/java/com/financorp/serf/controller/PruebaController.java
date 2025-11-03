package com.financorp.serf.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Configuración CORS específica para tu frontend Angular
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PruebaController {

    // 🔹 GET público (solo autenticación requerida)
    @GetMapping("/api/prueba")
    @PreAuthorize("isAuthenticated()")
    public String prueba() {
        return "¡Backend conectado correctamente!";
    }
}
