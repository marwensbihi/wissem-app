package com.app.App.controllers;

import com.app.App.models.Client;
import com.app.App.models.Gerant;
import com.app.App.models.Restaurant;
import com.app.App.services.GerantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class GerantC {
    @Autowired
    GerantService gerantService;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/gerants")
    public List<Gerant> getAll() {
        return gerantService.getAll();
    }

    @PostMapping("/gerants")
    public Gerant addGerant(@RequestBody Gerant gerant) {
        return gerantService.addGerant(gerant);
    }

    @PostMapping("/gerants/{gerantId}/restaurant/{restId}")
    public Gerant assignRestaurant(@PathVariable Long gerantId, @PathVariable Long restId) {
        return gerantService.assignRestaurant(gerantId, restId);
    }

    @PostMapping("/gerants/register")
    public Gerant register(@RequestBody Gerant gerant){
        return gerantService.addGerant(gerant);
    }

    @PostMapping("/gerants/login")
    public Optional<Gerant> login(@RequestBody Gerant gerant) {
        Optional<Gerant> gerantInDB = gerantService.getByUsername(gerant.getUsername());

        if ( gerantInDB.isEmpty() || !encoder.matches(gerant.getPassword(), gerantInDB.get().getPassword())) {
            throw new IllegalStateException("Bad credentials");
        }

        return gerantInDB;
    }

    @DeleteMapping("/gerants/{gerantId}")
    public boolean deleteGerant(@PathVariable Long gerantId) {
        return gerantService.deleteById(gerantId);
    }
}
