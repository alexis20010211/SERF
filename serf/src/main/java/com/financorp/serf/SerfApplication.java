package com.financorp.serf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h2>Clase principal del Sistema Empresarial de Reportes Financieros (SERF)</h2>
 *
 * <p>
 * {@code SerfApplication} es el punto de entrada del backend del sistema SERF.
 * Su función principal es inicializar el contexto de Spring Boot,
 * escanear los componentes de la aplicación y ejecutar el servidor embebido (Tomcat por defecto).
 * </p>
 *
 * <h3>Patrones de diseño aplicados:</h3>
 * <ul>
 *   <li><b>Singleton (implícito):</b> El contexto de Spring se comporta como un Singleton
 *       al crear una única instancia compartida para cada bean definido en la aplicación.</li>
 *   <li><b>Inversión de Control (IoC) y Dependency Injection (DI):</b>
 *       El framework se encarga de gestionar las dependencias entre los componentes,
 *       mejorando la modularidad y reduciendo el acoplamiento.</li>
 * </ul>
 *
 * <h3>Responsabilidades principales:</h3>
 * <ul>
 *   <li>Inicializar el entorno de ejecución de Spring Boot.</li>
 *   <li>Configurar automáticamente los componentes marcados con anotaciones como
 *       {@code @Service}, {@code @Repository}, {@code @Controller}, y {@code @Component}.</li>
 *   <li>Levantar el servidor embebido que permitirá exponer las APIs REST de SERF.</li>
 * </ul>
 *
 * <h3>Ejemplo de ejecución:</h3>
 * <pre>{@code
 * // Desde línea de comandos:
 * mvn spring-boot:run
 *
 * // O ejecutando directamente desde un IDE:
 * public static void main(String[] args) {
 *     SpringApplication.run(SerfApplication.class, args);
 * }
 * }</pre>
 *
 * <h3>Relación con el sistema:</h3>
 * <p>
 * Esta clase inicia todo el ecosistema de Spring, que carga automáticamente
 * los módulos de patrones de diseño implementados, tales como:
 * </p>
 * <ul>
 *   <li>Factory Method → en la generación de reportes financieros.</li>
 *   <li>Singleton → en componentes compartidos como el {@code LoggerGlobal}.</li>
 *   <li>Service Layer → en la lógica de negocio central (clases en {@code service}).</li>
 * </ul>
 *
 * @author Alesi
 * @version 1.0
 */
@SpringBootApplication
public class SerfApplication {

    /**
     * Método principal que lanza la aplicación SERF.
     *
     * @param args argumentos de ejecución opcionales.
     */
    public static void main(String[] args) {
        SpringApplication.run(SerfApplication.class, args);
    }

}
