package com.khadim.covoiturage.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Trajet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double duree;
    @ManyToOne
    @JoinColumn(name = "refType")
    private TypeTrajet type;
    @ManyToOne
    @JoinColumn(name = "refVilleDep")
    private Ville depart;
    @ManyToOne
    @JoinColumn(name = "refVilleArr")
    private Ville arrivee;
    //@Transient
    private Double distance;
    private Date dateDepart;
    private Double prix;
    private Instant dateCreate;
    private Instant dateUpdate;
    private String userId;
    private boolean archive;
    private boolean supprime;
}
