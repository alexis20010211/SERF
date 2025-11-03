package com.financorp.serf.factory;

import com.financorp.serf.model.Solicitud;
import com.financorp.serf.model.SolicitudFinanciera;
import com.financorp.serf.model.SolicitudTecnica;
import com.financorp.serf.model.SolicitudVentas;

/**
 * Fábrica responsable de la creación de objetos {@link Solicitud}.
 * Implementa el patrón Factory Method.
 */
public class SolicitudFactory {

    /**
     * Crea una nueva instancia de {@link Solicitud} según el tipo indicado.
     *
     * @param tipo          tipo de solicitud ("financiera", "técnica", "ventas")
     * @param cliente       nombre o identificador del cliente
     * @param monto         monto asociado a la solicitud
     * @param cuentaDestino solo usado para solicitudes financieras, puede ser null o ""
     * @return instancia concreta de {@link Solicitud}
     * @throws IllegalArgumentException si el tipo de solicitud no es válido
     */
    public static Solicitud crearSolicitud(String tipo, String cliente, double monto, String cuentaDestino) {
        return switch (tipo.toLowerCase()) {
            case "financiera" -> new SolicitudFinanciera(cliente, monto, 
                                                         cuentaDestino != null ? cuentaDestino : "");
            case "técnica", "tecnica" -> new SolicitudTecnica(cliente, "técnica", monto);
            case "ventas" -> new SolicitudVentas(cliente, "ventas", monto);
            default -> throw new IllegalArgumentException("Tipo de solicitud no válido: " + tipo);
        };
    }

    /**
     * Sobrecarga simple cuando no se necesita cuentaDestino (por ejemplo, técnica o ventas).
     */
    public static Solicitud crearSolicitud(String tipo, String cliente, double monto) {
        return crearSolicitud(tipo, cliente, monto, "");
    }
}
