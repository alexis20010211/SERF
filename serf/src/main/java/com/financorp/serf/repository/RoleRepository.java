package com.financorp.serf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financorp.serf.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // Buscar rol por nombre (ADMIN, USER, etc.)
    Optional<Role> findByName(String name);

    // Verificar existencia de rol por nombre
    boolean existsByName(String name);
}
