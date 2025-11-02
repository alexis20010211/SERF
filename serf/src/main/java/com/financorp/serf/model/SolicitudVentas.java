package com.financorp.serf.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

/**
 * Subclase concreta que representa una solicitud de tipo <b>Ventas</b>
 * dentro del sistema SERF.
 * <p>
 * Esta clase extiende {@link Solicitud} e implementa la lógica
 * particular del método {@code procesar()} para solicitudes
 * relacionadas con operaciones de ventas, cotizaciones o gestión
 * de pedidos.
 * </p>
 *
 * <p>Cumple el rol de <b>Producto Concreto</b> dentro del patrón
 * de diseño <b>Factory Method</b>, siendo instanciada por la
 * {@link com.financorp.serf.factory.SolicitudFactory} según
 * el tipo de solicitud requerido.</p>
 *
 * <p>Usa herencia JPA con la estrategia
 * {@link jakarta.persistence.InheritanceType#JOINED}, lo que permite
 * que sus datos se almacenen en una tabla propia vinculada con la
 * tabla base de {@link Solicitud}.</p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Solicitud solicitud = new SolicitudVentas("Pedro Gómez", "ventas", 1800.00);
 * solicitud.procesar();
 * }</pre>
 *
 * @see com.financorp.serf.model.Solicitud
 * @see com.financorp.serf.factory.SolicitudFactory
 * @see com.financorp.serf.model.SolicitudFinanciera
 * @see com.financorp.serf.model.SolicitudTecnica
 * @author Alesi
 * @version 1.0
 */
@Entity
@DiscriminatorValue("VENTAS")
@PrimaryKeyJoinColumn(name = "id")
public class SolicitudVentas extends Solicitud {

    /**
     * Constructor vacío requerido por JPA.
     */
    public SolicitudVentas() {
        super();
    }

    /**
     * Constructor con parámetros que inicializa los atributos
     * heredados de la clase base {@link Solicitud}.
     *
     * @param cliente nombre o identificador del cliente
     * @param tipo tipo de solicitud (en este caso, "ventas")
     * @param monto monto asociado a la operación de venta
     */
    public SolicitudVentas(String cliente, String tipo, double monto) {
        super(cliente, tipo, monto);
    }

    /**
     * Implementación concreta del método abstracto {@link Solicitud#procesar()}.
     * <p>
     * Define la lógica específica para solicitudes de ventas, como
     * registrar pedidos, generar comprobantes o actualizar inventarios.
     * </p>
     */
    @Override
    public void procesar() {
        System.out.println("Procesando solicitud de ventas para " + getCliente());
    }

    /**
     * Devuelve una representación textual legible de la solicitud.
     *
     * @return cadena con los datos principales de la solicitud
     */
    @Override
    public String toString() {
        return "SolicitudVentas{" +
                "cliente='" + getCliente() + '\'' +
                ", tipo='" + getTipo() + '\'' +
                ", monto=" + getMonto() +
                '}';
    }
}
