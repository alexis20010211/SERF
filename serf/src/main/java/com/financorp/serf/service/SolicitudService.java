package com.financorp.serf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financorp.serf.model.Solicitud;
import com.financorp.serf.repository.SolicitudRepository;

/**
 * <h2>Servicio de Gestión de Solicitudes</h2>
 *
 * <p>
 * La clase {@code SolicitudService} actúa como intermediaria entre los
 * controladores REST y la capa de acceso a datos ({@link SolicitudRepository}).
 * Se encarga de implementar la lógica de negocio relacionada con la creación,
 * consulta y eliminación de solicitudes.
 * </p>
 *
 * <h3>Patrones de diseño aplicados:</h3>
 * <ul>
 *   <li><b>Service Layer:</b> Centraliza la lógica de negocio y mantiene una
 *       separación clara entre el controlador y el acceso a datos.</li>
 *   <li><b>Repository Pattern:</b> Se apoya en {@link SolicitudRepository} para
 *       interactuar con la base de datos de forma desacoplada.</li>
 *   <li><b>Factory Method (relacionado):</b> Aunque este servicio no crea directamente
 *       las instancias, las solicitudes suelen ser generadas mediante
 *       {@code SolicitudFactory}, garantizando flexibilidad y extensibilidad.</li>
 * </ul>
 *
 * <h3>Responsabilidades principales:</h3>
 * <ul>
 *   <li>Obtener todas las solicitudes almacenadas en el sistema.</li>
 *   <li>Registrar nuevas solicitudes (creadas desde una fábrica o formulario).</li>
 *   <li>Consultar una solicitud específica por su ID.</li>
 *   <li>Eliminar solicitudes del registro.</li>
 * </ul>
 *
 * <h3>Ejemplo de uso:</h3>
 * <pre>{@code
 * @Autowired
 * private SolicitudService solicitudService;
 *
 * Solicitud solicitud = new SolicitudFinanciera("Juan Pérez", "financiera", 1500.0);
 * solicitudService.guardarSolicitud(solicitud);
 *
 * List<Solicitud> solicitudes = solicitudService.obtenerTodas();
 * solicitudes.forEach(Solicitud::procesar);
 * }</pre>
 *
 * @author Alesi
 * @version 1.0
 */
@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    /**
     * Obtiene la lista completa de solicitudes registradas.
     *
     * @return una lista con todas las instancias de {@link Solicitud}.
     */
    public List<Solicitud> obtenerTodas() {
        return solicitudRepository.findAll();
    }

    /**
     * Guarda o actualiza una solicitud en la base de datos.
     *
     * @param solicitud la instancia de {@link Solicitud} a registrar.
     * @return la solicitud persistida con su identificador asignado.
     */
    public Solicitud guardarSolicitud(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    /**
     * Busca una solicitud específica por su identificador.
     *
     * @param id el identificador único de la solicitud.
     * @return un {@link Optional} que contiene la solicitud si existe.
     */
    public Optional<Solicitud> obtenerPorId(Long id) {
        return solicitudRepository.findById(id);
    }

    /**
     * Elimina una solicitud de la base de datos.
     *
     * @param id el identificador único de la solicitud a eliminar.
     */
    public void eliminarSolicitud(Long id) {
        solicitudRepository.deleteById(id);
    }
}
