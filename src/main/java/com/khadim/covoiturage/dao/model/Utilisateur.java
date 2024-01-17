package com.khadim.covoiturage.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String password;
    private String telephone;
    private String adresse;
    private String cni;
    private Date dateNaissance;
    private boolean permis;
    @ManyToOne
    @JoinColumn(name = "refCat")
    private CategoriePermis categoriePermis;
    @OneToMany
    private List<Profil> profils = new ArrayList<>();
    @OneToMany
    private List<Reservation> reservations;
    @OneToMany
    private List<Vehicule> vehicules;
    private Instant dateCreate;
    private Instant dateUpdate;
    private String userId;
    private boolean archive;
    private boolean supprime;
}
