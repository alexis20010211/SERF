package com.financorp.serf.report.builder;

import com.financorp.serf.model.Reporte;

public interface ReportBuilder {
    void crearNuevoReporte();
    void construirEncabezado();
    void construirCuerpo();
    void construirPie();
    Reporte obtenerReporte();
}
