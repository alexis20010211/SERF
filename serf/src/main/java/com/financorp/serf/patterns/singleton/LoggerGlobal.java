package com.financorp.serf.patterns.singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <h2>Patrón Singleton: Logger Global del Sistema SERF</h2>
 *
 * <p>
 * Esta clase implementa un <b>Singleton</b> encargado de centralizar la
 * generación de logs dentro del sistema. Permite registrar mensajes de tipo
 * <i>informativo</i>, <i>advertencia</i> y <i>error</i> con un formato de fecha
 * unificado.
 * </p>
 *
 * <h3>Ventajas:</h3>
 * <ul>
 *   <li>Solo una instancia maneja todos los registros (control centralizado).</li>
 *   <li>Formato de tiempo estándar en todo el sistema.</li>
 *   <li>Facilita la trazabilidad y el monitoreo del sistema SERF.</li>
 * </ul>
 *
 * <h3>Ejemplo de uso:</h3>
 * <pre>{@code
 * LoggerGlobal logger = LoggerGlobal.getInstance();
 * logger.info("Inicio del sistema SERF");
 * logger.warn("Memoria baja");
 * logger.error("Error al conectar con la base de datos");
 * }</pre>
 *
 * <p>
 * Se complementa con {@link ConfiguracionGlobal}, ya que ambos usan el patrón Singleton
 * para mantener coherencia y consistencia global en la aplicación.
 * </p>
 *
 * @author Alesi
 * @version 1.0
 */
public class LoggerGlobal {

    /** Instancia única del logger global. */
    private static LoggerGlobal instancia;

    /** Formato de fecha y hora para los mensajes de log. */
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Constructor privado para impedir la creación de múltiples instancias.
     */
    private LoggerGlobal() {}

    /**
     * Devuelve la instancia única del logger global.
     * Si no existe, la crea (instanciación diferida).
     *
     * @return instancia única de {@link LoggerGlobal}
     */
    public static LoggerGlobal getInstance() {
        if (instancia == null) {
            instancia = new LoggerGlobal();
        }
        return instancia;
    }

    /**
     * Registra un mensaje informativo (INFO).
     *
     * @param mensaje mensaje a registrar
     */
    public void info(String mensaje) {
        System.out.println("[INFO] " + LocalDateTime.now().format(formatter) + " - " + mensaje);
    }

    /**
     * Registra un mensaje de advertencia (WARN).
     *
     * @param mensaje mensaje a registrar
     */
    public void warn(String mensaje) {
        System.out.println("[WARN] " + LocalDateTime.now().format(formatter) + " - " + mensaje);
    }

    /**
     * Registra un mensaje de error (ERROR).
     * Se envía a la salida de error estándar.
     *
     * @param mensaje mensaje de error
     */
    public void error(String mensaje) {
        System.err.println("[ERROR] " + LocalDateTime.now().format(formatter) + " - " + mensaje);
    }
}
