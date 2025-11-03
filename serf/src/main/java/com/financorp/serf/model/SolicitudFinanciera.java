package com.financorp.serf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Representa una solicitud financiera dentro del sistema SERF.
 * Hereda de {@link Solicitud} y se persiste en su propia tabla
 * <b>solicitud_financiera</b> usando el patrón JOINED.
 */
@Entity
@Table(name = "solicitud_financiera")
public class SolicitudFinanciera extends Solicitud {

    /** Cuenta destino asociada a la solicitud financiera. */
    private String cuentaDestino;

    /** Constructor vacío requerido por JPA. */
    public SolicitudFinanciera() {
        super();
        setTipo("financiera");
    }

    /**
     * Constructor que inicializa la solicitud financiera con cliente, monto y cuenta destino.
     *
     * @param cliente nombre del cliente
     * @param monto monto asociado
     * @param cuentaDestino cuenta bancaria destino
     */
    public SolicitudFinanciera(String cliente, double monto, String cuentaDestino) {
        super(cliente, "financiera", monto);
        this.cuentaDestino = cuentaDestino;
    }

    /**
     * Lógica específica para procesar la solicitud financiera.
     */
    @Override
    public void procesar() {
        System.out.println("Procesando solicitud financiera de " + getCliente() +
                           " por un monto de " + getMonto() +
                           " hacia la cuenta " + cuentaDestino);
        // Aquí iría la lógica real de pago, validación o registro contable
    }

    // Getters y Setters
    public String getCuentaDestino() { return cuentaDestino; }
    public void setCuentaDestino(String cuentaDestino) { this.cuentaDestino = cuentaDestino; }

    @Override
    public String toString() {
        return "SolicitudFinanciera{" +
               "id=" + getId() +
               ", cliente='" + getCliente() + '\'' +
               ", monto=" + getMonto() +
               ", cuentaDestino='" + cuentaDestino + '\'' +
               '}';
    }
}
