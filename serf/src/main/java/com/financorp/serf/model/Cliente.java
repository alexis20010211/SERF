package com.financorp.serf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa a un cliente dentro del sistema SERF.
 * <p>
 * Esta clase es una entidad JPA que mapea la tabla <b>cliente</b> en la base de datos.
 * </p>
 *
 * <p>Contiene información básica del cliente como su nombre, correo electrónico
 * y número de teléfono.</p>
 *
 * <p>Ejemplo de creación:</p>
 * <pre>{@code
 * Cliente cliente = new Cliente("María Gómez", "maria@correo.com", "987654321");
 * }</pre>
 *
 * @author Alesi
 * @version 1.1
 */
@Entity
@Table(name = "cliente") // asegura que se mapea con la tabla correcta
public class Cliente {

    /** Identificador único del cliente (clave primaria). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre completo del cliente. */
    private String nombre;

    /** Correo electrónico del cliente. */
    private String correo;

    /** Número de teléfono del cliente. */
    private String telefono;

    /** Constructor vacío requerido por JPA. */
    public Cliente() {}

    /**
     * Constructor que inicializa un cliente con todos sus datos.
     *
     * @param nombre   nombre completo del cliente
     * @param correo   correo electrónico del cliente
     * @param telefono número de teléfono del cliente
     */
    public Cliente(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    // ==========================
    // Getters y Setters
    // ==========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
