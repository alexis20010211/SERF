package com.financorp.serf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financorp.serf.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
