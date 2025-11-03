package com.financorp.serf.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Representa un producto importado por FinanCorp.
 * <p>
 * Esta clase mapea la tabla <b>producto</b> en la base de datos.
 * Contiene información técnica, financiera y de stock.
 * </p>
 */
@Entity
@Table(name = "producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoProducto;       // Código interno del producto
    private String nombre;               // Nombre del producto
    private String descripcionTecnica;   // Descripción técnica
    private String categoria;            // Laptop, Smartphone, etc.
    private Double costoImportacion;     // En moneda de origen
    private Double precioVentaSugerido;  // Moneda local
    private String proveedor;            // Proveedor del producto
    private LocalDate fechaImportacion;  // Fecha de importación
    private Integer stock;               // Stock disponible
    private String moneda;               // Ej: CNY, PEN, USD, EUR

    // Constructor vacío requerido por JPA
    public Producto() {}
}
