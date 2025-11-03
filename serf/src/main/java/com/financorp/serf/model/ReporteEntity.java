package com.financorp.serf.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa un reporte generado en el sistema SERF.
 * <p>
 * Esta entidad mapea la tabla <b>reportes</b> en la base de datos.
 * Contiene información básica como nombre y descripción del reporte.
 * </p>
 */
@Entity
@Table(name = "reportes")
public class ReporteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 1000)
    private String descripcion;

    // ==========================
    // Constructores
    // ==========================
    public ReporteEntity() {}

    public ReporteEntity(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // ==========================
    // Getters y Setters
    // ==========================
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    // ==========================
    // ToString para debugging
    // ==========================
    @Override
    public String toString() {
        return "ReporteEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
