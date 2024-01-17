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
public class Vehicule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marque;
    private String immatriculation;
    private int nombrePlace;
    @ManyToOne
    @JoinColumn(name = "refUser")
    private Utilisateur user;
    private String userId;
    private Instant dateCreate;
    private Instant dateUpdate;
    private boolean archive;
    private boolean supprime;
}
