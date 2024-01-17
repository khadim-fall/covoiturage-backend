package com.khadim.covoiturage.mappers.interfaces;

import com.khadim.covoiturage.dao.model.Avis;
import com.khadim.covoiturage.dao.model.Vehicule;
import com.khadim.covoiturage.dto.AvisDTO;
import com.khadim.covoiturage.dto.VehiculeDTO;

public interface IAvisMapper {
    public AvisDTO getAvisToAvisDTO(Avis data);
    public Avis getAvisDTOToAvis(AvisDTO data);
}
