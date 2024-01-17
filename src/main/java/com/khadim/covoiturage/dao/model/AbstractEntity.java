package com.khadim.covoiturage.dao.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;
@Data
public abstract class AbstractEntity <T>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;
    private Instant dateCreate;
    private Instant dateUpdate;
    private String userId;
    private boolean archive;
    private boolean supprime;
}