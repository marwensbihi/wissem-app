package com.app.App.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "livraison")
    private boolean livraison;

    @Column(name = "typePaiment")
    private String typePaiment;

    @Column(name = "description", length = 256)
    private String description;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "livreur_id")
    private Long livreurId;

    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "etat")
    private Integer etat;
}
