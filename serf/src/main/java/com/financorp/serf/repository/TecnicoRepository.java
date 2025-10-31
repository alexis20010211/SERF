package com.financorp.serf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financorp.serf.model.Tecnico;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    // no hace falta agregar nada más, JpaRepository ya incluye:
    // findAll(), findById(), save(), deleteById(), etc.
}
