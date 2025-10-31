package com.financorp.serf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Permite que las subclases tengan sus propias tablas
public abstract class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private String tipo;
    private double monto;

    // Constructor vacío requerido por JPA
    public Solicitud() {}

    // Constructor con parámetros
    public Solicitud(String cliente, String tipo, double monto) {
        this.cliente = cliente;
        this.tipo = tipo;
        this.monto = monto;
    }

    // Método abstracto que las subclases deben implementar
    public abstract void procesar();

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
