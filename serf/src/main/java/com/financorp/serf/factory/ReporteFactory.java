package com.financorp.serf.factory;

import com.financorp.serf.model.Reporte;
import com.financorp.serf.model.ReporteFinanciero;
import com.financorp.serf.model.ReporteGeneral;
import com.financorp.serf.model.ReporteInventario;
import com.financorp.serf.model.ReporteVentas;

/**
 * Fábrica encargada de la creación de diferentes tipos de {@link Reporte}.
 * <p>
 * Implementa el patrón de diseño <b>Factory Method</b>, permitiendo instanciar
 * distintos tipos de reportes sin exponer la lógica de creación al cliente.
 * </p>
 *
 * <p>Los tipos disponibles son:</p>
 * <ul>
 *   <li><b>financiero</b> → {@link ReporteFinanciero}</li>
 *   <li><b>inventario</b> → {@link ReporteInventario}</li>
 *   <li><b>ventas</b> → {@link ReporteVentas}</li>
 *   <li><b>general</b> → {@link ReporteGeneral}</li>
 * </ul>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Reporte reporte = ReporteFactory.crearReporte("financiero");
 * reporte.generar();
 * }</pre>
 *
 * @author Alesi
 * @version 1.0
 */
public class ReporteFactory {

    /**
     * Crea una instancia del tipo de {@link Reporte} especificado.
     *
     * @param tipo tipo de reporte a crear (puede ser "financiero", "inventario", "ventas" o "general")
     * @return una instancia concreta de {@link Reporte}
     * @throws IllegalArgumentException si el tipo de reporte no es reconocido
     */
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
