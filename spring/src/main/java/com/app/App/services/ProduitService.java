package com.app.App.services;

import com.app.App.models.Produit;
import com.app.App.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

     @Autowired
     private ProduitRepo produitRepo;

     public List<Produit> getAll() {
         return produitRepo.findAll();
     }

     public Produit getById(Long id) {
         return produitRepo.findById(id).orElseThrow(() ->
                 new IllegalStateException("Product with id: " + id + " does not exist"));
     }

     public boolean deleteById(Long id) {
         if (produitRepo.existsById(id)) {
             produitRepo.deleteById(id);
             return true;
         }

         return false;
     }

     public boolean deleteAll() {
         produitRepo.deleteAll();
         return true;
     }

     public Produit addProduit(Produit produit) {
         produit.setId(null);
         return produitRepo.save(produit);
     }


}
