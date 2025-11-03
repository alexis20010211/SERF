package com.financorp.serf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Configuración CORS específica para tu frontend Angular
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PruebaController {

    // Endpoint de prueba: http://localhost:8080/api/prueba
    @GetMapping("/api/prueba")
    public String prueba() {
        return "¡Backend conectado correctamente!";
    }
}
