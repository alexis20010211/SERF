package com.financorp.serf.model;

import com.financorp.serf.patterns.singleton.ConfiguracionGlobal;

/**
 * Representa un reporte general dentro del sistema SERF.
 * <p>
 * Implementa la interfaz {@link Reporte} y utiliza el patrón
 * <b>Singleton</b> mediante {@link ConfiguracionGlobal} para
 * obtener los valores de configuración global al ser instanciado.
 * </p>
 *
 * <p>Este reporte contiene información general de la corporación,
 * incluyendo país sede, moneda corporativa y formato de fecha.</p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * ReporteGeneral reporte = new ReporteGeneral();
 * System.out.println(reporte.generar());
 * }</pre>
 *
 * @author Alesi
 * @version 1.0
 * @see com.financorp.serf.model.Reporte
 * @see com.financorp.serf.patterns.singleton.ConfiguracionGlobal
 */
public class ReporteGeneral implements Reporte {

    private String pais;
    private String moneda;
    private String formatoFecha;

    /**
     * Constructor que inicializa el reporte general utilizando
     * los valores de la configuración global obtenidos desde
     * {@link ConfiguracionGlobal}.
     */
    public ReporteGeneral() {
        ConfiguracionGlobal config = ConfiguracionGlobal.getInstancia();
        this.pais = config.getPaisSede();
        this.moneda = config.getMonedaCorporativa();
        this.formatoFecha = config.getFormatoFecha();
    }

    /**
     * Genera el contenido del reporte general con los valores actuales
     * de configuración global.
     *
     * @return cadena de texto que representa el reporte generado
     */
    @Override
    public String generar() {
        return """
📄 Reporte General generado con configuración:
- País: %s
- Moneda: %s
- Formato de fecha: %s
""".formatted(pais, moneda, formatoFecha);
    }

    // ---------------------- Getters y Setters ----------------------

    /**
     * Obtiene el país sede del reporte.
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
     * Obtiene la moneda corporativa.
     * @return tipo de moneda configurada
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * Asigna manualmente la moneda corporativa (opcional).
     * @param moneda nombre de la moneda
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
     * Define manualmente el formato de fecha (opcional).
     * @param formatoFecha formato de fecha a aplicar
     */
    public void setFormatoFecha(String formatoFecha) {
        this.formatoFecha = formatoFecha;
    }
}
