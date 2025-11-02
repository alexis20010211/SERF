package com.financorp.serf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financorp.serf.model.Producto;
import com.financorp.serf.repository.ProductoRepository;

/**
 * <h2>Servicio de Gestión de Productos</h2>
 *
 * <p>
 * La clase {@code ProductoService} contiene la lógica de negocio relacionada
 * con la gestión de productos dentro del sistema SERF. 
 * Se encarga de coordinar las operaciones CRUD utilizando el repositorio 
 * {@link ProductoRepository}.
 * </p>
 *
 * <h3>Patrones de diseño aplicados:</h3>
 * <ul>
 *   <li><b>Service Layer (Capa de Servicio):</b> Aísla la lógica de negocio 
 *       de la capa de persistencia, facilitando mantenimiento y pruebas.</li>
 *   <li><b>Dependency Injection:</b> Uso de {@code @Autowired} para inyectar 
 *       dependencias sin crear instancias manualmente, favoreciendo el 
 *       desacoplamiento.</li>
 * </ul>
 *
 * <h3>Responsabilidades:</h3>
 * <ul>
 *   <li>Listar productos existentes.</li>
 *   <li>Registrar y actualizar productos.</li>
 *   <li>Eliminar productos del inventario.</li>
 *   <li>Recuperar un producto por su identificador.</li>
 * </ul>
 *
 * <h3>Ejemplo de uso:</h3>
 * <pre>{@code
 * @Autowired
 * private ProductoService productoService;
 *
 * // Crear nuevo producto
 * Producto p = new Producto("Laptop Lenovo", 2500.0, "Tecnología");
 * productoService.guardarProducto(p);
 *
 * // Obtener todos los productos
 * List<Producto> lista = productoService.obtenerTodos();
 * }</pre>
 *
 * @author Alesi
 * @version 1.0
 */
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    /**
     * Obtiene la lista completa de productos registrados.
     *
     * @return lista de productos existentes.
     */
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    /**
     * Busca un producto por su identificador.
     *
     * @param id identificador único del producto.
     * @return un {@link Optional} que contiene el producto si existe.
     */
    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    /**
     * Guarda o actualiza un producto en la base de datos.
     *
     * @param producto objeto producto a guardar o actualizar.
     * @return el producto persistido.
     */
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    /**
     * Elimina un producto del sistema según su ID.
     *
     * @param id identificador del producto a eliminar.
     */
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
