package com.financorp.serf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financorp.serf.model.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long> {
    // Método para buscar una filial por nombre
    Filial findByNombreIgnoreCase(String nombre);
}
