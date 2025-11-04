package com.financorp.serf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financorp.serf.model.Tecnico;

/**
 * <h2>Repositorio de Técnicos</h2>
 *
 * <p>
 * La interfaz {@code TecnicoRepository} gestiona las operaciones de acceso
 * y persistencia para la entidad {@link Tecnico}. Al extender de
 * {@link JpaRepository}, hereda automáticamente métodos CRUD y de paginación.
 * </p>
 *
 * <h3>Características:</h3>
 * <ul>
 *   <li>Implementa el patrón <b>Repository</b> de Spring Data JPA.</li>
 *   <li>Facilita la separación entre la lógica de negocio y la capa de persistencia.</li>
 *   <li>Permite agregar consultas personalizadas mediante nombres de métodos
 *       o anotaciones {@code @Query}.</li>
 * </ul>
 *
 * <h3>Ejemplo de uso:</h3>
 * <pre>{@code
 * @Autowired
 * private TecnicoRepository tecnicoRepository;
 *
 * // Crear nuevo técnico
 * Tecnico t = new Tecnico("Carlos Ramos", "Redes", "Senior");
 * tecnicoRepository.save(t);
 *
 * // Listar técnicos
 * List<Tecnico> tecnicos = tecnicoRepository.findAll();
 * }</pre>
 *
 * @see com.financorp.serf.model.Tecnico
 * @see org.springframework.data.jpa.repository.JpaRepository
 * @see org.springframework.stereotype.Repository
 *
 */
@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    // Ejemplo de método adicional personalizado:
    // List<Tecnico> findByEspecialidad(String especialidad);
}
