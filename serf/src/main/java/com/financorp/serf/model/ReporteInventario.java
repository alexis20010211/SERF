package com.financorp.serf.model;

/**
 * Representa un reporte de inventario dentro del sistema SERF.
 * <p>
 * Implementa la interfaz {@link Reporte} y hereda su método por defecto
 * {@link Reporte#obtenerConfiguracion()}, el cual obtiene los valores
 * desde el patrón <b>Singleton</b> implementado en
 * {@code ConfiguracionGlobal}.
 * </p>
 *
 * <p>Este reporte incluye información sobre existencias actuales,
 * rotación de productos y valoración de activos disponibles
 * en los distintos almacenes o filiales.</p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * ReporteInventario reporte = new ReporteInventario();
 * System.out.println(reporte.generar());
 * }</pre>
 *
 * @author Alesi
 * @version 1.0
 * @see com.financorp.serf.model.Reporte
 * @see com.financorp.serf.patterns.singleton.ConfiguracionGlobal
 */
public class ReporteInventario implements Reporte {

    /**
     * Genera el contenido del reporte de inventario.
     * <p>
     * Incluye detalles de existencias, rotación y valoración de activos,
     * además de la configuración global del sistema obtenida mediante
     * el método {@link #obtenerConfiguracion()}.
     * </p>
     *
     * @return texto descriptivo con los datos del reporte y la configuración global
     */
    @Override
    public String generar() {
        return """
               📦 Reporte de Inventario generado.
               Incluye existencias actuales, rotación y valoración de activos.
               """ + obtenerConfiguracion();
    }
}
