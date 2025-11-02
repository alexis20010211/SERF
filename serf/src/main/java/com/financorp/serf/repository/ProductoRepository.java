package com.financorp.serf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financorp.serf.model.Producto;

/**
 * <h2>Repositorio de Productos</h2>
 *
 * <p>
 * La interfaz {@code ProductoRepository} gestiona la persistencia de la entidad
 * {@link Producto} en la base de datos. Extiende de {@link JpaRepository}, 
 * lo que proporciona acceso a una amplia gama de operaciones CRUD sin necesidad
 * de implementación explícita.
 * </p>
 *
 * <h3>Características:</h3>
 * <ul>
 *   <li>Implementa el patrón de diseño <b>Repository</b>, separando la lógica de negocio del acceso a datos.</li>
 *   <li>Permite crear consultas personalizadas mediante nombres de método o anotaciones {@code @Query}.</li>
 *   <li>Gestiona de forma automática las transacciones y la conexión con la base de datos.</li>
 * </ul>
 *
 * <h3>Ejemplo de uso:</h3>
 * <pre>{@code
 * @Autowired
 * private ProductoRepository productoRepository;
 *
 * // Obtener todos los productos
 * List<Producto> productos = productoRepository.findAll();
 *
 * // Guardar nuevo producto
 * productoRepository.save(new Producto("Laptop Lenovo", 3500.00, "Tecnología"));
 * }</pre>
 *
 * @see com.financorp.serf.model.Producto
 * @see org.springframework.data.jpa.repository.JpaRepository
 * @see org.springframework.stereotype.Repository
 *
 * @author Alexis
 * @version 1.0
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Métodos personalizados pueden agregarse aquí, por ejemplo:
    // List<Producto> findByCategoria(String categoria);
}
