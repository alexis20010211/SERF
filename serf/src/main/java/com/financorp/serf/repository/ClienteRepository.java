package com.financorp.serf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financorp.serf.model.Cliente;

// El tipo del ID debe coincidir con tu entidad Cliente (por ejemplo Long)
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
