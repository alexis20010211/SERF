package com.financorp.serf.report.builder;

import com.financorp.serf.model.Reporte;

public class ReportDirector {

    public static Reporte construirReporte(Reporte reporteBase, String encabezado, String piePagina) {
        return new ReportBuilder(reporteBase)
                .agregarEncabezado(encabezado)
                .agregarPiePagina(piePagina)
                .build();
    }
}

