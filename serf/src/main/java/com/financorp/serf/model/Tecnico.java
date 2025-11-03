package com.financorp.serf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Representa un técnico dentro del sistema SERF.
 * <p>
 * Esta entidad almacena la información principal de los técnicos que
 * brindan soporte o mantenimiento en las filiales de la empresa.
 * </p>
 *
 * <p>Es una clase simple de persistencia que forma parte del
 * modelo de datos y puede ser instanciada mediante la
 * {@link com.financorp.serf.factory.TecnicoFactory}, lo que demuestra
 * la aplicación del patrón de diseño <b>Factory Method</b>.</p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Tecnico tecnico = TecnicoFactory.crearTecnico("María López", "Redes", "Senior");
 * }</pre>
 *
 * @author Alesi
 * @version 1.0
 * @see com.financorp.serf.factory.TecnicoFactory
 */
@Entity
public class Tecnico {

    /** Identificador único del técnico (clave primaria). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre completo del técnico. */
    private String nombre;

    /** Especialidad técnica (por ejemplo, soporte, redes, hardware, etc.). */
    private String especialidad;

    /** Nivel de experiencia o jerarquía (por ejemplo, Junior, Senior). */
    private String nivel;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Tecnico() {}

    /**
     * Constructor con parámetros para inicializar un técnico.
     *
     * @param nombre nombre del técnico
     * @param especialidad área de especialización del técnico
     * @param nivel nivel de experiencia del técnico
     */
    public Tecnico(String nombre, String especialidad, String nivel) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.nivel = nivel;
    }

    // ==============================
    // Getters y Setters
    // ==============================

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
}
