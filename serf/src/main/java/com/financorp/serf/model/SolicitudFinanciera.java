package com.financorp.serf.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

/**
 * Subclase concreta que representa una solicitud de tipo <b>Financiera</b>
 * dentro del sistema SERF.
 * <p>
 * Esta clase extiende a {@link Solicitud} y define la implementación
 * específica del método {@code procesar()}, cumpliendo el rol de
 * <b>Producto Concreto</b> dentro del patrón de diseño
 * <b>Factory Method</b>.
 * </p>
 *
 * <p>Es gestionada por JPA mediante herencia con estrategia
 * {@link jakarta.persistence.InheritanceType#JOINED},
 * lo que significa que sus datos se almacenan en una tabla separada
 * pero relacionada con la tabla base de {@code Solicitud}.</p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Solicitud solicitud = new SolicitudFinanciera("Carlos Ruiz", "financiera", 2500.00);
 * solicitud.procesar();
 * }</pre>
 *
 * @see com.financorp.serf.factory.SolicitudFactory
 * @see com.financorp.serf.model.Solicitud
 * @author Alesi
 * @version 1.0
 */
@Entity
@DiscriminatorValue("FINANCIERA")
@PrimaryKeyJoinColumn(name = "id")
public class SolicitudFinanciera extends Solicitud {

    /**
     * Constructor vacío requerido por JPA.
     */
    public SolicitudFinanciera() {
        super();
    }

    /**
     * Constructor con parámetros que inicializa los atributos
     * heredados de la clase base {@link Solicitud}.
     *
     * @param cliente nombre o identificador del cliente
     * @param tipo tipo de solicitud (en este caso, "financiera")
     * @param monto monto solicitado o gestionado
     */
    public SolicitudFinanciera(String cliente, String tipo, double monto) {
        super(cliente, tipo, monto);
    }

    /**
     * Implementación concreta del método abstracto {@link Solicitud#procesar()}.
     * <p>Define el comportamiento específico de procesamiento
     * para solicitudes de tipo financiera.</p>
     */
    @Override
    public void procesar() {
        System.out.println("Procesando solicitud financiera para " + getCliente() +
                " por un monto de $" + getMonto());
    }

    /**
     * Devuelve una representación textual legible de la solicitud.
     *
     * @return cadena con los datos principales de la solicitud
     */
    @Override
    public String toString() {
        return "SolicitudFinanciera{" +
                "cliente='" + getCliente() + '\'' +
                ", tipo='" + getTipo() + '\'' +
                ", monto=" + getMonto() +
                '}';
    }
}
