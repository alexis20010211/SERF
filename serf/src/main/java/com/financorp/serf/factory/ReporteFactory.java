package com.financorp.serf.factory;

import com.financorp.serf.model.Reporte;
import com.financorp.serf.model.ReporteFinanciero;
import com.financorp.serf.model.ReporteInventario;
import com.financorp.serf.model.ReporteVentas;
import com.financorp.serf.model.ReporteGeneral;

public class ReporteFactory {

    public static Reporte crearReporte(String tipo) {
        return switch (tipo) {
            case "financiero" -> new ReporteFinanciero();
            case "inventario" -> new ReporteInventario();
            case "ventas" -> new ReporteVentas();
            case "general" -> new ReporteGeneral();
            default -> throw new IllegalArgumentException("Tipo de reporte desconocido: " + tipo);
        };
    }
}
