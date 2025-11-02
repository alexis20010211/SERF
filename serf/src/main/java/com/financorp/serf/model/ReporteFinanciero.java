package com.financorp.serf.model;

import com.financorp.serf.patterns.singleton.ConfiguracionGlobal;

/**
 * Representa un reporte financiero dentro del sistema SERF.
 * <p>
 * Implementa la interfaz {@link Reporte} y utiliza el patrón
 * <b>Singleton</b> mediante {@link ConfiguracionGlobal} para
 * obtener los valores de configuración global al momento de la creación.
 * </p>
 *
 * <p>Este reporte contiene información relacionada con el país sede,
 * la moneda corporativa y el formato de fecha definidos globalmente
 * por la organización.</p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * ReporteFinanciero reporte = new ReporteFinanciero();
 * System.out.println(reporte.generar());
 * }</pre>
 *
 * @author Alesi
 * @version 1.0
 * @see com.financorp.serf.model.Reporte
 * @see com.financorp.serf.patterns.singleton.ConfiguracionGlobal
 */
public class ReporteFinanciero implements Reporte {

    private String pais;
    private String moneda;
    private String formatoFecha;

    /**
     * Constructor que inicializa los valores del reporte utilizando
     * la configuración global proporcionada por el Singleton
     * {@link ConfiguracionGlobal}.
     */
    public ReporteFinanciero() {
        ConfiguracionGlobal config = ConfiguracionGlobal.getInstancia();
        this.pais = config.getPaisSede();
        this.moneda = config.getMonedaCorporativa();
        this.formatoFecha = config.getFormatoFecha();
    }

    /**
     * Genera el reporte financiero utilizando los parámetros actuales
     * de configuración.
     *
     * @return cadena con el contenido del reporte financiero generado
     */
    @Override
    public String generar() {
        return """
📊 Reporte Financiero generado con configuración:
- País: %s
- Moneda: %s
- Formato fecha: %s
""".formatted(pais, moneda, formatoFecha);
    }

    // ---------------------- Getters y Setters ----------------------

    /**
     * Obtiene el país sede configurado.
     * @return nombre del país sede
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece manualmente el país sede (opcional).
     * @param pais país sede del reporte
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtiene la moneda utilizada en el reporte.
     * @return nombre de la moneda corporativa
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * Asigna manualmente la moneda del reporte (opcional).
     * @param moneda tipo de moneda a utilizar
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * Obtiene el formato de fecha configurado.
     * @return formato de fecha corporativo
     */
    public String getFormatoFecha() {
        return formatoFecha;
    }

    /**
     * Establece manualmente el formato de fecha del reporte (opcional).
     * @param formatoFecha formato de fecha a aplicar
     */
    public void setFormatoFecha(String formatoFecha) {
        this.formatoFecha = formatoFecha;
    }
}
