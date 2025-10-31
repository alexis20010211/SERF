package com.financorp.serf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financorp.serf.model.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    // No necesitas agregar nada más: JpaRepository ya provee
    // findAll(), findById(), save(), deleteById(), etc.
}
