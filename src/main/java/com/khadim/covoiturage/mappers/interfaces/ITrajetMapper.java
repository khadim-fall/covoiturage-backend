package com.khadim.covoiturage.mappers.interfaces;

import com.khadim.covoiturage.dao.model.Trajet;
import com.khadim.covoiturage.dto.TrajetDTO;

public interface ITrajetMapper {
    public TrajetDTO getTrajetToTrajetDTO(Trajet data);
    public Trajet getTrajetDTOToTrajet(TrajetDTO data);
}
