package com.financorp.serf.model;

public class ReporteInventario implements Reporte {

    @Override
    public String generar() {
        return """
               📦 Reporte de Inventario generado.
               Incluye existencias actuales, rotación y valoración de activos.
               """ + obtenerConfiguracion();
    }
}
