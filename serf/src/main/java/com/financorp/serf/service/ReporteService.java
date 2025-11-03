package com.financorp.serf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financorp.serf.model.ReporteEntity;
import com.financorp.serf.repository.ReporteRepository;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    public List<ReporteEntity> getAllReportes() {
        return reporteRepository.findAll();
    }

    public ReporteEntity getReporteById(Long id) {
        Optional<ReporteEntity> reporte = reporteRepository.findById(id);
        return reporte.orElse(null);
    }

    public ReporteEntity saveReporte(ReporteEntity reporte) {
        return reporteRepository.save(reporte);
    }

    public ReporteEntity updateReporte(Long id, ReporteEntity reporteActualizado) {
        return reporteRepository.findById(id)
                .map(reporte -> {
                    reporte.setNombre(reporteActualizado.getNombre());
                    reporte.setDescripcion(reporteActualizado.getDescripcion());
                    return reporteRepository.save(reporte);
                })
                .orElse(null);
    }

    public void deleteReporte(Long id) {
        reporteRepository.deleteById(id);
    }
}
