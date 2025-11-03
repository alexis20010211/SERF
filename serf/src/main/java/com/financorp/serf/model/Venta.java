package com.financorp.serf.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Cliente relacionado
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties({"ventas"}) // evita ciclo
    private Cliente cliente;

    // Producto vendido
    @ManyToOne
    @JoinColumn(name = "producto_id")
    @JsonIgnoreProperties({"ventas"}) // evita ciclo
    private Producto producto;

    // Filial donde se realizó la venta
    @ManyToOne
    @JoinColumn(name = "filial_id")
    @JsonIgnoreProperties({"ventas"}) // evita ciclo
    private Filial filial;

    private int cantidad;           // Cantidad vendida
    private double precioUnitario;  // Precio del producto en su moneda local
    private Double totalVentaEUR;   // Resultado de la conversión a EUR

    private LocalDateTime fechaVenta;

    public Venta() {}

    // ==============================
    // Getters y Setters
    // ==============================

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public Filial getFilial() { return filial; }
    public void setFilial(Filial filial) { this.filial = filial; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }

    public Double getTotalVentaEUR() { return totalVentaEUR; }
    public void setTotalVentaEUR(Double totalVentaEUR) { this.totalVentaEUR = totalVentaEUR; }

    public LocalDateTime getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(LocalDateTime fechaVenta) { this.fechaVenta = fechaVenta; }
}
