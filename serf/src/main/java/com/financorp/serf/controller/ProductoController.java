package com.financorp.serf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financorp.serf.model.Producto;
import com.financorp.serf.service.ProductoService;

/**
 * Controlador REST que gestiona las operaciones relacionadas con los productos.
 * Permite listar, obtener, crear y eliminar productos del sistema.
 * 
 * <p>Ruta base: <b>/api/productos</b></p>
 * 
 * <p>La configuración de CORS se gestiona globalmente en {@code CorsConfig}.</p>
 * 
 * @author Alesi
 * @version 1.0
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    /**
     * Constructor que inyecta el servicio de productos.
     *
     * @param productoService servicio que contiene la lógica de negocio para productos
     */
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * Obtiene la lista completa de productos disponibles en el sistema.
     *
     * @return lista de objetos {@link Producto}
     */
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.obtenerTodos();
    }

    /**
     * Obtiene un producto específico según su identificador único.
     *
     * @param id identificador del producto a buscar
     * @return un {@link Optional} que contiene el producto si existe, o vacío si no se encuentra
     */
    @GetMapping("/{id}")
    public Optional<Producto> obtenerProducto(@PathVariable Long id) {
        return productoService.obtenerPorId(id);
    }

    /**
     * Crea un nuevo producto y lo guarda en la base de datos.
     *
     * @param producto objeto {@link Producto} con los datos del nuevo producto
     * @return el producto creado con su ID asignado
     */
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    /**
     * Elimina un producto existente según su identificador.
     *
     * @param id identificador del producto a eliminar
     */
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
}
