package com.khadim.covoiturage.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userRef")
    private Utilisateur user;
    @ManyToOne
    @JoinColumn(name = "refTrajet")
    private Trajet trajet;
    private String commentaire;
    private EtatReservation etatReservation;
    @ManyToOne
    @JoinColumn(name = "refTypeReserv")
    private TypeReservation typeReservation;
    private Instant dateCreate;
    private Instant dateUpdate;
    private String userId;
    private boolean archive;
    private boolean supprime;
    private String designation;
}