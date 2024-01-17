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
public class UserProfil implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant dateCreate;
    private Instant dateUpdate;
    private String userId;
    private boolean archive;
    private boolean supprime;
    @ManyToOne
    @JoinColumn(name = "refUser")
    private Utilisateur user;
    @ManyToOne
    @JoinColumn(name = "refProfil")
    private Profil profil;
}
