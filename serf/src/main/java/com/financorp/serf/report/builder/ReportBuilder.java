package com.financorp.serf.report.builder;

import com.financorp.serf.model.Reporte;

/**
 * Patrón BUILDER:
 * Permite agregar secciones al reporte paso a paso.
 */
public class ReportBuilder {

    private final Reporte reporte;
    private String encabezado;
    private String piePagina;

    public ReportBuilder(Reporte reporte) {
        this.reporte = reporte;
    }

    public ReportBuilder agregarEncabezado(String encabezado) {
        this.encabezado = encabezado;
        return this;
    }

    public ReportBuilder agregarPiePagina(String piePagina) {
        this.piePagina = piePagina;
        return this;
    }

    public Reporte build() {
        return () -> (encabezado != null ? encabezado + "\n\n" : "") +
                     reporte.generar() +
                     (piePagina != null ? "\n\n" + piePagina : "");
    }
}
