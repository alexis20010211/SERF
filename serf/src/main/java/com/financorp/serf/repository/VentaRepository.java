package com.financorp.serf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financorp.serf.model.Filial;
import com.financorp.serf.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByFilial(Filial filial);
}
