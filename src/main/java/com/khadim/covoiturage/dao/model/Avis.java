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
public class Avis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commentaire;
    private String rdv;
    @ManyToOne
    @JoinColumn(name = "userRef")
    private Utilisateur user;
    private Instant dateCreate;
    private Instant dateUpdate;
    private String userId;
    private boolean archive;
    private boolean supprime;
}