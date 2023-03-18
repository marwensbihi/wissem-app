package com.app.App.services;

import com.app.App.models.Admin;
import com.app.App.repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    AdminRepo adminRepo;

    @Autowired
    PasswordEncoder encoder;

    public Optional<Admin> getByUsername(String username) {
        return adminRepo.findByUsername(username);
    }

    public Admin addAdmin(Admin admin) {
        if (adminRepo.existsByUsername(admin.getUsername())) {
            throw new IllegalStateException("Username already taken");
        }
        admin.setId(null);
        admin.setPassword(encoder.encode(admin.getPassword()));

        return adminRepo.save(admin);
    }
}
