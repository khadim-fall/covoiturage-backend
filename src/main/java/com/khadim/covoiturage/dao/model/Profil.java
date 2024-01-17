package com.khadim.covoiturage.dao.model;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Profil implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant dateCreate;
    private Instant dateUpdate;
    private String userId;
    private boolean archive;
    private boolean supprime;
    private String designation;
}