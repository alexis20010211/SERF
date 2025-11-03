package com.financorp.serf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financorp.serf.model.ReporteEntity;
import com.financorp.serf.service.ReporteService;

@RestController
@RequestMapping("/api/reporte")
// Permitir solicitudes desde Angular
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    // 🔹 GET públicos: cualquiera puede consultar
    @GetMapping
    public List<ReporteEntity> getAllReportes() {
        return reporteService.getAllReportes();
    }

    @GetMapping("/{id}")
    public ReporteEntity getReporteById(@PathVariable Long id) {
        return reporteService.getReporteById(id);
    }

    // 🔹 POST, PUT y DELETE protegidos: solo ADMIN
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ReporteEntity createReporte(@RequestBody ReporteEntity reporte) {
        return reporteService.saveReporte(reporte);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ReporteEntity updateReporte(@PathVariable Long id, @RequestBody ReporteEntity reporte) {
        return reporteService.updateReporte(id, reporte);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteReporte(@PathVariable Long id) {
        reporteService.deleteReporte(id);
    }
}
