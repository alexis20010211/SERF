package com.financorp.serf.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financorp.serf.model.Filial;
import com.financorp.serf.model.InventarioFilial;
import com.financorp.serf.model.Producto;

public interface InventarioFilialRepository extends JpaRepository<InventarioFilial, Long> {

    // Buscar inventario por filial y producto
    Optional<InventarioFilial> findByFilialAndProducto(Filial filial, Producto producto);

    // Listar todos los inventarios de un producto
    List<InventarioFilial> findByProducto(Producto producto);

    // Borrar todos los inventarios de un producto
    void deleteAllByProducto(Producto producto);
}
