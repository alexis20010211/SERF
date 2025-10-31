package com.financorp.serf.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("VENTAS")
@PrimaryKeyJoinColumn(name = "id")
public class SolicitudVentas extends Solicitud {

    public SolicitudVentas() {
        super();
    }

    public SolicitudVentas(String cliente, String tipo, double monto) {
        super(cliente, tipo, monto);
    }

    @Override
    public void procesar() {
        System.out.println("Procesando solicitud de ventas para " + getCliente());
    }

    @Override
    public String toString() {
        return "SolicitudVentas{" +
                "cliente='" + getCliente() + '\'' +
                ", tipo='" + getTipo() + '\'' +
                ", monto=" + getMonto() +
                '}';
    }
}
