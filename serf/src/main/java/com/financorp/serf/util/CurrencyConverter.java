package com.financorp.serf.util;

import org.springframework.stereotype.Component;

@Component
public class CurrencyConverter {

    // ✅ Simulación de una tasa corporativa fija para EUR
    private static final double CORPORATE_EXCHANGE_RATE = 0.25; 
    // Luego podremos obtenerlo de ConfiguracionGlobal (Singleton)

    /**
     * Conversión genérica con tasa indicada
     */
    public double convertir(double monto, double tasa) {
        return monto * tasa;
    }

    /**
     * ✅ Conversión automática a la moneda corporativa (EUR)
     * Necesario para VentaService
     */
    public double convertToCorporateCurrency(double montoLocal) {
        return convertir(montoLocal, CORPORATE_EXCHANGE_RATE);
    }
}
