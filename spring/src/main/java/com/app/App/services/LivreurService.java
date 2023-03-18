package com.app.App.services;

import com.app.App.models.Gerant;
import com.app.App.models.Livreur;
import com.app.App.models.Restaurant;
import com.app.App.repositories.LivreurRepo;
import com.app.App.repositories.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreurService {
    @Autowired
    LivreurRepo livreurRepo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RestaurantRepo restaurantRepo;

    public List<Livreur> getAll() {
        return livreurRepo.findAll();
    }

    public Livreur getById(Long id) {
        return livreurRepo.findById(id).orElseThrow(() ->
                new IllegalStateException("Livreur with id: " + id + " does not exist"));
    }

    public boolean deleteById(Long id) {
        if (livreurRepo.existsById(id)) {
            livreurRepo.deleteById(id);
            return true;
        }

        return false;
    }

    public boolean deleteAll() {
        livreurRepo.deleteAll();
        return true;
    }

    public Livreur addLivreur(Livreur livreur) {
        if (livreurRepo.existsByUsername(livreur.getUsername()) || livreurRepo.existsByEmail(livreur.getEmail())) {
            throw new IllegalStateException("Username or email already taken");
        }
        livreur.setId(null);
        livreur.setPassword(encoder.encode(livreur.getPassword()));

        return livreurRepo.save(livreur);
    }

    public Optional<Livreur> getByUsername(String username) {
        return livreurRepo.findByUsername(username);
    }

    public Optional<Livreur> getByEmail(String email) {
        return livreurRepo.findByEmail(email);
    }

}
