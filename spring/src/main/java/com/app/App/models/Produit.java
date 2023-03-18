package com.app.App.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "produits")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    @Column(name = "prixHT", nullable = false)
    private Integer prixHT;

    @Column(name = "tva", nullable = false)
    private Integer tva;

    @Column(name = "menu_id", nullable = false, updatable = false, insertable = false)
    private Long menuId;

    @Column(name = "restaurant_id", nullable = false, updatable = false, insertable = false)
    private Long restaurantId;
}
