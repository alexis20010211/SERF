package com.financorp.serf.report.builder;

import com.financorp.serf.model.Reporte;
import com.financorp.serf.model.ReporteFinanciero;

/**
 * Builder específico para ReporteFinanciero.
 * Permite armar paso a paso los datos del reporte.
 */
public class ReporteFinancieroBuilder {

    private final ReporteFinanciero reporte;

    public ReporteFinancieroBuilder() {
        this.reporte = new ReporteFinanciero();
    }

    public ReporteFinancieroBuilder conTitulo(String titulo) {
        reporte.setTitulo(titulo);
        return this;
    }

    public ReporteFinancieroBuilder conPeriodo(String periodo) {
        reporte.setPeriodo(periodo);
        return this;
    }

    public ReporteFinancieroBuilder conDepartamento(String departamento) {
        reporte.setDepartamento(departamento);
        return this;
    }

    public ReporteFinancieroBuilder conDatos(String datos) {
        reporte.setDatos(datos);
        return this;
    }

    public ReporteFinancieroBuilder conGraficos(String graficos) {
        reporte.setGraficos(graficos);
        return this;
    }

    public ReporteFinancieroBuilder conConclusiones(String conclusiones) {
        reporte.setConclusiones(conclusiones);
        return this;
    }

    /**
     * Construye el ReporteFinanciero final
     * @return ReporteFinanciero listo para generar
     */
    public ReporteFinanciero build() {
        return reporte;
    }

    /**
     * Construye un ReporteFinanciero listo como Reporte genérico.
     * Permite integrarlo con ReportBuilder si se quiere agregar encabezado o pie de página.
     * @return Reporte
     */
    public Reporte buildComoReporte() {
        return reporte;
    }
}
