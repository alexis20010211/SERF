package com.financorp.serf.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

/**
 * Subclase concreta que representa una solicitud de tipo <b>Técnica</b>
 * dentro del sistema SERF.
 * <p>
 * Esta clase extiende {@link Solicitud} e implementa el método
 * {@code procesar()} con la lógica específica para solicitudes técnicas.
 * Cumple el rol de <b>Producto Concreto</b> dentro del patrón de diseño
 * <b>Factory Method</b>, donde las instancias son creadas mediante la
 * {@link com.financorp.serf.factory.SolicitudFactory}.
 * </p>
 *
 * <p>Es gestionada por JPA usando herencia con la estrategia
 * {@link jakarta.persistence.InheritanceType#JOINED}, lo que permite
 * que sus atributos sean almacenados en una tabla separada pero vinculada
 * a la tabla base de {@link Solicitud}.</p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Solicitud solicitud = new SolicitudTecnica("María López", "técnica", 0);
 * solicitud.procesar();
 * }</pre>
 *
 * @see com.financorp.serf.model.Solicitud
 * @see com.financorp.serf.factory.SolicitudFactory
 * @author Alesi
 * @version 1.0
 */
@Entity
@DiscriminatorValue("TECNICA")
@PrimaryKeyJoinColumn(name = "id")
public class SolicitudTecnica extends Solicitud {

    /**
     * Constructor vacío requerido por JPA.
     */
    public SolicitudTecnica() {
        super();
    }

    /**
     * Constructor con parámetros que inicializa los atributos
     * heredados de la clase base {@link Solicitud}.
     *
     * @param cliente nombre o identificador del cliente
     * @param tipo tipo de solicitud (en este caso, "técnica")
     * @param monto monto asociado (si aplica)
     */
    public SolicitudTecnica(String cliente, String tipo, double monto) {
        super(cliente, tipo, monto);
    }

    /**
     * Implementación concreta del método abstracto {@link Solicitud#procesar()}.
     * <p>
     * Define el comportamiento específico para solicitudes técnicas,
     * como la asignación de un técnico o la verificación de soporte.
     * </p>
     */
    @Override
    public void procesar() {
        System.out.println("Procesando solicitud técnica para " + getCliente());
    }

    /**
     * Devuelve una representación textual legible de la solicitud.
     *
     * @return cadena con los datos principales de la solicitud
     */
    @Override
    public String toString() {
        return "SolicitudTecnica{" +
                "cliente='" + getCliente() + '\'' +
                ", tipo='" + getTipo() + '\'' +
                ", monto=" + getMonto() +
                '}';
    }
}
