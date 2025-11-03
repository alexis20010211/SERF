package com.financorp.serf.report.builder;

import com.financorp.serf.model.Reporte;
import com.financorp.serf.model.ReporteFinanciero;

public class ReporteFinancieroBuilder implements ReportBuilder {

    private ReporteFinanciero reporte;

    @Override
    public void crearNuevoReporte() {
        this.reporte = new ReporteFinanciero();
    }

    @Override
    public void construirEncabezado() {
        reporte.setTitulo("Reporte Financiero Global 2025");
        reporte.setPeriodo("Enero - Diciembre 2025");
        reporte.setDepartamento("Finanzas Corporativas");
    }

    @Override
    public void construirCuerpo() {
        reporte.setDatos("Ingresos, gastos, utilidades y flujo de caja consolidado.");
        reporte.setGraficos("Gráficos de barras, líneas y comparativos trimestrales.");
    }

    @Override
    public void construirPie() {
        reporte.setConclusiones("Crecimiento financiero del 12% respecto al año anterior.");
    }

    @Override
    public Reporte obtenerReporte() {
        return this.reporte;
    }
}
