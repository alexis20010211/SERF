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

/**
 * Controlador REST que gestiona las operaciones CRUD relacionadas con los técnicos.
 * Permite listar, obtener, registrar y eliminar técnicos dentro del sistema.
 *
 * <p>Ruta base: <b>/api/tecnicos</b></p>
 *
 * <p>Las solicitudes son aceptadas desde cualquier origen gracias a {@link CrossOrigin}.</p>
 *
 * @author Alesi
 * @version 1.0
 */
@RestController
@RequestMapping("/api/tecnicos")
@CrossOrigin(origins = "*")
public class TecnicoController {

    private final TecnicoService tecnicoService;

    /**
     * Constructor que inyecta la dependencia del servicio de técnicos.
     *
     * @param tecnicoService servicio que contiene la lógica de negocio para técnicos
     */
    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    /**
     * Obtiene la lista de todos los técnicos registrados en el sistema.
     *
     * @return lista de objetos {@link Tecnico}
     */
    @GetMapping
    public List<Tecnico> listarTecnicos() {
        return tecnicoService.obtenerTodos();
    }

    /**
     * Busca un técnico específico a partir de su identificador único.
     *
     * @param id identificador del técnico a consultar
     * @return un {@link Optional} que contiene el técnico si existe, o vacío si no se encuentra
     */
    @GetMapping("/{id}")
    public Optional<Tecnico> obtenerTecnico(@PathVariable Long id) {
        return tecnicoService.obtenerPorId(id);
    }

    /**
     * Crea un nuevo técnico y lo guarda en la base de datos.
     *
     * @param tecnico objeto {@link Tecnico} con los datos del nuevo registro
     * @return el técnico creado con su identificador asignado
     */
    @PostMapping
    public Tecnico crearTecnico(@RequestBody Tecnico tecnico) {
        return tecnicoService.guardarTecnico(tecnico);
    }

    /**
     * Elimina un técnico existente a partir de su identificador.
     *
     * @param id identificador del técnico que se desea eliminar
     */
    @DeleteMapping("/{id}")
    public void eliminarTecnico(@PathVariable Long id) {
        tecnicoService.eliminarTecnico(id);
    }
}
