package com.financorp.serf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

/**
 * Clase abstracta base que representa una solicitud dentro del sistema SERF.
 * <p>
 * Implementa el principio de herencia mediante {@link InheritanceType#JOINED},
 * lo que permite que cada tipo de solicitud (financiera, técnica, etc.)
 * tenga su propia tabla relacionada en la base de datos.
 * </p>
 *
 * <p>Esta clase actúa como la raíz jerárquica del patrón <b>Factory Method</b>,
 * ya que las subclases concretas son instanciadas a través de una fábrica
 * (por ejemplo, {@code SolicitudFactory}) que encapsula la lógica de creación.</p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Solicitud solicitud = SolicitudFactory.crearSolicitud("financiera", "Pago de proveedor", 1200.50);
 * solicitud.procesar();
 * }</pre>
 *
 * @author Alesi
 * @version 1.0
 * @see com.financorp.serf.factory.SolicitudFactory
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Solicitud {

    /** Identificador único de la solicitud (clave primaria). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre o identificador del cliente que genera la solicitud. */
    private String cliente;

    /** Tipo de solicitud (por ejemplo: "financiera", "técnica", etc.). */
    private String tipo;

    /** Monto o valor asociado a la solicitud. */
    private double monto;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Solicitud() {}

    /**
     * Constructor con parámetros para inicializar los atributos principales.
     *
     * @param cliente nombre o identificador del cliente
     * @param tipo tipo de solicitud
     * @param monto monto o valor asociado
     */
    public Solicitud(String cliente, String tipo, double monto) {
        this.cliente = cliente;
        this.tipo = tipo;
        this.monto = monto;
    }

    /**
     * Método abstracto que debe ser implementado por las subclases.
     * Define la lógica específica de procesamiento según el tipo de solicitud.
     */
    public abstract void procesar();

    // -----------------------------
    // Getters y Setters
    // -----------------------------

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
