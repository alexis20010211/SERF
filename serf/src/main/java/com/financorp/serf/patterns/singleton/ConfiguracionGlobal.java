package com.financorp.serf.patterns.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton para configuración global del sistema SERF,
 * incluyendo conversión automática de moneda.
 */
public class ConfiguracionGlobal {

    private static ConfiguracionGlobal instancia;

    private String monedaCorporativa;
    private String formatoFecha;
    private String paisSede;

    /** Tasas de conversión: moneda origen → valor en moneda corporativa */
    private final Map<String, Double> tasasConversion;

    private ConfiguracionGlobal() {
        this.monedaCorporativa = "EUR"; // Euro como moneda central
        this.formatoFecha = "dd/MM/yyyy";
        this.paisSede = "Perú";

        // Inicializamos algunas tasas de ejemplo
        this.tasasConversion = new HashMap<>();
        tasasConversion.put("CNY", 0.13); // 1 CNY = 0.13 EUR
        tasasConversion.put("PEN", 0.25); // 1 PEN = 0.25 EUR
        tasasConversion.put("USD", 0.92); // 1 USD = 0.92 EUR
    }

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

    // ==============================
    // Métodos de conversión de moneda
    // ==============================
    public double convertir(String monedaOrigen, double cantidad) {
        if (!tasasConversion.containsKey(monedaOrigen)) {
            throw new IllegalArgumentException("Moneda no soportada: " + monedaOrigen);
        }
        return cantidad * tasasConversion.get(monedaOrigen);
    }

    public void agregarTasaConversion(String monedaOrigen, double valorEnCorporativa) {
        tasasConversion.put(monedaOrigen, valorEnCorporativa);
    }

    @Override
    public String toString() {
        return "ConfiguracionGlobal{" +
                "monedaCorporativa='" + monedaCorporativa + '\'' +
                ", formatoFecha='" + formatoFecha + '\'' +
                ", paisSede='" + paisSede + '\'' +
                ", tasasConversion=" + tasasConversion +
                '}';
    }
}
