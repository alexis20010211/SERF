package com.financorp.serf.model;

import com.financorp.serf.patterns.singleton.ConfiguracionGlobal;

public class ReporteGeneral implements Reporte {

    private String pais;
    private String moneda;
    private String formatoFecha;

    public ReporteGeneral() {
        ConfiguracionGlobal config = ConfiguracionGlobal.getInstancia();
        this.pais = config.getPaisSede();
        this.moneda = config.getMonedaCorporativa();
        this.formatoFecha = config.getFormatoFecha();
    }

    @Override
    public String generar() {
        return """
📄 Reporte General generado con configuración:
- País: %s
- Moneda: %s
- Formato de fecha: %s
""".formatted(pais, moneda, formatoFecha);
    }

    // Getters y Setters opcionales
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }
    public String getFormatoFecha() { return formatoFecha; }
    public void setFormatoFecha(String formatoFecha) { this.formatoFecha = formatoFecha; }
}
