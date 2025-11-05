package com.financorp.serf.factory;

import java.util.List;

import com.financorp.serf.model.InventarioFilial;
import com.financorp.serf.model.Reporte;
import com.financorp.serf.model.ReporteInventario;
import com.financorp.serf.model.ReporteVentas;
import com.financorp.serf.model.Venta;
import com.financorp.serf.report.builder.ReportDirector;

public class ReporteFactory {

    public static Reporte crearReporte(String tipo, List<Venta> ventas, List<InventarioFilial> inventario) {
        return switch(tipo) {
            case "VENTAS" -> ReportDirector.construirReporte(
                    new ReporteVentas(ventas),
                    "ENCABEZADO VENTAS",
                    "PIE DE PAGINA VENTAS"
            );
            case "INVENTARIO" -> ReportDirector.construirReporte(
                    new ReporteInventario(inventario),
                    "ENCABEZADO INVENTARIO",
                    "PIE DE PAGINA INVENTARIO"
            );
            default -> throw new IllegalArgumentException("Tipo de reporte desconocido: " + tipo);
        };
    }
}
