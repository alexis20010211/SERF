package com.financorp.serf.model;

import com.financorp.serf.patterns.singleton.ConfiguracionGlobal;

public interface Reporte {

    // Método que todos los reportes deben implementar
    String generar();

    // Método por defecto que usa el Singleton
    default String obtenerConfiguracion() {
        ConfiguracionGlobal conf = ConfiguracionGlobal.getInstancia();
        return "Moneda: " + conf.getMonedaCorporativa() +
               ", Formato de fecha: " + conf.getFormatoFecha() +
               ", País sede: " + conf.getPaisSede();
    }
}
