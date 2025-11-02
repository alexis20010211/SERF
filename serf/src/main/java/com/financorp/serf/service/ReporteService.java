package com.financorp.serf.service;

import java.util.List;
import java.util.stream.Collectors;

import com.financorp.serf.factory.ReporteFactory;
import com.financorp.serf.model.Reporte;

/**
 * <h2>Servicio de Generación de Reportes</h2>
 *
 * <p>
 * La clase {@code ReporteService} se encarga de gestionar la creación
 * de múltiples tipos de reportes a partir de una lista de tipos solicitados.
 * Utiliza la clase {@link ReporteFactory} para instanciar los objetos concretos
 * según el tipo de reporte solicitado.
 * </p>
 *
 * <h3>Patrones de diseño aplicados:</h3>
 * <ul>
 *   <li><b>Factory Method:</b> Delegación de la creación de objetos {@link Reporte}
 *       a la clase {@code ReporteFactory}, evitando dependencias directas entre
 *       el servicio y las clases concretas de reportes.</li>
 *   <li><b>Service Layer:</b> Encapsula la lógica de negocio asociada a la
 *       generación de reportes, manteniendo un diseño modular y escalable.</li>
 * </ul>
 *
 * <h3>Responsabilidades:</h3>
 * <ul>
 *   <li>Recibir los tipos de reportes requeridos por el sistema.</li>
 *   <li>Generar instancias específicas de {@link Reporte} según el tipo.</li>
 *   <li>Devolver la lista completa de reportes creados.</li>
 * </ul>
 *
 * <h3>Ejemplo de uso:</h3>
 * <pre>{@code
 * ReporteService servicio = new ReporteService();
 * List<String> tipos = List.of("ventas", "inventario", "financiero");
 * List<Reporte> reportes = servicio.generarReportes(tipos);
 *
 * reportes.forEach(r -> System.out.println(r.generar()));
 * }</pre>
 *
 * @author Alesi
 * @version 1.0
 */
public class ReporteService {

    /**
     * Genera una lista de reportes a partir de los tipos especificados.
     * <p>
     * Cada tipo es procesado por {@link ReporteFactory#crearReporte(String)},
     * que devuelve la instancia correspondiente del reporte.
     * </p>
     *
     * @param tipos lista de tipos de reportes (por ejemplo: "ventas", "inventario", "financiero").
     * @return una lista de objetos {@link Reporte} creados dinámicamente.
     */
    public List<Reporte> generarReportes(List<String> tipos) {
        return tipos.stream()
                     .map(ReporteFactory::crearReporte)
                     .collect(Collectors.toList());
    }
}
