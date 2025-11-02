package com.financorp.serf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {

    // Endpoint de prueba: http://localhost:8080/api/prueba
    @GetMapping("/api/prueba")
    public String prueba() {
        return "¡Backend conectado correctamente!";
    }
}
