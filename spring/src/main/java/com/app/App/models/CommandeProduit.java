package com.app.App.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CommandeProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nbElements", nullable = false)
    private Integer nbElements;

    @Column(name = "supplement")
    private Long supplement_id;

    @Column(name = "commande_id")
    private Long commande_id;

    @Column(name = "produit_id")
    private Long produit_id;
}
