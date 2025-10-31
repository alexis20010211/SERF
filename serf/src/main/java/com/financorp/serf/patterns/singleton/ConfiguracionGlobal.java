package com.financorp.serf.patterns.singleton;

/**
 * Patrón Singleton: Configuración Global del sistema.
 * Se usa para mantener una sola instancia con parámetros
 * corporativos como moneda, formato de fecha, país, etc.
 */
public class ConfiguracionGlobal {

    private static ConfiguracionGlobal instancia;

    // Parámetros globales
    private String monedaCorporativa;
    private String formatoFecha;
    private String paisSede;

    // Constructor privado (impide crear instancias fuera)
    private ConfiguracionGlobal() {
        this.monedaCorporativa = "EUR"; // Euro como moneda central
        this.formatoFecha = "dd/MM/yyyy";
        this.paisSede = "Perú";
    }

    // Método estático para obtener la instancia única
    public static ConfiguracionGlobal getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionGlobal();
        }
        return instancia;
    }

    // Getters y setters
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