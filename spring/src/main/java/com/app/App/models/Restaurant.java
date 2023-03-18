package com.app.App.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "label", nullable = false)
    private String label;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "image")
    private String image;

    @Column(name = "type")
    private String type;

    @Column(name = "livreur_id")
    private Long livreur_id;

    @Column(name = "gerant_id")
    private Long gerant_id;
}
