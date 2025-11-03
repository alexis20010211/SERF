package com.financorp.serf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/solicitudes") // plural para consistencia con otros endpoints
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    // 🔹 GET públicos: cualquiera puede listar o ver solicitud
    @GetMapping
    public List<Solicitud> listarSolicitudes() {
        return solicitudService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<Solicitud> obtenerSolicitud(@PathVariable Long id) {
        return solicitudService.obtenerPorId(id);
    }

    // 🔹 POST y DELETE protegidos
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'TECNICO')")
    public Solicitud crearSolicitud(@RequestBody Solicitud solicitud) {
        return solicitudService.guardarSolicitud(solicitud);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TECNICO')")
    public void eliminarSolicitud(@PathVariable Long id) {
        solicitudService.eliminarSolicitud(id);
    }
}
