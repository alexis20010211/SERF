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
 */
public class ReporteGeneral implements Reporte {

    /** País sede de la corporación */
    private String pais;

    /** Moneda corporativa */
    private String moneda;

    /** Formato de fecha global */
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
📄 REPORTE GENERAL
Configuración Global:
- País: %s
- Moneda: %s
- Formato de fecha: %s
""".formatted(pais, moneda, formatoFecha);
    }

    // ==========================
    // Getters y Setters
    // ==========================
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }

    public String getFormatoFecha() { return formatoFecha; }
    public void setFormatoFecha(String formatoFecha) { this.formatoFecha = formatoFecha; }

    // ==========================
    // toString para debugging
    // ==========================
    @Override
    public String toString() {
        return "ReporteGeneral{" +
                "pais='" + pais + '\'' +
                ", moneda='" + moneda + '\'' +
                ", formatoFecha='" + formatoFecha + '\'' +
                '}';
    }
}
