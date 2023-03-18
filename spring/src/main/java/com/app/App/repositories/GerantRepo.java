package com.app.App.repositories;

import com.app.App.models.Client;
import com.app.App.models.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GerantRepo extends JpaRepository<Gerant, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    Optional<Gerant> findByUsername(String username);
    Optional<Gerant> findByEmail(String email);
}
