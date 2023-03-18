package com.app.App.services;

import com.app.App.models.Gerant;
import com.app.App.models.Restaurant;
import com.app.App.repositories.GerantRepo;
import com.app.App.repositories.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GerantService {
    @Autowired
    private GerantRepo gerantRepo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    private RestaurantRepo restaurantRepo;

    public List<Gerant> getAll() {
        return gerantRepo.findAll();
    }

    public Gerant getById(Long id) {
        return gerantRepo.findById(id).orElseThrow(() ->
                new IllegalStateException("Gerant with id: " + id + " does not exist"));
    }

    public boolean deleteById(Long id) {
        if (gerantRepo.existsById(id)) {
            gerantRepo.deleteById(id);
            return true;
        }

        return false;
    }

    public boolean deleteAll() {
        gerantRepo.deleteAll();
        return true;
    }

    public Gerant addGerant(Gerant gerant) {
        if (gerantRepo.existsByUsername(gerant.getUsername()) || gerantRepo.existsByEmail(gerant.getEmail())) {
            throw new IllegalStateException("Username or email already taken");
        }
        gerant.setId(null);
        gerant.setPassword(encoder.encode(gerant.getPassword()));

        return gerantRepo.save(gerant);
    }

    public Gerant assignRestaurant(Long gerantId, Long restId) {
        Gerant gerant = gerantRepo.findById(gerantId).orElseThrow(() -> new IllegalStateException("Gerant with id:" + gerantId + " does not exist"));
        Restaurant restaurant = restaurantRepo.findById(restId).orElseThrow(() -> new IllegalStateException("Restaurant with id:" + restId + " does not exist"));
        restaurant.setGerant_id(gerantId);
        return gerantRepo.save(gerant);
    }

    public Optional<Gerant> getByUsername(String username) {
        return gerantRepo.findByUsername(username);
    }

    public Optional<Gerant> getByEmail(String email) {
        return gerantRepo.findByEmail(email);
    }
}
