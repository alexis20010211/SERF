package com.financorp.serf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financorp.serf.model.Cliente;

/**
 * <h2>Repositorio de Clientes</h2>
 *
 * <p>
 * La interfaz {@code ClienteRepository} extiende de {@link JpaRepository} para 
 * proporcionar las operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre 
 * la entidad {@link Cliente}.
 * </p>
 *
 * <h3>Características:</h3>
 * <ul>
 *   <li>Gestiona la persistencia de los objetos {@code Cliente} en la base de datos.</li>
 *   <li>Hereda métodos de Spring Data JPA como {@code findAll()}, {@code save()}, {@code deleteById()}, etc.</li>
 *   <li>Puede ser extendido para agregar consultas personalizadas mediante 
 *       <b>Query Methods</b> o anotaciones {@code @Query}.</li>
 * </ul>
 *
 * <h3>Ejemplo de uso:</h3>
 * <pre>{@code
 * @Autowired
 * private ClienteRepository clienteRepository;
 *
 * // Obtener todos los clientes
 * List<Cliente> clientes = clienteRepository.findAll();
 *
 * // Guardar nuevo cliente
 * clienteRepository.save(new Cliente("Carlos Gómez", "carlos@financorp.com", "999888777"));
 * }</pre>
 *
 * @see com.financorp.serf.model.Cliente
 * @see org.springframework.data.jpa.repository.JpaRepository
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Aquí se pueden definir métodos personalizados, por ejemplo:
    // Optional<Cliente> findByCorreo(String correo);
}
