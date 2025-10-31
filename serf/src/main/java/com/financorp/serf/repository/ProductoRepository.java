package com.financorp.serf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financorp.serf.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
