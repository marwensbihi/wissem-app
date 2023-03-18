package com.app.App.controllers;

import com.app.App.models.Client;
import com.app.App.repositories.ClientRepo;
import com.app.App.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ClientC {
    @Autowired
    ClientService clientService;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/clients")
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @PostMapping("/clients")
    public Client add(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        if( clientService.deleteById(id) ) {
            return ResponseEntity.ok().body("Client with id: " + id + " has been deleted.");
        }
        return ResponseEntity.ok().body("An exception occurred.");
    }

    @PostMapping("/clients/register")
    public Client register(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @PostMapping("/clients/login")
    public Client login(@RequestBody Client client) {
        Client clientInDB = clientService.getByUsername(client.getUsername());

        if ( clientInDB == null || !encoder.matches(client.getPassword(), clientInDB.getPassword()) ) {
            throw new IllegalStateException("Bad credentials");
        }

        return clientInDB;
    }
}
