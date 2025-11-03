package com.financorp.serf.report.builder;

import com.financorp.serf.model.Reporte;

public class ReportDirector {
    private final ReportBuilder builder;

    public ReportDirector(ReportBuilder builder) {
        this.builder = builder;
    }

    public Reporte construirReporte() {
        builder.crearNuevoReporte();
        builder.construirEncabezado();
        builder.construirCuerpo();
        builder.construirPie();
        return builder.obtenerReporte();
    }
}
