package com.financorp.serf.service;

import java.util.List;
import java.util.stream.Collectors;

import com.financorp.serf.factory.ReporteFactory;
import com.financorp.serf.model.Reporte;

public class ReporteService {

    public List<Reporte> generarReportes(List<String> tipos) {
        return tipos.stream()
                     .map(ReporteFactory::crearReporte)
                     .collect(Collectors.toList());
    }
}
