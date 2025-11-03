package com.financorp.serf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financorp.serf.model.Filial;
import com.financorp.serf.model.InventarioFilial;
import com.financorp.serf.model.Producto;
import com.financorp.serf.repository.FilialRepository;
import com.financorp.serf.repository.InventarioFilialRepository;
import com.financorp.serf.repository.ProductoRepository;

@Service
public class FilialService {

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private InventarioFilialRepository inventarioFilialRepository;

    // =========================
    // CRUD de Filial
    // =========================

    public List<Filial> listarFiliales() {
        return filialRepository.findAll();
    }

    public Filial crearFilial(Filial filial) {
        return filialRepository.save(filial);
    }

    public Filial obtenerFilial(Long id) {
        return filialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filial no encontrada"));
    }

    public Filial actualizarFilial(Long id, Filial datos) {
        Filial filial = obtenerFilial(id);
        filial.setNombre(datos.getNombre());
        filial.setPais(datos.getPais());
        return filialRepository.save(filial);
    }

    public void eliminarFilial(Long id) {
        Filial filial = obtenerFilial(id);

        // Eliminar todos los inventarios asociados a esta filial
        List<InventarioFilial> inventarios = filial.getInventario();
        inventarios.forEach(inventarioFilialRepository::delete);

        filialRepository.delete(filial);
    }

    // =========================
    // Inventario por Filial
    // =========================

    public List<InventarioFilial> listarInventario(Long filialId) {
        Filial filial = obtenerFilial(filialId);
        return filial.getInventario();
    }

    public void agregarProductoAFilial(Long filialId, Long productoId, int stock) {
        Filial filial = obtenerFilial(filialId);

        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Buscar inventario existente
        Optional<InventarioFilial> existente = inventarioFilialRepository.findByFilialAndProducto(filial, producto);

        InventarioFilial inventario;
        if (existente.isPresent()) {
            inventario = existente.get();
            inventario.setStock(stock); // actualizar stock
        } else {
            inventario = new InventarioFilial();
            inventario.setFilial(filial);
            inventario.setProducto(producto);
            inventario.setStock(stock);
        }

        inventarioFilialRepository.save(inventario);
    }

    public void eliminarProductoDeFilial(Long filialId, Long productoId) {
        Filial filial = obtenerFilial(filialId);
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        inventarioFilialRepository.findByFilialAndProducto(filial, producto)
                .ifPresent(inventarioFilialRepository::delete);
    }
}
