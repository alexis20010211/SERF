package com.financorp.serf.patterns.singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerGlobal {

    private static LoggerGlobal instancia;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private LoggerGlobal() {}

    public static LoggerGlobal getInstance() {
        if (instancia == null) {
            instancia = new LoggerGlobal();
        }
        return instancia;
    }

    public void info(String mensaje) {
        System.out.println("[INFO] " + LocalDateTime.now().format(formatter) + " - " + mensaje);
    }

    public void warn(String mensaje) {
        System.out.println("[WARN] " + LocalDateTime.now().format(formatter) + " - " + mensaje);
    }

    public void error(String mensaje) {
        System.err.println("[ERROR] " + LocalDateTime.now().format(formatter) + " - " + mensaje);
    }

    /**
     * Método genérico para registrar mensajes sin un nivel específico.
     */
    public void log(String mensaje) {
        System.out.println("[LOG] " + LocalDateTime.now().format(formatter) + " - " + mensaje);
    }
}
