package com.khadim.covoiturage.dto;

import com.khadim.covoiturage.dao.model.Reservation;
import com.khadim.covoiturage.dao.model.Vehicule;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class UtilisateurDTO implements Serializable {
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
    private CategoriePermisDTO categoriePermis;
    private ProfilDTO addProfil;
    private String userId;
    private ProfilDTO abstractProfil;
    private List<ProfilDTO> profils;
    private List<Reservation> reservations;
    private List<Vehicule> vehicules;
    private Instant dateCreate;
    private Instant dateUpdate;
    private boolean archive;
}