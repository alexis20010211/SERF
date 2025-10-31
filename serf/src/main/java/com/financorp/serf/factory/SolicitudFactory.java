package com.financorp.serf.factory;

import com.financorp.serf.model.Solicitud;
import com.financorp.serf.model.SolicitudFinanciera;

public class SolicitudFactory {

    // Crea solicitudes según el tipo
    public static Solicitud crearSolicitud(String tipo, String descripcion, double monto) {
        if ("financiera".equalsIgnoreCase(tipo)) {
            return new SolicitudFinanciera(descripcion, tipo, monto);
        }
        throw new IllegalArgumentException("Tipo de solicitud no válido: " + tipo);
    }
}
