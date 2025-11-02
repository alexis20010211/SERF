package com.financorp.serf.model;

import com.financorp.serf.patterns.singleton.ConfiguracionGlobal;

/**
 * Interfaz base para la generación de reportes dentro del sistema SERF.
 * <p>
 * Define el contrato que deben cumplir todos los tipos de reportes, como
 * {@link ReporteFinanciero}, {@link ReporteInventario}, {@link ReporteVentas} y {@link ReporteGeneral}.
 * </p>
 *
 * <p>Además, implementa un método por defecto que utiliza el patrón <b>Singleton</b>
 * a través de {@link ConfiguracionGlobal}, para acceder a configuraciones globales
 * del sistema (por ejemplo: moneda, formato de fecha y país sede).</p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Reporte reporte = new ReporteFinanciero();
 * System.out.println(reporte.generar());
 * System.out.println(reporte.obtenerConfiguracion());
 * }</pre>
 *
 * @author Alesi
 * @version 1.0
 * @see com.financorp.serf.patterns.singleton.ConfiguracionGlobal
 */
public interface Reporte {

    /**
     * Genera el contenido del reporte correspondiente.
     * <p>
     * Cada clase concreta debe implementar este método para definir su propia
     * lógica de generación (por ejemplo, reporte financiero, de ventas o de inventario).
     * </p>
     *
     * @return una cadena de texto que representa el contenido del reporte generado
     */
    String generar();

    /**
     * Obtiene los valores de configuración global aplicados al reporte.
     * <p>
     * Este método utiliza el patrón <b>Singleton</b> para acceder a una única
     * instancia de {@link ConfiguracionGlobal}, garantizando coherencia en los
     * parámetros globales del sistema (como moneda, formato de fecha y país sede).
     * </p>
     *
     * @return cadena descriptiva con los parámetros de configuración global
     */
    default String obtenerConfiguracion() {
        ConfiguracionGlobal conf = ConfiguracionGlobal.getInstancia();
        return "Moneda: " + conf.getMonedaCorporativa() +
               ", Formato de fecha: " + conf.getFormatoFecha() +
               ", País sede: " + conf.getPaisSede();
    }
}
