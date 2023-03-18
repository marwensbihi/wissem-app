package com.app.App.controllers;

import com.app.App.models.Gerant;
import com.app.App.models.Livreur;
import com.app.App.services.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class LivreurC {
    @Autowired
    LivreurService livreurService;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/livreurs")
    public List<Livreur> getAll() {
        return livreurService.getAll();
    }

    @PostMapping("/livreurs")
    public Livreur add(@RequestBody Livreur livreur) {
        return livreurService.addLivreur(livreur);
    }

    @PostMapping("/livreurs/register")
    public Livreur register(@RequestBody Livreur livreur){
        return livreurService.addLivreur(livreur);
    }

    @PostMapping("/livreurs/login")
    public Optional<Livreur> login(@RequestBody Gerant gerant) {
        Optional<Livreur> livreurInDB = livreurService.getByUsername(gerant.getUsername());

        if ( livreurInDB.isEmpty() || !encoder.matches(gerant.getPassword(), livreurInDB.get().getPassword())) {
            throw new IllegalStateException("Bad credentials");
        }

        return livreurInDB;
    }

}
