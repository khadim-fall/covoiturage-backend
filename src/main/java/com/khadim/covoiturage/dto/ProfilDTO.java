package com.khadim.covoiturage.dto;

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
public class ProfilDTO implements Serializable {
    private Long id;
    private String designation;
    private Instant dateCreate;
    private Instant dateUpdate;
    private String userId;
    private boolean archive;
}