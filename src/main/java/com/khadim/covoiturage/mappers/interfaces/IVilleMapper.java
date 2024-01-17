package com.khadim.covoiturage.mappers.interfaces;

import com.khadim.covoiturage.dao.model.Ville;
import com.khadim.covoiturage.dto.VilleDTO;

public interface IVilleMapper {
    public VilleDTO getVilleToVilleDTO(Ville data);
    public Ville getVilleDTOToVille(VilleDTO data);
}
