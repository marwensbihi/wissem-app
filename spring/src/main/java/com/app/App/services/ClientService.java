package com.app.App.services;

import com.app.App.models.Client;
import com.app.App.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepo clientRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<Client> getAll() {
        return clientRepo.findAll();
    }

    public Client getById(Long id) {
        return clientRepo.findById(id).orElseThrow(() ->
                new IllegalStateException("Client with id: " + id + " does not exist"));
    }

    public boolean deleteById(Long id) {
        if (clientRepo.existsById(id)) {
            clientRepo.deleteById(id);
            return true;
        }

        return false;
    }

    public boolean deleteAll() {
        clientRepo.deleteAll();
        return true;
    }

    public Client addClient(Client client) {
        if (clientRepo.existsByUsername(client.getUsername()) || clientRepo.existsByEmail(client.getEmail())) {
            throw new IllegalStateException("Username or email already taken");
        }
        client.setId(null);
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        return clientRepo.save(client);
    }

    public Client getByUsername(String username) {
        return clientRepo.findByUsername(username).orElseThrow(() -> new IllegalStateException("User with username: " + username + " does not exist"));
    }

    public Optional<Client> getByEmail(String email) {
        return clientRepo.findByEmail(email);
    }
}
