package com.khadim.covoiturage.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;

@Data
@ToString
public class CategoriePermisDTO implements Serializable {
    private Long id;
    private String designation;
    private Instant dateCreate;
    private Instant dateUpdate;
    private String userId;
    private boolean archive;
}