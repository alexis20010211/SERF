package com.financorp.serf.factory;

import com.financorp.serf.model.Solicitud;
import com.financorp.serf.model.SolicitudFinanciera;

/**
 * Fábrica responsable de la creación de objetos {@link Solicitud}.
 * <p>
 * Implementa el patrón de diseño <b>Factory Method</b>, permitiendo crear
 * diferentes tipos de solicitudes sin exponer la lógica interna de instanciación.
 * </p>
 *
 * <p>Actualmente, la fábrica soporta el tipo:</p>
 * <ul>
 *   <li><b>financiera</b> → {@link SolicitudFinanciera}</li>
 * </ul>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Solicitud solicitud = SolicitudFactory.crearSolicitud("financiera", "Solicitud de crédito", 15000.0);
 * }</pre>
 *
 * @author Alesi
 * @version 1.0
 */
public class SolicitudFactory {

    /**
     * Crea una nueva instancia de {@link Solicitud} en función del tipo indicado.
     *
     * @param tipo         tipo de solicitud (por ejemplo: "financiera")
     * @param descripcion  descripción breve de la solicitud
     * @param monto        monto asociado a la solicitud
     * @return una instancia concreta de {@link Solicitud} correspondiente al tipo especificado
     * @throws IllegalArgumentException si el tipo de solicitud no es válido o no está implementado
     */
    public static Solicitud crearSolicitud(String tipo, String descripcion, double monto) {
        if ("financiera".equalsIgnoreCase(tipo)) {
            return new SolicitudFinanciera(descripcion, tipo, monto);
        }
        throw new IllegalArgumentException("Tipo de solicitud no válido: " + tipo);
    }
}
