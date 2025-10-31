package com.financorp.serf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especialidad;
    private String nivel; // 🔹 nuevo atributo

    public Tecnico() {}

    public Tecnico(String nombre, String especialidad, String nivel) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.nivel = nivel;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getNivel() { return nivel; } // 🔹 getter
    public void setNivel(String nivel) { this.nivel = nivel; } // 🔹 setter
}
