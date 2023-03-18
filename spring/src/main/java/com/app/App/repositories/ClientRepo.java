package com.app.App.repositories;

import com.app.App.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    Optional<Client> findByUsername(String username);
    Optional<Client> findByEmail(String email);
}
