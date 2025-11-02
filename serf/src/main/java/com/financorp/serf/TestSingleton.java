package com.financorp.serf;

import com.financorp.serf.patterns.singleton.ConfiguracionGlobal;

/**
 * <h2>Clase de prueba del patrón Singleton: Configuración Global</h2>
 *
 * <p>
 * Esta clase demuestra el funcionamiento del patrón de diseño <b>Singleton</b>
 * aplicado en la clase {@link com.financorp.serf.patterns.singleton.ConfiguracionGlobal}.
 * El objetivo es asegurar que exista una única instancia de configuración
 * global para todo el sistema SERF.
 * </p>
 *
 * <h3>Objetivo de la prueba:</h3>
 * <ul>
 *   <li>Verificar que dos objetos obtenidos mediante
 *       {@code ConfiguracionGlobal.getInstancia()} son exactamente el mismo
 *       en memoria.</li>
 *   <li>Comprobar que el estado global (moneda, país, formato de fecha)
 *       es compartido entre todas las referencias.</li>
 * </ul>
 *
 * <h3>Patrón de diseño aplicado:</h3>
 * <ul>
 *   <li><b>Singleton:</b> garantiza que sólo haya una instancia global
 *       de la clase {@code ConfiguracionGlobal} durante toda la ejecución
 *       del programa.</li>
 * </ul>
 *
 * <h3>Ejemplo de salida esperada:</h3>
 * <pre>
 * ConfiguracionGlobal{monedaCorporativa='EUR', formatoFecha='dd/MM/yyyy', paisSede='Perú'}
 * ConfiguracionGlobal{monedaCorporativa='EUR', formatoFecha='dd/MM/yyyy', paisSede='Perú'}
 * ¿Es la misma instancia? true
 * </pre>
 *
 * <h3>Relación con el sistema SERF:</h3>
 * <p>
 * Esta clase se usa principalmente con fines de verificación y prueba.
 * El Singleton {@code ConfiguracionGlobal} mantiene parámetros corporativos
 * que pueden ser accedidos por servicios, reportes o controladores del sistema,
 * asegurando consistencia global en toda la aplicación.
 * </p>
 *
 * @author Alesi
 * @version 1.0
 */
public class TestSingleton {

    /**
     * Método principal para ejecutar la prueba del Singleton.
     * 
     * @param args argumentos de línea de comando (no utilizados)
     */
    public static void main(String[] args) {

        // Obtención de dos instancias desde el método estático
        ConfiguracionGlobal c1 = ConfiguracionGlobal.getInstancia();
        ConfiguracionGlobal c2 = ConfiguracionGlobal.getInstancia();

        // Impresión de ambas referencias para verificar que apuntan al mismo objeto
        System.out.println(c1);
        System.out.println(c2);

        // Comparación directa de referencias
        System.out.println("¿Es la misma instancia? " + (c1 == c2));
    }
}
