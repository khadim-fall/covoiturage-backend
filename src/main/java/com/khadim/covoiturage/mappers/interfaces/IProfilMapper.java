package com.khadim.covoiturage.mappers.interfaces;

import com.khadim.covoiturage.dao.model.Profil;
import com.khadim.covoiturage.dto.ProfilDTO;

public interface IProfilMapper {
    public ProfilDTO getProfilToProfilDTO(Profil data);
    public Profil getProfilDTOToProfil(ProfilDTO data);
}
