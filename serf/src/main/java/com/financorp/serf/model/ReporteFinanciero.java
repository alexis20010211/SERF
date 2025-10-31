package com.financorp.serf.model;

import com.financorp.serf.patterns.singleton.ConfiguracionGlobal;

public class ReporteFinanciero implements Reporte {

    private String pais;
    private String moneda;
    private String formatoFecha;

    // Constructor que toma los valores desde ConfiguracionGlobal
    public ReporteFinanciero() {
        ConfiguracionGlobal config = ConfiguracionGlobal.getInstancia();
        this.pais = config.getPaisSede();
        this.moneda = config.getMonedaCorporativa();
        this.formatoFecha = config.getFormatoFecha();
    }

    @Override
    public String generar() {
        return """
📊 Reporte Financiero generado con configuración:
- País: %s
- Moneda: %s
- Formato fecha: %s
""".formatted(pais, moneda, formatoFecha);
    }

    // Getters y Setters opcionales
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getFormatoFecha() {
        return formatoFecha;
    }

    public void setFormatoFecha(String formatoFecha) {
        this.formatoFecha = formatoFecha;
    }
}
