package com.financorp.serf.patterns.singleton;

/**
 * <h2>Patrón Singleton: Configuración Global del Sistema SERF</h2>
 *
 * <p>
 * Esta clase implementa el patrón de diseño <b>Singleton</b>,
 * asegurando que exista una única instancia de configuración global
 * durante todo el ciclo de vida de la aplicación.
 * </p>
 *
 * <p>
 * Se utiliza para mantener valores corporativos comunes como:
 * la moneda central, el formato de fecha y el país de la sede principal.
 * Esto garantiza la coherencia en la configuración a nivel de toda la organización.
 * </p>
 *
 * <h3>Características principales:</h3>
 * <ul>
 *   <li>Instancia única accesible mediante {@link #getInstancia()}.</li>
 *   <li>Constructor privado que evita múltiples instanciaciones.</li>
 *   <li>Configuración predefinida con valores corporativos por defecto.</li>
 * </ul>
 *
 * <h3>Ejemplo de uso:</h3>
 * <pre>{@code
 * ConfiguracionGlobal config = ConfiguracionGlobal.getInstancia();
 * System.out.println(config.getMonedaCorporativa()); // EUR
 * config.setPaisSede("Chile");
 * }</pre>
 *
 * <p>
 * Este patrón se utiliza en sistemas empresariales como SERF para asegurar
 * consistencia en la configuración y evitar estados contradictorios entre módulos.
 * </p>
 *
 * @author Alesi
 * @version 1.0
 */
public class ConfiguracionGlobal {

    /** Instancia única de la configuración global. */
    private static ConfiguracionGlobal instancia;

    /** Moneda corporativa usada por defecto en los reportes y transacciones. */
    private String monedaCorporativa;

    /** Formato de fecha estándar usado en todo el sistema. */
    private String formatoFecha;

    /** País donde se encuentra la sede principal de la corporación. */
    private String paisSede;

    /**
     * Constructor privado para impedir la creación de múltiples instancias.
     * Inicializa la configuración con valores corporativos predeterminados.
     */
    private ConfiguracionGlobal() {
        this.monedaCorporativa = "EUR"; // Euro como moneda central
        this.formatoFecha = "dd/MM/yyyy";
        this.paisSede = "Perú";
    }

    /**
     * Devuelve la instancia única de la configuración global.
     * Si no existe, la crea (instanciación diferida).
     *
     * @return instancia única de {@link ConfiguracionGlobal}
     */
    public static ConfiguracionGlobal getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionGlobal();
        }
        return instancia;
    }

    // ==============================
    // Getters y Setters
    // ==============================

    public String getMonedaCorporativa() {
        return monedaCorporativa;
    }

    public void setMonedaCorporativa(String monedaCorporativa) {
        this.monedaCorporativa = monedaCorporativa;
    }

    public String getFormatoFecha() {
        return formatoFecha;
    }

    public void setFormatoFecha(String formatoFecha) {
        this.formatoFecha = formatoFecha;
    }

    public String getPaisSede() {
        return paisSede;
    }

    public void setPaisSede(String paisSede) {
        this.paisSede = paisSede;
    }

    @Override
    public String toString() {
        return "ConfiguracionGlobal{" +
                "monedaCorporativa='" + monedaCorporativa + '\'' +
                ", formatoFecha='" + formatoFecha + '\'' +
                ", paisSede='" + paisSede + '\'' +
                '}';
    }
}
