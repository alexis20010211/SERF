package com.financorp.serf.model;

public class ReporteVentas implements Reporte {

    @Override
    public String generar() {
        return """
               💰 Reporte de Ventas generado correctamente.
               Incluye ventas por producto, zona y periodo.
               """ + obtenerConfiguracion();
    }
}
