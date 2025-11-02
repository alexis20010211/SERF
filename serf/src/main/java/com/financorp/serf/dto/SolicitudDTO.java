package com.financorp.serf.dto;

public class SolicitudDTO {
    private String tipo;
    private String descripcion;
    private String estado;

    public SolicitudDTO() {}

    public SolicitudDTO(String tipo, String descripcion, String estado) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    // Getters y setters
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
