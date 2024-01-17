package com.khadim.covoiturage.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
@Data
public class UserProfilDTO implements Serializable {
    private Long id;
    private Instant dateCreate;
    private Instant dateUpdate;
    private String userId;
    private boolean archive;
    private UtilisateurDTO user;
    private ProfilDTO profil;
}