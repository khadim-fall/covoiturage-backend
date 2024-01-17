package com.khadim.covoiturage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VehiculeDTO implements Serializable {
    private Long id;
    private String marque;
    private String immatriculation;
    private int nombrePlace;
    private UtilisateurDTO user;
    private Instant dateCreate;
    private String userId;
    private Instant dateUpdate;
    private boolean archive;
}