package com.financorp.serf.dto;

public class VentaDTO {
    private Long id;
    private Long productoId; // o Producto producto, según cómo lo manejes
    private int cantidad;
    private double total;

    // Constructor vacío
    public VentaDTO() {}

    // Constructor con parámetros
    public VentaDTO(Long id, Long productoId, int cantidad, double total) {
        this.id = id;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.total = total;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
