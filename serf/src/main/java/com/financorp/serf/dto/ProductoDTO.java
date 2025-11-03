package com.financorp.serf.dto;

public class ProductoDTO {
    private String nombre;
    private double precio;
    private int stock;

    // Constructor vacío
    public ProductoDTO() {}

    // Constructor con campos
    public ProductoDTO(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}
