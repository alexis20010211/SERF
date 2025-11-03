package com.financorp.serf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financorp.serf.model.Tecnico;
import com.financorp.serf.service.TecnicoService;

@RestController
@RequestMapping("/api/tecnicos")
// Permitir solicitudes desde Angular con credenciales
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class TecnicoController {

    private final TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    @GetMapping
    public List<Tecnico> listarTecnicos() {
        return tecnicoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Tecnico> obtenerTecnico(@PathVariable Long id) {
        return tecnicoService.obtenerPorId(id);
    }

    @PostMapping
    public Tecnico crearTecnico(@RequestBody Tecnico tecnico) {
        return tecnicoService.guardarTecnico(tecnico);
    }

    @DeleteMapping("/{id}")
    public void eliminarTecnico(@PathVariable Long id) {
        tecnicoService.eliminarTecnico(id);
    }
}
