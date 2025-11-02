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

import com.financorp.serf.model.Solicitud;
import com.financorp.serf.service.SolicitudService;

/**
 * Controlador REST encargado de gestionar las operaciones relacionadas con las solicitudes.
 * Permite listar, obtener, crear y eliminar solicitudes en el sistema.
 *
 * <p>Ruta base: <b>/api/solicitudes</b></p>
 *
 * <p>Las peticiones se aceptan desde cualquier origen gracias a {@link CrossOrigin}.</p>
 *
 * @author Alesi
 * @version 1.0
 */
@RestController
@RequestMapping("/api/solicitudes")
@CrossOrigin(origins = "*")
public class SolicitudController {

    private final SolicitudService solicitudService;

    /**
     * Constructor que inyecta el servicio de solicitudes.
     *
     * @param solicitudService servicio que contiene la lógica de negocio para solicitudes
     */
    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    /**
     * Obtiene la lista completa de solicitudes registradas en el sistema.
     *
     * @return una lista de objetos {@link Solicitud}
     */
    @GetMapping
    public List<Solicitud> listarSolicitudes() {
        return solicitudService.obtenerTodas();
    }

    /**
     * Obtiene una solicitud específica a partir de su identificador.
     *
     * @param id identificador único de la solicitud a consultar
     * @return un {@link Optional} que contiene la solicitud si existe, o vacío si no se encuentra
     */
    @GetMapping("/{id}")
    public Optional<Solicitud> obtenerSolicitud(@PathVariable Long id) {
        return solicitudService.obtenerPorId(id);
    }

    /**
     * Crea una nueva solicitud en el sistema.
     *
     * @param solicitud objeto {@link Solicitud} con los datos de la nueva solicitud
     * @return la solicitud creada con su ID asignado
     */
    @PostMapping
    public Solicitud crearSolicitud(@RequestBody Solicitud solicitud) {
        return solicitudService.guardarSolicitud(solicitud);
    }

    /**
     * Elimina una solicitud existente según su identificador.
     *
     * @param id identificador de la solicitud a eliminar
     */
    @DeleteMapping("/{id}")
    public void eliminarSolicitud(@PathVariable Long id) {
        solicitudService.eliminarSolicitud(id);
    }
}
