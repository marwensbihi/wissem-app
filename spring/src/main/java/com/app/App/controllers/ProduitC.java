package com.app.App.controllers;

import com.app.App.models.Produit;
import com.app.App.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ProduitC {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/produits")
    public List<Produit> getAll() {
        return produitService.getAll();
    }

    @PostMapping("/produits")
    public Produit addProduit(@RequestBody Produit produit) {
        return produitService.addProduit(produit);
    }
}
