package com.financorp.serf.patterns.singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerGlobal {

    // Instancia única del singleton
    private static LoggerGlobal instancia;

    // Formato de fecha para los logs
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Constructor privado para evitar instanciación externa
    private LoggerGlobal() {}

    // Método público para obtener la instancia
    public static LoggerGlobal getInstance() {
        if (instancia == null) {
            instancia = new LoggerGlobal();
        }
        return instancia;
    }

    // Método para imprimir un mensaje de log
    public void info(String mensaje) {
        System.out.println("[INFO] " + LocalDateTime.now().format(formatter) + " - " + mensaje);
    }

    // Método para imprimir un mensaje de advertencia
    public void warn(String mensaje) {
        System.out.println("[WARN] " + LocalDateTime.now().format(formatter) + " - " + mensaje);
    }

    // Método para imprimir un mensaje de error
    public void error(String mensaje) {
        System.err.println("[ERROR] " + LocalDateTime.now().format(formatter) + " - " + mensaje);
    }
}
