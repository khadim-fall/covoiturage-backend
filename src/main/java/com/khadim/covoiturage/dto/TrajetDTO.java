package com.khadim.covoiturage.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Data
@ToString
public class TrajetDTO implements Serializable {
    private Long id;
    private double duree;
    private TypeTrajetDTO type;
    private VilleDTO depart;
    private VilleDTO arrivee;
    private Double distance;
    private Date dateDepart;
    private Double prix;
    private Instant dateCreate;
    private Instant dateUpdate;
    private String userId;
    private boolean archive;
}