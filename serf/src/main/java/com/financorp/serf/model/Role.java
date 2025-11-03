package com.financorp.serf.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa un rol dentro del sistema SERF.
 * <p>
 * Cada usuario puede tener uno o varios roles, por ejemplo: Admin, Usuario.
 * Esta clase es una entidad JPA que mapea la tabla <b>roles</b> en la base de datos.
 * </p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Role adminRole = new Role("Admin");
 * roleRepository.save(adminRole);
 * }</pre>
 *
 * @author Alesi
 * @version 1.0
 */
@Entity
@Table(name = "roles")
public class Role {

    /** Identificador único del rol (clave primaria). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre del rol (único y obligatorio). */
    @Column(nullable = false, unique = true)
    private String name;

    /** Constructor vacío requerido por JPA. */
    public Role() {}

    /**
     * Constructor que inicializa un rol con su nombre.
     *
     * @param name nombre del rol
     */
    public Role(String name) {
        this.name = name;
    }

    // ==========================
    // Getters y Setters
    // ==========================
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // ==========================
    // toString para debugging
    // ==========================
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
