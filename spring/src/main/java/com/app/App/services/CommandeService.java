package com.app.App.services;

import com.app.App.models.Commande;
import com.app.App.repositories.ClientRepo;
import com.app.App.repositories.CommandeRepo;
import com.app.App.repositories.LivreurRepo;
import com.app.App.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CommandeService {
    @Autowired
    CommandeRepo commandeRepo;

    @Autowired
    ProduitRepo produitRepo;

    @Autowired
    LivreurRepo livreurRepo;

    @Autowired
    ClientRepo clientRepo;

    public Commande getById(Long id) {
        return commandeRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Cannot find commande: " + id));
    }

    public Commande add(Commande commande) {
        clientRepo.findById(commande.getClientId()).orElseThrow(() -> new NoSuchElementException("No client with id: " + commande.getClientId()));

        commande.setClientId(commande.getClientId());

        commande.setId(null);

        return commandeRepo.save(commande);
    }
}
