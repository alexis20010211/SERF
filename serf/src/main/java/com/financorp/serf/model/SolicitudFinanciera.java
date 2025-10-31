package com.financorp.serf.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("FINANCIERA")
@PrimaryKeyJoinColumn(name = "id")
public class SolicitudFinanciera extends Solicitud {

    public SolicitudFinanciera() {
        super();
    }

    public SolicitudFinanciera(String cliente, String tipo, double monto) {
        super(cliente, tipo, monto);
    }

    @Override
    public void procesar() {
        System.out.println("Procesando solicitud financiera para " + getCliente());
    }

    @Override
    public String toString() {
        return "SolicitudFinanciera{" +
                "cliente='" + getCliente() + '\'' +
                ", tipo='" + getTipo() + '\'' +
                ", monto=" + getMonto() +
                '}';
    }
}
