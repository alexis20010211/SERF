package com.financorp.serf.factory;

import java.util.List;

import com.financorp.serf.model.InventarioFilial;
import com.financorp.serf.model.Reporte;
import com.financorp.serf.model.ReporteFinanciero;
import com.financorp.serf.model.ReporteGeneral;
import com.financorp.serf.model.ReporteInventario;
import com.financorp.serf.model.ReporteVentas;
import com.financorp.serf.model.Venta;

/**
 * Fábrica encargada de la creación de diferentes tipos de {@link Reporte}.
 * Implementa el patrón Factory Method.
 */
public class ReporteFactory {

    /**
     * Crea un reporte sin datos específicos.
     * Para ReporteInventario y ReporteVentas, pasa listas vacías.
     */
    public static Reporte crearReporte(String tipo) {
        return crearReporte(tipo, null, null);
    }

    /**
     * Crea un reporte con listas opcionales para inventarios o ventas.
     *
     * @param tipo tipo de reporte ("financiero", "inventario", "ventas", "general")
     * @param inventarios lista de inventarios para ReporteInventario (puede ser null)
     * @param ventas lista de ventas para ReporteVentas (puede ser null)
     * @return instancia de Reporte correspondiente
     */
    public static Reporte crearReporte(String tipo, List<InventarioFilial> inventarios, List<Venta> ventas) {
        return switch (tipo) {
            case "financiero" -> new ReporteFinanciero();
            case "inventario" -> new ReporteInventario(
                inventarios != null ? inventarios : List.of() // lista vacía si es null
            );
            case "ventas" -> new ReporteVentas(
                ventas != null ? ventas : List.of() // lista vacía si es null
            );
            case "general" -> new ReporteGeneral();
            default -> throw new IllegalArgumentException("Tipo de reporte desconocido: " + tipo);
        };
    }
}
