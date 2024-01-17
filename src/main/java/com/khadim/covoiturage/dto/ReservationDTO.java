package com.khadim.covoiturage.dto;

import com.khadim.covoiturage.dao.model.EtatReservation;
import com.khadim.covoiturage.dao.model.Trajet;
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
public class ReservationDTO implements Serializable {
    private Long id;
    private UtilisateurDTO user;
    private TrajetDTO trajet;
    private String commentaire;
    private EtatReservation etatReservation;
    private TypeReservationDTO typeReservation;
    private Instant dateCreate;
    private Instant dateUpdate;
    private String userId;
    private boolean archive;
    private String designation;
}