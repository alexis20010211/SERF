package com.financorp.serf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financorp.serf.model.Filial;
import com.financorp.serf.model.InventarioFilial;
import com.financorp.serf.model.Producto;
import com.financorp.serf.repository.FilialRepository;
import com.financorp.serf.repository.InventarioFilialRepository;
import com.financorp.serf.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private InventarioFilialRepository inventarioFilialRepository;

    // ===========================
    // CRUD de Producto
    // ===========================
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(Long id, Producto datos) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setNombre(datos.getNombre());
        producto.setCostoImportacion(datos.getCostoImportacion());
        producto.setPrecioVentaSugerido(datos.getPrecioVentaSugerido());
        producto.setCategoria(datos.getCategoria());
        producto.setMoneda(datos.getMoneda());
        producto.setStock(datos.getStock());

        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // eliminar inventarios asociados
        inventarioFilialRepository.deleteAllByProducto(producto);

        productoRepository.delete(producto);
    }

    public Producto obtenerProducto(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    // ===========================
    // Inventario x Filial
    // ===========================
    public List<InventarioFilial> listarInventarioDeProducto(Long productoId) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        return inventarioFilialRepository.findByProducto(producto);
    }

    public void agregarProductoAFilial(Long productoId, Long filialId, int stock) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Filial filial = filialRepository.findById(filialId)
                .orElseThrow(() -> new RuntimeException("Filial no encontrada"));

        InventarioFilial inv = inventarioFilialRepository
                .findByFilialAndProducto(filial, producto)
                .orElse(new InventarioFilial(filial, producto, 0));

        inv.setStock(inv.getStock() + stock);
        inventarioFilialRepository.save(inv);
    }

    public void eliminarProductoDeFilial(Long productoId, Long filialId) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Filial filial = filialRepository.findById(filialId)
                .orElseThrow(() -> new RuntimeException("Filial no encontrada"));

        inventarioFilialRepository.findByFilialAndProducto(filial, producto)
                .ifPresent(inventarioFilialRepository::delete);
    }
}
