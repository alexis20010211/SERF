package com.financorp.serf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Representa un producto dentro del sistema SERF.
 * <p>
 * Esta clase es una entidad JPA que mapea la tabla <b>producto</b> en la base de datos.
 * Contiene información básica como el nombre, precio y categoría del producto.
 * </p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Producto producto = new Producto("Laptop HP", 3500.0, "Tecnología");
 * }</pre>
 *
 * <p>Esta entidad es utilizada junto con {@link com.financorp.serf.factory.ProductoFactory}
 * para la creación estandarizada de productos.</p>
 *
 * @author Alesi
 * @version 1.0
 */
@Entity
public class Producto {

    /** Identificador único del producto (clave primaria). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre del producto. */
    private String nombre;

    /** Precio del producto. */
    private double precio;

    /** Categoría a la que pertenece el producto (ej. Tecnología, Hogar, Oficina, etc.). */
    private String categoria;

    /** Constructor vacío requerido por JPA. */
    public Producto() {}

    /**
     * Constructor que permite crear un producto con todos sus atributos.
     *
     * @param nombre     nombre del producto
     * @param precio     precio unitario del producto
     * @param categoria  categoría del producto
     */
    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
