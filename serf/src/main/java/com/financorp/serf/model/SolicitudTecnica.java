package com.financorp.serf.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("TECNICA")
@PrimaryKeyJoinColumn(name = "id")
public class SolicitudTecnica extends Solicitud {

    public SolicitudTecnica() {
        super();
    }

    public SolicitudTecnica(String cliente, String tipo, double monto) {
        super(cliente, tipo, monto);
    }

    @Override
    public void procesar() {
        System.out.println("Procesando solicitud técnica para " + getCliente());
    }

    @Override
    public String toString() {
        return "SolicitudTecnica{" +
                "cliente='" + getCliente() + '\'' +
                ", tipo='" + getTipo() + '\'' +
                ", monto=" + getMonto() +
                '}';
    }
}
