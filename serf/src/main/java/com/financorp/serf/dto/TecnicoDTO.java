package com.financorp.serf.dto;

public class TecnicoDTO {
    private String nombre;
    private String especialidad;
    private String nivel;

    public TecnicoDTO() {}

    public TecnicoDTO(String nombre, String especialidad, String nivel) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.nivel = nivel;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
}
