package com.financorp.serf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.financorp.serf.model.Filial;
import com.financorp.serf.model.InventarioFilial;
import com.financorp.serf.model.Producto;
import com.financorp.serf.repository.FilialRepository;
import com.financorp.serf.repository.InventarioFilialRepository;
import com.financorp.serf.repository.ProductoRepository;

@RestController
@RequestMapping("/filiales")
public class FilialController {

    private final FilialRepository filialRepository;
    private final ProductoRepository productoRepository;
    private final InventarioFilialRepository inventarioFilialRepository;

    public FilialController(FilialRepository filialRepository,
                            ProductoRepository productoRepository,
                            InventarioFilialRepository inventarioFilialRepository) {
        this.filialRepository = filialRepository;
        this.productoRepository = productoRepository;
        this.inventarioFilialRepository = inventarioFilialRepository;
    }

    // 🔹 GET público: listar todas las filiales
    @GetMapping
    public List<Filial> listarFiliales() {
        return filialRepository.findAll();
    }

    // 🔹 GET público por id
    @GetMapping("/{id}")
    public Optional<Filial> obtenerFilial(@PathVariable Long id) {
        return filialRepository.findById(id);
    }

    // 🔹 POST protegido: solo ADMIN/FILIAL puede crear
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'FILIAL')")
    public Filial crearFilial(@RequestBody Filial filial) {
        return filialRepository.save(filial);
    }

    // 🔹 DELETE protegido: solo ADMIN/FILIAL puede eliminar
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'FILIAL')")
    public void eliminarFilial(@PathVariable Long id) {
        filialRepository.deleteById(id);
    }

    // =========================
    // Agregar Producto a Filial
    // =========================
    @PostMapping("/{filialId}/productos/{productoId}")
    @PreAuthorize("hasAnyRole('ADMIN','FILIAL')")
    public InventarioFilial agregarProducto(
            @PathVariable Long filialId,
            @PathVariable Long productoId,
            @RequestParam(defaultValue = "0") int stockInicial
    ) {
        Filial filial = filialRepository.findById(filialId)
                .orElseThrow(() -> new RuntimeException("Filial no encontrada"));

        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        InventarioFilial inventario = new InventarioFilial();
        inventario.setFilial(filial);
        inventario.setProducto(producto);
        inventario.setStock(stockInicial);

        return inventarioFilialRepository.save(inventario);
    }

    // =========================
    // Eliminar Producto de Filial
    // =========================
    @DeleteMapping("/{filialId}/productos/{productoId}")
    @PreAuthorize("hasAnyRole('ADMIN','FILIAL')")
    public void eliminarProducto(
            @PathVariable Long filialId,
            @PathVariable Long productoId
    ) {
        Filial filial = filialRepository.findById(filialId)
                .orElseThrow(() -> new RuntimeException("Filial no encontrada"));

        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        InventarioFilial inv = inventarioFilialRepository
                .findByFilialAndProducto(filial, producto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado en la filial"));

        inventarioFilialRepository.delete(inv);
    }
}
