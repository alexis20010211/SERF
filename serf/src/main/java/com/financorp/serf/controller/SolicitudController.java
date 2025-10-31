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

@RestController
@RequestMapping("/api/solicitudes")
@CrossOrigin(origins = "*")
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    // Obtener todas las solicitudes
    @GetMapping
    public List<Solicitud> listarSolicitudes() {
        return solicitudService.obtenerTodas();
    }

    // Obtener solicitud por ID
    @GetMapping("/{id}")
    public Optional<Solicitud> obtenerSolicitud(@PathVariable Long id) {
        return solicitudService.obtenerPorId(id);
    }

    // Crear nueva solicitud
    @PostMapping
    public Solicitud crearSolicitud(@RequestBody Solicitud solicitud) {
        return solicitudService.guardarSolicitud(solicitud);
    }

    // Eliminar solicitud
    @DeleteMapping("/{id}")
    public void eliminarSolicitud(@PathVariable Long id) {
        solicitudService.eliminarSolicitud(id);
    }
}
