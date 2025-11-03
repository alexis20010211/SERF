package com.financorp.serf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Representa el inventario de un producto en una filial específica.
 * <p>
 * Esta clase mapea la tabla <b>inventarios_filiales</b> en la base de datos.
 * </p>
 */
@Entity
@Table(name = "inventarios_filiales")
public class InventarioFilial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Cantidad disponible del producto en la filial */
    private int stock;

    /** Producto al que pertenece este inventario */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    /** Filial donde se encuentra este inventario */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filial_id")
    private Filial filial;

    // ==========================
    // Constructores
    // ==========================
    public InventarioFilial() {}

    public InventarioFilial(Filial filial, Producto producto, int stock) {
        this.filial = filial;
        this.producto = producto;
        this.stock = stock;
    }

    // ==========================
    // Getters y Setters
    // ==========================
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public Filial getFilial() { return filial; }
    public void setFilial(Filial filial) { this.filial = filial; }

    // ==========================
    // ToString para debugging
    // ==========================
    @Override
    public String toString() {
        return "InventarioFilial{" +
                "id=" + id +
                ", stock=" + stock +
                ", producto=" + (producto != null ? producto.getNombre() : "null") +
                ", filial=" + (filial != null ? filial.getNombre() : "null") +
                '}';
    }
}
