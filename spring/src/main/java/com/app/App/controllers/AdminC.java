package com.app.App.controllers;

import com.app.App.models.Admin;
import com.app.App.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AdminC {

    @Autowired
    AdminService adminService;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/admins/register")
    public Admin register(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }

    @PostMapping("/admins/login")
    public Optional<Admin> login(@RequestBody Admin admin) {
        Optional<Admin> adminInDB = adminService.getByUsername(admin.getUsername());

        if ( adminInDB.isEmpty() || !encoder.matches(admin.getPassword(), adminInDB.get().getPassword())) {
            throw new IllegalStateException("Bad credentials");
        }

        return adminInDB;
    }
}
