package com.financorp.serf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financorp.serf.model.Solicitud;

/**
 * <h2>Repositorio de Solicitudes</h2>
 *
 * <p>
 * La interfaz {@code SolicitudRepository} administra la persistencia de la entidad
 * {@link Solicitud} en la base de datos. Hereda de {@link JpaRepository}, lo que
 * permite utilizar todas las operaciones CRUD de manera automática sin necesidad
 * de implementación explícita.
 * </p>
 *
 * <h3>Características:</h3>
 * <ul>
 *   <li>Implementa el patrón <b>Repository</b>, separando la capa de negocio de la capa de acceso a datos.</li>
 *   <li>Soporta consultas personalizadas mediante el uso de nombres de método o anotaciones {@code @Query}.</li>
 *   <li>Integración completa con el contexto de persistencia de Spring Data JPA.</li>
 * </ul>
 *
 * <h3>Ejemplo de uso:</h3>
 * <pre>{@code
 * @Autowired
 * private SolicitudRepository solicitudRepository;
 *
 * // Crear nueva solicitud
 * Solicitud s = new Solicitud("Compra Equipos", "Pendiente", LocalDate.now());
 * solicitudRepository.save(s);
 *
 * // Listar todas las solicitudes
 * List<Solicitud> solicitudes = solicitudRepository.findAll();
 * }</pre>
 *
 * @see com.financorp.serf.model.Solicitud
 * @see org.springframework.data.jpa.repository.JpaRepository
 * @see org.springframework.stereotype.Repository
 *
 */
@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    // Métodos personalizados opcionales, por ejemplo:
    // List<Solicitud> findByEstado(String estado);
}
