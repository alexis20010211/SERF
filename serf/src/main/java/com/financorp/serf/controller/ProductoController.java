package com.financorp.serf.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financorp.serf.model.Producto;
import com.financorp.serf.service.ProductoService;

/**
 * Controlador REST para gestionar productos en el sistema SERF.
 * Permite listar, obtener, crear, actualizar y eliminar productos.
 *
 * Ruta base: /api/productos
 * Autor: Alesi
 * Versión: 1.2
 */
@RestController
@RequestMapping("/api/productos")
// Permitir solicitudes desde Angular u otros frontends
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // =========================
    // ENDPOINTS PÚBLICOS
    // =========================

    // 🔹 Listar todos los productos
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    // 🔹 Obtener un producto por id
    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id) {
        return productoService.obtenerProducto(id);
    }

    // =========================
    // ENDPOINTS PROTEGIDOS (ADMIN/FILIAL)
    // =========================

    // 🔹 Crear un producto
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','FILIAL')")
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    // 🔹 Actualizar un producto
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','FILIAL')")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto datos) {
        return productoService.actualizarProducto(id, datos);
    }

    // 🔹 Eliminar un producto
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','FILIAL')")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
}
