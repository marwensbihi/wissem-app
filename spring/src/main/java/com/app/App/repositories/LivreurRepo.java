package com.app.App.repositories;

import com.app.App.models.Client;
import com.app.App.models.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivreurRepo extends JpaRepository<Livreur, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    Optional<Livreur> findByUsername(String username);
    Optional<Livreur> findByEmail(String email);
}
