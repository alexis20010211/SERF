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
@CrossOrigin(origins = "*")
public class TecnicoController {

    private final TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    // Obtener todos los técnicos
    @GetMapping
    public List<Tecnico> listarTecnicos() {
        return tecnicoService.obtenerTodos();
    }

    // Obtener técnico por ID
    @GetMapping("/{id}")
    public Optional<Tecnico> obtenerTecnico(@PathVariable Long id) {
        return tecnicoService.obtenerPorId(id); // Devuelve Optional<Tecnico>
    }

    // Crear técnico
    @PostMapping
    public Tecnico crearTecnico(@RequestBody Tecnico tecnico) {
        return tecnicoService.guardarTecnico(tecnico); // ⚡ Método correcto del service
    }

    // Eliminar técnico
    @DeleteMapping("/{id}")
    public void eliminarTecnico(@PathVariable Long id) {
        tecnicoService.eliminarTecnico(id); // ⚡ Método correcto del service
    }
}
