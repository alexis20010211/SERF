package com.financorp.serf.model;

import com.financorp.serf.patterns.singleton.ConfiguracionGlobal;

/**
 * Interfaz base para generación de reportes dentro del sistema SERF.
 * Define el contrato que deben cumplir todos los tipos de reportes,
 * como ReporteFinanciero, ReporteInventario, ReporteVentas y ReporteGeneral.
 *
 * También implementa un método por defecto que utiliza el patrón Singleton
 * a través de ConfiguracionGlobal para acceder a configuraciones globales.
 */
public interface Reporte {

    /**
     * Genera el contenido del reporte correspondiente.
     *
     * @return cadena de texto que representa el contenido del reporte generado
     */
    String generar();

    /**
     * Obtiene los valores de configuración global aplicados al reporte.
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
