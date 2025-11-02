package com.financorp.serf.dto;

public class ReporteDTO {
    private String tipo;
    private String contenido;

    public ReporteDTO() {}

    public ReporteDTO(String tipo, String contenido) {
        this.tipo = tipo;
        this.contenido = contenido;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
}
