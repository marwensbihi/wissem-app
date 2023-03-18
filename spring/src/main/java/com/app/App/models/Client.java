package com.app.App.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "codePostal")
    private Integer codePostal;

    @Column(name = "ville")
    private String ville;

    @Column(name = "numTel")
    private Integer numTel;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "username", nullable = false, length = 64)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, length = 64)
    private String email;
}
