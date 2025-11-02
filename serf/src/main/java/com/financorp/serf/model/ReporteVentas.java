package com.financorp.serf.model;

/**
 * Representa un reporte de ventas dentro del sistema SERF.
 * <p>
 * Implementa la interfaz {@link Reporte} y aprovecha el método por defecto
 * {@link Reporte#obtenerConfiguracion()} que accede al patrón
 * <b>Singleton</b> implementado en {@code ConfiguracionGlobal}.
 * </p>
 *
 * <p>Este reporte consolida información de ventas por producto, zona y periodo,
 * permitiendo una visión general del rendimiento comercial de cada filial o sede.</p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * ReporteVentas reporte = new ReporteVentas();
 * System.out.println(reporte.generar());
 * }</pre>
 *
 * @author Alesi
 * @version 1.0
 * @see com.financorp.serf.model.Reporte
 * @see com.financorp.serf.patterns.singleton.ConfiguracionGlobal
 */
public class ReporteVentas implements Reporte {

    /**
     * Genera el contenido del reporte de ventas.
     * <p>
     * Incluye información sobre ventas por producto, zona y periodo,
     * además de la configuración global del sistema (moneda, país, formato de fecha).
     * </p>
     *
     * @return texto descriptivo con los datos del reporte y la configuración global
     */
    @Override
    public String generar() {
        return """
               💰 Reporte de Ventas generado correctamente.
               Incluye ventas por producto, zona y periodo.
               """ + obtenerConfiguracion();
    }
}
